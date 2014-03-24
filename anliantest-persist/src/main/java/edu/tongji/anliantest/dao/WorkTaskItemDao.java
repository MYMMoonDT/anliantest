package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.WorkTaskItem;

@Repository
public class WorkTaskItemDao extends BaseDao<WorkTaskItem>{

	private final String GET_ITEM_COUNT = "select count(*) from WorkTaskItem";
	
	public long getItemCount() {
		Query query = createQuery(GET_ITEM_COUNT);
		return (Long)query.uniqueResult();
	}

}
