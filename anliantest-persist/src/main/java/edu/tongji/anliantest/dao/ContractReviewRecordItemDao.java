package edu.tongji.anliantest.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ContractReviewRecordItem;


@Repository
public class ContractReviewRecordItemDao extends BaseDao<ContractReviewRecordItem>{

	private final String GET_ITEM_COUNT = "select count(*) from ContractReviewRecordItem";
	private final String GET_MAX_ID = " select Max(itemId) from ContractReviewRecordItem" ;
	private final String REVIEW_CONTENT_PJB = "客户的要求是否明确，技术能力和资源是否满足要求，评价项目是否符合评价资质范围，评估类比现场，确定本项目可能存在的职业病危害因素。";
	private final String REVIEW_CONTENT_JCB = "确定现有仪器设备能否满足本项目的检测需要，检测方法是否现行有效，提供本项目检测预计所需的仪器设备和化学试剂清单，检测项目是否需要分包，分包方是否为客户接受，估算检测费用等相关事宜。";
	private final String REVIEW_CONTENT_XZB = "办公用品保障，项目交通保障能否满足本项目要求；能否及时采购本项目所需要的化学仪器、化学试剂；/d审核付款方式等与资金和财务有关的条款。";
	private final String REVIEW_CONTENT_ZKB = "核对各部门的合同评审内容是否真实、有效、可行。";
	private final String REVIEW_CONTENT_ZJL = "确定评价合同的综合条款，审核评价合同的整体合理性，是否签字。";
	
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
	
	public String getContentPJB(){//评价部评审内容
		return REVIEW_CONTENT_PJB;
	}
	public String getContentJCB(){//检测部评审内容
		return REVIEW_CONTENT_JCB;
	}
	public String getContentXZB(){//行政部评审内容
		return REVIEW_CONTENT_XZB;
	}
	public String getContentZKB(){//质控部评审内容
		return REVIEW_CONTENT_ZKB;
	}
	public String getContentZJL(){//总经理评审内容
		return REVIEW_CONTENT_ZJL;
	}
}
