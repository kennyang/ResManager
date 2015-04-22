package com.byosoft.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.po.User;
import com.byosoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class userQueryAction extends ActionSupport {
	private String username;
	private String ids;
	private List<User> userlist;
	private UserService userService;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("username", this.username);
		return this.SUCCESS;
	}
}
