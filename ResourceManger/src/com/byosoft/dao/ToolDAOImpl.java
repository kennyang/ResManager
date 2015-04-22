package com.byosoft.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.byosoft.fenye.Page;
import com.byosoft.po.Device;
import com.byosoft.po.Tool;

public class ToolDAOImpl extends HibernateDaoSupport implements ToolDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Tool queryToolByID(int id) {
		// TODO Auto-generated method stub
		List<Tool> temp = (List<Tool>)this.getHibernateTemplate().find("select tool from Tool tool where Id ="+id);
		return temp.get(0);
	}

	@Override
	public int querySearchCount(String alias) {
		// TODO Auto-generated method stub
		if(alias==null)
			alias = "";
		
		String sql="select count(*) from Tool tool";				
		if(alias.isEmpty())		
			sql="select count(*) from Tool Tool";
		if(!alias.isEmpty())
			sql="select count(*) from Tool tool where tool.alias like '%"+alias+"%'";
		
		
		List find = this.getHibernateTemplate().find(sql);
		return ((Long)find.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tool> queryToolByAlias(final String alias, final Page page) {
		// TODO Auto-generated method stub
		return	this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
		@Override
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			// TODO Auto-generated method stub
			String sql="select tool from Tool tool";				
			if(alias.isEmpty())		
				sql="select tool from Tool tool";
			if(!alias.isEmpty())
				sql="select tool from Tool tool where tool.alias like '%"+alias+"%'";
			Query query = session.createQuery(sql);
			
			query.setMaxResults(page.getEveryPage());
			
			query.setFirstResult(page.getBeginIndex());
			return query.list();
		}
	});
	}

}
