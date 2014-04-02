package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ContractReviewRecordTable;

@Repository
public class ContractReviewRecordTableDao extends BaseDao<ContractReviewRecordTable>{

	private final String GET_TABLE_COUNT = "select count(*) from ContractReviewRecordTable";
	private final String GET_MAX_ID = " select Max(tableId) from ContractReviewRecordTable" ;
	
	public long getTableCount() {
		Query query = createQuery(GET_TABLE_COUNT);
		return (Long)query.uniqueResult();
	}

	public Long getMaxTableId() {
		Query query = createQuery(GET_MAX_ID);
		Object result = query.uniqueResult();
		if(result == null)
			return (long) 0;
		else
			return (Long) result;
	}
	
	public int getNextId(){
		return Integer.parseInt(getMaxTableId().toString())+1;
	}

}
