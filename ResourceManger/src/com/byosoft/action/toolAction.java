package com.byosoft.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.po.Tool;
import com.byosoft.service.DeviceService;
import com.byosoft.service.ToolService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class toolAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String alias;
	private String path;
	private String filename;
	private int id;
	private int currentPage;

	private List<Tool> toollist;
	
	private ToolService toolService;
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Tool> getToollist() {
		return toollist;
	}

	public void setToollist(List<Tool> toollist) {
		this.toollist = toollist;
	}

	public ToolService getToolService() {
		return toolService;
	}

	public void setToolService(ToolService toolService) {
		this.toolService = toolService;
	}

	
	public String download() throws Exception
	{
		System.out.println("view called");
		HttpServletRequest request = ServletActionContext.getRequest();
		String toolid = request.getParameter("Id");
		System.out.println("toolid====="+toolid);
		Tool tool = toolService.loadToolById(Integer.parseInt(toolid));
		
		request.setAttribute("Id",toolid);
		request.setAttribute("alias", tool.getAlias());
		request.setAttribute("path", tool.getPath());
		request.setAttribute("filename", tool.getFilename());
		
		return "viewsuccess";	
	}

}
