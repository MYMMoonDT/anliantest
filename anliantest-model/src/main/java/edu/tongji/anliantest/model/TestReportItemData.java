package edu.tongji.anliantest.model;

import java.util.Date;

public class TestReportItemData {
	private int itemId;
	//private TestReportTable testReportTable;
	private String testWorkshopJob;
	private String testSubstance;
	private Integer testSubstanceId;
	private Date[] testTime;
	private Integer testSampleId;
	private String[][] testSampleNum;
	private String[][] testResult;
	private String[][] testTouchTime;
	private Integer[][] testCollectTime;
	private String testSubstanceDetailedName;
//	private HarmfulSubstanceNationalStandardTable harmfulSubstanceNationalStandardTable;
	
	public TestReportItemData() {
		this.testSampleNum = new String[3][4];
		this.testResult = new String[3][4];
		this.testTouchTime = new String[3][4];
		this.testCollectTime = new Integer[3][4];
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getTestWorkshopJob() {
		return testWorkshopJob;
	}

	public void setTestWorkshopJob(String testWorkshopJob) {
		this.testWorkshopJob = testWorkshopJob;
	}

	public String getTestSubstance() {
		return testSubstance;
	}

	public void setTestSubstance(String testSubstance) {
		this.testSubstance = testSubstance;
	}

	public Integer getTestSubstanceId() {
		return testSubstanceId;
	}

	public void setTestSubstanceId(Integer testSubstanceId) {
		this.testSubstanceId = testSubstanceId;
	}

	public Date[] getTestTime() {
		return testTime;
	}

	public void setTestTime(Date[] testTime) {
		this.testTime = testTime;
	}

	public Integer getTestSampleId() {
		return testSampleId;
	}

	public void setTestSampleId(Integer testSampleId) {
		this.testSampleId = testSampleId;
	}

	public String[][] getTestSampleNum() {
		return testSampleNum;
	}

	public void setTestSampleNum(String[][] testSampleNum) {
		this.testSampleNum = testSampleNum;
	}

	public String[][] getTestResult() {
		return testResult;
	}

	public void setTestResult(String[][] testResult) {
		this.testResult = testResult;
	}

	public String[][] getTestTouchTime() {
		return testTouchTime;
	}

	public void setTestTouchTime(String[][] testTouchTime) {
		this.testTouchTime = testTouchTime;
	}

	public Integer[][] getTestCollectTime() {
		return testCollectTime;
	}

	public void setTestCollectTime(Integer[][] testCollectTime) {
		this.testCollectTime = testCollectTime;
	}

	public String getTestSubstanceDetailedName() {
		return testSubstanceDetailedName;
	}

	public void setTestSubstanceDetailedName(String testSubstanceDetailedName) {
		this.testSubstanceDetailedName = testSubstanceDetailedName;
	}

	
}