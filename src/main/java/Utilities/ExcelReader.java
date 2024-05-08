package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import BaseEngine.baseEngine;


public class ExcelReader extends baseEngine {
	private String filePath;
	private FileInputStream fip;
	private static Workbook workbook;
	
	public ExcelReader(String filePath){
		this.filePath=filePath;
		try {
			fip=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fip);
		} catch (EncryptedDocumentException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public Sheet getSheet(String sheetName){
		Sheet sheet=null;
		sheet = workbook.getSheet(sheetName);
		return sheet;
	}
	
	public int getRowCount(String sheetName){		
		return getSheet(sheetName).getLastRowNum();
	}
	
	public int getColumnCount(String sheetName,int rowNum){
		return getSheet(sheetName).getRow(rowNum).getLastCellNum();
	}
	

	public  String getCellData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException{
		Cell cell=  getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		
		System.out.println("cellValue:::"+cell);		
		
		switch(cell.getCellType()){
		case STRING:
			cellValue=cell.getStringCellValue();
			break;
		case NUMERIC:
			cellValue=String.valueOf(cell.getNumericCellValue());
			break;
		
		default:
			break;
		}
		
		return cellValue;
	
	}
	
	
	
}
