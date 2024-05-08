package reusables;

import java.io.IOException;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BaseEngine.baseEngine;
import Utilities.*;

public class TicketPurchase extends baseEngine{
	public static CommonActions generalActions=new CommonActions();
	
	
	
	public static void validateTktPurcahseMsg()
	{
		
		if(!driver.getCurrentUrl().contains("danskespil"))
		{
			driver.switchTo().defaultContent();
		}
		else
		{
			driver.switchTo().parentFrame();	
		}
		
		try {
		
		generalActions.waitForElementVisibility(By.xpath("//div[@class='toast-message-wrapper']/div/div/div[contains(@class,'Features-toaster')]"));
		String text=driver.findElement(By.xpath("//div[@class='toast-message-wrapper']/div/div/div[contains(@class,'Features-toaster')]")).getText();
		
		System.out.println("Ticket Purchase message---->"+text);
		
		
		if(text.toUpperCase().trim().contains("PURCHASED") ||
			text.toLowerCase().trim().contains("compradas") ||
			text.toLowerCase().trim().contains("købt"))
		{
			
			test.log(Status.PASS, "Tickets Purchased Successfully!!");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			System.out.println("tickets purchased");
		}
		else
		{
			test.log(Status.FAIL, "Tickets Purchase is Failed!!");
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			Assert.assertTrue(false);
		}

		}catch(Exception exp)
		{
			test.log(Status.FAIL, "Wagering is Failed!!");
			System.err.println("Wagering is Failed!!");
			Assert.assertTrue(false);
		}
		
	}
	
	

	public static void ticketPurchase() throws InterruptedException, IOException{
		Thread.sleep(2000);
		
		
		if(!driver.getCurrentUrl().contains("danskespil") ){
//			System.out.println("Frame ID :::"+OR.getProperty("gameiFrameID"));
			driver.switchTo().frame(frameID);
			System.out.println("In Frames");
			Thread.sleep(1000);
			

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else if(driver.getCurrentUrl().contains("danskespil")) {
			driver.switchTo().frame(frameID);
			System.out.println("In Frames");
			Thread.sleep(1000);

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Failed to switch the frame for ticket purchase");
		}


		Wait<WebDriver> waitForTimer=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement timer=waitForTimer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='timer']/div[3]/span")));
		
		if(timer.getText().contains("00m:3")|| timer.getText().contains("00m:2")||timer.getText().contains("00m:1")||timer.getText().contains("00m:0")){
			System.out.println("Wait for 50 seconds");
			
			Thread.sleep(50000);
			test.info("Waiting for next round to start");
			System.out.println("Wait over....");
			
			driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
			Thread.sleep(2000);
			for(int ticket=1;ticket<=1;ticket++){
				
				driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
				Thread.sleep(2000);
				
				}
			driver.findElement(By.xpath("//*[@class='footer-right']/span/button[2]")).click(); // click on buy ticket
				test.info("Selecting the tickets");
				System.out.println("tickets selected");
				try {
				TestUtil.captureScreenshot();
				} catch (IOException e) {

				e.printStackTrace();
				}
				System.out.println("Confirm Purchase popup!!!");
				driver.findElement(By.xpath("//mat-dialog-actions[@class='mat-dialog-actions']/button[2]")).click();// Buy in confirm popup
				// driver.findElement(By.xpath("//*[@class='purchase-btn']")).click();
				test.info("Confirm Purchase popup!!!");
				// driver.findElement(By.xpath("//*[@class='btn btn-confirm']")).click();
				System.out.println("Purchased");
				Thread.sleep(1000);
		
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.info("Tickets purchased!!!");
//				Reporter.log("Tickets purchased");
				System.out.println("tickets purchased");

		}else if(driver.findElement(By.xpath("//*[@class='timer']/div[2]/span")).isDisplayed()) {
			
			
			System.out.println("Entered into 2nd conditon");
			
			
			
			
			WebElement timer2=waitForTimer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='timer']/div[3]/span")));
			
			
			Thread.sleep(2000);
			
			/*
			
			if(driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
				Thread.sleep(1000);
			}else {
				for(int ticket=1;ticket<=1;ticket++){
					
					driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
					Thread.sleep(2000);
				
					
					}
			}
			*/
			
			
			try {
				if(driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).isDisplayed()) {
					driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
					Thread.sleep(1000);
				}
				
			} catch (Exception exp) {
				
				
				
				System.out.println("By default Buy panel is opened for the next round");
				
				test.info("By default Buy panel is opened for the next round\"");
				
				
			}
			
			
			
