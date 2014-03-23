package edu.tongji.anliantest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.DepartmentInfo;

@Repository
public class DepartmentInfoDao extends BaseDao<DepartmentInfo>{

	private final String GET_DEPARTMENT_BY_NAME = "from DepartmentInfo d where d.departmentName = ? ";
	
	public DepartmentInfo getDepartmentByName(String departmentName) {
		List<DepartmentInfo> departments = (List<DepartmentInfo>)getHibernateTemplate().find(GET_DEPARTMENT_BY_NAME, departmentName);
		if(departments.size() == 0){
			return null;
		}else{
			return departments.get(0);
		}
	}

}
