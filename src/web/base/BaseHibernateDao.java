package web.base;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import web.model.User;
import web.util.CreateHQL;
import web.util.QueryResult;

@Repository("baseDao")
public class BaseHibernateDao<T, ID extends Serializable> extends HibernateDaoSupport {

	private Class<T> entityClass;
	private String entityName;
	private Field[] fields;
	private final Logger logger = Logger.getLogger(BaseHibernateDao.class);

	protected BaseHibernateDao() {
		entityClass = getSuperClassGenricType(this.getClass());
		entityName = entityClass.getSimpleName();
		this.fields = this.entityClass.getDeclaredFields();
	}

	/**
	 * 保存对象.
	 */
	public Integer save(T o) {
		return (Integer) getHibernateTemplate().save(o);
	}

	/**
	 * 保存或更新对象
	 */
	public void saveOrUpdate(T o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	/**
	 * 保存或更新对象
	 */
	public void merge(T o) {
		getHibernateTemplate().merge(o);
	}

	/**
	 * 根据ID获取对象.
	 */
	public Object get(Class<? extends Object> entityClass,ID id) {
		return super.getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 根据条件查询对象集合.
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] param) {
		return super.getHibernateTemplate().find(hql, param);
	}

	/**
	 * 按某属性值查询
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProp(String name, Object value) {
		return (List<T>) super.getHibernateTemplate().find("from " + entityClass.getSimpleName() + " where " + name + "=?", value);
	}

	/**
	 * 删除对象.
	 */
	public void remove(T o) {
		super.getHibernateTemplate().delete(o);
	}

	/**
	 * 查找所有对象
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> selectAll() {
		String queryString = "from " + entityClass.getSimpleName();
		return getHibernateTemplate().find(queryString);
	}

	/**
	 * 根据参数通过HQL语句获得查询结果
	 * 
	 * @param firstindex
	 *            查询�?��索引（第�?���?�?
	 * @param maxresult
	 *            记录�?
	 * @param wherejpql
	 *            查询语句
	 * @param queryParams
	 *            查询条件
	 * @param sort
	 *            排序字段
	 * @param order
	 *            排序方式
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public QueryResult<T> getQueryResult(Integer firstindex, Integer maxresult, String wherejpql, Object[] queryParams, String sort, String order) {
		Session session = getSession();
		QueryResult<T> qr = new QueryResult<T>();
		String entityname = getEntityName(this.entityClass);
		Query query = session.createQuery("select o from " + entityname + " o "
				+ (wherejpql == null || "".equals(wherejpql.trim()) ? "" : "where " + wherejpql) + buildOrderby(sort, order));
		setQueryParams(query, queryParams);
		if (firstindex != null && maxresult != null)
			query.setFirstResult(firstindex).setMaxResults(maxresult);
		List<T> list = query.list();
		qr.setResultlist(list);
		
//		query = session.createQuery("select count(*) from " + entityname + " o "
//				+ (wherejpql == null || "".equals(wherejpql.trim()) ? "" : "where " + wherejpql));
//		setQueryParams(query, queryParams);
//		query.setFirstResult(0).setMaxResults(1);		
//		qr.setTotalrecord((Long) query.uniqueResult());
		
		qr.setTotalrecord(new Long(list.size()));
		session.close();
		return qr;
	}

	/**
	 * 获取实体的名�?
	 * 
	 * @param <E>
	 * @param clazz
	 *            实体�?
	 * @return
	 */
	private <E> String getEntityName(Class<E> clazz) {
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if (entity != null) {
			if (entity.name() != null && !"".equals(entity.name())) {
				entityname = entity.name();
			}
		}
		return entityname;
	}

	/********************** 构建查询语句工具方法 ******************************/
	private void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
	}

	private <E> String getCountField(Class<E> clazz) {
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors) {
				Method method = propertydesc.getReadMethod();
				if (method != null && method.isAnnotationPresent(EmbeddedId.class)) {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					out = "o." + propertydesc.getName() + "." + (!ps[1].getName().equals("class") ? ps[1].getName() : ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	/****
	 * 构建order by 条件语句
	 ***/
	private String buildOrderby(String sort, String order) {
		StringBuffer orderbysql = new StringBuffer("");
		if (sort != null && !sort.equals("") && order != null && !order.equals("")) {
			orderbysql.append(" order by o.").append(sort).append(" ").append(order);
		}
		return orderbysql.toString();
	}

	/**
	 * 通过反射,获得指定类的父类的第�?��泛型参数的实际类�? 如BuyerServiceBean extends DaoSupport<Buyer>
	 * 
	 * @param clazz
	 *            clazz �?��反射的类,该类必须继承泛型父类
	 * @return 泛型参数的实际类�? 如果没有实现ParameterizedType接口，即不支持泛型，�?��直接返回
	 *         <code>Object.class</code>
	 */
	@SuppressWarnings("rawtypes")
	private Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	@SuppressWarnings({ "rawtypes" })
	private Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();// 得到泛型父类
		// 如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		// 返回表示此类型实际类型参数的Type对象的数�?数组里放的都是对应类型的Class, 如BuyerServiceBean extends
		// DaoSupport<Buyer,Contact>就返回Buyer和Contact类型
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
	
	/**
	 * 根据参数map查找用户集
	 * @param paramMap 		查询参数
	 * @param firstindex	
	 * @param maxresult
	 * @param sort			排序字段
	 * @param order			排序方式
	 * @return
	 */
	public QueryResult<T> findList(Map<String,Object> paramMap,
			Integer firstindex,Integer maxresult, String sort,String order)
	{
		StringBuffer hql = new StringBuffer("");
		List<Object> params = new ArrayList<Object>();
		
		CreateHQL.createFindHQL(paramMap,hql,params);
		
		return getQueryResult(firstindex, maxresult, hql.toString(),
				params.toArray(), sort, order);		
	}

}
