package com.byosoft.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.service.DeviceService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class deviceAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String devicename;
	private String ower;
	private String user;
	private String content;
	private int id;
	private int currentPage;

	public int getId() {
		return id;
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
	
	public DeviceService getDeviceService() {
		return deviceService;
	}
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}	
	public List<Device> getDevicelist() {
		return devicelist;
	}
	public void setDevicelist(List<Device> devicelist) {
		this.devicelist = devicelist;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String get() throws Exception
	{
		System.out.println("get called");
		HttpServletRequest request = ServletActionContext.getRequest();
		String deviceid = request.getParameter("Id");
		Device device = deviceService.loadDeviceById(Integer.parseInt(deviceid));
		
		request.setAttribute("Id",deviceid);
		request.setAttribute("devicename", device.getDevicename());
		request.setAttribute("ower", device.getOwer());
		request.setAttribute("user", device.getUser());
		request.setAttribute("content", device.getContent());
		
		return "getsuccess";	
	}
	
	public String view() throws Exception
	{
		System.out.println("view called");
		HttpServletRequest request = ServletActionContext.getRequest();
		String deviceid = request.getParameter("Id");
		Device device = deviceService.loadDeviceById(Integer.parseInt(deviceid));
		
		request.setAttribute("Id",deviceid);
		request.setAttribute("devicename", device.getDevicename());
		request.setAttribute("ower", device.getOwer());
		request.setAttribute("user", device.getUser());
		request.setAttribute("content", device.getContent());
		
		return "viewsuccess";	
	}
	
	public String delete() throws Exception
	{
		System.out.println("delete called");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String deviceid = request.getParameter("Id");
		Device device = deviceService.loadDeviceById(Integer.parseInt(deviceid));
		
		
		if(deviceService.deleteDevice(device))
		{
			//devicelist = deviceService.loadAllDevice();
			return "deletesuccess";
		}
		else
		{
			return this.ERROR;
		}
	}
	
	
	public String update() throws Exception
	{
		
		System.out.println("update called");
		
		Device device = new Device();
		device.setDevicename(devicename);
		device.setOwer(ower);
		device.setUser(user);
		device.setContent(content);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		device.setId(Integer.parseInt(request.getParameter("Id")));
		
		
		if(deviceService.updateDevice(device))
		{
			
			return "updatesuccess";
		}
		else
		{
			return this.ERROR;
		}
		
	}
	
	public String add() throws Exception {
		
		Device device = new Device();
		device.setDevicename(devicename);
		device.setOwer(ower);
		device.setUser(user);
		device.setContent(content);	
		

		if(deviceService.addDevice(device))
		{
			return "addsuccess";
		}
		else
		{
			return this.ERROR;
		}
	
	}

}
