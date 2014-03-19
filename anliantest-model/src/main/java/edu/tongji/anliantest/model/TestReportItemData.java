package edu.tongji.anliantest.model;

import java.math.BigDecimal;
import java.util.Date;

public class TestReportItemData {
	private int itemId;
	//private TestReportTable testReportTable;
	private String testWorkshopJob;
	private String testSubstance;
	private Integer testSubstanceId;
	private Date[] testTime;
	private Integer testSampleId;
	private String testSampleNum;
	private String[][] testResult;
	private BigDecimal[][] testTouchTime;
	private Integer[][] testCollectTime;
	private String testSubstanceDetailedName;
	
	public TestReportItemData() {
		this.testResult = new String[3][4];
		this.testTouchTime = new BigDecimal[3][4];
		this.testCollectTime = new Integer[3][4];
	}

	public TestReportItemData(int itemId, String testWorkshopJob,
			String testSubstance, Integer testSubstanceId, Date[] testTime,
			Integer testSampleId, String testSampleNum, String[][] testResult,
			BigDecimal[][] testTouchTime, Integer[][] testCollectTime,
			String testSubstanceDetailedName) {
		super();
		this.itemId = itemId;
		this.testWorkshopJob = testWorkshopJob;
		this.testSubstance = testSubstance;
		this.testSubstanceId = testSubstanceId;
		this.testTime = testTime;
		this.testSampleId = testSampleId;
		this.testSampleNum = testSampleNum;
		this.testResult = testResult;
		this.testTouchTime = testTouchTime;
		this.testCollectTime = testCollectTime;
		this.testSubstanceDetailedName = testSubstanceDetailedName;
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

	public String getTestSampleNum() {
		return testSampleNum;
	}

	public void setTestSampleNum(String testSampleNum) {
		this.testSampleNum = testSampleNum;
	}

	public String[][] getTestResult() {
		return testResult;
	}

	public void setTestResult(String[][] testResult) {
		this.testResult = testResult;
	}

	public BigDecimal[][] getTestTouchTime() {
		return testTouchTime;
	}

	public void setTestTouchTime(BigDecimal[][] testTouchTime) {
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