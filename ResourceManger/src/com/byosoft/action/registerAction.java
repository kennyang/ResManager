package com.byosoft.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.po.Device;
import com.byosoft.po.User;
import com.byosoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class registerAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String repassword;
	private String chinesename;
	private String phonenumber;
	private String email;
	private String isworker;
	private int id;
	private int currentPage;
	private List<User> userlist;
	
	private UserService userService;

	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getIsworker() {
		return isworker;
	}

	public void setIsworker(String isworker) {
		this.isworker = isworker;
	}
	public String get() throws Exception
	{
		System.out.println("get called");
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid = request.getParameter("Id");
		User user = userService.loadUserById(Integer.parseInt(userid));
		
		request.setAttribute("Id",userid);
		request.setAttribute("username", user.getUsername());
		
		request.setAttribute("password", user.getPassword());
		request.setAttribute("chinesename", user.getChinesename());
		request.setAttribute("phonenumber", user.getPhonenumber());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("isworker", user.getIsworker());
		
		return "getsuccess";	
	}
	
	public String view() throws Exception
	{
		System.out.println("view called");
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid = request.getParameter("Id");
		User user = userService.loadUserById(Integer.parseInt(userid));
		
		request.setAttribute("Id",userid);
		request.setAttribute("username", user.getUsername());
		
		request.setAttribute("password", user.getPassword());
		request.setAttribute("chinesename", user.getChinesename());
		request.setAttribute("phonenumber", user.getPhonenumber());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("isworker", user.getIsworker());
		
		return "viewsuccess";	
	}
	
	public String delete() throws Exception
	{
		System.out.println("delete called");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid = request.getParameter("Id");
		User user = userService.loadUserById(Integer.parseInt(userid));
		
		if("admin".equals(user.getUsername()))
		{
			request.setAttribute("url", "userlist.jsp");
			request.setAttribute("info", "admin用户不能被删除！正在跳转....");
			return this.ERROR;
		}
		
		
		if(userService.deleteUser(user))
		{
			//devicelist = deviceService.loadAllDevice();
			return "deletesuccess";
		}
		else
		{
			return this.ERROR;
		}
	}
	
	
	public String update() throws Exception
	{
		
		System.out.println("update called");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setChinesename(chinesename);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setIsworker(isworker);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		user.setId(Integer.parseInt(request.getParameter("Id")));
		
		
		if(userService.updateUser(user))
		{
			
			return "updatesuccess";
		}
		else
		{
			return this.ERROR;
		}
		
	}
	
	public String register() throws Exception {	
		System.out.println("username="+username);
		System.out.println("password="+password);
		System.out.println("repassword="+repassword);
		System.out.println("chinesename="+chinesename);
		System.out.println("phonenumber="+phonenumber);
		System.out.println("email="+email);
		System.out.println("isworker="+isworker);

		User user =new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setChinesename(chinesename);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setIsworker(isworker);
		
		if(userService.registerUser(user))
		{
			return "registersuccess";
		}
		else
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("url", "user.jsp");
			request.setAttribute("info", "用户名已存在，新增用户失败，正在跳转....");			
			return this.ERROR;
		}
	}
	
}
