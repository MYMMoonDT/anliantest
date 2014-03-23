package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ContractReviewRecordItem;


@Repository
public class ContractReviewRecordItemDao extends BaseDao<ContractReviewRecordItem>{

	private final String GET_TABLE_COUNT = "select count(*) from ContractReviewRecordItem";
	
	public long getItemCount() {
		Query query = createQuery(GET_TABLE_COUNT);
		return (Long)query.uniqueResult();
	}

}
