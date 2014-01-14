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
	
	@RequestMapping(value = "/process/step1/entrustAgreement")
	public String processStep1EntrustAgreementPage(){
		return "form/step1/project_step1_entrustAgreement";
	}
	
	@RequestMapping(value = "/process/step1/contractReviewForm")
	public String processStep1ContractReviewFormPage(){
		return "form/step1/project_step1_contractReviewForm";
	}
	
	@RequestMapping(value = "/process/step1/contractModifyApplication")
	public String processStep1ContractModifyApplicationPage(){
		return "form/step1/project_step1_contractModifyApplication";
	}
}	
