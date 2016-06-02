package web.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import web.base.BaseServiceImpl;
import web.base.Pager;
import web.base.Pagination;
import web.dao.UserCommentDao;
import web.model.UserComment;
import web.service.UserCommentService;
import web.util.QueryResult;

@Service("userCommentService")
public class UserCommentServiceImpl extends BaseServiceImpl<UserComment> implements UserCommentService{
	
	Logger log = Logger.getLogger(UserCommentServiceImpl.class);

	@Resource(name = "userCommentDao")
	private UserCommentDao userCommentDao;
	
	public Pagination<UserComment> getUserCommentList(Map<String,Object> paramMap,Pager pager)
	{
		Pagination<UserComment> pagination = new Pagination<UserComment>();
		QueryResult<UserComment> queryResult = userCommentDao.findList(paramMap,
				pager.getStartIndex(), pager.getPageSize(),
				pager.getSort(), pager.getDir());
			
		List<UserComment> list = queryResult.getResultlist();
		pager.calcPageCount(queryResult.getTotalrecord());
		pagination.setRecords(list);
		pagination.setPager(pager);
		return pagination;	
	}

}
