package org.tongji.anliantest.persist;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tongji.anliantest.model.EmployeeInfo;

@Repository
public class EmployeeInfoDao extends BaseDao<EmployeeInfo>{
	
	private final String GET_EMPLOYEE_BY_EPNUM = "from EmployeeInfo ep where ep.epNumber = ?";
	
	public EmployeeInfo getEmployeeByEmployeeNum(String epNum){
		List<EmployeeInfo> employees = (List<EmployeeInfo>)getHibernateTemplate().find(GET_EMPLOYEE_BY_EPNUM, epNum);
		if(employees.size() == 0){
			return null;
		}else{
			return employees.get(0);
		}
	}
}
