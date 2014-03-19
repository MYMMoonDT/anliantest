package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.TestDataProcessItem;

@Repository
public class TestDataProcessItemDao extends BaseDao<TestDataProcessItem> {
	private final String GET_ITEM_COUNT = "select count(*) from TestDataProcessItem";
	
	public long getItemCount() {
		Query query = createQuery(GET_ITEM_COUNT);
		return (Long)query.uniqueResult();
	}
}