package com.byosoft.service;

import com.byosoft.fenye.Page;
import com.byosoft.fenye.Result;
import com.byosoft.po.Tool;

public interface ToolService {
	public Tool loadToolById(int id);
	public Result LoadToolByAlias(String alias, Page page);
}
