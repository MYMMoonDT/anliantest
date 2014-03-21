package edu.tongji.anliantest.model;

// Generated 2014-3-20 17:07:37 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * HarmfulSubstanceNationalStandardTable generated by hbm2java
 */
@Entity
@Table(name = "harmful_substance_national_standard_table", catalog = "anliantest")
public class HarmfulSubstanceNationalStandardTable implements
		java.io.Serializable {

	private int substanceId;
	private String substanceEnglishName;
	private String substanceChineseName;
	private String chemicalAbstractNum;
	private BigDecimal mac;
	private BigDecimal pcTwa;
	private BigDecimal pcStel;
	private BigDecimal om;
	private String substanceComment;
	private Integer macScale;
	private Integer pcTwaScale;
	private Integer pcStelScale;
	private Integer omScale;
	private Set<TestDataResultItem> testDataResultItems = new HashSet<TestDataResultItem>(
			0);
	private Set<SamplePlanItem> samplePlanItems = new HashSet<SamplePlanItem>(0);
	private Set<TestDataProcessGroup> testDataProcessGroups = new HashSet<TestDataProcessGroup>(
			0);

	public HarmfulSubstanceNationalStandardTable() {
	}

	public HarmfulSubstanceNationalStandardTable(int substanceId) {
		this.substanceId = substanceId;
	}

	public HarmfulSubstanceNationalStandardTable(int substanceId,
			String substanceEnglishName, String substanceChineseName,
			String chemicalAbstractNum, BigDecimal mac, BigDecimal pcTwa,
			BigDecimal pcStel, BigDecimal om, String substanceComment,
			Integer macScale, Integer pcTwaScale, Integer pcStelScale,
			Integer omScale, Set<TestDataResultItem> testDataResultItems,
			Set<SamplePlanItem> samplePlanItems,
			Set<TestDataProcessGroup> testDataProcessGroups) {
		this.substanceId = substanceId;
		this.substanceEnglishName = substanceEnglishName;
		this.substanceChineseName = substanceChineseName;
		this.chemicalAbstractNum = chemicalAbstractNum;
		this.mac = mac;
		this.pcTwa = pcTwa;
		this.pcStel = pcStel;
		this.om = om;
		this.substanceComment = substanceComment;
		this.macScale = macScale;
		this.pcTwaScale = pcTwaScale;
		this.pcStelScale = pcStelScale;
		this.omScale = omScale;
		this.testDataResultItems = testDataResultItems;
		this.samplePlanItems = samplePlanItems;
		this.testDataProcessGroups = testDataProcessGroups;
	}

	@Id
	@Column(name = "substance_id", unique = true, nullable = false)
	public int getSubstanceId() {
		return this.substanceId;
	}

	public void setSubstanceId(int substanceId) {
		this.substanceId = substanceId;
	}

	@Column(name = "substance_english_name")
	public String getSubstanceEnglishName() {
		return this.substanceEnglishName;
	}

	public void setSubstanceEnglishName(String substanceEnglishName) {
		this.substanceEnglishName = substanceEnglishName;
	}

	@Column(name = "substance_chinese_name")
	public String getSubstanceChineseName() {
		return this.substanceChineseName;
	}

	public void setSubstanceChineseName(String substanceChineseName) {
		this.substanceChineseName = substanceChineseName;
	}

	@Column(name = "chemical_abstract_num", length = 45)
	public String getChemicalAbstractNum() {
		return this.chemicalAbstractNum;
	}

	public void setChemicalAbstractNum(String chemicalAbstractNum) {
		this.chemicalAbstractNum = chemicalAbstractNum;
	}

	@Column(name = "MAC", precision = 14, scale = 8)
	public BigDecimal getMac() {
		return this.mac;
	}

	public void setMac(BigDecimal mac) {
		this.mac = mac;
	}

	@Column(name = "PC_TWA", precision = 14, scale = 8)
	public BigDecimal getPcTwa() {
		return this.pcTwa;
	}

	public void setPcTwa(BigDecimal pcTwa) {
		this.pcTwa = pcTwa;
	}

	@Column(name = "PC_STEL", precision = 14, scale = 8)
	public BigDecimal getPcStel() {
		return this.pcStel;
	}

	public void setPcStel(BigDecimal pcStel) {
		this.pcStel = pcStel;
	}

	@Column(name = "OM", precision = 14, scale = 8)
	public BigDecimal getOm() {
		return this.om;
	}

	public void setOm(BigDecimal om) {
		this.om = om;
	}

	@Column(name = "substance_comment")
	public String getSubstanceComment() {
		return this.substanceComment;
	}

	public void setSubstanceComment(String substanceComment) {
		this.substanceComment = substanceComment;
	}

	@Column(name = "MAC_scale")
	public Integer getMacScale() {
		return this.macScale;
	}

	public void setMacScale(Integer macScale) {
		this.macScale = macScale;
	}

	@Column(name = "PC_TWA_scale")
	public Integer getPcTwaScale() {
		return this.pcTwaScale;
	}

	public void setPcTwaScale(Integer pcTwaScale) {
		this.pcTwaScale = pcTwaScale;
	}

	@Column(name = "PC_STEL_scale")
	public Integer getPcStelScale() {
		return this.pcStelScale;
	}

	public void setPcStelScale(Integer pcStelScale) {
		this.pcStelScale = pcStelScale;
	}

	@Column(name = "OM_scale")
	public Integer getOmScale() {
		return this.omScale;
	}

	public void setOmScale(Integer omScale) {
		this.omScale = omScale;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "harmfulSubstanceNationalStandardTable")
	public Set<TestDataResultItem> getTestDataResultItems() {
		return this.testDataResultItems;
	}

	public void setTestDataResultItems(
			Set<TestDataResultItem> testDataResultItems) {
		this.testDataResultItems = testDataResultItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "harmfulSubstanceNationalStandardTable")
	public Set<SamplePlanItem> getSamplePlanItems() {
		return this.samplePlanItems;
	}

	public void setSamplePlanItems(Set<SamplePlanItem> samplePlanItems) {
		this.samplePlanItems = samplePlanItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "harmfulSubstanceNationalStandardTable")
	public Set<TestDataProcessGroup> getTestDataProcessGroups() {
		return this.testDataProcessGroups;
	}

	public void setTestDataProcessGroups(
			Set<TestDataProcessGroup> testDataProcessGroups) {
		this.testDataProcessGroups = testDataProcessGroups;
	}

}
