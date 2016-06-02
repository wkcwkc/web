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
import web.base.Pagination;
import web.model.User;
import web.model.UserComment;
import web.model.Video;
import web.model.VideoImg;
import web.service.UserCommentService;
import web.service.UserService;
import web.service.VideoImgService;
import web.service.VideoService;


@RequestMapping("/test")
@Controller
public class TestController {

	private static final Logger log = Logger.getLogger(TestController.class);
			
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "videoImgService")
	private VideoImgService videoImgService;
	
	@Resource(name = "videoService")
	private VideoService videoService;
	
	@Resource(name = "userCommentService")
	private UserCommentService userCommentService;
	
	@RequestMapping(value = "")
	public String index(Model model, HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> paramMap=new HashMap<String,Object>();
		
		Pager pager=new Pager();
		pager.setPageSize(10); 
		paramMap.put("level",100);
		Pagination<User> paginationUser=userService.getUserList(paramMap, pager);
		User user=paginationUser.getRecords().get(0);
		//User user=(User) userService.find(1);
		model.addAttribute("user", user);
		
		VideoImg videoImg=(VideoImg) videoImgService.find(1);
		model.addAttribute("videoImg", videoImg);
		
		Video video=(Video) videoService.find(1);
		model.addAttribute("video", video);
		
		UserComment userComment=(UserComment) userCommentService.find(1);
		model.addAttribute("userComment", userComment);
		
		return "/test";
	}
			
}
