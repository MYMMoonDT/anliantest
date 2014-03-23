package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ContractReviewRecordTable;

@Repository
public class ContractReviewRecordTableDao extends BaseDao<ContractReviewRecordTable>{

	private final String GET_TABLE_COUNT = "select count(*) from ContractReviewRecordTable";
	
	public long getTableCount() {
		Query query = createQuery(GET_TABLE_COUNT);
		return (Long)query.uniqueResult();
	}

}
