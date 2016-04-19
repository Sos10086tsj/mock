package com.cherong.mock.domain.rabc.repository;

import com.cherong.mock.domain.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.rabc.model.SysResource;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface SysResourceRepository extends BaseRepository<SysResource, Long>{
	public SysResource findByCode(String code);
}
