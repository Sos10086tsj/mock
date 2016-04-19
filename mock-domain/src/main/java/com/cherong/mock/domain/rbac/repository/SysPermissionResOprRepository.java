package com.cherong.mock.domain.rbac.repository;

import java.util.Collection;
import java.util.List;

import com.cherong.mock.common.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.api.rbac.model.SysPermissionResOpr;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface SysPermissionResOprRepository extends BaseRepository<SysPermissionResOpr, Long>{
	public List<SysPermissionResOpr> findByPermissionCodeIn(Collection<String> permissionCodes);
}
