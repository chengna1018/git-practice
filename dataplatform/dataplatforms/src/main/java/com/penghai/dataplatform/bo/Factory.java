package com.penghai.dataplatform.bo;

/*
 * 工厂细节BO
 * @author 李浩
 */
public class Factory {
	// 主键id
	private Integer id;
	// 工厂名称
	private String fname;
	// 所在经度
	private String longitude;
	// 所在纬度
	private String latitude;
	// 工厂地址
	private String address;
	// 工厂联系电话
	//private String telephone;
	// 工厂详情
	private String desc;
	// 工厂图片
	private String picture;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}*/

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
