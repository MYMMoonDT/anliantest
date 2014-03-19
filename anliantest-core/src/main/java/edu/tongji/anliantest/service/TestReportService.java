package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.TestReportItemDao;
import edu.tongji.anliantest.dao.TestReportTableDao;
import edu.tongji.anliantest.model.TestReportItem;
import edu.tongji.anliantest.model.TestReportTable;

@Service
public class TestReportService {
	@Autowired
	private TestReportTableDao testReportTableDao;
	@Autowired
	private TestReportItemDao testReportItemDao;
	
	public void addTable(TestReportTable table) {
		testReportTableDao.save(table);
	}

	public long getTableCount() {
		return testReportTableDao.getTableCount();
	}

	public void addItem(TestReportItem item) {
		testReportItemDao.save(item);
	}
	
	public long getItemCount() {
		return testReportItemDao.getItemCount();
	}
	
	public TestReportTable getTestReportTableByTableId(int tableId) {
		return testReportTableDao.get(tableId);
	}
}
