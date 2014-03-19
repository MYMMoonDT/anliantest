package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TestDataProcessGroup;

@Repository
public class TestDataProcessGroupDao extends BaseDao<TestDataProcessGroup> {
	private final String GET_GROUP_COUNT = "select count(*) from TestDataProcessGroup";
	
	public long getGroupCount() {
		Query query = createQuery(GET_GROUP_COUNT);
		return (Long)query.uniqueResult();
	}
}