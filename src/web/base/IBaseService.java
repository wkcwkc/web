package web.base;

public interface IBaseService {

	/**
	 * 根据主键id和对象class，获得对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object find(Class clazz, Long id);

	/**
	 * 删除
	 * 
	 * @param o
	 */
	public void remove(Object o);
	

	/**
	 * 保存
	 * 
	 * @param o
	 * @return
	 */
	public Integer save(Object o);

	/**
	 * 更新
	 * 
	 * @param o
	 */
	public void update(Object o);

}
