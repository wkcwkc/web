package web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.base.Pager;
import web.model.User;
import web.service.UserService;


@RequestMapping("/test")
@Controller
public class TestController {

	private static final Logger log = Logger.getLogger(TestController.class);
			
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "")
	public String index(Model model, HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> paramMap=new HashMap<String,Object>();
		
		Pager pager=new Pager();
		pager.setPageSize(10); 
		
		paramMap.put("level",100);
		User user=userService.getUserList(paramMap, pager).getRecords().get(0);
		
		model.addAttribute("user", user);
		
		return "/test";
	}
			
}
