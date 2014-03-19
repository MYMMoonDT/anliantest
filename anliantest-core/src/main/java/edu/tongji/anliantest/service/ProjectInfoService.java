package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.ProjectInfoDao;

@Service
public class ProjectInfoService {

	@Autowired
	private ProjectInfoDao projectInfoDao;
}
