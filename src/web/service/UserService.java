package web.service;

import java.util.Map;

import web.base.IBaseService;
import web.base.Pager;
import web.base.Pagination;
import web.model.User;


public interface UserService extends IBaseService{
		
	/**
	 * 根据参数map查找用户集
	 * @param paramMap	查询参数
	 * @param pager
	 * @return
	 */
	public Pagination<User> getUserList(Map<String,Object> paramMap,Pager pager);
	/**
	 * 根据用户名、密码查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	public User getUser(String name,String password);
}
