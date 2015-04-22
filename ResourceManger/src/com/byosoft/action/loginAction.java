package com.byosoft.action;

import java.util.Map;

import com.byosoft.po.User;
import com.byosoft.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	private UserService userService;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		if(userService.loginUser(user))
		{
			Map session = ActionContext.getContext().getSession();
			session.put("username",username);
			return this.SUCCESS;
		}
		else
		{
			this.addActionError("用户名或密码错误！");
			return this.input();
		}
	}
	
	
}
