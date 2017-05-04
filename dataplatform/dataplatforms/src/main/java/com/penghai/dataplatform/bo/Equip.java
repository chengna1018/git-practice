package com.penghai.dataplatform.bo;
/**
 * 此处，Spring的依赖注入方式为属性注入，通过setXxx()方法。
 * @author Administrator
 *
 */
public class Equip {
	private Integer id;
	private String ename;
	private String desc;
	private String picture;
	private Integer factoryId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(Integer factoryId) {
		this.factoryId = factoryId;
	}
	
	
}
