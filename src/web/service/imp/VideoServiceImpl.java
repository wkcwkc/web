package web.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import web.base.BaseServiceImpl;
import web.base.Pager;
import web.base.Pagination;
import web.dao.VideoDao;
import web.model.Video;
import web.service.VideoService;
import web.util.QueryResult;

@Service("videoService")
public class VideoServiceImpl extends BaseServiceImpl<Video> implements VideoService{
	
	Logger log = Logger.getLogger(VideoServiceImpl.class);

	@Resource(name = "videoDao")
	private VideoDao videoDao;
	
	public Pagination<Video> getVideoList(Map<String,Object> paramMap,Pager pager)
	{
		Pagination<Video> pagination = new Pagination<Video>();
		QueryResult<Video> queryResult = videoDao.findList(paramMap,
				pager.getStartIndex(), pager.getPageSize(),
				pager.getSort(), pager.getDir());
			
		List<Video> list = queryResult.getResultlist();
		pager.calcPageCount(queryResult.getTotalrecord());
		pagination.setRecords(list);
		pagination.setPager(pager);
		return pagination;	
	}

}
