package com.byosoft.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.po.Tool;
import com.byosoft.po.User;
import com.byosoft.service.DeviceService;
import com.byosoft.service.ToolService;
import com.byosoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class showSearchToolListAction extends ActionSupport {
	
	private int currentPage;
	private ToolService toolService;
	private List<Tool> toollist;
	
	
	private String alias;
	

	public ToolService getToolService() {
		return toolService;
	}

	public void setToolService(ToolService toolService) {
		this.toolService = toolService;
	}

	public List<Tool> getToollist() {
		return toollist;
	}

	public void setToollist(List<Tool> toollist) {
		this.toollist = toollist;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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
			
		String alias = (String) request.getAttribute("alias");
		
		System.out.println("alias======="+alias);
		
		Result reuslt = toolService.LoadToolByAlias(alias, page);
		page = reuslt.getPage();
		
		toollist = reuslt.getList();
		
		request.setAttribute("all", toollist);
		request.setAttribute("page", page);
		
		return this.SUCCESS;
	}

}
