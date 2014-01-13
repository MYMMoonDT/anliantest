package edu.tongji.anliantest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.service.EmployeeService;

@Controller
public class EmployeeController extends BaseController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/doLogout")
	public String logout(HttpSession session){
		session.removeAttribute(EMPLOYEE_CONTEXT);
		return "forward:/index.jsp";
	}
	
	@RequestMapping(value = "/checkLogin")
	public ModelAndView checkLogin(HttpServletRequest request, EmployeeInfo employee){
		EmployeeInfo dbEmployee = employeeService.getEmployeeByEmployeeNum(employee.getEmployeeNumber());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:login");
		if(dbEmployee == null){
			mav.addObject("errorMsg", "用户名不存在");
		}else if(!dbEmployee.getEmployeePassword().equals(employee.getEmployeePassword())){
			mav.addObject("errorMsg", "用户密码不正确");
		}else{
			setSessionEmployee(request, dbEmployee);
			mav.setViewName("redirect:home");
		}
		return mav;
	}
	@RequestMapping(value = "/home")
	public String homePage(){
		return "home";
	}
}
