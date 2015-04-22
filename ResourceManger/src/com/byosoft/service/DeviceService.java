package com.byosoft.service;

import java.util.List;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;

public interface DeviceService {
	public boolean addDevice(Device device);
	public boolean updateDevice(Device device);
	public boolean deleteDevice(Device device);
	public boolean deleteCheckedDevice(List<Device> devicelist);
	public Result loadAllDevice(Page page);
	public Device loadDeviceById(int id);

	public Result LoadDeviceByDeviceNameAndOwer(String devicename,String ower,Page page);
}
