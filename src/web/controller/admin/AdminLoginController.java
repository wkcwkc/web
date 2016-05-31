package web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.base.BaseController;
import web.base.Pager;
import web.globel.GlobalDefine;
import web.model.User;
import web.service.UserService;
import web.sessionmodel.LoginSession;

@RequestMapping("/admin")
@Controller
public class AdminLoginController extends BaseController{
	
	private static final Logger log = Logger.getLogger(AdminLoginController.class);
	
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "")
	public String login(Model model, HttpServletRequest request,HttpServletResponse response)
	{
		return "admin/login/login";		
	}
	
	@RequestMapping(value = "startlogin")
	public void startLogin(String name,String password,HttpServletRequest request,HttpServletResponse response)
	{	
		LoginSession loginSession=new LoginSession();
		User user=userService.getUser(name,password);
		if(user!=null)
		{
			if(user.getLevel()==100)
			{
				loginSession.setId(user.getId());
				loginSession.setName(name);
				loginSession.setStatus(GlobalDefine.SESSION_LOGIN_STATUS.SESSION_LOGIN_IN);
				request.getSession().setAttribute(GlobalDefine.SESSION_LOGIN_ADMIN,loginSession);
				responsePrintResult(response, GlobalDefine.JS_DEFINED.JS_RESULT.SUCCESS);
			}
		}
		else
		{
			responsePrintResult(response, GlobalDefine.JS_DEFINED.JS_RESULT.ERROR);			
		}					
	}
	
	@RequestMapping(value = "loginout")
	public String loginOut(String name,String password,HttpServletRequest request,HttpServletResponse response)
	{
		LoginSession loginSession=getLoginAdmin(request);
		loginSession.setStatus(GlobalDefine.SESSION_LOGIN_STATUS.SESSION_LOGIN_OUT); 
		request.getSession().setAttribute(GlobalDefine.SESSION_LOGIN_ADMIN, loginSession);
		
		return "admin/login/login";	
	}
	
	@RequestMapping(value = "menu")
	public String menu(Model model, HttpServletRequest request,HttpServletResponse response)
	{
		return "admin/menu";		
	}
	
}
