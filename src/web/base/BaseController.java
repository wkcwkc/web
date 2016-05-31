package web.base;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import web.globel.GlobalDefine;
import web.sessionmodel.LoginSession;

public class BaseController {

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
		binder.registerCustomEditor(Double.class, new CustomNumberEditor(
				Double.class, true));
	}

	/**
	 * 异步请求返回结果
	 * 
	 * @param request
	 * @param result
	 */
	protected void responsePrintResult(HttpServletResponse response,
			Object result) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(result);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取前台登录用户名
	 * */
	protected LoginSession getLoginUser(HttpServletRequest request) {
		LoginSession loginSession = (LoginSession) request.getSession()
				.getAttribute(GlobalDefine.SESSION_LOGIN_USER);
		return loginSession;
	}
	
	/**
	 * 获取后台登录用户名
	 * */
	protected LoginSession getLoginAdmin(HttpServletRequest request) {
		LoginSession loginSession = (LoginSession) request.getSession()
				.getAttribute(GlobalDefine.SESSION_LOGIN_ADMIN);
		return loginSession;
	}

}
