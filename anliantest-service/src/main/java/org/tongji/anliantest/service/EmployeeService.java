package org.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tongji.anliantest.model.EmployeeInfo;
import org.tongji.anliantest.persist.EmployeeInfoDao;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeInfoDao employeeInfoDao;
	
	public EmployeeInfo getEmployeeByEmployeeNum(String epNum){
		return employeeInfoDao.getEmployeeByEmployeeNum(epNum);
	}
}
