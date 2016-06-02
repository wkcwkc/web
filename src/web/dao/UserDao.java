package web.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import web.base.BaseHibernateDao;
import web.globel.GlobalDefine;
import web.model.User;
import web.util.QueryResult;


@Repository("userDao")
public class UserDao extends BaseHibernateDao<User,Long>{

	Logger log = Logger.getLogger(UserDao.class);
		
	public QueryResult<User> findUser(String name,String password)
	{
		StringBuffer hql = new StringBuffer(" 1 = 1 ");
		List<Object> params = new ArrayList<Object>();
			
		hql.append(" and name=?");
		params.add(name);
		hql.append(" and password=?");
		params.add(password);
		
		return getQueryResult(0, 10, hql.toString(),
				params.toArray(), "id", GlobalDefine.SORT_DIR.DESC);		
	}
}
