package web.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import web.base.BaseServiceImpl;
import web.base.Pager;
import web.base.Pagination;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;
import web.util.QueryResult;


@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	Logger log = Logger.getLogger(User.class);

	@Resource(name = "userDao")
	private UserDao userDao;
	
	public Pagination<User> getUserList(Map<String,Object> paramMap,Pager pager)
	{
		Pagination<User> pagination = new Pagination<User>();
		QueryResult<User> queryResult = userDao.findList(paramMap,
				pager.getStartIndex(), pager.getPageSize(),
				pager.getSort(), pager.getDir());
			
		List<User> list = queryResult.getResultlist();
		pager.calcPageCount(queryResult.getTotalrecord());
		pagination.setRecords(list);
		pagination.setPager(pager);
		return pagination;	
	}
	
	public User getUser(String name,String password)
	{		
		QueryResult<User> queryResult = userDao.findUser(name,password);
			
		List<User> list = queryResult.getResultlist();
		if(list.size()!=0)
			return list.get(0);
		else
			return null;
	}

}
