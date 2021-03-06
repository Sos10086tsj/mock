package com.cherong.mock.domain.user.repository;

import com.cherong.mock.common.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.api.user.model.User;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface UserRepository extends BaseRepository<User, Long>{
	public User findByUsername(String username);
}
