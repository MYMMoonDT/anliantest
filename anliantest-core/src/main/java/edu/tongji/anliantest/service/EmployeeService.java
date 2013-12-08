package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.EmployeeDao;
import edu.tongji.anliantest.model.EmployeeInfo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeeDao;
	
	
	public EmployeeInfo getEmployeeByEmployeeNum(String employeeNum){
		return employeeeDao.getEmployeeByEmployeeNum(employeeNum);
	}
}
