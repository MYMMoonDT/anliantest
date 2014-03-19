package edu.tongji.anliantest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;

@Repository
public class HarmfulSubstanceNationalStandardTableDao extends BaseDao<HarmfulSubstanceNationalStandardTable> {
	private final String GET_STANDARD_LIST = "from HarmfulSubstanceNationalStandardTable t";
	
	public List<HarmfulSubstanceNationalStandardTable> getStandardList() {
		List<HarmfulSubstanceNationalStandardTable> list = (List<HarmfulSubstanceNationalStandardTable>)find(GET_STANDARD_LIST);
		return list;
	}
}
