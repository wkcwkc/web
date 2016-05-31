package web.controller.website;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.base.BaseController;
import web.globel.GlobalDefine;
import web.model.User;
import web.service.UserService;
import web.sessionmodel.LoginSession;

@RequestMapping("/login")
@Controller
public class LoginController extends BaseController{
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "")
	public String login(Model model, HttpServletRequest request,HttpServletResponse response)
	{
		return "/website/login/login";
	}
	
	@RequestMapping(value = "startlogin")
	public void startLogin(String name,String password,HttpServletRequest request,HttpServletResponse response)
	{	
		LoginSession loginSession=new LoginSession();
		User user=userService.getUser(name,password);
		if(user!=null)
		{
			loginSession.setId(user.getId());
			loginSession.setName(name);
			loginSession.setStatus(GlobalDefine.SESSION_LOGIN_STATUS.SESSION_LOGIN_IN);
			request.getSession().setAttribute(GlobalDefine.SESSION_LOGIN_USER,loginSession);
			responsePrintResult(response, GlobalDefine.JS_DEFINED.JS_RESULT.SUCCESS);
		}
		else
		{
			responsePrintResult(response, GlobalDefine.JS_DEFINED.JS_RESULT.ERROR);			
		}					
	}
	
	@RequestMapping(value = "loginout")
	public String loginOut(HttpServletRequest request,HttpServletResponse response)
	{
		LoginSession loginSession=getLoginUser(request);
		loginSession.setStatus(GlobalDefine.SESSION_LOGIN_STATUS.SESSION_LOGIN_OUT); 
		request.getSession().setAttribute(GlobalDefine.SESSION_LOGIN_USER, loginSession);
		return "/website/login/login";
	}
	
	@RequestMapping(value = "register")
	public String register(HttpServletRequest request,HttpServletResponse response)
	{
	
		return "/website/login/register";
	}
	@RequestMapping(value = "registersave")
	public void register(User user,HttpServletRequest request,HttpServletResponse response)
	{
		userService.save(user);
		responsePrintResult(response,GlobalDefine.JS_DEFINED.JS_RESULT.SUCCESS);
	}
	
}
