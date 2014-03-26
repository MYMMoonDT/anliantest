package edu.tongji.anliantest.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;
import edu.tongji.anliantest.model.TestDataProcessGroup;
import edu.tongji.anliantest.model.TestDataProcessItem;
import edu.tongji.anliantest.model.TestDataProcessTable;
import edu.tongji.anliantest.model.TestDataResultItem;
import edu.tongji.anliantest.model.TestDataResultTable;
import edu.tongji.anliantest.model.TestReportItemData;
import edu.tongji.anliantest.model.TestReportTable;

public class DocumentGeneration {
	private static int ParticlesNotOtherwiseRegulatedId = 461;
	private static int[] PercentIdList = {439, 440, 441, 442, 443, 444};
	private static int[] ColsToCheck = {7, 2, 1};
	
//	public static void main(String argv[]) {
//		String filePath = "C:\\Users\\SausageHC\\eclipse_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\anliantest-web\\WEB-INF\\tempDocs\\reportTableTest.doc";
//		//getReportTableData(filePath);
//	}
	
	public static void getReportTableData(String filePath, TestReportTable table, ArrayList<TestReportItemData> itemDataList) {
//		TestReportTable table = new TestReportTable();
//		ArrayList<TestReportItemData> itemDataList = new ArrayList<TestReportItemData>();
		int cellRowIdx = -1;
		StudyJacob jacob = new StudyJacob();
		try {
			jacob.openDocument(filePath);
			
			String temp;
			jacob.switchToHeader();
			Dispatch selection = jacob.getSelection();
			Dispatch.call(selection, "WholeStory");
			temp = Dispatch.get(selection, "Text").getString();
			table.setTestReportNum(temp.substring(temp.indexOf('：')+1, temp.indexOf('\r')));
			jacob.switchToMainDoc();
			
			jacob.getTable(1);
			table.setSampleName(getValue(jacob.getCellString(1, 1)));
			temp = getValue(jacob.getCellString(1, 2));
			table.setSampleNum(Integer.valueOf(temp.substring(0, temp.length()-1)));
			table.setTestUnitName(getValue(jacob.getCellString(2, 1)));
			table.setSampleStatus(getValue(jacob.getCellString(2, 2)));
			table.setTestUnitAddress(getValue(jacob.getCellString(3, 1)));
			table.setTestProperty(getValue(jacob.getCellString(3, 2)));
			table.setEntrustUnitName(getValue(jacob.getCellString(4, 1)));
			
			jacob.getTable(2);
			Date[] dates = null;
			dates = getDate(jacob.getCellString(jacob.getRowsCount(), 1));
			table.setSampleTimeStart(dates[0]);
			if (dates.length == 2) {
				table.setSampleTimeEnd(dates[1]);
			}
			dates = getDate(jacob.getCellString(jacob.getRowsCount(), 2));
			table.setReceiveTimeStart(dates[0]);
			if (dates.length == 2) {
				table.setReceiveTimeEnd(dates[1]);
			}
			dates = getDate(jacob.getCellString(jacob.getRowsCount(), 3));
			table.setTestTimeStart(dates[0]);
			if (dates.length == 2) {
				table.setTestTimeEnd(dates[1]);
			}
			dates = getDate(jacob.getCellString(jacob.getRowsCount(), 4));
			table.setReportTime(dates[0]);

			Dispatch doc = jacob.getDocumnet();
			Dispatch sentences = Dispatch.get(doc, "Sentences").getDispatch();
			int senCnt = Dispatch.get(sentences, "Count").getInt();
			temp = Dispatch.get(Dispatch.call(sentences, "Item", senCnt).getDispatch(), "Text").getString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			table.setTableTime(dateFormat.parse(temp.trim()));
			
			jacob.getTable(3);
			dateFormat = new SimpleDateFormat("MM月dd号");
			Date[] testTime = new Date[3];
			String[][] testSampleNum = new String[3][4];
			String[][] testResult = new String[3][4];
			String[][] testTouchTime = new String[3][4];
			Integer[][] testCollectTime = new Integer[3][4];
			int tableRow = jacob.getRowsCount();
			int i = -1, j = 0, prevRowIdx = -1 ;
			int prevTestTime = 1, prevSubstance = 1, prevWorkshopJob = 2;
			int[] prevRows = {prevTestTime, prevSubstance, prevWorkshopJob};
			TestReportItemData itemData = new TestReportItemData();;
			for (cellRowIdx = 2; cellRowIdx <= tableRow; cellRowIdx++) {
				if (jacob.isCellStrExisted(cellRowIdx, 7)) {
					//DONE use prev to judge if time is same
					if (!isSameCells(jacob, cellRowIdx, prevRows, ColsToCheck, 0)) {
						i++;
						j = 0;
						prevRows[0] = cellRowIdx;
						//prevTestTime = cellRowIdx;
						if (jacob.isCellStrExisted(cellRowIdx, 2)) {
							//DONE use prev to judge if time is same
							if (!isSameCells(jacob, cellRowIdx, prevRows, ColsToCheck, 1)) {
								if (prevRowIdx != -1) {
									itemData = new TestReportItemData();
									i = 0;
									j = 0;
									testTime = new Date[3];
									testSampleNum = new String[3][4];
									testResult = new String[3][4];
									testTouchTime = new String[3][4];
									testCollectTime = new Integer[3][4];
								}
								prevRowIdx=1;
								
								String sub = jacob.getCellString(cellRowIdx, 2);
								String[] r = splitSubName(sub);
								itemData.setTestSubstance(r[0]);
								itemData.setTestSubstanceDetailedName(r[1]);
								itemData.setTestTime(testTime);
								itemData.setTestSampleNum(testSampleNum);
								itemData.setTestResult(testResult);
								itemData.setTestTouchTime(testTouchTime);
								itemData.setTestCollectTime(testCollectTime);
								
								itemDataList.add(itemData);
								//prevSubstance = cellRowIdx;
								prevRows[1] = cellRowIdx;
								
								if (jacob.isCellStrExisted(cellRowIdx, 1)) {
									itemData.setTestWorkshopJob(jacob.getCellString(cellRowIdx, 1));
									//prevWorkshopJob = cellRowIdx;
									prevRows[2] = cellRowIdx;
								} else {
									itemData.setTestWorkshopJob(jacob.getCellString(prevRows[2], 1));
								}
							}
						}
						testTime[i] = dateFormat.parse(jacob.getCellString(cellRowIdx, 7));
						// TODO Deal with different months / years
						Calendar c = Calendar.getInstance();
						c.setTimeInMillis(table.getSampleTimeStart().getTime());
						int year = c.get(Calendar.YEAR);
						c.setTime(testTime[i]);
						c.set(Calendar.YEAR, year);
						testTime[i] = c.getTime();
					}
				}
					testSampleNum[i][j] = jacob.getCellString(cellRowIdx, 3);
					testResult[i][j] = jacob.getCellString(cellRowIdx, 4);
					testTouchTime[i][j] = jacob.getCellString(cellRowIdx, 5);
					temp = jacob.getCellString(cellRowIdx, 6);
					testCollectTime[i][j] = Integer.valueOf(temp.substring(0, temp.length() - 3));
					j++;
			}
			
			jacob.close();
			jacob.closeDocument();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Remove later
			try {
				System.out.println(cellRowIdx+": "+jacob.getCellString(cellRowIdx, 3));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private static String[] splitSubName(String sub) {
		sub = sub.replace('(', '（');
		sub = sub.replace(')', '）');
		sub = sub.replace(" ", "");
		// TODO Deal with other detailedName
		String subDetail;
		if (sub.contains("其他粉尘")) {
			String[] strs = sub.split("[（\\(）\\)]");
			sub = strs[0];
			subDetail = strs[1];
		} else {
			subDetail = null;
		}
		String[] r = {sub, subDetail};
		return r;
	}
	private static boolean isSameCells(StudyJacob jacob, int rowToCheck, int prevRows[], int[] cols, int compareBegin) throws Exception {
		for (int i = compareBegin; i < cols.length; i++) {
			if (!isSameCell(jacob, rowToCheck, prevRows[i], cols[i]))
				return false;
		}
		return true;
	}
	
	private static boolean isSameCell(StudyJacob jacob, int row1, int row2, int col) throws Exception {
		if (!jacob.isCellStrExisted(row1, col)) return true;
		if (jacob.isInOnePage(row1, col, row2, col)) return false;
		String s1 = jacob.getCellString(row1, col);
		String s2 = jacob.getCellString(row2, col);
		if (!s1.equals(s2)) return false;
		return true;
	}
	
	private static Date[] getDate(String s) {
		// TODO Deal with different months / years
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date[] dates = new Date[2];
		try {
			for (int i = 0; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))) {
					int wavyIndex = s.indexOf('~');
					if (wavyIndex != -1) {
						dates[0] = dateFormat.parse(s.substring(i, wavyIndex));
						dates[1] = dateFormat.parse(s.substring(i, s.lastIndexOf('-') + 1) + s.substring(wavyIndex + 1, s.length()));
					} else {
						dates[0] = dateFormat.parse(s.substring(i, s.length()));
					}
					break;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dates;
	}

	private static String getValue(String nameAndValue) {
		if (nameAndValue != null)
			return nameAndValue.substring(nameAndValue.indexOf('：')+1, nameAndValue.length());
		else 
			return null;
	}
	
	public static void generateResultTable(TestDataResultTable resultTable, String filePath) {
		//ComThread.InitSTA();
		StudyJacob jacob = new StudyJacob();
		jacob.createNewDocument();
		setPage(jacob, 3.17, 2.54);
		Dispatch font = jacob.getFont();
		Dispatch.put(font, "Name", new Variant("仿宋"));
		Dispatch.put(font, "Name", new Variant("Times New Roman"));
		
		addResultDataToTable(resultTable, jacob);
		
		
		jacob.save(filePath);
		jacob.closeDocument();
		jacob.close();
		//ComThread.Release();
	}
	
	public static void generateProcessTable(TestDataProcessTable processTable, String filePath) {
		//ComThread.InitSTA();
		StudyJacob jacob = new StudyJacob();
		jacob.createNewDocument();
		setPage(jacob, 0.8, 1.27);
		Dispatch font = jacob.getFont();
		Dispatch.put(font, "Name", new Variant("宋体"));
		Dispatch.put(font, "Name", new Variant("Times New Roman"));
	
		// TODO Add projectNum
		setHeader(jacob, processTable.getTableNum(), "");
		setNote(jacob);	
		addProcessDataToTable(processTable, jacob);
		jacob.breakHeaderFooterLink();
		
		jacob.save(filePath);
		jacob.closeDocument();
		jacob.close();
		//ComThread.Release();
	}

	public static ArrayList<HarmfulSubstanceNationalStandardTable> getHarmfulData1(int substanceIdBegin) throws Exception {
			StudyJacob jacob = new StudyJacob();
			jacob.openDocument("C:\\Users\\SausageHC\\eclipse_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\anliantest-web\\WEB-INF\\tempDocs\\2.doc");
	
			ArrayList<HarmfulSubstanceNationalStandardTable> list = new ArrayList<HarmfulSubstanceNationalStandardTable>();
			int tableIndex = 1;
			int prevIndex = 0;
			int tableRow = jacob.getRowsCount(tableIndex);
			int substanceId = substanceIdBegin;
			for (int row = 3; row <= tableRow - 1; row++) {
				try {
					String s = jacob.getCellString(tableIndex, row, 1);
					if (s == null)
						continue;
					prevIndex = Integer.valueOf(s);
					System.out.println("[" + row + "," + 1 + "] (" + s + ")");
				} catch (Exception e) {
					System.out.println("[" + row + "," + 1 + "] (" + prevIndex
							+ ")");
				}
	
				HarmfulSubstanceNationalStandardTable item = new HarmfulSubstanceNationalStandardTable(substanceId++);
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
				String comment = jacob.getCellString(tableIndex, row, 9);
				if (comment != null && comment.equals("-")) {
					comment = null;
				}
				item.setSubstanceComment(comment);
				list.add(item);
	//			harmfulSubstanceNationalStandardService.addItem(item);
			}
			System.out.println("row:" + tableRow);
	
			jacob.close();
			jacob.closeDocument();
			return list;
		}

	public static ArrayList<HarmfulSubstanceNationalStandardTable> getHarmfulData2(int substanceIdBegin) throws Exception {
			StudyJacob jacob = new StudyJacob();
			jacob.openDocument("C:\\Users\\SausageHC\\eclipse_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\anliantest-web\\WEB-INF\\tempDocs\\2.doc");
	
			ArrayList<HarmfulSubstanceNationalStandardTable> list = new ArrayList<HarmfulSubstanceNationalStandardTable>();
			int tableIndex = 2;
			int prevIndex = 0;
	//		int tableCol = jacob.getColumnsCount(tableIndex);
			int tableRow = jacob.getRowsCount(tableIndex);
			int substanceId = substanceIdBegin;
			for (int row = 3; row <= tableRow - 1; row++) {
				try {
					String s = jacob.getCellString(tableIndex, row, 1);
					if (s == null)
						continue;
					prevIndex = Integer.valueOf(s);
					System.out.println("[" + row + "," + 1 + "] (" + s + ")");
				} catch (Exception e) {
					System.out.println("[" + row + "," + 1 + "] (" + prevIndex
							+ ")");
				}
	
				HarmfulSubstanceNationalStandardTable item = new HarmfulSubstanceNationalStandardTable(substanceId++);
				item.setSubstanceEnglishName(jacob
						.getCellString(tableIndex, row, 3));
				item.setChemicalAbstractNum(jacob.getCellString(tableIndex, row, 4));
				ValueAndScale vs = new ValueAndScale();
	
				if (getValueAndScaleFromString(vs,
						jacob.getCellString(tableIndex, row, 7))) {
					item.setOm(vs.getValue());
					item.setOmScale(vs.getScale());
				}
				String comment = jacob.getCellString(tableIndex, row, 8);
				if (comment != null && comment.equals("-")) {
					comment = null;
				}
				item.setSubstanceComment(comment);
	
				String name = jacob.getCellString(tableIndex, row, 2);
				item.setSubstanceChineseName(name+"（总尘）");
				if (getValueAndScaleFromString(vs,
						jacob.getCellString(tableIndex, row, 5))) {
					item.setPcTwa(vs.getValue());
					item.setPcTwaScale(vs.getScale());
				}
				list.add(item);
	//			harmfulSubstanceNationalStandardService.addItem(item);
	
				item.setSubstanceId(substanceId++);
				item.setSubstanceChineseName(name+"（呼尘）");
				if (getValueAndScaleFromString(vs,
						jacob.getCellString(tableIndex, row, 6))) {
					item.setPcTwa(vs.getValue());
					item.setPcTwaScale(vs.getScale());
				}
				
				list.add(item);
	//			harmfulSubstanceNationalStandardService.addItem(item);
			}
			System.out.println("row:" + tableRow);
	
			jacob.close();
			jacob.closeDocument();
			return list;
		}

	private static void addResultDataToTable(TestDataResultTable resultTable,
			StudyJacob jacob) {
		int tableCol = 14;
		int tableRow = 1;
		Dispatch table = jacob.insertTable(tableCol, tableRow);
		Dispatch borders = Dispatch.get(table, "Borders").toDispatch();
		Dispatch.put(borders, "InsideLineStyle", new Variant(1));
		Dispatch.put(borders, "OutsideLineStyle", new Variant(1));
		
		jacob.setTableAlignCenter();
		
		//Dispatch font = jacob.getFont();
		//Dispatch.put(font, "Bold", new Variant(true));
		int headingRowCount = addResultTableHeadingRows(jacob);
		tableRow = headingRowCount + 1;
		//font = jacob.getFont();
		//Dispatch.put(font, "Bold", new Variant(false));
		
		int cellRowIdx = tableRow, cellColIdx = 1;
		//int mergeRowBegin = cellRowIdx;
		Iterator<TestDataResultItem> itemIt = resultTable.getTestDataResultItems().iterator();
		while (itemIt.hasNext()) {
			TestDataResultItem item = itemIt.next();
			jacob.putTxtToCell(cellRowIdx, 1, item.getTestWorkshopJob());
			HarmfulSubstanceNationalStandardTable substance = item.getHarmfulSubstanceNationalStandardTable();
			jacob.putTxtToCell(cellRowIdx, 2, substance.getSubstanceChineseName() + getDetailedName(item.getSubstanceDetailedName(), substance.getSubstanceId()));
			jacob.putTxtToCell(cellRowIdx, 3, item.getTestSampleCount().toString());
			jacob.putTxtToCell(cellRowIdx, 4, new ValueAndScale(item.getTestTouchTime(), item.getTestTouchTimeScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 5, getRangeString(item.getTestResultRangeStart(), item.getTestResultRangeStartType(), item.getTestResultRangeEnd(), item.getTestResultRangeEndType(), item.getTestResultRangeScale()));
			String type = item.getResultType();//.equals("=") ? "" : "<";
			jacob.putTxtToCell(cellRowIdx, 6, new ValueAndScale(item.getMac(), item.getMacScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 7, new ValueAndScale(item.getCtwa(), item.getCtwaScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 8, new ValueAndScale(item.getCstel(), item.getCstelScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 9, new ValueAndScale(item.getOm(), item.getOmScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 10, new ValueAndScale(substance.getMac(), substance.getMacScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 11, new ValueAndScale(substance.getPcTwa(), substance.getPcTwaScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 12, new ValueAndScale(substance.getPcStel(), substance.getPcStelScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 13, new ValueAndScale(substance.getOm(), substance.getOmScale()).toString());
			if (item.getTestResult().equals("不合格")) {
				jacob.putBoldTxtToCell(cellRowIdx, 14, item.getTestResult());
			} else {
				jacob.putTxtToCell(cellRowIdx, 14, item.getTestResult());
			}
			
			if (itemIt.hasNext()) {
				jacob.addRow();
				tableRow++;
				cellRowIdx++;
			}
		}
		
//		for (int row = mergeRowBegin + 1; row <= cellRowIdx; row++) {
//			//for (int col = 1; col <= tableCol; col++) {
//			int col = 1;
//				String mergeStr;
//				try {
//					mergeStr = jacob.getCellString(mergeRowBegin, col);
//
//					if (jacob.isInOnePage(mergeRowBegin, col, row, col)) {
//						jacob.deleteCellTxt(row, col);
//						jacob.mergeCell(mergeRowBegin, col, row, col);
//					} else {
//						jacob.putTxtToCell(row, col, mergeStr);
//						continue;
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			//}
//		}
		String prevStr = "";
		int prevRowIdx = 1;
		for (cellRowIdx = headingRowCount; cellRowIdx <= tableRow; cellRowIdx++) {
			String curStr;
			try {
				curStr = jacob.getCellString(cellRowIdx, cellColIdx);
				if (curStr.equals(prevStr)
						&& jacob.isInOnePage(prevRowIdx, cellColIdx, cellRowIdx, cellColIdx)) {
					jacob.deleteCellTxt(cellRowIdx, cellColIdx);
					jacob.mergeCell(prevRowIdx, cellColIdx, cellRowIdx,	cellColIdx);						
				} else {
					prevRowIdx = cellRowIdx;
					prevStr = curStr;
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	private static String getRangeString(BigDecimal start, String startType, BigDecimal end, String endType, int scale) {
		StringBuffer temp = new StringBuffer();
		temp.append(new ValueAndScale(start, scale).toTypeString(startType));
		if (!startType.equals(endType) || !start.equals(end)) {
			temp.append("-");
			temp.append(new ValueAndScale(end, scale).toTypeString(endType));
		}		
		return temp.toString();
	}
	
	private static int addResultTableHeadingRows(StudyJacob jacob) {		
		jacob.addRow();
		jacob.addRow();
		jacob.setRowHeadingFormat(1);
		jacob.setRowHeadingFormat(2);

		jacob.setRowBold(1);
		jacob.setRowBold(2);
		
		jacob.setColumnWidth(4.21, 1);
		jacob.setColumnWidth(2.75, 2);
		jacob.setColumnWidth(1.37, 3);
		jacob.setColumnWidth(1.27, 4);
		jacob.setColumnWidth(3.17, 5);
		jacob.setColumnWidth(1.27, 6);
		jacob.setColumnWidth(1.51, 7);
		jacob.setColumnWidth(1.65, 8);
		jacob.setColumnWidth(1.53, 9);
		jacob.setColumnWidth(1.48, 10);
		jacob.setColumnWidth(1.26, 11);
		jacob.setColumnWidth(1.49, 12);
		jacob.setColumnWidth(1.51, 13);
		jacob.setColumnWidth(1.56, 14);
		//jacob.setRowsHeightRuleExactly();
		jacob.setRowsHeight(0.7);
		jacob.setRowHeight(0.66, 1);
		jacob.setRowHeight(0.66, 2);
		
		jacob.putTxtToCell(1, 1, "检测地点");
		jacob.mergeCell(1, 1, 2, 1);
		jacob.putTxtToCell(1, 2, "检测\n项目");
		jacob.mergeCell(1, 2, 2, 2);
		jacob.putTxtToCell(1, 3, "样品数（个）");
		jacob.mergeCell(1, 3, 2, 3);
		jacob.putTxtToCell(1, 4, "接触时间(h/d)");
		jacob.mergeCell(1, 4, 2, 4);
		jacob.putTxtToCell(1, 5, "检测结果\n（mg/m");
		jacob.insertSuperText("3");
		jacob.insertText("）");
		jacob.mergeCell(1, 5, 1, 9);
		jacob.putTxtToCell(1, 6, "职业接触限值（mg/m");
		jacob.insertSuperText("3");
		jacob.insertText("）");
		jacob.mergeCell(1, 6, 1, 9);
		jacob.putTxtToCell(1, 7, "评价\n结论");
		jacob.mergeCell(1, 7, 2, 14);
		jacob.putTxtToCell(2, 5, "范围");
		jacob.putTxtToCell(2, 6, "C");
		jacob.insertSubText("MAC");
		jacob.putTxtToCell(2, 7, "C");
		jacob.insertSubText("TWA");
		jacob.putTxtToCell(2, 8, "C");
		jacob.insertSubText("STEL");
		jacob.putTxtToCell(2, 9, "超限倍数");
		jacob.putTxtToCell(2, 10, "MAC");
		jacob.putTxtToCell(2, 11, "PC-\nTWA");
		jacob.putTxtToCell(2, 12, "PC-\nSTEL");
		jacob.putTxtToCell(2, 13, "最大超限倍数");
		return 2;
	}
	
	private static void setPage(StudyJacob jacob, double verticalMargin, double horizontalMargin) {
		jacob.setPageOrientation(1);
		Dispatch pageSetup = jacob.getPageSetup();
		Dispatch.put(pageSetup, "TopMargin", jacob.centimetersToPoints(verticalMargin));
		Dispatch.put(pageSetup, "BottomMargin", jacob.centimetersToPoints(verticalMargin));
		Dispatch.put(pageSetup, "LeftMargin", jacob.centimetersToPoints(horizontalMargin));
		Dispatch.put(pageSetup, "RightMargin", jacob.centimetersToPoints(horizontalMargin));
	}

	private static void setHeader(StudyJacob jacob, String tableNum, String projectNum) {
		jacob.switchToHeader();
		Dispatch selection = jacob.getSelection();
		
		Dispatch.call(selection, "ClearFormatting");

		Dispatch font = jacob.getFont();
		Dispatch.put(font, "Name", new Variant("宋体"));
		Dispatch.put(font, "Name", new Variant("Times New Roman"));
		Dispatch.put(font, "Size", 14);
		Dispatch paragraphFormat = Dispatch.get(selection, "ParagraphFormat").toDispatch();
		Dispatch.put(paragraphFormat, "Alignment", 1);
		jacob.insertText("检测报告计算判定过程记录——有毒物质\n\n");
		Dispatch.put(font, "Size", 10.5);
		Dispatch.put(paragraphFormat, "Alignment", 3);
		
		jacob.insertText("表码：");
		jacob.insertText(tableNum);
		jacob.insertSpace(58-tableNum.length());
		jacob.insertText("修订状态：1/0");
		jacob.insertSpace(52);
		jacob.insertText("第 ");
		jacob.insertPageNum();
		jacob.insertText("页  共 ");
		jacob.insertNumPages();
		jacob.insertText("页\n");
		jacob.insertText("项目编号：");
		jacob.insertText(projectNum);
		jacob.insertSpace(54-projectNum.length());
		jacob.insertText("项目类型： 检评  预评  控评√");
		jacob.switchToMainDoc();
	}
	
	private static int addProcessTableHeadingRows(StudyJacob jacob) {		
		jacob.addRow();
		jacob.addRow();
		jacob.setRowHeadingFormat(1);
		jacob.setRowHeadingFormat(2);
		
		jacob.setColumnWidth(2.04, 1);
		jacob.setColumnWidth(2.65, 2);
		jacob.setColumnWidth(3.4, 3);
		jacob.setColumnWidth(3.43, 4);
		jacob.setColumnWidth(2.09, 5);
		jacob.setColumnWidth(1.92, 6);
		jacob.setColumnWidth(1.54, 7);
		jacob.setColumnWidth(1.5, 8);
		jacob.setColumnWidth(1.63, 9);
		jacob.setColumnWidth(1.23, 10);
		jacob.setColumnWidth(1.56, 11);
		jacob.setColumnWidth(1.46, 12);
		jacob.setColumnWidth(1.4, 13);
		jacob.setColumnWidth(1.34, 14);
		jacob.setColumnWidth(1.2, 15);
		jacob.setRowsHeightRuleExactly();
		jacob.setRowsHeight(0.63);
		jacob.setRowHeight(1.31, 1);
		jacob.setRowHeight(1.05, 2);
		
		jacob.putTxtToCell(1, 1, "日期");
		jacob.mergeCell(1, 1, 2, 1);
		jacob.putTxtToCell(1, 2, "车间/岗位");
		jacob.mergeCell(1, 2, 2, 2);
		jacob.putTxtToCell(1, 3, "危害因素");
		jacob.mergeCell(1, 3, 2, 3);
		jacob.putTxtToCell(1, 4, "样品编号");
		jacob.mergeCell(1, 4, 2, 4);
		jacob.putTxtToCell(1, 5, "检测结果\n(mg/m");
		jacob.insertSuperText("3");
		jacob.insertText(")");
		jacob.mergeCell(1, 5, 2, 5);
		jacob.putTxtToCell(1, 6, "代表接触\n时间(h)");
		jacob.mergeCell(1, 6, 2, 6);
		jacob.putTxtToCell(1, 7, "检测结果\n（mg/m");
		jacob.insertSuperText("3");
		jacob.insertText("）");
		jacob.mergeCell(1, 7, 1, 10);
		jacob.putTxtToCell(1, 8, "职业接触限值（mg/m");
		jacob.insertSuperText("3");
		jacob.insertText("）");
		jacob.mergeCell(1, 8, 1, 11);
		jacob.putTxtToCell(1, 9, "判定结果");
		jacob.mergeCell(1, 9, 2, 15);
		jacob.putTxtToCell(2, 7, "MAC");
		jacob.putTxtToCell(2, 8, "C");
		jacob.insertSubText("TWA");
		jacob.putTxtToCell(2, 9, "C");
		jacob.insertSubText("STEL");
		jacob.putTxtToCell(2, 10, "超限倍数");
		jacob.putTxtToCell(2, 11, "MAC");
		jacob.putTxtToCell(2, 12, "PC-\nTWA");
		jacob.putTxtToCell(2, 13, "PC-\nSTEL");
		jacob.putTxtToCell(2, 14, "超限倍数");
		return 2;
	}
	
	private static void setNote(StudyJacob jacob) {
		jacob.insertBoldText("注：");
		jacob.insertText("有毒物质C");
		jacob.insertSubText("STEL");
		jacob.insertText("的选取和C");
		jacob.insertSubText("TWA");
		jacob.insertText("的计算：\n");
		jacob.insertText("\t采用定点、短时间采样方法的采样，在某工作岗位选取有代表性的、工人可能接触有毒物质浓度最高的几个时段进行短时间采样。几个时段中有毒物质浓度的最高值即是该岗位工人接触的C");
		jacob.insertSubText("STEL");
		jacob.insertText("，用几个时段中有毒物质的浓度分别乘以所代表的相应接触时间，再除以8小时即是该岗位工人接触的C");
		jacob.insertSubText("TWA");
		jacob.insertText("的计算公式：\n");
		jacob.insertText("\t\t\t\tC");
		jacob.insertSubText("TWA");
		jacob.insertText("=(C");
		jacob.insertSubText("1");
		jacob.insertText("T");
		jacob.insertSubText("1");
		jacob.insertText("+ C");
		jacob.insertSubText("2");
		jacob.insertText("T");
		jacob.insertSubText("2");
		jacob.insertText("+…C");
		jacob.insertSubText("n");
		jacob.insertText("T");
		jacob.insertSubText("n");
		jacob.insertText(")/8\n");
		jacob.insertText("\t\tC");
		jacob.insertSubText("TWA");
		jacob.insertText("---空气中有害物质8h时间加权平均浓度，mg/m");
		jacob.insertSuperText("3");
		jacob.insertText("\n");
		jacob.insertText("\t\tC");
		jacob.insertSubText("1");
		jacob.insertText("、C");
		jacob.insertSubText("2");
		jacob.insertText("、C");
		jacob.insertSubText("n");
		jacob.insertText("---空气中有害物质浓度，mg/ m");
		jacob.insertSuperText("3");
		jacob.insertText("\n");
		jacob.insertText("\t\tT");
		jacob.insertSubText("1");
		jacob.insertText("、T");
		jacob.insertSubText("2");
		jacob.insertText("、T");
		jacob.insertSubText("n");
		jacob.insertText("---劳动者在相应的有害物质浓度下的工作时间，h\n");
		jacob.insertText("\t\t8---时间加权平均容许浓度规定的8h\n");
	}
	
//	private boolean needMerge() {
//		
//	}
	
	private static void addProcessDataToTable(TestDataProcessTable processTable,
			StudyJacob jacob) {
		int tableCol = 15;
		int tableRow = 1;
		Dispatch table = jacob.insertTable(tableCol, tableRow);
		Dispatch borders = Dispatch.get(table, "Borders").toDispatch();
		Dispatch.put(borders, "InsideLineStyle", new Variant(1));
		Dispatch.put(borders, "OutsideLineStyle", new Variant(1));
		
		jacob.setTableAlignCenter();
		
		int headingRowCount = addProcessTableHeadingRows(jacob);
		tableRow = headingRowCount + 1;
		ArrayList<Integer> colsNotToMerge = new ArrayList<Integer>();
		colsNotToMerge.add(4);
		colsNotToMerge.add(5);
		colsNotToMerge.add(6);
		
		int cellRowIdx = tableRow, cellColIdx = 1;
		int prevTestTime = 1, prevSubstance = 1, prevWorkshopJob = 1, newPrevRow = 1;
		int[] prevRows = {prevTestTime, prevSubstance, prevWorkshopJob};
		SimpleDateFormat dateFormat =  new SimpleDateFormat("MM月dd号");
		Set<TestDataProcessGroup> groupSet = processTable.getTestDataProcessGroups();
		Iterator<TestDataProcessGroup> groupIt = groupSet.iterator();
		while (groupIt.hasNext()) {
			TestDataProcessGroup group = groupIt.next();
			jacob.putTxtToCell(cellRowIdx, 1, dateFormat.format(group.getTestDataTime()));
			jacob.putTxtToCell(cellRowIdx, 2, group.getTestWorkshopJob());
			HarmfulSubstanceNationalStandardTable substance = group.getHarmfulSubstanceNationalStandardTable();
			jacob.putTxtToCell(cellRowIdx, 3, substance.getSubstanceChineseName() + getDetailedName(group.getSubstanceDetailedName(), substance.getSubstanceId()));
			String type = group.getResultType();//.equals("=") ? "" : "<";
			jacob.putTxtToCell(cellRowIdx, 7, new ValueAndScale(group.getMac(), group.getMacScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 8, new ValueAndScale(group.getCtwa(), group.getCtwaScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 9, new ValueAndScale(group.getCstel(), group.getCstelScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 10, new ValueAndScale(group.getOm(), group.getOmScale()).toTypeString(type));
			jacob.putTxtToCell(cellRowIdx, 11, new ValueAndScale(substance.getMac(), substance.getMacScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 12, new ValueAndScale(substance.getPcTwa(), substance.getPcTwaScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 13, new ValueAndScale(substance.getPcStel(), substance.getPcStelScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 14, new ValueAndScale(substance.getOm(), substance.getOmScale()).toString());
			if (group.getTestResult().equals("不合格")) {
				jacob.putBoldTxtToCell(cellRowIdx, 15, group.getTestResult());
			} else {
				jacob.putTxtToCell(cellRowIdx, 15, group.getTestResult());
			}
			int mergeResultsRowBegin = cellRowIdx;
			Set<TestDataProcessItem> itemSet = group.getTestDataProcessItems();
			Iterator<TestDataProcessItem> itemIt = itemSet.iterator();
			while (itemIt.hasNext()) {
				TestDataProcessItem item = itemIt.next();
				jacob.putTxtToCell(cellRowIdx, 4, item.getTestSampleNum());
				jacob.putTxtToCell(cellRowIdx, 5, new ValueAndScale(item.getTestResult(), item.getTestResultScale()).toTypeString(item.getTestResultType()));
				jacob.putTxtToCell(cellRowIdx, 6, new ValueAndScale(item.getTestTouchTime(), item.getTestTouchTimeScale()).toString());
				if (itemIt.hasNext() || groupIt.hasNext())
					jacob.addRow();
				tableRow++;
				cellRowIdx++;
			}
			boolean crossPage = false;
			for (int col = 1; col <= tableCol; col++) {
				if (colsNotToMerge.contains(col))
					continue;
//					jacob.mergeCell(mergeResultsRowBegin, col, cellRowIdx-1, col);
				
				
				int row;
				for (row = mergeResultsRowBegin + 1; row < cellRowIdx; row++) {
					if (jacob.isInOnePage(mergeResultsRowBegin, col, row, col)) {
						jacob.deleteCellTxt(row, col);
					} else {
						crossPage = true;
						newPrevRow = row;
						break;
					}
				}
				try {
					String mergeStr;
					mergeStr = jacob.getCellString(mergeResultsRowBegin, col);

					//if (jacob.isInOnePage(mergeRowBegin, col, row, col)) {
					if (row < cellRowIdx) {							
						//if (row > mergeRowBegin)
							jacob.mergeCell(mergeResultsRowBegin, col, row-1, col);
						jacob.putTxtToCell(row, col, mergeStr);
						//if (row < cellRowIdx-1)
							jacob.mergeCell(row, col, cellRowIdx-1, col);
					} else {
						jacob.mergeCell(mergeResultsRowBegin, col, cellRowIdx-1, col);
					}
					//} else {
					//	continue;
					//}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				if (jacob.getCellString(prevRows[2], 2).equals(jacob.getCellString(mergeResultsRowBegin, 2))
						&& jacob.isInOnePage(prevRows[2], 2, mergeResultsRowBegin, 2)) {
					jacob.deleteCellTxt(mergeResultsRowBegin, 2);
					jacob.mergeCell(mergeResultsRowBegin, 2, prevRows[2], 2);
					if (jacob.getCellString(prevRows[1], 3).equals(jacob.getCellString(mergeResultsRowBegin, 3))
							&& jacob.isInOnePage(prevRows[1], 3, mergeResultsRowBegin, 3)) {
						jacob.deleteCellTxt(mergeResultsRowBegin, 3);
						jacob.mergeCell(mergeResultsRowBegin, 3, prevRows[1], 3);
						if (jacob.getCellString(prevRows[0], 1).equals(jacob.getCellString(mergeResultsRowBegin, 1))
								&& jacob.isInOnePage(prevRows[0], 1, mergeResultsRowBegin, 1)) {
							jacob.deleteCellTxt(mergeResultsRowBegin, 1);
							jacob.mergeCell(mergeResultsRowBegin, 1, prevRows[0], 1);
						} else {
							prevRows[0] = mergeResultsRowBegin;
						}
					} else {
						prevRows[0] = mergeResultsRowBegin;
						prevRows[1] = mergeResultsRowBegin;
					}
				} else {
					prevRows[0] = mergeResultsRowBegin;
					prevRows[1] = mergeResultsRowBegin;
					prevRows[2] = mergeResultsRowBegin;
				}
				if (crossPage) {
					prevRows[0] = newPrevRow;
					prevRows[1] = newPrevRow;
					prevRows[2] = newPrevRow;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		tableRow--;
		
//		colsNotToMerge.add(1);
//		colsNotToMerge.add(7);
//		colsNotToMerge.add(8);
//		colsNotToMerge.add(9);
//		colsNotToMerge.add(10);
//		colsNotToMerge.add(11);
//		colsNotToMerge.add(12);
//		colsNotToMerge.add(13);
//		colsNotToMerge.add(14);
//		colsNotToMerge.add(15);
//		String prevStr = "";
//		int prevRowIdx = 1;
//		for (cellColIdx = 1; cellColIdx <= tableCol; cellColIdx++) {
//			if (colsNotToMerge.contains(cellColIdx))
//				continue;
//			//cellColIdx = 2;
//			for (cellRowIdx = headingRowCount; cellRowIdx <= tableRow; cellRowIdx++) {
//				String curStr;
//				try {
//					curStr = jacob.getCellString(cellRowIdx, cellColIdx);
//					if (curStr.equals(prevStr)
//							&& jacob.isInOnePage(prevRowIdx, cellColIdx, cellRowIdx, cellColIdx)) {
//						jacob.deleteCellTxt(cellRowIdx, cellColIdx);
//						jacob.mergeCell(prevRowIdx, cellColIdx, cellRowIdx,	cellColIdx);						
//					} else {
//						prevRowIdx = cellRowIdx;
//						prevStr = curStr;
//					}
//				} catch (Exception e) {
//					continue;
//				}
//			}
//		}

		jacob.moveDown(1);
	}

	private static String getDetailedName(
			String detailedName, int substanceId) {
		if (detailedName == null) return "";

		if (substanceId == ParticlesNotOtherwiseRegulatedId) {
			return "（" + detailedName + "）";
		}
		for (int i = 0; i < PercentIdList.length; i++) {
			if (PercentIdList[i] == substanceId) {
				return "（" + detailedName + "%）";
			}
		}
		return "";
	}

	private static boolean getValueAndScaleFromString(ValueAndScale vs, String s) {
		if (s == null || s.equals("-")) {
			return false;
		} else {
			vs.setValue(new BigDecimal(Double.valueOf(s)));
			int index = s.indexOf('.');
			if (index != -1) {
				vs.setScale(s.length() - index - 1);
			} else {
				vs.setScale(0);
			}
			return true;
		}
	}
}