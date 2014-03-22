package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.TestDataResultItemDao;
import edu.tongji.anliantest.dao.TestDataResultTableDao;
import edu.tongji.anliantest.model.TestDataResultItem;
import edu.tongji.anliantest.model.TestDataResultTable;

@Service
public class TestDataResultService {
	@Autowired
	private TestDataResultTableDao testDataResultTableDao;
	@Autowired
	private TestDataResultItemDao testDataResultItemDao;
	
	public void addTable(TestDataResultTable table) {
		testDataResultTableDao.save(table);
	}

	public long getTableCount() {
		return testDataResultTableDao.getTableCount();
	}
	
	public TestDataResultTable getResultTableById(int id) {
		return testDataResultTableDao.get(id);
	}

	public void addItem(TestDataResultItem item) {
		testDataResultItemDao.save(item);
	}
	
	public long getItemCount() {
		return testDataResultItemDao.getItemCount();
	}
	
	public TestDataResultTable getTestReportTableByTableId(int tableId) {
		return testDataResultTableDao.get(tableId);
	}
}
