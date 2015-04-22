package com.byosoft.dao;

import java.util.List;

import com.byosoft.fenye.Page;
import com.byosoft.po.Device;
import com.byosoft.po.User;

public interface UserDAO {
	//添加用户
	public void add(User user);
	
	//删除用户
	public void delete(User user);
	
	public void delete(List<User> userlist);
	
	//更新用户
	public void update(User user);
	
	//查询所有用户
	public List<User> queryAllUser(Page page);
	
	public int queryAllCount();
	
	//根据用户查询
	public User queryByUsername(String username);
	
	public User queryUserByID(int id);
	
	
	public int querySearchCount(String username);
	
	public List<User> queryUserByUserName(String username,Page page);
	
	
}
