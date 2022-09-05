package com.alok.aut.project.Util;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;


public class ExcelUtil {

	private static XSSFSheet ExcelSheet;    
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static String Path;

	public static void setExcelFile(String filePath,String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){
			throw (e);
		}
	}

	public static int getRowCount(){
		return ExcelSheet.getPhysicalNumberOfRows();
	}

	public static int getColumnCount(){
		return ExcelSheet.getRow(0).getPhysicalNumberOfCells();
	}

	public static String getCellData(int row, int col) throws Exception{
		String CellData=null;
		try{
			Cell = ExcelSheet.getRow(row).getCell(col);			
			if (Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING)
				CellData=Cell.getStringCellValue();			
			if(Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC)
				CellData=String.valueOf((int)Cell.getNumericCellValue());			
		}catch (Exception e){
			Log.error ("Exception occured while retrieving CellData in utilityScripts.ExcelUtil.getCellData");
		}

		return CellData;
	}

	public static String[] getRowData(int row){

		int noOfCells=ExcelSheet.getRow(row).getPhysicalNumberOfCells();
		String[] rowData=new String[noOfCells];
		for (int i=0;i<=noOfCells-1;i++){
			Cell = ExcelSheet.getRow(row).getCell(i);
			if (Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING)
				rowData[i]=Cell.getStringCellValue();			
			if(Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC)
				rowData[i]=String.valueOf((int)Cell.getNumericCellValue());		
		}		
		return rowData;		
	}

}
