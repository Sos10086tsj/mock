package com.cherong.mock.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseDeletedEntity;
import com.cherong.mock.domain.rabc.constant.SysResourceHierarchy;

/**
 * Description: 资源 
 * 三级
 * 层级分别为 1 2 3
 * 顺序范围 1 ~ 10000
 * parentCode is null 表示跟目录
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
	
	@Column(name = "parent_code")
	private String parentCode;
	
	@Column
	private String name;
	
	@Column
	private String url;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private SysResourceHierarchy hierarchy;
	
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

	public SysResourceHierarchy getHierarchy() {
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

	public void setHierarchy(SysResourceHierarchy hierarchy) {
		this.hierarchy = hierarchy;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
}
