package Utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import BaseEngine.baseEngine;

public class parameterizatedData extends baseEngine{

		static Object[][] data=null;
		static String sheetName;
		
//		@DataProvider(name="getData")
//		public static Object[][] getData(Method m) throws EncryptedDocumentException, IOException{
//		
//			
//			System.out.println("In Excel");		
//			System.out.println("Method Name:::"+m.getName());		
//			if(m.getName().equals("labelsFST")){
//				sheetName=m.getName();
//				System.out.println("sheetName:::"+sheetName);
//				int rows=excel.getRowCount(sheetName);
//				System.out.println("Rows Count:::"+rows);
//				int col=excel.getColumnCount(sheetName,rows);
//				System.out.println("Col Count:::"+col);
//				data= new Object[rows][col];			
//				
//					for(int rowNum=1;rowNum<=rows;rowNum++){
//						for(int colNum=0;colNum<col;colNum++){
//							System.out.println(sheetName+"<--->"+ rowNum +"<--->"+colNum);
//							data[rowNum-1][colNum]=excel.getCellData(sheetName, rowNum, colNum);
//							
//						}
//					}
//				}else{
//					System.out.println("No Excel Sheet");
//				}
//			return data;
//			}

		@DataProvider(name="borgata")
		public static Object[][] borgata(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("bingo.borgataonline")){
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
		
		
		@DataProvider(name="foxy")
		public static Object[][] foxy(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("foxyBingo")){
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
		
		@DataProvider(name="cheeky")
		public static Object[][] cheeky(Method m) throws EncryptedDocumentException, IOException{
		
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("cheekyBingo")){
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
		@DataProvider(name="coral")
		public static Object[][] coral(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("coralBingo")){
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
		
		@DataProvider(name="ladbrokes")
		public static Object[][] ladbrokes(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("ladbrokesBingo")){
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
		
		@DataProvider(name="gala")
		public static Object[][] gala(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("galaBingo")){
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
		
		@DataProvider(name="sbcom")
		public static Object[][] sbcom(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("sportingBetBingo")){
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
		
		@DataProvider(name="betboo")
		public static Object[][] betboo(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("betbooBingo")){
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
		
		@DataProvider(name="ds")
		public static Object[][] ds(Method m) throws EncryptedDocumentException, IOException{
		
			
			System.out.println("In Excel");		
			System.out.println("Method Name:::"+m.getName());		
			if(m.getName().equals("danskespilBingo")){
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
	
	}
	
	

