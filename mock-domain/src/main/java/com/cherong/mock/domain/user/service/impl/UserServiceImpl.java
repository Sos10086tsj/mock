package com.cherong.mock.domain.user.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cherong.mock.common.base.jpa.service.BaseServiceImpl;
import com.cherong.mock.domain.api.rbac.constant.SysResourceHierarchy;
import com.cherong.mock.domain.api.rbac.model.SysPermission;
import com.cherong.mock.domain.api.rbac.model.SysPermissionResOpr;
import com.cherong.mock.domain.api.rbac.model.SysResource;
import com.cherong.mock.domain.api.rbac.model.SysRole;
import com.cherong.mock.domain.api.rbac.model.SysRolePermission;
import com.cherong.mock.domain.api.user.model.User;
import com.cherong.mock.domain.api.user.model.UserRole;
import com.cherong.mock.domain.api.user.service.UserService;
import com.cherong.mock.domain.api.user.vo.Menu;
import com.cherong.mock.domain.rbac.repository.SysPermissionResOprRepository;
import com.cherong.mock.domain.rbac.repository.SysResourceRepository;
import com.cherong.mock.domain.rbac.repository.SysRolePermissionRepository;
import com.cherong.mock.domain.rbac.repository.SysRoleRepository;
import com.cherong.mock.domain.user.SysResourcesComparator;
import com.cherong.mock.domain.user.repository.UserRepository;
import com.cherong.mock.domain.user.repository.UserRoleRepository;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{
	@Resource
	private UserRepository repository;
	@Resource
	private UserRoleRepository userRoleRepository;
	@Resource
	private SysRolePermissionRepository rolePermissionRepository;
	@Resource
	private SysPermissionResOprRepository permissionResOprRepository;
	@Resource
	private SysRoleRepository roleRepository;
	@Resource
	private SysResourceRepository resourceRepository;
	
	@Override
	public List<Menu> getUserMenus(Long userId) {
		//1. 获取所有角色
		List<UserRole> userRoles = this.userRoleRepository.findByUserId(userId);
		
		if (userRoles.isEmpty()) {
			return null;
		}
		
		//2. 获取所有角色code
		Set<String> roleCodes = new HashSet<String>();
		for (UserRole userRole : userRoles) {
			SysRole role = userRole.getRole();
			if (!role.getDelete()) {
				roleCodes.add(role.getCode());
			}
		}
		if (roleCodes.isEmpty()) {
			return null;
		}
		
		//3. 获取所有权限列表
		List<SysRolePermission> rolePermissions = this.rolePermissionRepository.findByRoleCodeIn(roleCodes);
		Set<String> permissionCodes = new HashSet<String>();
		for (SysRolePermission rolePermission : rolePermissions) {
			SysPermission permission = rolePermission.getPermission();
			if (!permission.getDelete()) {
				permissionCodes.add(permission.getCode());
			}
		}
		if (permissionCodes.isEmpty()) {
			return null;
		}
		
		//4. 获取所有资源
		List<SysPermissionResOpr> permissionResOprs = this.permissionResOprRepository.findByPermissionCodeIn(permissionCodes);
		Set<String> resourceCodes = new HashSet<String>();
		List<SysResource> resources = new ArrayList<SysResource>();
		for (SysPermissionResOpr sysPermissionResOpr : permissionResOprs) {
			SysResource resource = sysPermissionResOpr.getResource();
			if (!resource.getDelete() && resource.getShow()) {
				if (!resourceCodes.contains(resource.getCode())) {
					resources.add(resource);
				}
				resourceCodes.add(resource.getCode());
			}
		}
		if (resourceCodes.isEmpty()) {
			return null;
		}
		
		//排序封装menu
		return this.generateMenu(resources);
	}

	private List<Menu> generateMenu(List<SysResource> resources) {
		//1. 排序
		Collections.sort(resources, new SysResourcesComparator());
		
		Map<String, Menu> menuMap = new HashMap<String, Menu>();
		for (SysResource sysResource : resources) {
			if (sysResource.getDelete() || !sysResource.getShow()) {
				continue;
			}
			
			//处理1级菜单
			if (sysResource.getHierarchy().equals(SysResourceHierarchy.FIRST)) {
				menuMap.put(sysResource.getCode(), Menu.convert2Menu(sysResource));
			}else if (sysResource.getHierarchy().equals(SysResourceHierarchy.SECONDE)) {
				Menu menu = menuMap.get(sysResource.getParentCode());
				if (null == menu) {
					SysResource firstResource = this.resourceRepository.findByCode(sysResource.getParentCode());
					menu = Menu.convert2Menu(firstResource);
				}
				menu.getSubMenus().add(Menu.convert2Menu(sysResource));
				menuMap.put(sysResource.getParentCode(), menu);
			}
//			else if (sysResource.getHierarchy().equals(SysResourceHierarchy.THIRD)) {
//				SysResource secondeResource = this.resourceRepository.findByCode(sysResource.getParentCode());
//				SysResource firstResource = this.resourceRepository.findByCode(secondeResource.getParentCode());
//				Menu menu = menuMap.get(firstResource.getCode());
//				Menu secondMenu = null;
//				if (null == menu) {
//					menu = Menu.convert2Menu(firstResource);
//					secondMenu = Menu.convert2Menu(secondeResource);
//				}else {
//					boolean secondMenuExist = false;
//					for (Menu subMenu : menu.getSubMenus()) {
//						if (subMenu.getCode().equals(secondeResource.getCode())) {
//							secondMenuExist = true;
//							secondMenu = subMenu;
//							break;
//						}
//					}
//					if (!secondMenuExist) {
//						secondMenu =  Menu.convert2Menu(secondeResource);
//					}
//				}
//				secondMenu.getSubMenus().add(Menu.convert2Menu(sysResource));
//				menu.getSubMenus().add(secondMenu);
//				menuMap.put(firstResource.getCode(), menu);
//			}
		}
		
		List<Menu> menus = new ArrayList<Menu>();
		for (String key : menuMap.keySet()) {
			menus.add(menuMap.get(key));
		}
		
		return menus;
	}

	@Override
	public User findByUsername(String username){
		return this.repository.findByUsername(username);
	}
}
