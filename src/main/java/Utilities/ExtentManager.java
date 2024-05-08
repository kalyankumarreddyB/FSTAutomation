package Utilities;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import BaseEngine.baseEngine;
import freemarker.template.SimpleDate;

public class ExtentManager extends baseEngine {


		
		public static ExtentSparkReporter  report;
		public static ExtentReports extent;
		public static ExtentTest test;
		public static String reportName;
		
		public static ExtentReports getInstance() {
			
			if(extent==null){
				
				
				Date d = new Date();
				SimpleDateFormat formatter=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateFormat=formatter.format(d).toString().replace(":", "_").replace(" ", "_");
				System.out.println("ReportName:::"+dateFormat);
				
				
				//report=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html");	
				
			//	report=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+"aFSTReport_"+dateFormat+".html");
				
				report=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\surefire-reports\\FST\\"+"FSTReport_"+dateFormat+".html");
				
				extent=new ExtentReports();
				
				extent.attachReporter(report);
				
				try {
					report.loadXMLConfig((new File(System.getProperty("user.dir")+"\\src\\main\\java\\executables\\ReportsConfig.xml")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			
			
			return extent;
			
		}
		

	
}
