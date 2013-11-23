package org.tongji.anliantest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tongji.anliantest.model.EmployeeInfo;
import org.tongji.anliantest.service.EmployeeService;

@Controller
@RequestMapping("user")
public class EmployeeController extends AbstractController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(EmployeeInfo epInfo){
		EmployeeInfo dbEpInfo = employeeService.getEmployeeByEmployeeNum(epInfo.getEpNumber());
		if(dbEpInfo.getEpNumber().equals(epInfo.getEpNumber())){
			return "home";
		}else{
			return "login";
		}
	}
}
