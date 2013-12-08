package edu.tongji.anliantest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.service.EmployeeService;

@Controller
public class EmployeeController extends AbstractController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/login")
	public String loginPage(){
		return "login";
	}
	@RequestMapping(value = "/checkLogin")
	public String checkLogin(EmployeeInfo employee){
		EmployeeInfo dbEmployee = employeeService.getEmployeeByEmployeeNum(employee.getEmployeeNumber());
		if(dbEmployee == null){
			return "login";
		}else if(!dbEmployee.getEmployeePassword().equals(employee.getEmployeePassword())){
			return "login";
		}else{
			return "home";
		}
	}
}
