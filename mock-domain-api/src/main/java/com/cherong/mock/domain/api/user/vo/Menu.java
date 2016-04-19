package com.cherong.mock.domain.api.user.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cherong.mock.domain.api.rbac.model.SysResource;

/**
 * Description:	三级菜单	层级分别为 1 2 3
 * 						顺序范围 1 ~ 10000
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 741054676052478361L;
	private String code;
	private String name;
	private String url;
	private List<Menu> subMenus = new ArrayList<Menu>();
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public static Menu convert2Menu(SysResource resource) {
		Menu menu = new Menu();
		menu.setCode(resource.getCode());
		menu.setName(resource.getName());
		menu.setUrl(resource.getUrl());
		return menu;
	}
	@Override
	public String toString() {
		return "Menu [code=" + code + ", name=" + name + ", url=" + url + ", subMenus=" + subMenus + "]";
	}
	
	
}
