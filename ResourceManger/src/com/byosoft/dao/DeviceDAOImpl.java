package com.byosoft.dao;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.byosoft.fenye.Page;
import com.byosoft.po.Device;

public class DeviceDAOImpl extends HibernateDaoSupport implements DeviceDAO {

	@Override
	public void add(Device device) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().save(device);
		
	}

	@Override
	public void update(final Device device) {
		// TODO Auto-generated method stub
		
		System.out.println("deviceid==="+device.getId());
		
		this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				final String sql="update Device device set device.devicename='"+device.getDevicename()+
						"',device.ower='"+device.getOwer()+
						"',device.user='"+device.getUser()+
						"',device.content='"+device.getContent()+
						"',device.modifytime='"+device.getModifytime()+
						"' where device.Id ='"+device.getId()+"'";
				Query query = session.createQuery(sql);
				query.executeUpdate();
				return null;
			}
		});
		
		
/*		String sql="update Device device set device.devicename='"+device.getDevicename()+
											"',device.ower='"+device.getOwer()+
											"',device.user='"+device.getUser()+
											"',device.content='"+device.getContent()+"'";*/
	}

	@Override
	public void delete(Device device) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(device);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Device> queryAllDevice(final Page page) {
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("select device from Device device");
				query.setMaxResults(page.getEveryPage());
				
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
		});

	}

	@Override
	public Device queryDeviceByID(int id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Device> temp = (List<Device>)this.getHibernateTemplate().find("select device from Device device where Id ="+id);
		return temp.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Device> queryDeviceByDeviceNameAndOwer(final String devicename,
			final String ower,final Page page) {

			return	this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String sql="select device from Device device";				
				if(!devicename.isEmpty()&&!ower.isEmpty())
					sql="select device from Device device where device.ower='"+ower+"' and device.devicename like '%"+devicename+"%' order by device.modifytime desc";
				if(!devicename.isEmpty()&&ower.isEmpty())
					sql="select device from Device device where device.devicename like '%"+devicename+"%' order by device.modifytime desc";
				if(devicename.isEmpty()&&!ower.isEmpty())
					sql="select device from Device device where device.ower='"+ower+"' order by device.modifytime desc";
				if(devicename.isEmpty()&&ower.isEmpty())
					sql="select device from Device device order by device.modifytime desc";
				Query query = session.createQuery(sql);
				
				query.setMaxResults(page.getEveryPage());
				
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
		});
	}

	@Override
	public int queryAllCount() {
		// TODO Auto-generated method stub
		
		List find = this.getHibernateTemplate().find("select count(*) from Device device");
		return ((Long)find.get(0)).intValue();
	}

	@Override
	public int querySearchCount(String devicename, String ower) {
		// TODO Auto-generated method stub
		String sql="select count(*) from Device device";
		
		if(devicename==null)
			devicename = "";
		if(ower == null)
			ower = "";
		
		if(!devicename.isEmpty()&&!ower.isEmpty())
			sql="select count(*) from Device device where device.ower='"+ower+"' and device.devicename like '%"+devicename+"%'";
		if(!devicename.isEmpty()&&ower.isEmpty())
			sql="select count(*) from Device device where device.devicename like '%"+devicename+"%'";
		if(devicename.isEmpty()&&!ower.isEmpty())
			sql="select count(*) from Device device where device.ower='"+ower+"'";
		if(devicename.isEmpty()&&ower.isEmpty())
			sql="select count(*) from Device device";
		
		
		List find = this.getHibernateTemplate().find(sql);
		return ((Long)find.get(0)).intValue();
	}

	@Override
	public void delete(List<Device> devicelist) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().deleteAll(devicelist);
	}
}

