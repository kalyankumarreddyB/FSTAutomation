package reusables;


import java.io.IOException;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BaseEngine.baseEngine;
import Utilities.TestUtil;
import reusables.CommonActions;

public class Login extends baseEngine{
	
	public static CommonActions generalActions=new CommonActions();
	
	
public static boolean authentication(String URL,String username,String password) throws InterruptedException{
	
	boolean flag=true;
	
	String newPassword = "";
	 waitForElementToLoad=new FluentWait<WebDriver>(driver).
								 withTimeout(Duration.ofSeconds(300))
								.pollingEvery(Duration.ofSeconds(3)).
								ignoring(NoSuchElementException.class).
								ignoring(StaleElementReferenceException.class);
	
	
	//foxy, cheeky, betboo and sbcom login
	
	if(driver.getCurrentUrl().contains("foxy")
	|| driver.getCurrentUrl().contains("cheeky")
	|| driver.getCurrentUrl().contains("sportingbet") 
	|| driver.getCurrentUrl().contains("betboo"))
		
	{		
		WebElement loginButton=waitForElementToLoad.
							until(ExpectedConditions.visibilityOfElementLocated
							(By.xpath("//*[@class='navbar-wrapper-right ng-star-inserted']/vn-h-button[1]/vn-menu-item/a | //*[@class='navbar-wrapper-right']/vn-h-button[1]/vn-menu-item/a")));
			
		if(password.contains("123123.0")) {
			newPassword=	password.replace("123123.0", "123123");
			
			
		loginButton.click();//Clicked on login button
		Thread.sleep(1000);
		generalActions.waitForElementVisibility(By.xpath("//div[@id='username']/input"));
		driver.findElement(By.xpath("//div[@id='username']/input")).sendKeys(username);
		driver.findElement(By.xpath("//div[@id='password']/input")).sendKeys(newPassword);
		
		// Click on Cookies button
		
		WebElement cookieClose=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
										
		cookieClose.click();
										
		//test.info("Clicked on Cookies button");
		System.out.println("Clicked on Cookies button");
		
		
		
		//Thread.sleep(3000);
		
			
		
		}else {
			loginButton.click();//Clicked on login button
			Thread.sleep(1000);
			generalActions.waitForElementVisibility(By.xpath("//div[@id='username']/input"));
			driver.findElement(By.xpath("//div[@id='username']/input")).sendKeys(username);
			//System.out.println("New password-->"+newPassword);
			driver.findElement(By.xpath("//div[@id='password']/input")).sendKeys(password);
			//test.info("Credentials are provided");
			System.out.println("Credentials are provided");
			
			
			// Click on Cookies button
			
			WebElement cookieClose=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
								
			cookieClose.click();
								
			//test.info("Clicked on Cookies button");
			System.out.println("Clicked on Cookies button");
			
			
			//Thread.sleep(3000);
			
			
		}
		
		
		generalActions.waitForElementVisibility(By.xpath("//*[@id='login']/form/fieldset/section/div/button"));
		driver.findElement(By.xpath("//*[@id='login']/form/fieldset/section/div/button")).click();
		
		//Thread.sleep(10000);
		
		try {
			generalActions.waitForLoginErrorVisibility(By.xpath("//div[contains(@class,'theme-error-i ')]/div"));
			String loginError=driver.findElement(By.xpath("//div[contains(@class,'theme-error-i ')]/div")).getText();
			
			flag=false;
			
			System.err.println("Login Error::"+loginError);		
			
		}catch(Exception exp){
		
		WebElement waitForDepositButton=waitForElementToLoad.
												until(ExpectedConditions.visibilityOfElementLocated
												(By.xpath("//vn-h-deposit-button/vn-menu-item/a")));
		
		//test.info("Logged into portal");
		
		System.out.println("Logged into portal");
		
		test.log(Status.PASS, "Logged into the Portal Successfully");

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
		}
		
// Commented on Dec 20th, 23		
		
/*		
		
		WebElement cookieClose=waitForElementToLoad.
				until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='onetrust-button-group']/button[2]")));
		
		cookieClose.click();
		
*/
		
		//Ladbrokes, Coral and Gala Login
	}else if(driver.getCurrentUrl().contains("ladbrokes")
			|| driver.getCurrentUrl().contains("coral")
			|| driver.getCurrentUrl().contains("gala")
			|| driver.getCurrentUrl().contains("borgataonline"))
	
	{
		WebElement loginButton=waitForElementToLoad.until
										(ExpectedConditions.visibilityOfElementLocated
										(By.xpath("//*[@class='navbar-wrapper-right ng-star-inserted']/vn-h-button[2]/vn-menu-item/a | //*[@class='navbar-wrapper-right']/vn-h-button[2]/vn-menu-item/a")));
// new code		
		if(password.contains("123123.0")) {
			newPassword=	password.replace("123123.0", "123123");
		}
		
		
			
		
		loginButton.click();//Clicked on login button
		Thread.sleep(2000);
		generalActions.waitForElementVisibility(By.xpath("//div[@id='username']/input"));
		driver.findElement(By.xpath("//div[@id='username']/input")).sendKeys(username);
		driver.findElement(By.xpath("//div[@id='password']/input")).sendKeys(password);
		
	
		// Click on Cookies button
		
		WebElement cookieClose=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
		
		cookieClose.click();
		
		//test.info("Clicked on Cookies button");
		System.out.println("Clicked on Cookies button");
	
		//Thread.sleep(3000);
		generalActions.waitForElementVisibility(By.xpath("//*[@id='login']/form/fieldset/section/div/button"));
		driver.findElement(By.xpath("//*[@id='login']/form/fieldset/section/div/button")).click();
		//test.info("Clicked on login");
		System.out.println("Clicked on login button");
		//Thread.sleep(10000);
		
		try {
			generalActions.waitForLoginErrorVisibility(By.xpath("//div[contains(@class,'theme-error-i ')]/div"));
			String loginError=driver.findElement(By.xpath("//div[contains(@class,'theme-error-i ')]/div")).getText();
			
			flag=false;
			
			System.err.println("Login Error::"+loginError);	
			
			Thread.sleep(120000);
			
		}
		
		catch (Exception exp) {
			
			WebElement waitForDepositButton=waitForElementToLoad.
					until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//vn-h-deposit-button/vn-menu-item/a")));
			//test.info("Logged into portal");
			test.log(Status.PASS, "Logged into the Portal Successfully");
			
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
		}
		
		
//		waitTime();
	


//		Commented on Dec 20th, 23		
		
/*     
		WebElement cookieClose=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='onetrust-button-group']/button[2]")));
		
		WebElement cookieClose=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
		
		cookieClose.click();
*/		
		
	}else if(driver.getCurrentUrl().contains("danskespil")) 
	
	{
		WebElement waitForLoginButton=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ensButtons']/button[3]")));
		
		//DS Login
//		driver.findElement(By.xpath("//*[@class='ensButtons']/button[3]")).click();//Cookies Accepting
		
		driver.findElement(By.xpath("//div[@class='ensButtons']//button[@id='ensSaveAll']")).click();//Cookies Accepting	
		//test.info("Cookie message accepted");
		System.out.println("Cookie message accepted");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='accountmenu']/a[4]")).click();//Clicked on login
		//test.info("Clicked on login");
		System.out.println("Clicked on login");
		//driver.findElement(By.xpath("(//a[@class='button button--full-width button--secondary button--is-desktop'])[1]")).click();
		//driver.findElement(By.xpath("//div[@class='container--small']/section/div[3]/a")).click();//Clicked on login in nemid screen 
		//System.out.println("Navigating to nemid screen");
		
		
		waitTime();
		System.out.println("In Login window");
		generalActions.waitForLoginErrorVisibility(By.xpath("//*[@class='input-field ']/input[@id='Username']"));
		driver.findElement(By.xpath("//*[@class='input-field ']/input[@id='Username']")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@class='input-field ']/input[@id='Password']")).sendKeys(password);
		//Thread.sleep(3000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='spacing-top']/button"));
		driver.findElement(By.xpath("//*[@class='spacing-top']/button")).click();
		
		//test.info("Credentials provided");
		System.out.println("Credentials provided");
		
		Thread.sleep(10000);
		WebElement waitForDepositButton=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='accountmenu']/a[2]")));
		//test.info("Logged into portal");
		System.out.println("Logged into portal");
		
		test.log(Status.PASS, "Logged into the Portal Successfully");

		Thread.sleep(1000);
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
	}
	else{
		
		flag=false;
		System.err.println("Failed to Login due to incorrect Label URL");
		//test.info("Failed to login");
	}
	
	return flag;	

	}


}
