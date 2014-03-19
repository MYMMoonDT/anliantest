package edu.tongji.anliantest.model;

// Generated 2014-3-14 19:09:28 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ContractReviewRecordTable generated by hbm2java
 */
@Entity
@Table(name = "contract_review_record_table", catalog = "anliantest")
public class ContractReviewRecordTable implements java.io.Serializable {

	private int tableId;
	private EmployeeInfo employeeInfo;
	private ProjectInfo projectInfo;
	private String tableNum;
	private String tableStatus;
	private Date tableTime;
	private Set<ContractReviewRecordItem> contractReviewRecordItems = new HashSet<ContractReviewRecordItem>(
			0);

	public ContractReviewRecordTable() {
	}

	public ContractReviewRecordTable(int tableId) {
		this.tableId = tableId;
	}

	public ContractReviewRecordTable(int tableId, EmployeeInfo employeeInfo,
			ProjectInfo projectInfo, String tableNum, String tableStatus,
			Date tableTime,
			Set<ContractReviewRecordItem> contractReviewRecordItems) {
		this.tableId = tableId;
		this.employeeInfo = employeeInfo;
		this.projectInfo = projectInfo;
		this.tableNum = tableNum;
		this.tableStatus = tableStatus;
		this.tableTime = tableTime;
		this.contractReviewRecordItems = contractReviewRecordItems;
	}

	@Id
	@Column(name = "table_id", unique = true, nullable = false)
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "technical_employ_id")
	public EmployeeInfo getEmployeeInfo() {
		return this.employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	public ProjectInfo getProjectInfo() {
		return this.projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	@Column(name = "table_num", length = 13)
	public String getTableNum() {
		return this.tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	@Column(name = "table_status", length = 8)
	public String getTableStatus() {
		return this.tableStatus;
	}

	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "table_time", length = 19)
	public Date getTableTime() {
		return this.tableTime;
	}

	public void setTableTime(Date tableTime) {
		this.tableTime = tableTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contractReviewRecordTable")
	public Set<ContractReviewRecordItem> getContractReviewRecordItems() {
		return this.contractReviewRecordItems;
	}

	public void setContractReviewRecordItems(
			Set<ContractReviewRecordItem> contractReviewRecordItems) {
		this.contractReviewRecordItems = contractReviewRecordItems;
	}

}
