package com.byosoft.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.service.DeviceService;
import com.opensymphony.xwork2.ActionSupport;

public class showDeviceListAction extends ActionSupport {
	
	private int currentPage;
	private DeviceService deviceService;
	private List<Device> devicelist;
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(20);
		
		Result reuslt = deviceService.loadAllDevice(page);
		page = reuslt.getPage();
		
		devicelist = reuslt.getList();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("all", devicelist);
		request.setAttribute("page", page);
		
		return this.SUCCESS;
	}

}
