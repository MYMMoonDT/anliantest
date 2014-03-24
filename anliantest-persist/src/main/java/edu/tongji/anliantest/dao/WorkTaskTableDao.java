package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.WorkTaskTable;

@Repository
public class WorkTaskTableDao extends BaseDao<WorkTaskTable>{

	private final String GET_TABLE_COUNT = "select count(*) from WorkTaskTable";
	public long getTableCount() {
		Query query = createQuery(GET_TABLE_COUNT);
		return (Long)query.uniqueResult();
	}
	

}
