package reusables;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import BaseEngine.baseEngine;

public class Logout extends baseEngine{
	
	public static CommonActions generalActions=new  CommonActions();

	public static void logout(String URL) throws InterruptedException{
	
		//ca.checkPageIsReady();
		
	if(!driver.getCurrentUrl().contains("danskespil")) 
	{
		
		if(driver.getCurrentUrl().contains("sportingbet") ||driver.getCurrentUrl().contains("betboo") ) 
		{
			generalActions.checkPageIsReady();	
			//Thread.sleep(10000);
			
			
			generalActions.waitForElementVisibility(By.xpath("//div[@class='user-container']/div"));	
			WebElement profile = driver.findElement(By.xpath("//div[@class='user-container']/div"));
			
			profile.click();
			
				
			Thread.sleep(2000);
			
			generalActions.waitForElementVisibility(By.xpath("//vn-am-logout/descendant::a"));
			WebElement logout=driver.findElement(By.xpath("//vn-am-logout/descendant::a"));
			
			logout.click();
			
			//test.info("Logout from the site:::"+URL);
			System.out.println("Logout from the site:::"+URL);
			test.log(Status.PASS, "Logout from the site:::"+URL);
			
			Thread.sleep(2000);
		}	
		
		else
		{
			generalActions.checkPageIsReady();	
			
			//Thread.sleep(10000);
			
			
			generalActions.waitForElementVisibility(By.xpath("//div[@class='user-container']/div"));
			WebElement profile = driver.findElement(By.xpath("//div[@class='user-container']/div"));
			
			profile.click();
			
				
			Thread.sleep(2000);
			
		/*	generalActions.waitForElementVisibility(By.cssSelector(".menu-item-txt.logout-txt.ng-star-inserted"));
			WebElement logout=driver.findElement(By.cssSelector(".menu-item-txt.logout-txt.ng-star-inserted")); */
			
			
			
			generalActions.waitForElementVisibility(By.xpath("//span[text()='Log Out']"));	
			WebElement logout=driver.findElement(By.xpath("//span[text()='Log Out']"));
			
			
		/*	executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", logout);	
			
			generalActions.waitForElementToBeClickable(By.cssSelector("//div[contains(@class,'m-menu-items')]//vn-menu-item[@linkclass='am-logout']/a"));
			WebElement logout=driver.findElement(By.cssSelector("//div[contains(@class,'m-menu-items')]//vn-menu-item[@linkclass='am-logout']/a"));*/
			
			logout.click();
			
			//test.info("Logout from the site:::"+URL);
			System.out.println("Logout from the site:::"+URL);
			test.log(Status.PASS, "Logout from the site:::"+URL);
			
			Thread.sleep(2000);
		}	
		
	}
	
	else 
	{
			
			generalActions.checkPageIsReady();
		
			
			generalActions.waitForElementVisibility(By.xpath("//*[@class='accountmenu']/a[2]"));
			WebElement dsProfile=driver.findElement(By.xpath("//*[@class='accountmenu']/a[2]"));
			dsProfile.click();
			
			Thread.sleep(2000);
			
			generalActions.waitForElementVisibility(By.xpath("//*[@class='accountmenu']/div[2]/div/div[2]/div/a"));
			driver.findElement(By.xpath("//*[@class='accountmenu']/div[2]/div/div[2]/div/a")).click();
			
			//test.info("Logout from the site:::"+URL);
			System.out.println("Logout from the site:::"+URL);
			test.log(Status.PASS, "Logout from the site:::"+URL);
			
			
			Thread.sleep(2000);
	}
}
	
}
