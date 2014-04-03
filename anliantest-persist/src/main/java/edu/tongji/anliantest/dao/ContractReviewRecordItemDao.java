package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ContractReviewRecordItem;


@Repository
public class ContractReviewRecordItemDao extends BaseDao<ContractReviewRecordItem>{

	private final String GET_ITEM_COUNT = "select count(*) from ContractReviewRecordItem";
	private final String GET_MAX_ID = " select Max(itemId) from ContractReviewRecordItem" ;
	
	public long getItemCount() {
		Query query = createQuery(GET_ITEM_COUNT);
		return (Long)query.uniqueResult();
	}

//	public int getMaxItemId(){
//		Query query = createQuery(GET_MAX_ID);
//		Object result = query.uniqueResult();
//		System.out.println(result);
//		if(result == null)
//			return 0;
//		else
//			return Integer.parseInt(result.toString());
//	}
//	
//	public int getNextId() {
//		return getMaxItemId()+1;
//	}

	public int getNextId(){
		return super.getNextId(GET_MAX_ID);
	}
}
