package web.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import web.base.BaseHibernateDao;
import web.model.VideoImg;

@Repository("videoImgDao")
public class VideoImgDao extends BaseHibernateDao<VideoImg,Long>{

	Logger log = Logger.getLogger(VideoImgDao.class);
	
	
}
