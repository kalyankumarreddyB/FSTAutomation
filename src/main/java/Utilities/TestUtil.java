package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BaseEngine.baseEngine;

public class TestUtil extends baseEngine{

	public static String screenShotName;
	public static String path;

	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String dateFormat=d.toString().replace(":", "_").replace(" ", "_");
		System.out.println("Date:::"+d);
		screenShotName = dateFormat+".jpg";
		
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		path=userDir+"\\target\\surefire-reports\\FST\\"+screenShotName;
		
		FileUtils.copyFile(scrFile, new File(path));
		
		
//		 path = scrFile.getAbsolutePath();
//		FileUtils.copyFile(scrFile, new File(userDir+"\\target\\Reports\\"+screenShotName));
	//	path=userDir+"\\target\\surefire-reports\\html\\"+screenShotName;
		
		
		
		
//		return path;
	
	

		
	
	
	
	}
	
	
}
