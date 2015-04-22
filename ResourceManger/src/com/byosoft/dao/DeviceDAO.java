package com.byosoft.dao;

import java.util.List;

import com.byosoft.fenye.Page;
import com.byosoft.po.Device;

public interface DeviceDAO {
	
	//添加设备
	public void add(Device device);
	
	//修改设备
	public void update(Device device);
	
	//删除设备
	public void delete(Device device);
	
	//批量删除设备
	public void delete(List<Device> devicelist);
	
	//查询所有设备设备
	public List<Device> queryAllDevice(Page page);
	
	//查询所有设备的数量 
	public int queryAllCount();
	
	//查询搜索设备的数量
	public int querySearchCount(String devicename,String ower);
	
	//根据id查询设置
	public Device queryDeviceByID(int id);
	
	
	//根据设备名称和所有者组合查询
	public List<Device> queryDeviceByDeviceNameAndOwer(String devicename,String ower,Page page);
	
}
