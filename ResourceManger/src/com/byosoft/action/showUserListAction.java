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

public class showUserListAction extends ActionSupport {
	
	private int currentPage;
	private UserService userService;
	private List<User> userlist;
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(20);
		
		Result reuslt = userService.loadAllUser(page);
		page = reuslt.getPage();
		
		userlist = reuslt.getList();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("all", userlist);
		request.setAttribute("page", page);
		
		return this.SUCCESS;
	}

}
