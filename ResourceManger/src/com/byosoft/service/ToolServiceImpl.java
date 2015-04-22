package com.byosoft.service;

import java.util.List;

import com.byosoft.dao.ToolDAO;
import com.byosoft.fenye.Page;
import com.byosoft.fenye.PageUtil;
import com.byosoft.fenye.Result;
import com.byosoft.po.Device;
import com.byosoft.po.Tool;

public class ToolServiceImpl implements ToolService {

	private ToolDAO toolDAO;
	
	public ToolDAO getToolDAO() {
		return toolDAO;
	}
	public void setToolDAO(ToolDAO toolDAO) {
		this.toolDAO = toolDAO;
	}
	@Override
	public Tool loadToolById(int id) {
		// TODO Auto-generated method stub
		return toolDAO.queryToolByID(id);

	}
	@Override
	public Result LoadToolByAlias(String alias, Page page) {
		// TODO Auto-generated method stub
		if(alias==null)
			alias = "";

		page = PageUtil.createPage(page,toolDAO.querySearchCount(alias));
		List<Tool> all = toolDAO.queryToolByAlias(alias, page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}

}
