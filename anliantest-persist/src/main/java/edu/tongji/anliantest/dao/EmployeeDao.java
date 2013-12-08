package edu.tongji.anliantest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.EmployeeInfo;

@Repository
public class EmployeeDao extends BaseDao<EmployeeInfo>{
	private final String GET_EMPLOYEE_BY_EMPLOYEENUM = "from EmployeeInfo e where e.employeeNumber = ? ";
	
	public EmployeeInfo getEmployeeByEmployeeNum(String employeeNum){
		List<EmployeeInfo> employees = (List<EmployeeInfo>)getHibernateTemplate().find(GET_EMPLOYEE_BY_EMPLOYEENUM, employeeNum);
		if(employees.size() == 0){
			return null;
		}else{
			return employees.get(0);
		}
	}
}
