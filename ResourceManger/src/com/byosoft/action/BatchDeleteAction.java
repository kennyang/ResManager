package com.byosoft.action;

import java.util.ArrayList;
import java.util.List;

import com.byosoft.po.Device;
import com.byosoft.service.DeviceService;
import com.opensymphony.xwork2.ActionSupport;

public class BatchDeleteAction extends ActionSupport{
	private String ids;
	private DeviceService deviceService;

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(this.getIds());
		String ids = this.getIds().substring(0, this.getIds().length()-1);
		if(ids.startsWith("on"))
		{
			ids.substring(2, ids.length());
		}
		System.out.println("ids====="+ids);
		String[] ids_arr = ids.split(",");
		List<Device> list = new ArrayList<Device>();
		for(int i=0;i<ids_arr.length;i++)
		{
			int temp =Integer.parseInt(ids_arr[i]);
			list.add(deviceService.loadDeviceById(temp));	
		}
		deviceService.deleteCheckedDevice(list);
		
		return this.SUCCESS;
	}	
}
