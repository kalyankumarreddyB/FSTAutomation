package BaseEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import listenerData.CustomListeners;

public class baseEngine {
	
	
	public static WebDriver driver=null;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public String pass;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static  ExtentReports rep=Utilities.ExtentManager.getInstance();
	public static String cellValue ;
	public static JavascriptExecutor executor=(JavascriptExecutor) driver;
	public static WebElement skip;
	public static Actions act;
	public static WebElement twoWinText;
	public static WebElement MultiWinText;
	protected static String balBeforeWagerCurrencyRemoval;
	protected static String balAfterWagerCurrencyRemoval;
	protected static double balanceAfterWagering;
	protected static double balanceBeforeWagering;
	protected static double wageredAmount;
	protected static double ticketPrice;
	protected static String exactBalAfterWager;
	protected static String exactBalBeforeWager;
	protected static String exactBalAfterWin;
	protected static String actualWager;
	protected static String wagerReplace;
	protected static double balanceAfterGameComplete;
	protected static String getWinnerTextWinners;
	protected static String purchaseText;
	public static List<WebElement> sizeOfContainer;
	public static int sizeofPrizes;
	public static List<WebElement> sizeOfFeature;
	public static String getFeatureText;
	public static WebElement featureText;
	public static ExtentTest test;
	public static Wait<WebDriver> wait;
	public static String URL;
	public static WebElement frames;
	public static List<WebElement> sizeOfPrizes;
	public static int potSize;
	public static String getPotText;
	public static SoftAssert sa=new SoftAssert();
	public static String userDir=System.getProperty("user.dir");
	public static FileInputStream fip;
	public static FileOutputStream fos;
	public static Workbook workbook=new XSSFWorkbook();
	public static WebElement ballType;
	public static String getBallType;
	public static ExcelReader excel=new ExcelReader(userDir+"\\src\\main\\java\\excel\\Datadriven.xlsx");
	public static Wait<WebDriver> waitForElementToLoad;
	public static int frameID=1;
	public static final String AUTOMATE_USERNAME = "bingo_teATMhmq2Gc";
	public static final String AUTOMATE_ACCESS_KEY = "NUPQHDi38Tx127JErqQc";
	public static final String URL2 = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	
	
	@BeforeSuite
	public static void setUp() throws IOException{
		
		
		System.out.println("Path of dir is :::"+userDir);
		
		if(driver==null){
			
			fis=new FileInputStream(userDir+"\\src\\main\\java\\properties\\Config.properties");
			config.load(fis);
			fis=new FileInputStream(userDir+"\\src\\main\\java\\properties\\OR.properties");
			OR.load(fis);
			log.debug("Prop file loaded");
					
		}
//		if(config.getProperty("chromeBrowser").equals("chrome")){
//			System.setProperty("webdriver.chrome.driver", userDir+"\\src\\main\\java\\drivers\\chromedriver.exe");
//			
//		}else if(config.getProperty("firefoxBrowser").equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", userDir+"\\src\\main\\java\\drivers\\geckodriver.exe");
//		}else if(config.getProperty("edgeBrowser").equals("edge")) {
//			System.setProperty("webdriver.edge.driver", userDir+"\\src\\main\\java\\drivers\\msedgedriver.exe");
//		}else {
//			System.out.println("Failed to launch browser");
//		}

	}
	
