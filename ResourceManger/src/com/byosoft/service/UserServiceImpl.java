package com.byosoft.service;

import java.util.List;

import com.byosoft.dao.UserDAO;
import com.byosoft.fenye.Page;
import com.byosoft.fenye.PageUtil;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.po.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		if(userDAO.queryByUsername(user.getUsername())!= null)
		{
			return false;
		}
		else
		{
			userDAO.add(user);
			return true;
		}
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		if(user.getUsername()!=null)
		{
			User userinfo = userDAO.queryByUsername(user.getUsername());
			
			if(userinfo==null)
				return false;
			
			if(user.getUsername().equals(userinfo.getUsername())
					&&user.getPassword().equals(userinfo.getPassword()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}

	@Override
	public Result LoadUserByDeviceName(String username, Page page) {
		// TODO Auto-generated method stub
		if(username==null)
			username = "";
		page = PageUtil.createPage(page,userDAO.querySearchCount(username));
		List<User> all = userDAO.queryUserByUserName(username, page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
			userDAO.update(user);
			return true;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		userDAO.delete(user);
		return true;
	}

	@Override
	public boolean deleteCheckedUser(List<User> userlist) {
		// TODO Auto-generated method stub
		userDAO.delete(userlist);
		return true;
	}

	@Override
	public Result loadAllUser(Page page) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page, userDAO.queryAllCount());
		List<User> all = userDAO.queryAllUser(page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}

	@Override
	public User loadUserById(int id) {
		// TODO Auto-generated method stub
		return userDAO.queryUserByID(id);
	}
	
}
