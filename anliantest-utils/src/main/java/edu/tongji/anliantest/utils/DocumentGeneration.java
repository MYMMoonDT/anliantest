package edu.tongji.anliantest.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import edu.tongji.anliantest.model.HarmfulSubstanceNationalStandardTable;
import edu.tongji.anliantest.model.TestDataProcessGroup;
import edu.tongji.anliantest.model.TestDataProcessItem;
import edu.tongji.anliantest.model.TestDataProcessTable;

public class DocumentGeneration {

	public static void main(String[] args) {
		
	}
	
	public static void generateProcessTable(TestDataProcessTable processTable) {
		StudyJacob jacob = new StudyJacob();
		jacob.createNewDocument();
		jacob.insertText("Hello, World!");
		int tableCol = 15;
		int tableRow = 100;
		Dispatch table = jacob.insertTable(tableCol, tableRow);
		Dispatch borders = Dispatch.get(table, "Borders").toDispatch();
		Dispatch.put(borders, "InsideLineStyle", new Variant(1));
		//Dispatch.put(borders, "InsideLineWidth", new Variant(8));
		Dispatch.put(borders, "OutsideLineStyle", new Variant(1));
		int cellRowIdx = 1;
		Set<TestDataProcessGroup> groupSet = processTable.getTestDataProcessGroups();
		
		for (TestDataProcessGroup group : groupSet) {
			jacob.putTxtToCell(cellRowIdx, 1, group.getTestDataTime().toString());
			jacob.putTxtToCell(cellRowIdx, 2, group.getTestWorkshopJob());
			HarmfulSubstanceNationalStandardTable substance = group.getHarmfulSubstanceNationalStandardTable();
			jacob.putTxtToCell(cellRowIdx, 3, substance.getSubstanceChineseName());
			jacob.putTxtToCell(cellRowIdx, 7, new ValueAndScale(group.getMac(), group.getMacScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 8, new ValueAndScale(group.getCtwa(), group.getCtwaScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 9, new ValueAndScale(group.getCstel(), group.getCstelScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 10, new ValueAndScale(group.getOm(), group.getOmScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 11, new ValueAndScale(substance.getMac(), substance.getMacScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 12, new ValueAndScale(substance.getPcTwa(), substance.getPcTwaScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 13, new ValueAndScale(substance.getPcStel(), substance.getPcStelScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 14, new ValueAndScale(substance.getOm(), substance.getOmScale()).toString());
			jacob.putTxtToCell(cellRowIdx, 15, group.getTestResult().toString());
			
			Set<TestDataProcessItem> itemSet = group.getTestDataProcessItems();
			for (TestDataProcessItem item : itemSet) {
				jacob.putTxtToCell(cellRowIdx, 4, item.getTestSampleNum());
				jacob.putTxtToCell(cellRowIdx, 5, new ValueAndScale(item.getTestResult(), item.getTestResultScale()).toString());
				jacob.putTxtToCell(cellRowIdx, 6, new ValueAndScale(item.getTestTouchTime(), item.getTestResultScale()).toString());
				cellRowIdx++;
			}
		}
		
		
		
		jacob.save("C:\\ProcessTable.doc");
		jacob.closeDocument();
		jacob.close();
	}

	public static ArrayList<HarmfulSubstanceNationalStandardTable> getHarmfulData1(int substanceIdBegin) throws Exception {
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

	public static ArrayList<HarmfulSubstanceNationalStandardTable> getHarmfulData2(int substanceIdBegin) throws Exception {
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