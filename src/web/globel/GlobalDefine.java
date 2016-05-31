package web.globel;

public class GlobalDefine {
	
	public final static String APP_NAME = "网站";
	
	/** 前台会话登陆用户 */
	public final static String SESSION_LOGIN_USER = "user_login";
	/** 后台会话登陆用户 */
	public final static String SESSION_LOGIN_ADMIN = "admin_login";
	/**登陆状态*/
	public static final class SESSION_LOGIN_STATUS {
		/**已登陆*/
		public final static Integer SESSION_LOGIN_IN=1;
		/**已登出*/
		public final static Integer SESSION_LOGIN_OUT=0;		
	}
	
	public final static String SUPER_SYSTEM_USER="admin";
	public final static String ADMIN_INIT_PASSWORD="123456xx";
			
	/**
	 * 存放图片的目录
	 */
	public final static String SAVEPATH = "D:\\upload\\web\\";

	//public final static String SAVEPATH = "/data/upload/web/";
	
	/***
	 * 站点域名
	 */
	//public final static String DOMAIN=	"http://www.xxx.com";
	
	public final static String DOMAIN=	"http://localhost";
	 
	
	/** 排序方式 */
	public static final class SORT_DIR {
		/** 正序 */
		public static final String ASC = "asc";
		/** 倒序 */
		public static final String DESC = "desc";
	}
	
	/**账号状态*/
	public final static class USER_STATUS{
		/**正常使用*/
		public static final Integer NOMORL=1;
		/**暂时关闭*/
		public static final Integer PRISON=2;
		/**永久禁止*/
		public static final Integer FORBIT=3;
	}
	
	
	public final static class JS_DEFINED {
		public final static class JS_RESULT{
			public static final String SUCCESS="success";
			public static final String ERROR="error";
			public static final String FORBID="forbid";
			public static final String FILLINFO="fillinfo";
			public static final String FAIL="fail";
		}
	}

}
