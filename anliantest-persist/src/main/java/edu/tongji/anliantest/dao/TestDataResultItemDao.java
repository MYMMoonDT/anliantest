package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TestDataResultItem;

@Repository
public class TestDataResultItemDao extends BaseDao<TestDataResultItem> {
	private final String GET_ITEM_COUNT = "select count(*) from TestDataResultItem";
	
	public long getItemCount() {
		Query query = createQuery(GET_ITEM_COUNT);
		return (Long)query.uniqueResult();
	}
}