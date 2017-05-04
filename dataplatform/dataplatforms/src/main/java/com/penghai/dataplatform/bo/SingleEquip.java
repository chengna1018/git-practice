package com.penghai.dataplatform.bo;

public class SingleEquip {
	private Integer id;
	private Integer eid;
	private String ename;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	private Integer kn;
	private Integer max_mohou;
	private Integer min_mohou;
	private Integer ejection_stroke;
	private Float ejection_pressure;
	private String picture;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getKn() {
		return kn;
	}
	public void setKn(Integer kn) {
		this.kn = kn;
	}
	public Integer getMax_mohou() {
		return max_mohou;
	}
	public void setMax_mohou(Integer max_mohou) {
		this.max_mohou = max_mohou;
	}
	public Integer getMin_mohou() {
		return min_mohou;
	}
	public void setMin_mohou(Integer min_mohou) {
		this.min_mohou = min_mohou;
	}
	public Integer getEjection_stroke() {
		return ejection_stroke;
	}
	public void setEjection_stoke(Integer ejection_stroke) {
		this.ejection_stroke = ejection_stroke;
	}
	public Float getEjection_pressure() {
		return ejection_pressure;
	}
	public void setEjection_pressure(Float ejection_pressure) {
		this.ejection_pressure = ejection_pressure;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
 