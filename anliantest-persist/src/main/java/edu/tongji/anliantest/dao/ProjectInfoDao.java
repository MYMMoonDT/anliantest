package edu.tongji.anliantest.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.EmployeeInfo;
import edu.tongji.anliantest.model.ProjectInfo;

@Repository
public class ProjectInfoDao extends BaseDao<ProjectInfo>{

	private final String GET_PROJECT_COUNT = "select count(*) from ProjectInfo";
	private final String GET_PROJECT_BY_NAME = "from ProjectInfo p where p.projectName = ? ";
	
	public long getCount() {
		Query query = createQuery(GET_PROJECT_COUNT);
		return (Long)query.uniqueResult();
	}

	public ProjectInfo getProjectByName(String projectName) {
		List<ProjectInfo> projects = (List<ProjectInfo>)getHibernateTemplate().find(GET_PROJECT_BY_NAME, projectName);
		if(projects.size() == 0){
			return null;
		}else{
			return projects.get(0);
		}
	}

	
}
