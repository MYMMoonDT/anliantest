package edu.tongji.anliantest.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
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
import edu.tongji.anliantest.utils.DocumentGeneration;
import edu.tongji.anliantest.utils.Range;

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
	
	protected int getSessionTableId(HttpServletRequest request, String name){
		return (Integer)request.getSession().getAttribute(name);
	}

	protected void setSessionTableId(HttpServletRequest request,  String name, int tableId){
		request.getSession().setAttribute(name, tableId);
	}

	@RequestMapping(value = "/experimentCalculation")
	public String experimentCalculationPage(){
		return "experimentCalculation/createTestReportTable";
	}

	@RequestMapping(value = "/addTestReportItem")
	public String testReportItemPage(){
		return "experimentCalculation/addTestReportItem";
	}
	
	@RequestMapping(value = "/uploadTestReport")
	public String uploadTestReport(){
		return "experimentCalculation/uploadTestReport";
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

	@RequestMapping(value = "/addTestReportItemAndCalc")
	public ModelAndView addTestReportItemAndCalc(HttpServletRequest request, TestReportItemData data) throws Exception{
		// convert TestReportItemData to ArrayList<TestReportItem>
		Range<BigDecimal> range = new Range<BigDecimal>();
		ArrayList<TestReportItem> reportItemList = getReportItemListFromInput(request, data, range);
		
		ArrayList<Integer> dayCount = getDayCountList(reportItemList);
		
		// calculate
	
		ArrayList<TestDataProcessGroup> groupList = calcProcessData(request, reportItemList, dayCount);
	
		calcResultData(request, reportItemList, dayCount, groupList, range);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:addTestReportItem");
		mav.addObject("resultMsg", "success");
		return mav;
	}

	@RequestMapping(value = "/createTestReportTableFromDoc")
	public void createTestReportTableFromDoc(HttpServletRequest request, HttpServletResponse response) {
		try {
			BufferedInputStream fileIn = new BufferedInputStream(request.getInputStream());
			String fn = request.getParameter("fileName");
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append(request.getSession().getServletContext().getRealPath(""));
			strBuffer.append("\\WEB-INF\\tempDocs\\");
			strBuffer.append(fn);
			String filePath = strBuffer.toString();
			
			saveUploadFile(fileIn, filePath);
		
			TestReportTable reportTable = new TestReportTable();
			ArrayList<TestReportItemData> itemDataList = new ArrayList<TestReportItemData>();
			String error = "";
			try {
				DocumentGeneration.getReportTableData(filePath, reportTable, itemDataList);
				error = "表基本信息";
				createTestReportTable(request, reportTable);
				TestReportItemData itemData = null;
				Iterator<TestReportItemData> itemDataIt = itemDataList.iterator();
				while (itemDataIt.hasNext()) {
					itemData = itemDataIt.next();
					error = "<p>车间/岗位：" + itemData.getTestWorkshopJob()
							+ "</p><p>检测项目：" + itemData.getTestSubstance() + "处</p>";
					addTestReportItemAndCalc(request, itemData);
				}
//				for (TestReportItemData itemData : itemDataList) {
//					addTestReportItemAndCalc(request, itemData);
//				}
				PrintWriter printWriter = response.getWriter();
				printWriter.write("Success");
			} catch (Exception e) {
				//e.printStackTrace();
				PrintWriter printWriter = response.getWriter();
				if (e.getMessage() != null)
					printWriter.write("错误：" + error + e.getMessage());
				else
					printWriter.write("错误：" + error);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadProcessTable")
	public void downloadProcessTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(request.getSession().getServletContext().getRealPath(""));
		strBuffer.append("\\WEB-INF\\tempDocs\\");
		int reportTableId = getSessionTableId(request, REPORT_TABLE_ID_CONTEXT);
		strBuffer.append(testReportService.getTestReportTableByTableId(reportTableId).getTestUnitName());
		strBuffer.append(" 有毒物质 计算结果表.doc"); 
		int processTableId = getSessionTableId(request, PROCESS_TABLE_ID_CONTEXT);
		TestDataProcessTable processTable = testDataProcessService.getProcessTableById(processTableId);
		String filePath = strBuffer.toString();
		generateProcessTableToDoc(processTable, filePath);
		
		setResponseForDownload(response, filePath);
	}

	@RequestMapping(value = "/downloadResultTable")
	public void downloadResultTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(request.getSession().getServletContext().getRealPath(""));
		strBuffer.append("\\WEB-INF\\tempDocs\\");
		int reportTableId = getSessionTableId(request, REPORT_TABLE_ID_CONTEXT);
		strBuffer.append(testReportService.getTestReportTableByTableId(reportTableId).getTestUnitName());
		strBuffer.append(" 结果与评价.doc"); 
		int resultTableId = getSessionTableId(request, RESULT_TABLE_ID_CONTEXT);
		TestDataResultTable resultTable = testDataResultService.getResultTableById(resultTableId);
		String filePath = strBuffer.toString();
		generateResultTableToDoc(resultTable, filePath);
		
		setResponseForDownload(response, filePath);
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

	@RequestMapping(value = "/getHarmfulData1")
	public void getHarmfulData1FromDoc(HttpServletRequest request) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(request.getSession().getServletContext().getRealPath(""));
		strBuffer.append("\\WEB-INF\\tempDocs\\");
		strBuffer.append("GBZ.doc");
		String filePath = strBuffer.toString();
		ArrayList<HarmfulSubstanceNationalStandardTable> list = DocumentGeneration.getHarmfulData1(filePath, (int)harmfulSubstanceNationalStandardService.getItemCount());
		for (HarmfulSubstanceNationalStandardTable item : list) {
			harmfulSubstanceNationalStandardService.addItem(item);
		}
	}

	@RequestMapping(value = "/getHarmfulData2")
	public void getHarmfulData2FromDoc(HttpServletRequest request) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(request.getSession().getServletContext().getRealPath(""));
		strBuffer.append("\\WEB-INF\\tempDocs\\");
		strBuffer.append("GBZ.doc");
		String filePath = strBuffer.toString();
		ArrayList<HarmfulSubstanceNationalStandardTable> list = DocumentGeneration.getHarmfulData2(filePath, (int)harmfulSubstanceNationalStandardService.getItemCount());
		for (HarmfulSubstanceNationalStandardTable item : list) {
			harmfulSubstanceNationalStandardService.addItem(item);
		}
	}

	private void saveUploadFile(BufferedInputStream fileIn, String filePath)
			throws FileNotFoundException, IOException {
		byte[] buf = new byte[1024];
		File file = new File(filePath);

		BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file));

		while (true) {
			// 读取数据
			int bytesIn = fileIn.read(buf, 0, 1024);

			if (bytesIn == -1) {
				break;
			} else {
				fileOut.write(buf, 0, bytesIn);
			}
		}

		fileOut.flush();
		fileOut.close();

		System.out.println(file.getAbsolutePath());
	}
	
	private ArrayList<TestReportItem> getReportItemListFromInput(
			HttpServletRequest request, TestReportItemData data, Range<BigDecimal> range) throws Exception {
		ArrayList<TestReportItem> reportItemList = new ArrayList<TestReportItem>();
		int reportItemIdBegin = (int)testReportService.getItemCount();
		int reportTableId = getSessionTableId(request, REPORT_TABLE_ID_CONTEXT);
		TestReportTable reportTable = testReportService.getTestReportTableByTableId(reportTableId);
		int offset = 0;
		if (Character.isDigit(data.getTestResult()[0][0].charAt(0))) {
			range.setStartType("=");
			range.setStart(BigDecimal.valueOf(Double.valueOf(data.getTestResult()[0][0])));			
		} else {
			range.setStartType("<");
			range.setStart(BigDecimal.valueOf(Double.valueOf(data.getTestResult()[0][0].substring(1))));
		}
		range.setEnd(range.getStart());
		range.setEndType(range.getStartType());
		for (int i = 0; i < 3; i++) {
			if (data.getTestTime()[i] != null) {
				if (i > 0 && data.getTestTime()[i].equals(data.getTestTime()[i-1]))
					throw new Exception("采样日期重复");
				for (int j = 0; j < 4; j++) {
					if (data.getTestResult()[i][j] != null && !data.getTestResult()[i][j].equals("")) {
						TestReportItem temp = new TestReportItem();
						temp.setItemId(reportItemIdBegin+offset);
						try {
							temp.setTestTouchTime(BigDecimal.valueOf(Double.valueOf(data.getTestTouchTime()[i][j])));
						} catch(Exception e) {
							System.out.println(data.getTestSampleNum()[i][j]);
						}
						String touchTime = data.getTestTouchTime()[i][j];
						temp.setTestTouchTimeScale(getScaleFromNumStr(touchTime));
						temp.setTestCollectTime(data.getTestCollectTime()[i][j]);
						temp.setTestReportTable(reportTable);
						
						String testResult = data.getTestResult()[i][j];
	
						if (Character.isDigit(testResult.charAt(0))) {
							temp.setTestResult(BigDecimal.valueOf(Double.valueOf(testResult)));
							temp.setTestResultType("=");
						} else {
							temp.setTestResult(BigDecimal.valueOf(Double.valueOf(testResult.substring(1))));
							temp.setTestResultType("<");
							//range.setStart(null);
						}
	
						if (range.getStart().compareTo(temp.getTestResult()) > 0) {
							range.setStart(temp.getTestResult());
							range.setStartType(temp.getTestResultType());
						} else if (range.getStart().compareTo(temp.getTestResult()) == 0
								&& range.getStartType().equals("=") && temp.getTestResultType().equals("<")) {
							range.setStartType("<");
						}
						if (range.getEnd().compareTo(temp.getTestResult()) < 0) {
							range.setEnd(temp.getTestResult());
							range.setEndType(temp.getTestResultType());
						} else if (range.getEnd().compareTo(temp.getTestResult()) == 0
								&& range.getEndType().equals("<") && temp.getTestResultType().equals("=")) {
							range.setEndType("=");
						}
						//range.setEnd(range.getEnd().max(temp.getTestResult()));
						//if (range.getStart() != null) {
						//	range.setStart(range.getStart().min(temp.getTestResult()));
						//}
						//+"-"+(offset+1<10?"0":"")+String.valueOf(offset+1)
						temp.setTestSampleNum(data.getTestSampleNum()[i][j]);
						if (data.getTestSampleId() != null) {
							temp.setHarmfulSubstanceNationalStandardTable(harmfulSubstanceNationalStandardService.getSubstanceById(data.getTestSubstanceId()));
						} else {
							temp.setHarmfulSubstanceNationalStandardTable(harmfulSubstanceNationalStandardService.getSubstanceByName(data.getTestSubstance()));
						}
						//temp.setTestSubstance();
						temp.setTestTime(data.getTestTime()[i]);
						temp.setTestWorkshopJob(data.getTestWorkshopJob());
						temp.setTestResultScale(getScaleFromNumStr(testResult));
						if (data.getTestSubstanceDetailedName() != null && data.getTestSubstanceDetailedName().length() != 0) {
							temp.setSubstanceDetailedName(data.getTestSubstanceDetailedName());
						}
						reportItemList.add(temp);
						testReportService.addItem(temp);
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
						
		}
		dayCount.add(count);
		return dayCount;
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
			HarmfulSubstanceNationalStandardTable standardTable = reportItem.getHarmfulSubstanceNationalStandardTable();
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
				processTableItem.setTestTouchTimeScale(reportItem.getTestTouchTimeScale());
				testDataProcessService.addItem(processTableItem);
				BigDecimal calculatedResult = reportItem.getTestResult().multiply(BigDecimal.valueOf(reportItem.getTestCollectTime()/15));
				if (hasLess && hasEqual) {
					if (!processTableItem.getTestResultType().equals("="))
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
			if (hasLess && !hasEqual) {
				ctwa = cstel = mac = reportItem.getTestResult();
			} else {
				mac = cstel;
				ctwa = new BigDecimal(ctwa.doubleValue()/8);				
			}
			if (pc_twa != null)
				om = new BigDecimal(cstel.doubleValue()/pc_twa.doubleValue());
			
			boolean passed = true;
			if (std_mac != null) {
				if (hasLess && !hasEqual) {
					group.setMacScale(reportItem.getTestResultScale());
				} else {
					int macScale = standardTable.getMacScale()+1;
					mac = rounding(mac, macScale);
					group.setMacScale(mac.scale());
				}
				group.setMac(mac);
				if (mac.compareTo(std_mac) > 0) {
					passed = false;
				}
			}
			if (pc_twa != null) {
				if (hasLess && !hasEqual) {
					group.setCtwaScale(reportItem.getTestResultScale());
				} else {
					int ctwaScale = standardTable.getPcTwaScale()+1;
					ctwa = rounding(ctwa, ctwaScale);
					group.setCtwaScale(ctwa.scale());
				}
				group.setCtwa(ctwa);
				if (ctwa.compareTo(pc_twa) > 0) {
					passed = false;
				}
			}
				
			if (pc_stel != null) {
				if (hasLess && !hasEqual) {
					group.setCstelScale(reportItem.getTestResultScale());
				} else {
					int cstelScale = standardTable.getPcStelScale()+1;
					cstel = rounding(cstel, cstelScale);
					group.setCstelScale(cstel.scale());
				}
				group.setCstel(cstel);
				if (cstel.compareTo(pc_stel) > 0) {
					passed = false;
				}
			}
			if (std_om != null) {
				int omScale = standardTable.getOmScale() + 1;
				om = rounding(om, omScale);
				group.setOmScale(om.scale());
				group.setOm(om);
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

	private void calcResultData(HttpServletRequest request,
			ArrayList<TestReportItem> reportItemList,
			ArrayList<Integer> dayCount,
			ArrayList<TestDataProcessGroup> groupList,  Range<BigDecimal> range) {
		int sampleCount = reportItemList.size();
		BigDecimal maxGroupTouchTime = new BigDecimal(0);
		int offset = 0;
		for (Integer cnt : dayCount) {
			BigDecimal groupTouchTime = new BigDecimal(0);
			for (int i= offset; i < offset+cnt; i++) {
				groupTouchTime = groupTouchTime.add(reportItemList.get(i).getTestTouchTime());
			}
			offset += cnt;
			maxGroupTouchTime = maxGroupTouchTime.max(groupTouchTime);
		}
		
		int resultItemId = (int)testDataResultService.getItemCount();
		TestDataResultItem resultItem = new TestDataResultItem(resultItemId);
		TestDataResultTable resultTable = testDataResultService.getResultTableById(this.getSessionTableId(request, RESULT_TABLE_ID_CONTEXT));
		resultItem.setTestDataResultTable(resultTable);
		resultItem.setHarmfulSubstanceNationalStandardTable(groupList.get(0).getHarmfulSubstanceNationalStandardTable());
		resultItem.setTestWorkshopJob(groupList.get(0).getTestWorkshopJob());
		resultItem.setTestSampleCount(sampleCount);
		resultItem.setTestTouchTime(maxGroupTouchTime);
		resultItem.setTestTouchTimeScale(reportItemList.get(0).getTestTouchTimeScale());
		resultItem.setTestResultRangeScale(reportItemList.get(0).getTestResultScale());
		resultItem.setSubstanceDetailedName(reportItemList.get(0).getSubstanceDetailedName());
		resultItem.setTestResultRangeStart(range.getStart());
		resultItem.setTestResultRangeStartType(range.getStartType());
		resultItem.setTestResultRangeEnd(range.getEnd());
		resultItem.setTestResultRangeEndType(range.getEndType());
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

	
	private void generateProcessTableToDoc(TestDataProcessTable processTable, String filePath) {
		DocumentGeneration.generateProcessTable(processTable, filePath);
	}

	private void generateResultTableToDoc(TestDataResultTable resultTable, String filePath) {
		DocumentGeneration.generateResultTable(resultTable, filePath);
	}

	private void setResponseForDownload(HttpServletResponse response,
				String filePath) throws UnsupportedEncodingException, IOException {
			File file = new File(filePath);
			String fileNameSrc = file.getName();
			String fileName = URLEncoder.encode(fileNameSrc, "UTF-8");
			if (fileName.length() > 150)// 解决IE 6.0 bug
				fileName = new String(fileNameSrc.getBytes("GBK"), "ISO-8859-1");
			else
				fileName = fileName.replace("+", "%20");
			
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);
			response.setContentType("application/msword");
			Cookie cookie = new Cookie("fileDownload", "true");
			cookie.setPath("/");
			response.addCookie(cookie);
			
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(new FileInputStream(filePath));
				bos = new BufferedOutputStream(response.getOutputStream());
	
				byte[] buff = new byte[2048];
				int bytesRead;
	
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
	
			} catch (final IOException e) {
				System.out.println("IOException." + e);
	
			} finally {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			}
		}

	/**
	 * 修约
	 * 四舍六入五成双，不能为零
	 * 
	 * @param v
	 * @param scale
	 * @return
	 */
	private BigDecimal rounding(BigDecimal v, int scale) {
		v = v.setScale(8, RoundingMode.HALF_UP);
		BigDecimal zero = new BigDecimal(0);
		BigDecimal u = null;
		do {
			u = v.setScale(scale++, RoundingMode.HALF_EVEN);
		} while (u.compareTo(zero) == 0);
		return u;
	}
	
	/**
	 * 解析字符串得到小数位。
	 * 
	 * @param num
	 * @return
	 */
	private int getScaleFromNumStr(String num) {
		int index = num.indexOf('.');
		if (index == -1)
			return 0;
		else
			return num.length() - index - 1;
	}
}