	public static void waitTime(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void waitingTime(){
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
	}
	
	
	

	
	
	@AfterSuite
	public void shutDown(){
		
		driver.quit();
	
	}
	
	@BeforeTest
	//@Parameters("browser")
	public void browserLaunch() throws MalformedURLException{
		
		
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : config.getProperty("browser");
		
		System.out.println("Browser-->"+browser);
		
		if(browser.equalsIgnoreCase("Chrome")){
	//	WebDriverManager.chromedriver().setup();
		
	//		WebDriverManager.chromedriver().clearDriverCache().setup();	
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver2.exe");
		
		ChromeOptions options = new ChromeOptions();
		 options.setExperimentalOption("useAutomationExtension", false);
		 options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation")); 
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 prefs.put("credentials_enable_service", false);
		 prefs.put("profile.password_manager_enabled", false);

		 options.setExperimentalOption("prefs", prefs);
		 driver=new ChromeDriver(options);
		}
		else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter available browser name for test execution");
			log.info("Please enter available browser name for test execution");
		}

		

		
//	    DesiredCapabilities caps = new DesiredCapabilities();
//	    HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
//	    networkLogsOptions.put("captureContent", true);
//	    caps.setCapability("os_version", "10");
//	    caps.setCapability("browserstack.geoLocation", "GB");
//	    caps.setCapability("browser", "Chrome");
//	    caps.setCapability("browser_version", "latest");
//	    caps.setCapability("os", "Windows");
//	    caps.setCapability("name", "Labels FST"); // test name
//	    caps.setCapability("browserstack.networkLogs", true);
//	    caps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
//	    caps.setCapability("browserstack.local", "true");
//	    driver = new RemoteWebDriver(new URL(URL2), caps);
		
		
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	
	public void closeBrowser() throws EncryptedDocumentException, IOException{

		driver.close();
	}

	

//	@AfterMethod
//	
//	public void status(ITestResult result) throws IOException {
//		System.out.println("Stauts of test is AfterMethod :::"+result.getStatus());
//		FileInputStream fis=new FileInputStream(userDir+"\\src\\main\\java\\excel\\Datadriven.xlsx");
//		XSSFWorkbook workbook=new XSSFWorkbook(fis);
//		
//		XSSFSheet  sheet=workbook.getSheet("labelsFST");
//		Font fontStyle=workbook.createFont();
//		int rowCount=excel.getRowCount("labelsFST");
//		CellStyle style=workbook.createCellStyle();
//		Row row;
//		Cell cell;
//		sheet.getRow(0).createCell(4).setCellValue("Status");
//		fontStyle.setBold(true);
////		cell.setCellStyle(style);
////		style.setFont(fontStyle);
//		style.setFillBackgroundColor(IndexedColors.GREY_50_PERCENT.getIndex());  
//		style.setFillPattern(FillPatternType.FINE_DOTS);
// 
//		for(int siteStatusCounter=1;siteStatusCounter<=rowCount;siteStatusCounter++) {
//		if(result.getStatus()==1 && (excel.getCellData("labelsFST", siteStatusCounter, 1).equalsIgnoreCase("Y"))) {
//			System.out.println("Row Count in base Class:::"+rowCount);
//			System.out.println("siteStatusCounter:::"+siteStatusCounter);
//			System.out.println("In excel row");
//			row=sheet.getRow(siteStatusCounter);
//			
////			if(row.createCell(4).getCellType() == null) {
//				style=workbook.createCellStyle();
//				style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());  
//				style.setFillPattern(FillPatternType.FINE_DOTS); 
//				cell=row.createCell(4);
//				cell.setCellValue("Pass");
//				fontStyle.setBold(true);
//				cell.setCellStyle(style);
//				style.setFont(fontStyle);
//				System.out.println("Updated the status in excel");
//				System.out.println("Status Pass");
////			}
//			
//			
//			
//		}else if(result.getStatus()==3 && (excel.getCellData("labelsFST", siteStatusCounter, 1).equalsIgnoreCase("N"))) {
//		
//			System.out.println("In excel row");
//			row=sheet.getRow(siteStatusCounter);
//			
////			if(row.createCell(4).getCellType() == null) {
//				style=workbook.createCellStyle();
//				style.setFillBackgroundColor(IndexedColors.DARK_YELLOW.getIndex());  
//				style.setFillPattern(FillPatternType.FINE_DOTS);
//				cell=row.createCell(4);
//				cell.setCellValue("Skip");
////				font.setBold(true);
//				cell.setCellStyle(style);
//				style.setFont(fontStyle);
//				System.out.println("Updated the status in excel");
//				System.out.println("Status Skip");
////			}
//			
//			
//			
//		}else if(result.getStatus()==2 && (excel.getCellData("labelsFST", siteStatusCounter, 1).equalsIgnoreCase("Y"))) {
//		
//			System.out.println("In excel row");
//			row=sheet.getRow(siteStatusCounter);
//			
////			if(row.createCell(4).getCellType() == null) {
//				style=workbook.createCellStyle();
//				style.setFillBackgroundColor(IndexedColors.RED .getIndex());  
//	            style.setFillPattern(FillPatternType.FINE_DOTS);
//				cell=row.createCell(4);
//				cell.setCellValue("Fail");
////				font.setBold(true);
//				cell.setCellStyle(style);
//				style.setFont(fontStyle);
//				System.out.println("Updated the status in excel");
//				System.out.println("Status Fail");
////			}
//			
//			
//		}
//		
//		else {
//			System.out.println("Failed to update the sheet");
//		}
//			
//		}
//			
//			try{
//				fos = new FileOutputStream(userDir+"\\src\\main\\java\\excel\\Datadriven.xlsx");
//				workbook.write(fos);
//				fos.close();
//				System.out.println("File closed");
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//			
//	}

}

