package com.byosoft.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.po.Device;
import com.byosoft.service.DeviceService;
import com.opensymphony.xwork2.ActionSupport;

public class deviceQueryAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String devicename;
	private String ower;
	private String ids;
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	private List<Device> devicelist;
	private DeviceService deviceService;
	
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
	public List<Device> getDevicelist() {
		return devicelist;
	}
	public void setDevicelist(List<Device> devicelist) {
		this.devicelist = devicelist;
	}
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("devicename", this.devicename);
		request.setAttribute("ower", this.ower);
		
		return this.SUCCESS;
	}
}

