package com.cherong.mock.domain.user.repository;

import java.util.List;

import com.cherong.mock.common.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.api.user.model.UserRole;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface UserRoleRepository extends BaseRepository<UserRole, Long>{
	public List<UserRole> findByUserId(Long userId);
}
