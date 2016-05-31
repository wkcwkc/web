package web.controller.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Controller
public class IndexController {
	private static final Logger log = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value = "")
	public String index(Model model, HttpServletRequest request,HttpServletResponse response)
	{
		return "website/index";		
	}
	
	@RequestMapping(value = "menu")
	public String menu(Model model, HttpServletRequest request,HttpServletResponse response)
	{
		return "website/menu";		
	}
		
}
