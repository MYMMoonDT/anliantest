package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.ContractReviewRecordItemDao;
import edu.tongji.anliantest.dao.ContractReviewRecordTableDao;
import edu.tongji.anliantest.model.ContractReviewRecordItem;
import edu.tongji.anliantest.model.ContractReviewRecordTable;


@Service
public class ContractReviewRecordService {

	@Autowired
	private ContractReviewRecordTableDao contractReviewRecordTableDao;
	@Autowired
	private ContractReviewRecordItemDao contractReviewRecordItemDao;
	
	
	public long getTableCount() {
		return contractReviewRecordTableDao.getTableCount();
	}


	public void addTable(ContractReviewRecordTable contractReviewRecordTable) {
		contractReviewRecordTableDao.save(contractReviewRecordTable);
	}


	public long getItemCount() {
		return contractReviewRecordItemDao.getItemCount();
	}


	public ContractReviewRecordTable getTableById(int tableId) {
		return contractReviewRecordTableDao.get(tableId);
	}


	public void addItem(ContractReviewRecordItem contractReviewRecordItem) {
		contractReviewRecordItemDao.save(contractReviewRecordItem);
	}


	public int getNextTableId() {
		return contractReviewRecordTableDao.getNextId();
	}


	public int getNextItemId() {
		return contractReviewRecordItemDao.getNextId();
	}
	
	public String getContentPJB(){//评价部评审内容
		return contractReviewRecordItemDao.getContentPJB();
	}
	public String getContentJCB(){//检测部评审内容
		return contractReviewRecordItemDao.getContentJCB();
	}
	public String getContentXZB(){//行政部评审内容
		return contractReviewRecordItemDao.getContentXZB();
	}
	public String getContentZKB(){//质控部评审内容
		return contractReviewRecordItemDao.getContentZKB();
	}
	public String getContentZJL(){//总经理评审内容
		return contractReviewRecordItemDao.getContentZJL();
	}


	public void updateTable(ContractReviewRecordTable contractReviewRecordTable) {
		contractReviewRecordTableDao.update(contractReviewRecordTable);
	}


	
	
	
}
