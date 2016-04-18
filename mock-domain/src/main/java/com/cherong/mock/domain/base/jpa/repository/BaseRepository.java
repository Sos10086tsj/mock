package com.cherong.mock.domain.base.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Description: 
 * @author Paris
 * @date Mar 26, 20155:13:10 PM
 * @version beta
 */
@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends JpaRepository<M, ID>, JpaSpecificationExecutor<M> {
	public List<M> findPage(Pageable pageable);
}
