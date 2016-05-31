package web.util;

import java.util.List;
import java.util.Map;

public class CreateHQL {
	
	public static void createFindHQL(Map<String,Object> paramMap,StringBuffer hql,List<Object> params)
	{
		hql.append(" 1 = 1 ");
		
		for(String key:paramMap.keySet())
		{
			if(paramMap.get(key).getClass()==String.class)
			{
				hql.append(" and "+key+" like ? ");
				params.add("%" + paramMap.get(key) + "%");
			}
			if(paramMap.get(key).getClass()==Integer.class)
			{
				hql.append(" and "+key+" = ? ");
				params.add(paramMap.get(key));
			}		
		}
		
	}

}
