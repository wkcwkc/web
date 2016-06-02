package web.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import web.base.BaseServiceImpl;
import web.base.Pager;
import web.base.Pagination;
import web.dao.VideoImgDao;
import web.model.VideoImg;
import web.service.VideoImgService;
import web.util.QueryResult;

@Service("videoImgService")
public class VideoImgServiceImpl extends BaseServiceImpl<VideoImg> implements VideoImgService{

	Logger log = Logger.getLogger(VideoImgServiceImpl.class);

	@Resource(name = "videoImgDao")
	private VideoImgDao videoImgDao;
	
	public Pagination<VideoImg> getVideoImgList(Map<String,Object> paramMap,Pager pager)
	{
		Pagination<VideoImg> pagination = new Pagination<VideoImg>();
		QueryResult<VideoImg> queryResult = videoImgDao.findList(paramMap,
				pager.getStartIndex(), pager.getPageSize(),
				pager.getSort(), pager.getDir());
			
		List<VideoImg> list = queryResult.getResultlist();
		pager.calcPageCount(queryResult.getTotalrecord());
		pagination.setRecords(list);
		pagination.setPager(pager);
		return pagination;	
	}


}
