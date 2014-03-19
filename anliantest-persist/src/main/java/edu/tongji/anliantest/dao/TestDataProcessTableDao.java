package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TestDataProcessTable;

@Repository
public class TestDataProcessTableDao extends BaseDao<TestDataProcessTable> {
	private final String GET_TABLE_COUNT = "select count(*) from TestDataProcessTable";
	
	public long getTableCount() {
		Query query = createQuery(GET_TABLE_COUNT);
		return (Long)query.uniqueResult();
	}
}
