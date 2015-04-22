package com.byosoft.dao;

import java.util.List;

import com.byosoft.fenye.Page;
import com.byosoft.po.Tool;

public interface ToolDAO {
	public Tool queryToolByID(int id);
	public int querySearchCount(String alias);
	public List<Tool> queryToolByAlias(String alias,Page page);
}
