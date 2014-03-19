package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.ContractReviewRecordItemDao;
import edu.tongji.anliantest.dao.ContractReviewRecordTableDao;

@Service
public class ContractReviewReviewService {

	@Autowired
	private ContractReviewRecordTableDao contractReviewRecordTableDao;
	@Autowired
	private ContractReviewRecordItemDao contractReviewRecordItemDao;
}
