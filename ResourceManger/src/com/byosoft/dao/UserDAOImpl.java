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
import com.byosoft.po.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void update(final User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				final String sql="update User user set user.username='"+user.getUsername()+
						"',user.password='"+user.getPassword()+
						"',user.chinesename='"+user.getChinesename()+
						"',user.phonenumber='"+user.getPhonenumber()+
						"',user.email='"+user.getEmail()+
						"' where user.Id ='"+user.getId()+"'";
				Query query = session.createQuery(sql);
				query.executeUpdate();
				return null;
			}
		});
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAllUser(final Page page) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("select user from User user");
				query.setMaxResults(page.getEveryPage());
				
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
		});

	}

	@Override
	public User queryByUsername(String username) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().find("select user from User user where user.username='"+username+"'");
		if(list.size()==0)
		{
			return null;
		}
		else
		{
			return (User)list.get(0);
		}
	}

	@Override
	public int querySearchCount(String username) {
		// TODO Auto-generated method stub
		
		if(username==null)
			username = "";
		
		String sql="select count(*) from User user";				
		if(username.isEmpty())		
			sql="select count(*) from User user";
		if(!username.isEmpty())
			sql="select count(*) from User user where username = '"+username+"'";
		
		
		List find = this.getHibernateTemplate().find(sql);
		return ((Long)find.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryUserByUserName(final String username, final Page page) {
		// TODO Auto-generated method stub
		return	this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
		@Override
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			// TODO Auto-generated method stub
			String sql="select user from User user";				
			if(username.isEmpty())		
				sql="select user from User user";
			if(!username.isEmpty())
				sql="select user from User user where username = '"+username+"'";
			Query query = session.createQuery(sql);
			
			query.setMaxResults(page.getEveryPage());
			
			query.setFirstResult(page.getBeginIndex());
			return query.list();
		}
	});
	}

	@Override
	public void delete(List<User> userlist) {
		this.getHibernateTemplate().deleteAll(userlist);	
	}

	@Override
	public int queryAllCount() {
		// TODO Auto-generated method stub
		List find = this.getHibernateTemplate().find("select count(*) from User user");
		return ((Long)find.get(0)).intValue();
	}

	@Override
	public User queryUserByID(int id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> temp = (List<User>)this.getHibernateTemplate().find("select user from User user where Id ="+id);
		return temp.get(0);
	}

}
