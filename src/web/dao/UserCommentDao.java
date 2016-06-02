package web.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import web.base.BaseHibernateDao;
import web.model.UserComment;

@Repository("userCommentDao")
public class UserCommentDao extends BaseHibernateDao<UserComment,Long>{

	Logger log = Logger.getLogger(UserCommentDao.class);
}
