package edu.tongji.anliantest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;
import edu.tongji.anliantest.model.TestDataProcessGroup;
import edu.tongji.anliantest.model.TestDataProcessItem;
import edu.tongji.anliantest.model.TestDataProcessTable;
import edu.tongji.anliantest.model.TestDataResultItem;
import edu.tongji.anliantest.model.TestDataResultTable;
import edu.tongji.anliantest.model.TestReportItem;
import edu.tongji.anliantest.model.TestReportItemData;
import edu.tongji.anliantest.model.TestReportTable;
import edu.tongji.anliantest.service.HarmfulSubstanceNationalStandardService;
import edu.tongji.anliantest.service.TestDataProcessService;
import edu.tongji.anliantest.service.TestDataResultService;
import edu.tongji.anliantest.service.TestReportService;
import edu.tongji.anliantest.utils.StudyJacob;

@Controller
public class ExperimentCalcController extends BaseController {
	protected static final String REPORT_TABLE_ID_CONTEXT = "REPORT_TABLE_ID_CONTEXT";
	protected static final String PROCESS_TABLE_ID_CONTEXT = "PROCESS_TABLE_ID_CONTEXT";
	protected static final String RESULT_TABLE_ID_CONTEXT = "RESULT_TABLE_ID_CONTEXT";

	@Autowired
	private TestReportService testReportService;
	@Autowired
	private TestDataProcessService testDataProcessService;
	@Autowired
	private HarmfulSubstanceNationalStandardService harmfulSubstanceNationalStandardService;
	@Autowired
	private TestDataResultService testDataResultService;

	@RequestMapping(value = "/experimentCalculation")
	public String experimentCalculationPage(){
		return "experimentCalculation/createTestReportTable";
	}
	
	@RequestMapping(value = "/addTestReportItem")
	public String testReportItemPage(){
		return "experimentCalculation/addTestReportItem";
	}
	
	@RequestMapping(value = "/createTestReportTable")
	public ModelAndView createTestReportTable(HttpServletRequest request, TestReportTable reportTable) {
		int reportTableId = (int)testReportService.getTableCount();
		reportTable.setTableId(reportTableId);
		setSessionTableId(request, REPORT_TABLE_ID_CONTEXT, reportTableId);
		testReportService.addTable(reportTable);

		TestDataProcessTable processTable = new TestDataProcessTable();
		int processTableId = (int)testDataProcessService.getTableCount();
		processTable.setTableId(processTableId);
		setSessionTableId(request, PROCESS_TABLE_ID_CONTEXT, processTableId);
		processTable.setTableNum("ALJC/JL30-29");
		testDataProcessService.addTable(processTable);
		
		TestDataResultTable resultTable = new TestDataResultTable();
		int resultTableId = (int)testDataResultService.getTableCount();
		resultTable.setTableId(resultTableId);
		setSessionTableId(request, RESULT_TABLE_ID_CONTEXT, resultTableId);
		testDataResultService.addTable(resultTable);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:addTestReportItem");
		return mav;
	}
	
	protected int getSessionTableId(HttpServletRequest request, String name){
		return (Integer)request.getSession().getAttribute(name);
	}
	
	protected void setSessionTableId(HttpServletRequest request,  String name, int tableId){
		request.getSession().setAttribute(name, tableId);
	}
	class Range<T> {
		private T start;
		private T end;
		
		Range() {
			start = null;
			end = null;
		}

		public T getStart() {
			return start;
		}

		public void setStart(T start) {
			this.start = start;
		}

		public T getEnd() {
			return end;
		}

		public void setEnd(T end) {
			this.end = end;
		}
	}
	@RequestMapping(value = "/addTestReportItemAndCalc")
	public ModelAndView addTestReportItemAndCalc(HttpServletRequest request, TestReportItemData data){
		// convert TestReportItemData to ArrayList<TestReportItem>
		Range<BigDecimal> range = new Range<BigDecimal>();
		ArrayList<TestReportItem> reportItemList = getReportItemListFromInput(
				request, data, range);
		
		ArrayList<Integer> dayCount = getDayCountList(reportItemList);
		
		// calculate

		ArrayList<TestDataProcessGroup> groupList = calcProcessData(request,
				reportItemList, dayCount);

		calcResultData(request, reportItemList, dayCount, groupList, range);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:addTestReportItem");
		
		mav.addObject("resultMsg", "success");
		
		return mav;
	}

