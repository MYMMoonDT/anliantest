package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ProjectInfo;

@Repository
public class ProjectInfoDao extends BaseDao<ProjectInfo>{

	private final String GET_PROJECT_COUNT = "select count(*) from ProjectInfo";
	
	public long getCount() {
		Query query = createQuery(GET_PROJECT_COUNT);
		return (Long)query.uniqueResult();
	}

}
