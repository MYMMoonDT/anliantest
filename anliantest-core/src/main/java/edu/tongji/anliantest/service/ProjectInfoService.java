package edu.tongji.anliantest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tongji.anliantest.dao.ProjectInfoDao;
import edu.tongji.anliantest.model.ProjectInfo;

@Service
public class ProjectInfoService {

	@Autowired
	private ProjectInfoDao projectInfoDao;
	
	
	public void addProject(ProjectInfo projectInfo){
		projectInfoDao.save(projectInfo);
	}


	public long getCount() {
		return projectInfoDao.getCount();
	}


	public ProjectInfo getProjectById(int projectId) {
		return projectInfoDao.get(projectId);
	}


	public ProjectInfo getProjectByName(String projectName) {
		return projectInfoDao.getProjectByName(projectName);
	}


	public void update(ProjectInfo projectInfo) {
		projectInfoDao.update(projectInfo);
	}


	public List<ProjectInfo> getAllProjects() {
		return projectInfoDao.loadAll();
	}


	
}