	private void calcResultData(HttpServletRequest request,
			ArrayList<TestReportItem> reportItemList,
			ArrayList<Integer> dayCount,
			ArrayList<TestDataProcessGroup> groupList,  Range<BigDecimal> range) {
		int sampleCount = reportItemList.size();
		BigDecimal groupTouchTime = new BigDecimal(0);
		for (int i= 0; i < dayCount.get(0); i++) {
			groupTouchTime = groupTouchTime.add(reportItemList.get(i).getTestTouchTime());
		}
		
		
		int resultItemId = (int)testDataResultService.getItemCount();
		TestDataResultItem resultItem = new TestDataResultItem(resultItemId);
		TestDataResultTable resultTable = testDataResultService.getResultTableByid(this.getSessionTableId(request, RESULT_TABLE_ID_CONTEXT));
		resultItem.setTestDataResultTable(resultTable);
		resultItem.setHarmfulSubstanceNationalStandardTable(groupList.get(0).getHarmfulSubstanceNationalStandardTable());
		resultItem.setTestWorkshopJob(groupList.get(0).getTestWorkshopJob());
		resultItem.setTestSampleCount(sampleCount);
		resultItem.setTestTouchTime(groupTouchTime);
		resultItem.setTestResultRangeScale(reportItemList.get(0).getTestResultScale());
		resultItem.setSubstanceDetailedName(reportItemList.get(0).getSubstanceDetailedName());
		if (range.getStart() != null) {
			resultItem.setTestResultRangeStart(range.getStart());
		}
		resultItem.setTestResultRangeEnd(range.getEnd());
		BigDecimal mac = new BigDecimal(0);
		BigDecimal ctwa = new BigDecimal(0);
		BigDecimal cstel = new BigDecimal(0);
		BigDecimal om = new BigDecimal(0);
		int macScale = 0, ctwaScale = 0, cstelScale = 0, omScale = 0;
		String resultType = null;
		boolean passed = true;
		for (TestDataProcessGroup group : groupList) {
			if (group.getTestResult().equals("不合格")) {
				passed = false;
			}
			if (group.getMac() != null) {
				if (mac.compareTo(group.getMac()) < 0) {
					mac = group.getMac();
					macScale = group.getMacScale();
					resultType = group.getResultType();
				}
			} else {
				mac = null;
			}
			if (group.getCtwa() != null) {
				if (ctwa.compareTo(group.getCtwa()) < 0) {
					ctwa = group.getCtwa();
					ctwaScale = group.getCtwaScale();
					resultType = group.getResultType();
				}
			} else {
				ctwa = null;
			}
			if (group.getCstel() != null) {
				if (cstel.compareTo(group.getCstel()) < 0) {
					cstel = group.getCstel();
					cstelScale = group.getCstelScale();
					resultType = group.getResultType();
				}
			} else {
				cstel = null;
			}
			if (group.getOm() != null) {
				if (om.compareTo(group.getOm()) < 0) {
					om = group.getOm();
					omScale = group.getOmScale();
					resultType = group.getResultType();
				}
			} else {
				om = null;
			}
		}
		resultItem.setMac(mac);
		resultItem.setCtwa(ctwa);
		resultItem.setCstel(cstel);
		resultItem.setOm(om);
		resultItem.setMacScale(macScale);
		resultItem.setCtwaScale(ctwaScale);
		resultItem.setCstelScale(cstelScale);
		resultItem.setOmScale(omScale);
		resultItem.setResultType(resultType);
		
		if (passed) {
			resultItem.setTestResult("合格");
		} else {
			resultItem.setTestResult("不合格");
		}
		testDataResultService.addItem(resultItem);
	}

	private BigDecimal rounding(BigDecimal v, int scale) {
		BigDecimal zero = new BigDecimal(0);
		BigDecimal u = null;
		do {
			u = v.setScale(scale++, RoundingMode.HALF_EVEN);
		}while (u.compareTo(zero) == 0);
		return u;
	}
	
