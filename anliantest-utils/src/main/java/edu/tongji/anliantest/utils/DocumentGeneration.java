package edu.tongji.anliantest.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;
import edu.tongji.anliantest.model.TestDataProcessGroup;
import edu.tongji.anliantest.model.TestDataProcessItem;
import edu.tongji.anliantest.model.TestDataProcessTable;

public class DocumentGeneration {
//	StudyJacob jacob;
//	
//	public DocumentGeneration() {
//		this.jacob = new StudyJacob();
//	}
	
//	public static void main(String[] args) {
//		
//	}
	private int ParticlesNotOtherwiseRegulatedId = 461;
	private int[] PercentIdList = {439, 440, 441, 442, 443, 444};
	
	private void setPage(StudyJacob jacob) {
		jacob.setPageOrientation(1);
		Dispatch pageSetup = jacob.getPageSetup();
		Dispatch.put(pageSetup, "TopMargin", jacob.centimetersToPoints(0.8));
		Dispatch.put(pageSetup, "BottomMargin", jacob.centimetersToPoints(0.8));
		Dispatch.put(pageSetup, "LeftMargin", jacob.centimetersToPoints(1.27));
		Dispatch.put(pageSetup, "RightMargin", jacob.centimetersToPoints(1.27));
		
		Dispatch font = jacob.getFont();
		Dispatch.put(font, "Name", new Variant("宋体"));
		Dispatch.put(font, "Name", new Variant("Times New Roman"));
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
	
	private int addTableHeadingRows(StudyJacob jacob) {		
		jacob.addRow();
		jacob.addRow();
		jacob.setRowHeadingFormat(1);
		jacob.setRowHeadingFormat(2);
		
		jacob.setColumnWidth(2.04, 1);
		jacob.setColumnWidth(2.15, 2);
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
		return 3;
	}
	
	private static void writeNote(StudyJacob jacob) {
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
	
	public void generateProcessTable(TestDataProcessTable processTable, String fileName) {
		StudyJacob jacob = new StudyJacob();
		jacob.createNewDocument();
		setPage(jacob);
		// TODO Add projectNum
		setHeader(jacob, processTable.getTableNum(), "");
		writeNote(jacob);	
		addProcessDataToTable(processTable, jacob);
		//jacob.breakHeaderFooterLink();
		
		jacob.save("C:\\"+fileName);
		jacob.closeDocument();
		jacob.close();
	}

	private void addProcessDataToTable(TestDataProcessTable processTable,
			StudyJacob jacob) {
		int tableCol = 15;
		int tableRow = 1;
		Dispatch table = jacob.insertTable(tableCol, tableRow);
		Dispatch borders = Dispatch.get(table, "Borders").toDispatch();
		Dispatch.put(borders, "InsideLineStyle", new Variant(1));
		//Dispatch.put(borders, "InsideLineWidth", new Variant(8));
		Dispatch.put(borders, "OutsideLineStyle", new Variant(1));
		
		jacob.setTableAlignCenter();
		
		tableRow = addTableHeadingRows(jacob);
		ArrayList<Integer> colsNotToMerge = new ArrayList<Integer>();
		colsNotToMerge.add(4);
		colsNotToMerge.add(5);
		colsNotToMerge.add(6);
		
		int cellRowIdx = tableRow, cellColIdx = 1;
		SimpleDateFormat dateFormat =  new SimpleDateFormat("MM月dd号");
		Set<TestDataProcessGroup> groupSet = processTable.getTestDataProcessGroups();
		Iterator<TestDataProcessGroup> groupIt = groupSet.iterator();
		while (groupIt.hasNext()) {
			TestDataProcessGroup group = groupIt.next();
			jacob.putTxtToCell(cellRowIdx, 1, dateFormat.format(group.getTestDataTime()));
			jacob.putTxtToCell(cellRowIdx, 2, group.getTestWorkshopJob());
			HarmfulSubstanceNationalStandardTable substance = group.getHarmfulSubstanceNationalStandardTable();
			jacob.putTxtToCell(cellRowIdx, 3, substance.getSubstanceChineseName() + getDetailedName(group, substance));
			jacob.putTxtToCell(cellRowIdx, 7, new ValueAndScale(group.getMac(), group.getMacScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 8, new ValueAndScale(group.getCtwa(), group.getCtwaScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 9, new ValueAndScale(group.getCstel(), group.getCstelScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 10, new ValueAndScale(group.getOm(), group.getOmScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 11, new ValueAndScale(substance.getMac(), substance.getMacScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 12, new ValueAndScale(substance.getPcTwa(), substance.getPcTwaScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 13, new ValueAndScale(substance.getPcStel(), substance.getPcStelScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 14, new ValueAndScale(substance.getOm(), substance.getOmScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 15, group.getTestResult().toString());
			int mergeRowBegin = cellRowIdx;
			Set<TestDataProcessItem> itemSet = group.getTestDataProcessItems();
			Iterator<TestDataProcessItem> itemIt = itemSet.iterator();
			while (itemIt.hasNext()) {
				TestDataProcessItem item = itemIt.next();
				jacob.putTxtToCell(cellRowIdx, 4, item.getTestSampleNum());
				jacob.putTxtToCell(cellRowIdx, 5, new ValueAndScale(item.getTestResult(), item.getTestResultScale()).toString());
				jacob.putTxtToCell(cellRowIdx, 6, new ValueAndScale(item.getTestTouchTime(), item.getTestResultScale()).toString());
				if (itemIt.hasNext() || groupIt.hasNext())
					jacob.addRow();
				tableRow++;
				cellRowIdx++;
			}
			for (int row = mergeRowBegin + 1; row < cellRowIdx; row++) {
				for (int col = 1; col <= tableCol; col++) {
					if (colsNotToMerge.contains(col))
						continue;
					String mergeStr;
					try {
						mergeStr = jacob.getCellString(mergeRowBegin, col);

						if (jacob.isInOnePage(mergeRowBegin, col, row, col)) {
							jacob.deleteCellTxt(row, col);
							jacob.mergeCell(mergeRowBegin, col, row, col);
						} else {
							jacob.putTxtToCell(row, col, mergeStr);
							continue;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		tableRow--;
		
		colsNotToMerge.add(1);
		colsNotToMerge.add(7);
		colsNotToMerge.add(8);
		colsNotToMerge.add(9);
		colsNotToMerge.add(10);
		colsNotToMerge.add(11);
		colsNotToMerge.add(12);
		colsNotToMerge.add(13);
		colsNotToMerge.add(14);
		colsNotToMerge.add(15);
		String prevStr = "";
		int prevRowIdx = 1;
		for (cellColIdx = 1; cellColIdx <= tableCol; cellColIdx++) {
			if (colsNotToMerge.contains(cellColIdx))
				continue;
			//cellColIdx = 2;
			for (cellRowIdx = 1; cellRowIdx <= tableRow; cellRowIdx++) {
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
//		for (int col = 1; col <= tableCol; col++) {
//			jacob.deleteCell(tableRow+1, 1);
//		}
		jacob.moveDown(1);
	}

	private String getDetailedName(
			TestDataProcessGroup group, HarmfulSubstanceNationalStandardTable substance) {
		int substanceId = substance.getSubstanceId();
		if (substanceId == this.ParticlesNotOtherwiseRegulatedId) {
			return "（" + group.getSubstanceDetailedName() + "）";
		}
		for (int i = 0; i < this.PercentIdList.length; i++) {
			if (this.PercentIdList[i] == substanceId) {
				return "（" + group.getSubstanceDetailedName() + "%）";
			}
		}
		return "";
	}

	public ArrayList<HarmfulSubstanceNationalStandardTable> getHarmfulData1(int substanceIdBegin) throws Exception {
		StudyJacob jacob = new StudyJacob();
		jacob.openDocument("C:\\2.doc");

		ArrayList<HarmfulSubstanceNationalStandardTable> list = new ArrayList<HarmfulSubstanceNationalStandardTable>();
		int tableIndex = 1;
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

	public ArrayList<HarmfulSubstanceNationalStandardTable> getHarmfulData2(int substanceIdBegin) throws Exception {
		StudyJacob jacob = new StudyJacob();
		jacob.openDocument("C:\\2.doc");

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

	private boolean getValueAndScaleFromString(ValueAndScale vs, String s) {
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