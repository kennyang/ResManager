package com.byosoft.service;

import java.util.List;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.po.User;

public interface UserService {
	public boolean registerUser(User user);
	
	public boolean loginUser(User user);
	
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public boolean deleteCheckedUser(List<User> userlist);
	public Result loadAllUser(Page page);
	public User loadUserById(int id);
	
	public Result LoadUserByDeviceName(String username,Page page);
}
