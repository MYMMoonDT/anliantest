package edu.tongji.anliantest.service;

import java.util.List;

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
	
	public EmployeeInfo getEmployeeByEmployeeName(String employeeName){
		return employeeeDao.getEmployeeByEmployeeName(employeeName);
	}

	public List<EmployeeInfo> getAllEmployees() {
		return employeeeDao.loadAll();
	}

	public void update(EmployeeInfo employeeInfo) {
		employeeeDao.update(employeeInfo);
	}
}
