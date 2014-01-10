package edu.tongji.anliantest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController extends BaseController {
	@RequestMapping(value = "/project")
	public String projectPage(){
		return "project";
	}
	
	@RequestMapping(value = "/experiment")
	public String experimentPage(){
		return "experiment";
	}
	
	@RequestMapping(value = "/document")
	public String documentPage(){
		return "document";
	}
	
	@RequestMapping(value = "/message")
	public String messagePage(){
		return "message";
	}
}
