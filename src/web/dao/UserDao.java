package web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import web.base.BaseHibernateDao;
import web.globel.GlobalDefine;
import web.model.User;
import web.util.CreateHQL;
import web.util.QueryResult;


@Repository("userDao")
public class UserDao extends BaseHibernateDao<User,Long>{

	Logger log = Logger.getLogger(User.class);
	
	/**
	 * 按id查询
	 * */
	public User get(Integer id) {
		return super.getHibernateTemplate().get(User.class, id);
	}
	/**
	 * 根据参数map查找用户集
	 * @param paramMap 		查询参数
	 * @param firstindex	
	 * @param maxresult
	 * @param sort			排序字段
	 * @param order			排序方式
	 * @return
	 */
	public QueryResult<User> findUserList(Map<String,Object> paramMap,
			Integer firstindex,Integer maxresult, String sort,String order)
	{
		StringBuffer hql = new StringBuffer("");
		List<Object> params = new ArrayList<Object>();
		
		CreateHQL.createFindHQL(paramMap,hql,params);
		
		return getQueryResult(firstindex, maxresult, hql.toString(),
				params.toArray(), sort, order);		
	}
	
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
