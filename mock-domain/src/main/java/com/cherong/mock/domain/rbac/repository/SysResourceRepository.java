package com.cherong.mock.domain.rbac.repository;

import com.cherong.mock.common.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.api.rbac.model.SysResource;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface SysResourceRepository extends BaseRepository<SysResource, Long>{
	public SysResource findByCode(String code);
}
