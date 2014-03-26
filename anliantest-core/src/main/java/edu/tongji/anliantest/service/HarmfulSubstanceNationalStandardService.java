package edu.tongji.anliantest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.HarmfulSubstanceNationalStandardTableDao;
import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;
import edu.tongji.anliantest.model.TestReportItem;

@Service
public class HarmfulSubstanceNationalStandardService {
	@Autowired
	private HarmfulSubstanceNationalStandardTableDao harmfulSubstanceNationalStandardTableDao;
	
	public String getStandardNameById(int id) {
		return harmfulSubstanceNationalStandardTableDao.get(id).getSubstanceChineseName();
	}

	public List<HarmfulSubstanceNationalStandardTable> getStardardList() {
		return harmfulSubstanceNationalStandardTableDao.getStandardList();
	}
	
	public HarmfulSubstanceNationalStandardTable getSubstanceById(int id) {
		return harmfulSubstanceNationalStandardTableDao.get(id);
	}
	
	public void addItem(HarmfulSubstanceNationalStandardTable item) {
		harmfulSubstanceNationalStandardTableDao.save(item);
	}
	
	public long getItemCount() {
		return harmfulSubstanceNationalStandardTableDao.getItemCount();
	}
	
	public HarmfulSubstanceNationalStandardTable getSubstanceByName(String name) {
		return harmfulSubstanceNationalStandardTableDao.getHarmfulSubstanceNationalStandardTableByName(name);
	}
}
