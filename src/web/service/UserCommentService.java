package web.service;

import java.util.Map;

import web.base.IBaseService;
import web.base.Pager;
import web.base.Pagination;
import web.model.UserComment;

public interface UserCommentService extends IBaseService{
	
	/**
	 * 根据参数map查找用户集
	 * @param paramMap	查询参数
	 * @param pager
	 * @return
	 */
	public Pagination<UserComment> getUserCommentList(Map<String,Object> paramMap,Pager pager);

}
