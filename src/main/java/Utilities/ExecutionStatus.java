package Utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import BaseEngine.baseEngine;

public class ExecutionStatus extends baseEngine{
	
//	public static String suiteRunMode;
	
	public static void isSuiteExecutable(String suiteName,String suiteRunMode) throws EncryptedDocumentException, IOException {
		
		ExcelReader excel=new ExcelReader("C:\\Users\\aditya.chavali\\OneDrive - Entain Group\\Desktop\\Auto\\FSTUpdated\\FSTUpdated\\src\\main\\java\\excel\\Datadriven.xlsx");
		
		String sheetName="TestSuite";
		int row=excel.getRowCount(sheetName);
		
		for(int rowNum=1;rowNum<=row;rowNum++) {
			String testSuiteName=excel.getCellData(sheetName, rowNum	, 0);
			if(testSuiteName.equalsIgnoreCase("suiteName")) {
				
				 suiteRunMode=excel.getCellData(sheetName, rowNum, 1);
				 
				 if(suiteRunMode.equalsIgnoreCase("Y")) {
					 
				 }
				
				
			}
		}
	}

}
