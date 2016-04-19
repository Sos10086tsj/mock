package com.cherong.mock.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseDeletedEntity;

/**
 * Description: 资源
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_resouces")
public class SysResource extends BaseDeletedEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1825547512241871787L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String url;
	
	@Column
	private Integer hierarchy;
	
	@Column
	private Integer seq;

	@Column(name = "show", columnDefinition="TINYINT(1)")
	private Boolean show;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}

	public Integer getSeq() {
		return seq;
	}

	public Boolean getShow() {
		return show;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}
}
