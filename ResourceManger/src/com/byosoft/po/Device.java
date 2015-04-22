package com.byosoft.po;

import java.util.Date;

public class Device {
	private int Id;
	private String devicename;
	private String ower;
	private String user;
	private String content;
	private String modifytime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public String getOwer() {
		return ower;
	}
	public void setOwer(String ower) {
		this.ower = ower;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	
}