	private ArrayList<TestDataProcessGroup> calcProcessData(
			HttpServletRequest request,
			ArrayList<TestReportItem> reportItemList,
			ArrayList<Integer> dayCount) {
		int processItemIdBegin = (int)testDataProcessService.getItemCount();
		int offset = 0;

		ArrayList<TestDataProcessGroup> groupList = new ArrayList<TestDataProcessGroup>();
		TestDataProcessTable processTable = testDataProcessService.getProcessTableById(this.getSessionTableId(request, PROCESS_TABLE_ID_CONTEXT));
		for (Integer cnt : dayCount) {
			int groupId = (int)testDataProcessService.getGroupCount();
			TestDataProcessGroup group = new TestDataProcessGroup(groupId);
			group.setTestDataProcessTable(processTable);
			TestReportItem reportItem = reportItemList.get(offset);
			HarmfulSubstanceNationalStandardTable standardTable = harmfulSubstanceNationalStandardService.getHarmfulSubstanceNationalStandardTableById(reportItem.getTestSubstanceId());
			group.setHarmfulSubstanceNationalStandardTable(standardTable);
			group.setTestDataTime(reportItem.getTestTime());
			group.setTestWorkshopJob(reportItem.getTestWorkshopJob());
			group.setSubstanceDetailedName(reportItem.getSubstanceDetailedName());
			testDataProcessService.addGroup(group);
			BigDecimal mac = null;
			BigDecimal ctwa = new BigDecimal(0);
			BigDecimal cstel = new BigDecimal(0);
			BigDecimal om = new BigDecimal(0);
			
			int temp = offset;
			boolean hasEqual = false, hasLess = false;
			for (int i = 0; i < cnt; i++) {
				reportItem = reportItemList.get(offset);
				if (reportItem.getTestResultType().equals("=")) {
					hasEqual = true;
				} else {
					hasLess = true;
				}
				offset++;
			}
			
			offset = temp;
			
			for (int i = 0; i < cnt; i++) {
				reportItem = reportItemList.get(offset);
				TestDataProcessItem processTableItem = new TestDataProcessItem();
				processTableItem.setItemId(processItemIdBegin+offset);
				processTableItem.setTestDataProcessGroup(group);
				processTableItem.setTestResult(reportItem.getTestResult());
				processTableItem.setTestResultScale(reportItem.getTestResultScale());
				processTableItem.setTestResultType(reportItem.getTestResultType());
				processTableItem.setTestSampleNum(reportItem.getTestSampleNum());
				processTableItem.setTestTouchTime(reportItem.getTestTouchTime());
				testDataProcessService.addItem(processTableItem);
				BigDecimal calculatedResult = reportItem.getTestResult().multiply(BigDecimal.valueOf(reportItem.getTestCollectTime()/15));
				if (hasLess && hasEqual) {
					calculatedResult = new BigDecimal(calculatedResult.doubleValue()/2);
					group.setResultType("=");
				} else if (hasLess){
					group.setResultType("<");
				} else {
					group.setResultType("=");
				}
				ctwa = ctwa.add(calculatedResult.multiply(reportItem.getTestTouchTime()));
				cstel = cstel.max(reportItem.getTestResult());
				offset++;
			}
			BigDecimal std_mac = standardTable.getMac();
			BigDecimal pc_twa = standardTable.getPcTwa();
			BigDecimal pc_stel = standardTable.getPcStel();
			BigDecimal std_om = standardTable.getOm();
			mac = cstel;
			ctwa = new BigDecimal(ctwa.doubleValue()/8);
			om = new BigDecimal(cstel.doubleValue()/pc_twa.doubleValue());			
			

			
			boolean passed = true;
			if (std_mac != null) {
				int macScale = standardTable.getMacScale()+1;
				mac = rounding(mac, macScale);
				group.setMac(mac);
				group.setMacScale(mac.scale());
				if (mac.compareTo(std_mac) > 0) {
					passed = false;
				}
			}
			if (pc_twa != null) {
				int ctwaScale = standardTable.getPcTwaScale()+1;
				ctwa = rounding(ctwa, ctwaScale);
				group.setCtwa(ctwa);
				group.setCtwaScale(ctwa.scale());
				if (ctwa.compareTo(pc_twa) > 0) {
					passed = false;
				}
			}
				
			if (pc_stel != null) {
				int cstelScale = standardTable.getPcStelScale()+1;
				cstel = rounding(cstel, cstelScale);
				group.setCstel(cstel);
				group.setCstelScale(cstel.scale());
				if (cstel.compareTo(pc_stel) > 0) {
					passed = false;
				}
			}
			if (std_om != null) {
				int omScale = standardTable.getOmScale()+1;
				om = rounding(om, omScale);
				group.setOm(om);
				group.setOmScale(om.scale());
				if (om.compareTo(std_om) > 0) {
					passed = false;
				}
			}
			
			if (passed) {
				group.setTestResult("合格");
			} else {
				group.setTestResult("不合格");
			}
			groupList.add(group);
			testDataProcessService.updateGroup(group);
		}
		return groupList;
	}

