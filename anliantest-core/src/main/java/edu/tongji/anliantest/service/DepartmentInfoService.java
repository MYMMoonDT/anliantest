package edu.tongji.anliantest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.DepartmentInfoDao;
import edu.tongji.anliantest.model.DepartmentInfo;


@Service
public class DepartmentInfoService {

	@Autowired
	private DepartmentInfoDao departmentInfoDao;

	public DepartmentInfo getDepartmentByName(String departmentName) {
		return departmentInfoDao.getDepartmentByName(departmentName);
	}
}