			for(int ticket=1;ticket<=1;ticket++){
				
				driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
				Thread.sleep(2000);
			
				
				}
			driver.findElement(By.xpath("//*[@class='footer-right']/span/button[2]")).click(); // click on buy ticket
				test.info("Selecting the tickets");
				System.out.println("tickets selected");
				try {
				TestUtil.captureScreenshot();
				} catch (IOException e) {

				e.printStackTrace();
				}
				System.out.println("Confirm Purchase popup!!!");
				driver.findElement(By.xpath("//mat-dialog-actions[@class='mat-dialog-actions']/button[2]")).click();// Buy in confirm popup
			
				test.info("Confirm Purchase popup!!!");

				System.out.println("Purchased");
				Thread.sleep(1000);
			

				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.info("Tickets purchased!!!");
				Reporter.log("Tickets purchased");
				System.out.println("tickets purchased");
			
		}
		
		else {
			
			
			
			
			Thread.sleep(2000);
			
			

			
			
			System.out.println("Entered into 3rd conditon");
			
			driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
			Thread.sleep(1000);
			test.info("Clicked on buy panel");
			
			
			for(int ticket=1;ticket<=1;ticket++){
				
				driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
				Thread.sleep(1000);
				test.info("Ticket incrementor");
				// driver.findElement(By.cssSelector("div.incremental-purchse > span.up > span")).click();
				}
			driver.findElement(By.xpath("//*[@class='footer-right']/span/button[2]")).click(); // click on buy ticket
				test.info("Selecting the tickets");
				System.out.println("tickets selected");
				try {
				TestUtil.captureScreenshot();
				} catch (IOException e) {

				e.printStackTrace();
				}
				System.out.println("Confirm Purchase popup!!!");
				driver.findElement(By.xpath("//mat-dialog-actions[@class='mat-dialog-actions']/button[2]")).click();// Buy in confirm popup
			
				test.info("Confirm Purchase popup!!!");
			
				System.out.println("Purchased");
				Thread.sleep(2000);


				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.info("Tickets purchased!!!");
				Reporter.log("Tickets purchased");
				System.out.println("tickets purchased");

		}

	}
	
	public static void ticketPurchaseFST() throws InterruptedException, IOException{
		Thread.sleep(1000);
		
		
		if(!driver.getCurrentUrl().contains("danskespil") ){
//			System.out.println("Frame ID :::"+OR.getProperty("gameiFrameID"));
			driver.switchTo().frame(frameID);
			System.out.println("In Frames");
			Thread.sleep(1000);
			

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else if(driver.getCurrentUrl().contains("danskespil")) {
			driver.switchTo().frame(frameID);
			System.out.println("DS: Entered into FrameID-1");
			Thread.sleep(1000);

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Failed to switch the frame for ticket purchase");
		}


		Wait<WebDriver> waitForTimer=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(360))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		WebElement timer=waitForTimer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='timer']/div[3]/span")));
		
		if(timer.getText().contains("00m:0")){
			System.out.println("Wait for 30 seconds");
			System.out.println("Waiting for next round to start");
			Thread.sleep(30000);
			
			System.out.println("Wait over....");
			
			generalActions.waitForTicketPriceVisibility(By.xpath("//div[@id='footer']/span/button[2]"));
			
			driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
			Thread.sleep(2000);
			
			//Getting Ticket price
			try {
					
			generalActions.waitForTicketPriceVisibility(By.xpath(OR.getProperty("getTicketPrice")));
			
			Thread.sleep(1000);
			
			BalanceVerification.getTicketPrice(driver.findElement(By.xpath(OR.getProperty("getTicketPrice"))).getText());
			
			}catch(Exception exp)
			{
				System.err.println("Ticket Price fetching is failed");
				exp.printStackTrace();
			}
			
			for(int ticket=1;ticket<=1;ticket++){
				
				driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
				Thread.sleep(2000);
				
				}
			driver.findElement(By.xpath("//*[@class='footer-right']/span/button[2]")).click(); // click on buy ticket
				//test.info("Selecting the tickets");
				System.out.println("tickets selected");
				try {
				TestUtil.captureScreenshot();
				} catch (IOException e) {

				e.printStackTrace();
				}
				System.out.println("Confirm Purchase popup!!!");
				driver.findElement(By.xpath("//mat-dialog-actions[@class='mat-dialog-actions']/button[2]")).click();// Buy in confirm popup
				// driver.findElement(By.xpath("//*[@class='purchase-btn']")).click();
				//test.info("Confirm Purchase popup!!!");
				//System.out.println("Confirm Purchase popup!!!");
				// driver.findElement(By.xpath("//*[@class='btn btn-confirm']")).click();
				
				System.out.println("Purchased");
				
				Thread.sleep(1000);
		
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//test.info("Tickets purchased!!!");
				
				TicketPurchase.validateTktPurcahseMsg();

				//System.out.println("tickets purchased");

		}else if(driver.findElement(By.xpath("//*[@class='timer']/div[2]/span")).isDisplayed()) {
			
			
			System.out.println("Entered into 2nd conditon");
			
			
			
			
			WebElement timer2=waitForTimer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='timer']/div[3]/span")));
			
			
			Thread.sleep(2000);
			
			/*
			
			if(driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
				Thread.sleep(1000);
			}else {
				for(int ticket=1;ticket<=1;ticket++){
					
					driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
					Thread.sleep(2000);
				
					
					}
			}
			*/
			
			
			try {
				if(driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).isDisplayed()) {
					driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
					Thread.sleep(1000);
					
					//Getting Ticket price
					try {
					
					generalActions.waitForTicketPriceVisibility(By.xpath(OR.getProperty("getTicketPrice")));
					
					//Thread.sleep(1000);
					
					BalanceVerification.getTicketPrice(driver.findElement(By.xpath(OR.getProperty("getTicketPrice"))).getText());
					
					}catch(Exception exp)
					{
						System.err.println("Ticket Price fetching is failed");
						exp.printStackTrace();
					}
					
				}
				
			} catch (Exception exp) {
				
				
				
				System.out.println("By default Buy panel is opened for the next round");
				
				//Getting Ticket price
				try {
				
				generalActions.waitForTicketPriceVisibility(By.xpath(OR.getProperty("getTicketPrice")));
				
				//Thread.sleep(1000);
				
				BalanceVerification.getTicketPrice(driver.findElement(By.xpath(OR.getProperty("getTicketPrice"))).getText());
				
				}catch(Exception e)
				{
					System.err.println("Ticket Price fetching is failed");
					e.printStackTrace();
				}
				
				//test.info("By default Buy panel is opened for the next round\"");
				
				
			}
			
			
			
			for(int ticket=1;ticket<=1;ticket++){
				
				driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
				Thread.sleep(1000);
			
				
				}
			
			
			driver.findElement(By.xpath("//*[@class='footer-right']/span/button[2]")).click(); // click on buy ticket
				//test.info("Selecting the tickets");
				System.out.println("tickets selected");
				try {
				TestUtil.captureScreenshot();
				} catch (IOException e) {

				e.printStackTrace();
				}
	
				driver.findElement(By.xpath("//mat-dialog-actions[@class='mat-dialog-actions']/button[2]")).click();// Buy in confirm popup
			
				//test.info("Confirm Purchase popup!!!");
				
				System.out.println("Confirm Purchase popup!!!");

				System.out.println("Purchased");
				//Thread.sleep(1000);
			

				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//test.info("Tickets purchased!!!");
				//Reporter.log("Tickets purchased");
				
				TicketPurchase.validateTktPurcahseMsg();
				
				//System.out.println("tickets purchased");
			
		}
		
		else {
			
			
			Thread.sleep(2000);
			
			System.out.println("Entered into 3rd conditon");
			
			driver.findElement(By.xpath("//div[@id='footer']/span/button[2]")).click(); //open buy panel
			Thread.sleep(1000);
		//	test.info("Clicked on buy panel");
			System.out.println("Clicked on buy panel");
			
			
			
			//Getting Ticket price
			try {
						
			generalActions.waitForTicketPriceVisibility(By.xpath(OR.getProperty("getTicketPrice")));
			
			//Thread.sleep(1000);
			
			BalanceVerification.getTicketPrice(driver.findElement(By.xpath(OR.getProperty("getTicketPrice"))).getText());
			
			}catch(Exception exp)
			{
				System.err.println("Ticket Price fetching is failed");
				exp.printStackTrace();
			}
			
			for(int ticket=1;ticket<=1;ticket++){
				
				driver.findElement(By.xpath("//span[@class='up']")).click(); // tickets incrementor
				Thread.sleep(1000);
				//test.info("Ticket incrementor");
				System.out.println("Ticket incrementor");
				
				// driver.findElement(By.cssSelector("div.incremental-purchse > span.up > span")).click();
				}
			driver.findElement(By.xpath("//*[@class='footer-right']/span/button[2]")).click(); // click on buy ticket
				//test.info("Selecting the tickets");
				System.out.println("tickets selected");
				try {
				TestUtil.captureScreenshot();
				} catch (IOException e) {

				e.printStackTrace();
				}
				System.out.println("Confirm Purchase popup!!!");
				driver.findElement(By.xpath("//mat-dialog-actions[@class='mat-dialog-actions']/button[2]")).click();// Buy in confirm popup
			
				//test.info("Confirm Purchase popup!!!");
			
				System.out.println("Purchased");
				Thread.sleep(2000);


				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//test.info("Tickets purchased!!!");
				//Reporter.log("Tickets purchased");
				
				TicketPurchase.validateTktPurcahseMsg();
				
				//System.out.println("tickets purchased");

		}

	}
	
	

}
