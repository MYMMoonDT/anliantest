package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TestReportTable;

@Repository
public class TestReportTableDao extends BaseDao<TestReportTable> {
	private final String GET_TABLE_COUNT = "select count(*) from TestReportTable";
	
	public long getTableCount() {
		Query query = createQuery(GET_TABLE_COUNT);
		return (Long)query.uniqueResult();
	}
}
