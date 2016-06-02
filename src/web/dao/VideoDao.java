package web.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import web.base.BaseHibernateDao;
import web.model.Video;

@Repository("videoDao")
public class VideoDao extends BaseHibernateDao<Video,Integer>{

	Logger log = Logger.getLogger(VideoDao.class);
}
