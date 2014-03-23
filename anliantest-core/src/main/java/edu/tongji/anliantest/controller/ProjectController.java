package edu.tongji.anliantest.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.anliantest.model.ContractReviewRecordTable;
import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.ProjectInfo;
import edu.tongji.anliantest.service.ContractReviewRecordService;
import edu.tongji.anliantest.service.EmployeeService;
import edu.tongji.anliantest.service.ProjectInfoService;

@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectInfoService projectInfoService;
	@Autowired
	private ContractReviewRecordService contractReviewRecordService;
	
	
	@RequestMapping(value="/createProject")//创建项目
	public ModelAndView createProject(HttpServletRequest request, ProjectInfo projectInfo){
		ModelAndView mad = new ModelAndView();
		
		EmployeeInfo businessEmployee = employeeService.getEmployeeByEmployeeName((String) request.getAttribute("businessEmployee"));
		EmployeeInfo projectEmployee = employeeService.getEmployeeByEmployeeName((String) request.getAttribute("projectEmployee"));
		projectInfo.setEmployeeInfoByBusinessEmployeeId(businessEmployee);//业务负责人
		projectInfo.setEmployeeInfoByProjectEmployeeId(projectEmployee);//项目负责人
		projectInfo.setProjectCreateTime(new Date());//创建日期
		projectInfoService.addProject(projectInfo);//持久化
		
		mad.addObject("projectInfo",projectInfo);
		mad.setViewName("forward:process/step1/contractReviewForm");
		
		return mad;
	}
	
	@RequestMapping(value="/createContractReviewRecordTable")//创建合同评审记录表
	public ModelAndView createContractReviewRecordTable(ContractReviewRecordTable contractReviewRecordTable){
		ModelAndView mad = new ModelAndView();
		int contactReviewRecordTableId = (int)contractReviewRecordService.getTableCount();
		contractReviewRecordTable.setTableId(contactReviewRecordTableId);
		contractReviewRecordTable.setTableNum("ALJC/JL07-03");
		
		contractReviewRecordService.addTable(contractReviewRecordTable);
		
		mad.setViewName("forward:process/step1/contractReviewForm");//mark
		return mad;
	}
	
	
	
	
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
	@RequestMapping(value = "/process/step2")
	public String processStep2Page(){
		return "project_step2";
	}
	@RequestMapping(value = "/process/step3")
	public String processStep3Page(){
		return "project_step3";
	}
	@RequestMapping(value = "/process/step4")
	public String processStep4Page(){
		return "project_step4";
	}
	@RequestMapping(value = "/process/step5")
	public String processStep5Page(){
		return "project_step5";
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
	
	@RequestMapping(value = "/process/step1/contractModifyNotification")
	public String processStep1ContractModifyNotificationPage(){
		return "form/step1/project_step1_contractModifyNotification";
	}
	
	@RequestMapping(value = "process/step1/techServiceContractPublicPlace")
	public String processStep1TechServiceContractPublicPlace(){
		return "form/step1/project_step1_techServiceContractPublicPlace";
	}
	
	@RequestMapping(value = "process/step1/techServiceContractWorkPlace")
	public String processStep1TechServiceContractWorkPlace(){
		return "form/step1/project_step1_techServiceContractWorkPlace";
	}
	
	@RequestMapping(value = "process/step1/techServiceContractConstrProjDiseasePreAssess")
	public String processStep1TechServiceContractConstrProjDiseasePreAssess(){
		return "form/step1/project_step1_techServiceContractConstrProjDiseasePreAssess";
	}
	
	@RequestMapping(value = "process/step1/techServiceContractConstrProjDiseaseCtrlEffect")
	public String processStep1TechServiceContractConstrProjDiseaseCtrlEffect(){
		return "form/step1/project_step1_techServiceContractConstrProjDiseaseCtrlEffect";
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
	@RequestMapping(value = "/process/step5/sampleRegestration")
	public String processStep5RegestrationPage(){
		return "form/step5/project_step5_sampleRegestration";
	}
	@RequestMapping(value = "/process/step5/testSampleExceptionHandle")
	public String processStep5TestSampleExceptionHandlePage(){
		return "form/step5/project_step5_testSampleExceptionHandle";
	}
	@RequestMapping(value = "/process/step5/sendReceiveRecord")
	public String procesStep5SendReceiveRecordPage(){
		return "form/step5/project_step5_sendReceiveRecord";
	}
	
	@RequestMapping(value = "/process/step5/sampleTreatment")
	public String procesStep5SampleTreatmentPage(){
		return "form/step5/project_step5_sampleTreatment";
	}
	
	@RequestMapping(value = "/process/step5/sampleEnabledApplication")
	public String procesStep5SampleEnabledApplicationPage(){
		return "form/step5/project_step5_sampleEnabledApplication";
	}
	
	@RequestMapping(value = "/process/step5/originalRecord")
	public String procesStep5OriginalRecordPage(){
		return "form/step5/project_step5_originalRecord";
	}
}	
