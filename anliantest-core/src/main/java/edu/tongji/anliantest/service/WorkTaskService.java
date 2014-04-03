package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.WorkTaskItemDao;
import edu.tongji.anliantest.dao.WorkTaskTableDao;
import edu.tongji.anliantest.model.WorkTaskItem;
import edu.tongji.anliantest.model.WorkTaskTable;

@Service
public class WorkTaskService {

	@Autowired
	private WorkTaskTableDao workTaskTableDao;
	@Autowired
	private WorkTaskItemDao workTaskItemDao;
	
	
	public long getTableCount() {
		return workTaskTableDao.getTableCount();
	}


	public void addTable(WorkTaskTable workTaskTable) {
		workTaskTableDao.save(workTaskTable);
	}


	public long getItemCount() {
		return workTaskItemDao.getItemCount();
	}


	public WorkTaskTable getTableById(int workTaskTableId) {
		return workTaskTableDao.get(workTaskTableId);
	}


	public void addItem(WorkTaskItem workTaskItem) {
		workTaskItemDao.save(workTaskItem);
	}


	public int getNextTableId() {
		return workTaskTableDao.getNextId();
	}


	public int getNextItemId() {
		return workTaskItemDao.getNextId();
	}
}
