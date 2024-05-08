package Utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import BaseEngine.baseEngine;




public class parameterizationExcel extends baseEngine{
	
	static Object[][] data=null;
	static String sheetName;
	
	@DataProvider(name="getData")
	public static Object[][] getData() throws EncryptedDocumentException, IOException{
		
		System.out.println("In Excel");		
//		System.out.println("Method Name:::"+m.getName());		
//		if(m.getName().equals("labelsFST")){
			sheetName="labelsFST";
			System.out.println("sheetName:::"+sheetName);
			int rows=excel.getRowCount(sheetName);
			System.out.println("Rows Count:::"+rows);
			int col=excel.getColumnCount(sheetName,rows);
			System.out.println("Col Count:::"+col);
			data= new Object[rows][col];			
			
				for(int rowNum=1;rowNum<=rows;rowNum++){
					for(int colNum=0;colNum<col;colNum++){
						System.out.println(sheetName+"<--->"+ rowNum +"<--->"+colNum);
						data[rowNum-1][colNum]=excel.getCellData(sheetName, rowNum, colNum);
						
					}
				}
//			}else{
//				System.out.println("No Excel Sheet");
//			}
		return data;
		}

	@DataProvider(name="borgata")
	public static Object[][] borgata(Method m) throws EncryptedDocumentException, IOException{
	
		
		System.out.println("In Excel");		
		System.out.println("Method Name:::"+m.getName());		
		if(m.getName().equals("borgataLive")){
			sheetName=m.getName();
			System.out.println("sheetName:::"+sheetName);
			int rows=excel.getRowCount(sheetName);
			System.out.println("Rows Count:::"+rows);
			int col=excel.getColumnCount(sheetName,rows);
			System.out.println("Col Count:::"+col);
			data= new Object[rows][col];			
			
				for(int rowNum=1;rowNum<=rows;rowNum++){
					for(int colNum=0;colNum<col;colNum++){
						System.out.println(sheetName+"<--->"+ rowNum +"<--->"+colNum);
						data[rowNum-1][colNum]=excel.getCellData(sheetName, rowNum, colNum);
						
					}
				}
			}else{
				System.out.println("No Excel Sheet");
			}
		return data;
		}
	
//@Test(dataProviderClass=parameterizationExcel.class,dataProvider="borgata");
//	
//	public static void borgataLive(String runMode,String username,String password,String URL){
////		data1.get("URL");
//		System.out.println(username+"<------->"+password+"<------->"+URL+" RunMode:::"+runMode);
//	}
}
