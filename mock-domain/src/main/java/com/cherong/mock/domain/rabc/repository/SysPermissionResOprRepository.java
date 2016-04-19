package com.cherong.mock.domain.rabc.repository;

import java.util.Collection;
import java.util.List;

import com.cherong.mock.domain.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.rabc.model.SysPermissionResOpr;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface SysPermissionResOprRepository extends BaseRepository<SysPermissionResOpr, Long>{
	public List<SysPermissionResOpr> findByPermissionCodeIn(Collection<String> permissionCodes);
}
