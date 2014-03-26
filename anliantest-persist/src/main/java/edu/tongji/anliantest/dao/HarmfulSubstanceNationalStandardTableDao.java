package edu.tongji.anliantest.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;

@Repository
public class HarmfulSubstanceNationalStandardTableDao extends BaseDao<HarmfulSubstanceNationalStandardTable> {
	private final String GET_STANDARD_LIST = "from HarmfulSubstanceNationalStandardTable t";
	private final String GET_ITEM_COUNT = "select count(*) from HarmfulSubstanceNationalStandardTable";
	private final String GET_SUBSTANCE_BY_NAME = "from HarmfulSubstanceNationalStandardTable t where t.substanceChineseName = ?";
	
	public List<HarmfulSubstanceNationalStandardTable> getStandardList() {
		List<HarmfulSubstanceNationalStandardTable> list = (List<HarmfulSubstanceNationalStandardTable>)find(GET_STANDARD_LIST);
		return list;
	}
	
	public long getItemCount() {
		Query query = createQuery(GET_ITEM_COUNT);
		return (Long)query.uniqueResult();
	}
	
	public HarmfulSubstanceNationalStandardTable getHarmfulSubstanceNationalStandardTableByName(String name) {
		List<HarmfulSubstanceNationalStandardTable> list = (List<HarmfulSubstanceNationalStandardTable>)find(GET_SUBSTANCE_BY_NAME, name);
		try {
			// TODO check substanceChineseName 
			return list.get(0);
		} catch(Exception e) {
			System.out.println(name);
			return null;
		}
	}
}
