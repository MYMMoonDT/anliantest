package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TestReportItem;

@Repository
public class TestReportItemDao extends BaseDao<TestReportItem> {
	private final String GET_ITEM_COUNT = "select count(*) from TestReportItem";
	
	public long getItemCount() {
		Query query = createQuery(GET_ITEM_COUNT);
		return (Long)query.uniqueResult();
	}
}