package com.byosoft.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.po.User;
import com.byosoft.service.DeviceService;
import com.byosoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class showSearchUserListAction extends ActionSupport {
	
	private int currentPage;
	private UserService userService;
	private List<User> userlist;
	
	
	private String username;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String execute() throws Exception {
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(20);
		
		HttpServletRequest request = ServletActionContext.getRequest();
			
		String username = (String) request.getAttribute("username");
		
		System.out.println("username======="+username);
		
		Result reuslt = userService.LoadUserByDeviceName(username, page);
		page = reuslt.getPage();
		
		userlist = reuslt.getList();
		
		request.setAttribute("all", userlist);
		request.setAttribute("page", page);
		
		return this.SUCCESS;
	}

}
