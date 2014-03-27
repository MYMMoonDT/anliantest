package edu.tongji.anliantest.model;

public class TestReportSiO2ItemData {
	private String testWorkshopJob;
	private String testSampleNum;
	private double testResult;
	
	public TestReportSiO2ItemData() {
	}

	public TestReportSiO2ItemData(String testWorkshopJob) {
		this.testWorkshopJob = testWorkshopJob;
	}
	
	public String getTestWorkshopJob() {
		return testWorkshopJob;
	}

	public void setTestWorkshopJob(String testWorkshopJob) {
		this.testWorkshopJob = testWorkshopJob;
	}

	public String getTestSampleNum() {
		return testSampleNum;
	}

	public void setTestSampleNum(String testSampleNum) {
		this.testSampleNum = testSampleNum;
	}

	public double getTestResult() {
		return testResult;
	}

	public void setTestResult(double testResult) {
		this.testResult = testResult;
	}

	@Override
	public boolean equals(Object obj) {
		TestReportSiO2ItemData item = (TestReportSiO2ItemData) obj;
		return testWorkshopJob.equals(item.getTestWorkshopJob());
	}
	
	
}