package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import web.globel.GlobalDefine;
import web.sessionmodel.LoginSession;

public class LoginFilter implements Filter {

	Logger log = Logger.getLogger(LoginFilter.class);
	
	private static final boolean openFilter=true;

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		if(!openFilter){
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String contextPath=request.getContextPath();
		String reqURI = request.getRequestURI();
		
//		System.out.println("contextPath:"+contextPath);
//		System.out.println("reqURI:"+reqURI);
		if (reqURI.endsWith("index")||reqURI.endsWith("admin")||reqURI.endsWith("startlogin")||reqURI.endsWith("login"))
		{
			chain.doFilter(servletRequest, servletResponse);
		}
		else
		{
			if(reqURI.startsWith(contextPath+"/index"))
			{
				LoginSession loginSession=(LoginSession)request.getSession().getAttribute(web.globel.GlobalDefine.SESSION_LOGIN_USER);
				if(loginSession==null)
				{				
					response.sendRedirect(request.getContextPath() + "/login");
				}
				else
				{
					if(loginSession.getStatus()==GlobalDefine.SESSION_LOGIN_STATUS.SESSION_LOGIN_IN)
					{
						chain.doFilter(servletRequest, servletResponse);
						return;	
					}
					else
						response.sendRedirect(request.getContextPath() + "/login");
				}
			}
			else
			{
				LoginSession loginSession=(LoginSession)request.getSession().getAttribute(web.globel.GlobalDefine.SESSION_LOGIN_ADMIN);
				if(loginSession==null)
				{
					response.sendRedirect(request.getContextPath() + "/admin");					
				}
				else
				{
					if(loginSession.getStatus()==GlobalDefine.SESSION_LOGIN_STATUS.SESSION_LOGIN_IN)
					{
						chain.doFilter(servletRequest, servletResponse);
						return;	
					}
					else
						response.sendRedirect(request.getContextPath() + "/admin");			
				}
			}
			
		}
		
	}

	public void init(FilterConfig config) throws ServletException {
	}

}
