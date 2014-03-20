package edu.tongji.anliantest.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;

@Repository
public class HarmfulSubstanceNationalStandardTableDao extends BaseDao<HarmfulSubstanceNationalStandardTable> {
	private final String GET_STANDARD_LIST = "from HarmfulSubstanceNationalStandardTable t";
	private final String GET_ITEM_COUNT = "select count(*) from HarmfulSubstanceNationalStandardTable";
	
	public List<HarmfulSubstanceNationalStandardTable> getStandardList() {
		List<HarmfulSubstanceNationalStandardTable> list = (List<HarmfulSubstanceNationalStandardTable>)find(GET_STANDARD_LIST);
		return list;
	}
	
	public long getItemCount() {
		Query query = createQuery(GET_ITEM_COUNT);
		return (Long)query.uniqueResult();
	}
}
