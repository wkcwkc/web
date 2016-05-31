package web.base;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BaseServiceImpl implements IBaseService {

	@Resource(name = "baseDao")
	private BaseHibernateDao<Object, Long> baseDao;

	@SuppressWarnings("rawtypes")
	public Object find(Class clazz, Long id) {
		return baseDao.get(clazz, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Object o) {
		baseDao.remove(o);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer save(Object o) {
		return baseDao.save(o);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object o) {
		baseDao.saveOrUpdate(o);
	}

	
	public void validateArgs(Object... args) {
		for (Object temp : args) {
			if (temp==null) {
				throw new BusinessException("对象不能为空");
			}
			if (temp instanceof String) {
				if (StringUtils.isEmpty(temp.toString())) {
					throw new BusinessException("参数不能为空");
				}
			}
		}
	}

}
