package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.HarmfulSubstanceNationalStandardTableDao;
import edu.tongji.anliantest.dao.TestDataProcessGroupDao;
import edu.tongji.anliantest.dao.TestDataProcessItemDao;
import edu.tongji.anliantest.dao.TestDataProcessTableDao;
import edu.tongji.anliantest.model.TestDataProcessGroup;
import edu.tongji.anliantest.model.TestDataProcessItem;
import edu.tongji.anliantest.model.TestDataProcessTable;

@Service
public class TestDataProcessService {
	@Autowired
	private TestDataProcessTableDao testDataProcessTableDao;
	@Autowired
	private TestDataProcessItemDao testDataProcessItemDao;
	@Autowired
	private TestDataProcessGroupDao testDataProcessGroupDao;
	@Autowired
	private HarmfulSubstanceNationalStandardTableDao harmfulSubstanceNationalStandardTableDao;
	
	public void addTable(TestDataProcessTable table) {
		testDataProcessTableDao.save(table);
	}

	public long getTableCount() {
		return testDataProcessTableDao.getTableCount();
	}

	public TestDataProcessTable getProcessTableById(int id) {
		return testDataProcessTableDao.get(id);
	}
	
	public void addItem(TestDataProcessItem item) {
		testDataProcessItemDao.save(item);
	}
	
	public long getItemCount() {
		return testDataProcessItemDao.getItemCount();
	}
	
	public TestDataProcessTable getTestReportTableByTableId(int tableId) {
		return testDataProcessTableDao.get(tableId);
	}

	public long getGroupCount() {
		return testDataProcessGroupDao.getGroupCount();
	}
	
	public void addGroup(TestDataProcessGroup group) {
		testDataProcessGroupDao.save(group);
	}
	
	public void updateGroup(TestDataProcessGroup group) {
		testDataProcessGroupDao.update(group);
	}
}
