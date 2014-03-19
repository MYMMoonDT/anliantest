package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TestDataResultTable;

@Repository
public class TestDataResultTableDao extends BaseDao<TestDataResultTable> {
	private final String GET_TABLE_COUNT = "select count(*) from TestDataResultTable";
	
	public long getTableCount() {
		Query query = createQuery(GET_TABLE_COUNT);
		return (Long)query.uniqueResult();
	}
}
