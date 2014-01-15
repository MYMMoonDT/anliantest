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
	@RequestMapping(value = "/process/step3")
	public String processStep3Page(){
		return "project_step3";
	}
	@RequestMapping(value = "/process/step4")
	public String processStep4Page(){
		return "project_step4";
	}
	@RequestMapping(value = "/process/step7")
	public String processStep7Page(){
		return "project_step7";
	}@RequestMapping(value = "/process/step8")
	public String processStep8Page(){
		return "project_step8";
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
	
	@RequestMapping(value = "/process/step3/customerInfoRegister")
	public String processStep3CustomerInfoRegisterPage(){
		return "form/step3/project_step3_customerInfoRegister";
	}
	
	@RequestMapping(value = "/process/step3/companySelectionRegister")
	public String processStep3CompanySelectionRegisterPage(){
		return "form/step3/project_step3_companySelectionRegister";
	}
	
	@RequestMapping(value = "/process/step3/companySelectionCheckRegister")
	public String processStep3CompanySelectionCheckRegisterPage(){
		return "form/step3/project_step3_companySelectionCheckRegister";
	}

	@RequestMapping(value = "/process/step3/fieldInvestigation")
	public String processStep3FieldInvestigationPage(){
		return "form/step3/project_step3_fieldInvestigation";
	}
	
	@RequestMapping(value = "/process/step3/publicTestNotification")
	public String processStep3PublicTestNotificationPage(){
		return "form/step3/project_step3_publicTestNotification";
	}
	
	@RequestMapping(value = "/process/step3/publicTestSamplePlanAir")
	public String processStep3PublicTestSamplePlanAir(){
		return "form/step3/project_step3_publicTestSamplePlanAir";
	}
	
	@RequestMapping(value = "/process/step4/equipmentWarehouseRecord")
	public String processStep4EquipmentWarehouseRecordPage(){
		return "form/step4/project_step4_equipmentWarehouseRecord";
	}
	
	@RequestMapping(value = "/process/step4/fieldEquipmentRecord")
	public String processStep4FieldEquipmentRecordPage(){
		return "form/step4/project_step4_fieldEquipmentRecord";
	}
	
	@RequestMapping(value = "/process/step4/publicTestSampleRecordAir")
	public String processStep4PublicTestSampleRecordAirPage(){
		return "form/step4/project_step4_publicTestSampleRecordAir";
	}
}	
