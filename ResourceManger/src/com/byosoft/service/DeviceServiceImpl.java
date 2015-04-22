package com.byosoft.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.byosoft.dao.DeviceDAO;
import com.byosoft.fenye.Page;
import com.byosoft.fenye.PageUtil;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;

public class DeviceServiceImpl implements DeviceService {

	private DeviceDAO deviceDAO;
	
	
	public DeviceDAO getDeviceDAO() {
		return deviceDAO;
	}


	public void setDeviceDAO(DeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}

	@Override
	public boolean addDevice(Device device) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		device.setModifytime(sdf.format(date));
		deviceDAO.add(device);
		return true;
	}


	@Override
	public Result loadAllDevice(Page page) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page, deviceDAO.queryAllCount());
		List<Device> all = deviceDAO.queryAllDevice(page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}


	@Override
	public Result LoadDeviceByDeviceNameAndOwer(String devicename,
			String ower,Page page) {
		// TODO Auto-generated method stub
		if(devicename==null)
			devicename = "";
		if(ower == null)
			ower = "";
		page = PageUtil.createPage(page,deviceDAO.querySearchCount(devicename,ower));
		List<Device> all = deviceDAO.queryDeviceByDeviceNameAndOwer(devicename, ower, page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}


	@Override
	public Device loadDeviceById(int id) {
		// TODO Auto-generated method stub
		return deviceDAO.queryDeviceByID(id);
	}


	@Override
	public boolean updateDevice(Device device) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		device.setModifytime(sdf.format(date));
		
		deviceDAO.update(device);
		return true;
	}


	@Override
	public boolean deleteDevice(Device device) {
		// TODO Auto-generated method stub
		deviceDAO.delete(device);
		return true;
	}


	@Override
	public boolean deleteCheckedDevice(List<Device> devicelist) {
		// TODO Auto-generated method stub
		deviceDAO.delete(devicelist);
		return true;
	}

}
