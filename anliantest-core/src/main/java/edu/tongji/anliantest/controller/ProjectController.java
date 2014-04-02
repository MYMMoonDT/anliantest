package edu.tongji.anliantest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.anliantest.model.ContractReviewRecordItem;
import edu.tongji.anliantest.model.ContractReviewRecordTable;
import edu.tongji.anliantest.model.DepartmentInfo;
import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.ProjectInfo;
import edu.tongji.anliantest.model.WorkTaskItem;
import edu.tongji.anliantest.model.WorkTaskTable;
import edu.tongji.anliantest.service.ContractReviewRecordService;
import edu.tongji.anliantest.service.DepartmentInfoService;
import edu.tongji.anliantest.service.EmployeeService;
import edu.tongji.anliantest.service.ProjectInfoService;
import edu.tongji.anliantest.service.WorkTaskService;

@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseController {

	
	protected static final String PROJECT_ID_CONTEXT = "projectId";
	protected static final String CONTRACTREVIEWRECORD_ID_CONTEXT="contractReviewRecordTableId";
	protected static final String WORKTASKTABLE_ID_CONTEXT="workTaskTableId";
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectInfoService projectInfoService;
	@Autowired
	private ContractReviewRecordService contractReviewRecordService;
	@Autowired
	private DepartmentInfoService departmentInfoService; 
	@Autowired
	private WorkTaskService workTaskService;

	@RequestMapping(value="/createProject")//创建项目
	public ModelAndView createProject(HttpServletRequest request, ProjectInfo projectInfo){
		ModelAndView mad = new ModelAndView();

		EmployeeInfo businessEmployee = employeeService.getEmployeeByEmployeeName((String) request.getParameter("businessEmployee"));
		EmployeeInfo projectEmployee = employeeService.getEmployeeByEmployeeName((String) request.getParameter("projectEmployee"));
		projectInfo.setEmployeeInfoByBusinessEmployeeId(businessEmployee);//业务负责人
		projectInfo.setEmployeeInfoByProjectEmployeeId(projectEmployee);//项目负责人
		projectInfo.setProjectCreateTime(new Date());//创建日期
		projectInfoService.addProject(projectInfo);//持久化

//		System.out.println((String) request.getParameter("businessEmployee"));
//		System.out.println((String) request.getParameter("projectEmployee"));
		employeeService.update(businessEmployee);//更新外键
		employeeService.update(projectEmployee);//更新外键

		mad.addObject("projectInfo",projectInfo);
		int projectId = projectInfo.getProjectId();/*MARK*/
		//		System.out.println("projectId: "+projectId);
		setIdIntoSession(request, PROJECT_ID_CONTEXT, projectId);
		
		
		
		mad.setViewName("forward:process/step1/contractReviewForm");

		return mad;
	}

	@RequestMapping(value="/createContractReviewRecordTable")//创建合同评审记录表
	public ModelAndView createContractReviewRecordTable(HttpServletRequest request, ContractReviewRecordTable contractReviewRecordTable){
		ModelAndView mad = new ModelAndView();
		
		int contractReviewRecordTableId = contractReviewRecordService.getNextTableId();//TODO:ID
		contractReviewRecordTable.setTableId(contractReviewRecordTableId);
		
		setIdIntoSession(request, CONTRACTREVIEWRECORD_ID_CONTEXT, contractReviewRecordTableId);
		contractReviewRecordTable.setTableNum("ALJC/JL07-03");
//		contractReviewRecordTable.setTableTime(new Date());
		
		ProjectInfo projectInfo = projectInfoService.getProjectById(getIdFromSession(request, PROJECT_ID_CONTEXT));
		contractReviewRecordTable.setProjectInfo(projectInfo);
		projectInfoService.update(projectInfo);//更新外键
		
		EmployeeInfo technicalEmployee = getSessionEmployee(request);
		contractReviewRecordTable.setEmployeeInfo(technicalEmployee);
		employeeService.update(technicalEmployee);//更新外键

		contractReviewRecordService.addTable(contractReviewRecordTable);

		//mad.addObject("mode", "addItem");//设置为添加条目的模式
		mad.setViewName("process/step1/contractReviewForm");/*MARK*/
		return mad;
	}

	@RequestMapping(value="/addContractReviewRecordItem")//增加合同评审记录表条目
	public ModelAndView addContractReviewRecordItem(HttpServletRequest request, ContractReviewRecordItem contractReviewRecordItem){
		ModelAndView mad = new ModelAndView();
		
		int contractReviewRecordItemId = (int) contractReviewRecordService.getItemCount();//TODO:ID
		contractReviewRecordItem.setItemId(contractReviewRecordItemId);
		
		ContractReviewRecordTable contractReviewRecordTable = contractReviewRecordService.getTableById(getIdFromSession(request, CONTRACTREVIEWRECORD_ID_CONTEXT));
		contractReviewRecordItem.setContractReviewRecordTable(contractReviewRecordTable);
		DepartmentInfo departmentInfo = departmentInfoService.getDepartmentByName((String)request.getParameter("departmentName"));
		contractReviewRecordItem.setDepartmentInfo(departmentInfo);
		contractReviewRecordItem.setItemTime(new Date());

		contractReviewRecordService.addItem(contractReviewRecordItem);

		mad.setViewName("");/*MARK*/
		return mad;
	}

	@RequestMapping(value="/createWorkTaskTable")//创建工作任务表
	public ModelAndView createWorkTaskTable(HttpServletRequest request, WorkTaskTable workTaskTable){
		ModelAndView mad = new ModelAndView();
		
		int workTaskTableId = (int) workTaskService.getTableCount();//TODO:ID
		workTaskTable.setTableId(workTaskTableId);
		
		setIdIntoSession(request, WORKTASKTABLE_ID_CONTEXT, workTaskTableId);
		workTaskTable.setTableNum("ALJC/JL32-01");
		workTaskTable.setTaskTime(new Date());
		ProjectInfo projectInfo = projectInfoService.getProjectByName((String)request.getParameter("projectName"));
		workTaskTable.setProjectInfo(projectInfo);
		EmployeeInfo taskEmployee = employeeService.getEmployeeByEmployeeName((String)request.getParameter("taskEmployee"));
		workTaskTable.setEmployeeInfo(taskEmployee);

		workTaskService.addTable(workTaskTable);
		mad.setViewName("forward:process/step1/workTaskList");/*MARK*/
		return mad;
	}

	@RequestMapping(value="/addWorkTaskItem")//增加工作任务表条目
	public ModelAndView addWorkTaskItem(HttpServletRequest request, WorkTaskItem workTaskItem){
		ModelAndView mad = new ModelAndView();
		
		int workTaskItemId = (int) workTaskService.getItemCount();//TODO:ID
		workTaskItem.setItemId(workTaskItemId);

		WorkTaskTable workTaskTable = workTaskService.getTableById(getIdFromSession(request, WORKTASKTABLE_ID_CONTEXT));
		workTaskItem.setWorkTaskTable(workTaskTable);

		DepartmentInfo departmentInfo = departmentInfoService.getDepartmentByName((String)request.getParameter("departmentName"));
		workTaskItem.setDepartmentInfo(departmentInfo);

		workTaskService.addItem(workTaskItem);
		mad.setViewName("");/*MARK*/
		return mad;
	}


	protected int getIdFromSession(HttpServletRequest request, String name){
		return (Integer)request.getSession().getAttribute(name);
	}

	protected void setIdIntoSession(HttpServletRequest request,  String name, int Id){
		request.getSession().setAttribute(name, Id);
	}

	@RequestMapping(value = "/create" ,method={RequestMethod.GET})
	public ModelAndView createProjectPage(){
		ModelAndView mad = new ModelAndView();
		List<EmployeeInfo> employeeList = employeeService.getAllEmployees();
		//		System.out.println(employeeList.isEmpty());
		List<String> employeeNames = new ArrayList<String>();
		for(EmployeeInfo e:employeeList){
			employeeNames.add(e.getEmployeeName());
			//			System.out.println("e.getEmployeeName()"+e.getEmployeeName());
		}
		mad.addObject("employeeList", employeeNames);
		mad.setViewName("projectCreate");
		return mad;
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
	@RequestMapping(value = "process/step2/workTaskList")
	public String processStep2WorkTaskList(){
		return "form/step2/project_step2_workTaskList";
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
