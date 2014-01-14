package edu.tongji.anliantest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseController {
	@RequestMapping(value = "/create")
	public String createProjectPage(){
		return "projectCreate";
	}
	
	@RequestMapping(value = "/edit")
	public String editProjectPage(){
		return "projectEdit";
	}
	
	@RequestMapping(value = "/process/step1")
	public String processStep1Page(){
		return "project_step1";
	}
}	
