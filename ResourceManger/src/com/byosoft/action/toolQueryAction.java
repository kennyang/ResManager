package com.byosoft.action;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byosoft.po.Tool;
import com.byosoft.service.ToolService;
import com.opensymphony.xwork2.ActionSupport;

public class toolQueryAction extends ActionSupport {
	private String alias;
	private int id;
	private List<Tool> toollist;
	
	
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("alias", this.alias);
		System.out.println("======="+alias);
		return this.SUCCESS;
	}
}
