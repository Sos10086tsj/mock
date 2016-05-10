package com.cherong.mock.web.vo;
/**
 * Description:
 * Auth:Paris
 * Date:May 10, 2016
**/
public class SelectVo {
	private String value;
	private String label;
	
	public SelectVo(String value,String label){
		this.label = label;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