	private ArrayList<Integer> getDayCountList(
			ArrayList<TestReportItem> reportItemList) {
		ArrayList<Integer> dayCount = new ArrayList<Integer>();
		Integer count = 0;
		Date prevDate = new Date(0);
		for (TestReportItem item : reportItemList) {
			if (!item.getTestTime().equals(prevDate)) {
				if (count != 0) {
					dayCount.add(count);
				}
				count = 0;
				prevDate = item.getTestTime();
			}
			count++;
			testReportService.addItem(item);			
		}
		dayCount.add(count);
		return dayCount;
	}

	private ArrayList<TestReportItem> getReportItemListFromInput(
			HttpServletRequest request, TestReportItemData data, Range<BigDecimal> range) {
		ArrayList<TestReportItem> reportItemList = new ArrayList<TestReportItem>();
		int reportItemIdBegin = (int)testReportService.getItemCount();
		int reportTableId = getSessionTableId(request, REPORT_TABLE_ID_CONTEXT);
		TestReportTable reportTable = testReportService.getTestReportTableByTableId(reportTableId);
		int offset = 0;
		range.setStart(BigDecimal.valueOf(Double.valueOf(data.getTestResult()[0][0])));
		range.setEnd(range.getStart());
		for (int i = 0; i < 3; i++) {
			if (data.getTestTime()[i] != null) {
				for (int j = 0; j < 4; j++) {
					if (data.getTestResult()[i][j] != "") {
						TestReportItem temp = new TestReportItem();
						temp.setItemId(reportItemIdBegin+offset);
						temp.setTestTouchTime(data.getTestTouchTime()[i][j]);
						temp.setTestCollectTime(data.getTestCollectTime()[i][j]);
						temp.setTestReportTable(reportTable);
						
						String testResult = data.getTestResult()[i][j];
						int scale = testResult.length() - testResult.indexOf('.') - 1;
						if (Character.isDigit(testResult.charAt(0))) {
							temp.setTestResult(BigDecimal.valueOf(Double.valueOf(testResult)));
							temp.setTestResultType("=");
						} else {
							temp.setTestResult(BigDecimal.valueOf(Double.valueOf(testResult.substring(1))));
							temp.setTestResultType(testResult.substring(0, 1));
							range.setStart(null);
						}

						range.setEnd(range.getEnd().max(temp.getTestResult()));
						if (range.getStart() != null) {
							range.setStart(range.getStart().min(temp.getTestResult()));
						}
						temp.setTestSampleNum(data.getTestSampleNum()+"-"+(offset+1<10?"0":"")+String.valueOf(offset+1));
						temp.setTestSubstanceId(data.getTestSubstanceId());
						temp.setTestSubstance(harmfulSubstanceNationalStandardService.getStandardNameById(data.getTestSubstanceId()));
						temp.setTestTime(data.getTestTime()[i]);
						temp.setTestWorkshopJob(data.getTestWorkshopJob());
						temp.setTestResultScale(scale);
						temp.setSubstanceDetailedName(data.getTestSubstanceDetailedName().length() == 0 ? null : data.getTestSubstanceDetailedName());
						reportItemList.add(temp);
						offset++;
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		return reportItemList;
	}

	@RequestMapping(value = "/loadSubstanceList")
	public void loadSubstanceList(HttpServletRequest request, HttpServletResponse response) {
		List<HarmfulSubstanceNationalStandardTable> list = harmfulSubstanceNationalStandardService.getStardardList();
		StringBuffer result = new StringBuffer("[");
		Iterator<HarmfulSubstanceNationalStandardTable> it = list.iterator();
		while (it.hasNext()) {
			HarmfulSubstanceNationalStandardTable temp = it.next();
			result.append("{\"id\" : \"");
			result.append(temp.getSubstanceId());
			result.append("\", ");
			result.append("\"name\" : \"");
			result.append(temp.getSubstanceChineseName());
			result.append("\"}, ");
		}
		result.setLength(result.length()-2);
		result.append("]");
		PrintWriter out = null;    
        response.setContentType("application/json");  
        try {  
            out = response.getWriter();
            out.write(result.toString());  
            System.out.println(result);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
	
	public void getHarmfulData(String[] args) throws Exception {
		StudyJacob jacob = new StudyJacob();
		jacob.openDocument("C:\\2.doc");

		ArrayList<HarmfulSubstanceNationalStandardTable> list = new ArrayList<HarmfulSubstanceNationalStandardTable>();
		int tableIndex = 1;
		int prevIndex = 0;
		int tableCol = jacob.getColumnsCount(tableIndex);
		int tableRow = jacob.getRowsCount(tableIndex);
		for (int row = 3; row <= tableRow - 1; row++) {
			HarmfulSubstanceNationalStandardTable item = new HarmfulSubstanceNationalStandardTable();
			try {
				String s = jacob.getCellString(tableIndex, row, 1);
				if (s.length() == 0)
					continue;
				prevIndex = Integer.valueOf(s);
				System.out.println("[" + row + "," + 1 + "] (" + s + ")");
			} catch (Exception e) {
				System.out.println("[" + row + "," + 1 + "] (" + prevIndex
						+ ")");
			}

			item.setSubstanceEnglishName(jacob
					.getCellString(tableIndex, row, 2));
			item.setChemicalAbstractNum(jacob.getCellString(tableIndex, row, 3));
			item.setSubstanceChineseName(jacob
					.getCellString(tableIndex, row, 4));
			ValueAndScale vs = new ValueAndScale();
			if (getValueAndScaleFromString(vs,
					jacob.getCellString(tableIndex, row, 5))) {
				item.setMac(vs.getValue());
				item.setMacScale(vs.getScale());
			}
			if (getValueAndScaleFromString(vs,
					jacob.getCellString(tableIndex, row, 6))) {
				item.setPcTwa(vs.getValue());
				item.setPcTwaScale(vs.getScale());
			}
			if (getValueAndScaleFromString(vs,
					jacob.getCellString(tableIndex, row, 7))) {
				item.setPcStel(vs.getValue());
				item.setPcStelScale(vs.getScale());
			}
			if (getValueAndScaleFromString(vs,
					jacob.getCellString(tableIndex, row, 8))) {
				item.setOm(vs.getValue());
				item.setOmScale(vs.getScale());
			}
			item.setSubstanceComment(jacob.getCellString(tableIndex, row, 9));
			list.add(item);
		}
		System.out.println(list.toString());
		System.out.println("col:" + tableCol + "\trow:" + tableRow);
		String s = jacob.getCellString(tableIndex, 51, 1);
		System.out.println("s: " + s);
		jacob.close();
		jacob.closeDocument();
	}

	private boolean getValueAndScaleFromString(ValueAndScale vs, String s) {
		if (s == null || s.equals("-")) {
			return false;
		} else {
			vs.setValue(new BigDecimal(Double.valueOf(s)));
			int index = s.indexOf('.');
			if (index != -1) {
				vs.setScale(s.length() - index - 1);
			}
			return true;
		}
	}

}

class ValueAndScale {
	private BigDecimal value;
	private int scale;

	public ValueAndScale() {
	}

	public ValueAndScale(BigDecimal value, int scale) {
		this.value = value;
		this.scale = scale;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
}
