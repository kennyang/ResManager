package com.byosoft.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.po.Device;
import com.byosoft.po.User;
import com.byosoft.service.DeviceService;
import com.byosoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class BatchDeleteUserAction extends ActionSupport{
	private String ids;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(this.getIds());
		String ids = this.getIds().substring(0, this.getIds().length()-1);
		if(ids.startsWith("on"))
		{
			ids.substring(2, ids.length());
		}
		System.out.println("ids====="+ids);
		String[] ids_arr = ids.split(",");
		List<User> list = new ArrayList<User>();
		for(int i=0;i<ids_arr.length;i++)
		{
			int temp =Integer.parseInt(ids_arr[i]);
			User usr = userService.loadUserById(temp);
			if("admin".equals(usr.getUsername()))
			{
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("url", "userlist.jsp");
				request.setAttribute("info", "admin用户不能被删除，正在跳转....");
				return this.ERROR;
			}
			list.add(usr);	
		}
		userService.deleteCheckedUser(list);
		
		return this.SUCCESS;
	}	
}
