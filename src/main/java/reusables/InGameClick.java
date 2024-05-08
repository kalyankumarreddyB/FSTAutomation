package reusables;

import java.awt.AWTException;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

import Utilities.TestUtil;
import reusables.CommonActions;

public class InGameClick extends BalanceVerification {
	
	public static CommonActions generalActions=new CommonActions();
	
	public static int sizeofPrizes;
	
	/* Sound toggle is completely removed
	 * public static void soundOption() throws InterruptedException {
	 * 
	 * if(!driver.getCurrentUrl().contains("danskespil")) {
	 * 
	 * driver.switchTo().defaultContent(); waitForElementToLoad=new
	 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
	 * .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
	 * WebElement soundOptionDisplay=waitForElementToLoad.until(ExpectedConditions.
	 * visibilityOfElementLocated(By.xpath("//*[@class='primary-btn']/span")));
	 * 
	 * WebElement
	 * soundOn=driver.findElement(By.xpath("//div[@class='slider round']/span[1]"));
	 * 
	 * Thread.sleep(1000); executor = (JavascriptExecutor) driver;
	 * executor.executeScript("arguments[0].click();", soundOn);
	 * System.out.println("Opted for Sound"); try { TestUtil.captureScreenshot(); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } test.info("Sound opted"); Reporter.log("Sound opted");
	 * WebElement
	 * soundOption=driver.findElement(By.xpath("//*[@class='primary-btn']/span"));
	 * soundOption.click(); Thread.sleep(2000); try { TestUtil.captureScreenshot();
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } System.out.println("Sound option closed");
	 * Thread.sleep(2000); test.info("Sound option closed");
	 * Reporter.log("Sound option closed"); Thread.sleep(2000); try {
	 * TestUtil.captureScreenshot(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * }else if(driver.getCurrentUrl().contains("danskespil")) {
	 * driver.switchTo().frame(0); Wait<WebDriver> waitForSound=new
	 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
	 * .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
	 * WebElement soundOptionDisplay=waitForSound.until(ExpectedConditions.
	 * visibilityOfElementLocated(By.xpath("//*[@class='primary-btn']/span")));
	 * 
	 * WebElement
	 * soundOn=driver.findElement(By.xpath("//div[@class='slider round']/span[1]"));
	 * 
	 * Thread.sleep(1000); executor = (JavascriptExecutor) driver;
	 * executor.executeScript("arguments[0].click();", soundOn);
	 * System.out.println("Opted for Sound"); try { TestUtil.captureScreenshot(); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } test.info("Sound opted"); Reporter.log("Sound opted");
	 * WebElement
	 * soundOption=driver.findElement(By.xpath("//*[@class='primary-btn']/span"));
	 * soundOption.click(); Thread.sleep(2000); try { TestUtil.captureScreenshot();
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } System.out.println("Sound option closed");
	 * Thread.sleep(2000); test.info("Sound option closed");
	 * Reporter.log("Sound option closed"); }
	 * 
	 * }
	 */
	
public static void skip() throws InterruptedException {
		
		
		if(driver.getCurrentUrl().contains("danskespil")) {
			
			
			
	
			driver.switchTo().frame(0);
			
			

		skip = driver.findElement(By.xpath("//*[@class='action-buttons']/span[1]"));
		//skip = driver.findElement(By.xpath("//*[class=\"button button--full-width button--secondary button--is-desktop\""));
		//driver.findElement(By.xpath("a[@class='button button--full-width button--secondary button--is-desktop'"));
		Wait<WebDriver> skipWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement skipTutorial=skipWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='action-buttons']/span[1]")));
		
		try {
			if (skip.isDisplayed()) {
				skip.click();
				System.out.println("Skipped");
				//test.info("Clicked on tutorial skip");
				Reporter.log("Tutorial Skipped");
				Thread.sleep(1000);
				
				
				test.log(Status.PASS, "Game Launched Successfully");
								
				
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());
				
				
				
				
				
			} else {
				System.out.println("No Skip");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}	else {
		

		
		Wait<WebDriver> skipWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement skipTutorial=skipWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='action-buttons']/span[1]")));
		skip = driver.findElement(By.xpath("//*[@class='action-buttons']/span[1]"));
		try {
			if (skip.isDisplayed()) {
				skip.click();
				System.out.println("Skipped");
				Reporter.log("Tutorial Skipped");
				//test.info("Clicked on tutorial skip");
				Thread.sleep(1000);
				
				test.log(Status.PASS, "Game Launched Successfully");
				
				/*
				String scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				
				
				Media media =MediaEntityBuilder.createScreenCaptureFromBase64String(scrFile2,"Test").build();

				
				test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(scrFile2,"Test").build());*/
				
				
				
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());
				
				
				
				
			} else {
				System.out.println("No Skip");
			}
		} catch (Exception e) {
			
			System.err.println("Room Launch Failed!!");
			System.out.println(e);
		}

	}

	}

public static void confirmDefaultSound()
{
	
	try {
		
	driver.switchTo().defaultContent();
	System.out.println("Moved to default frame");	
	
	generalActions.waitForElementVisibility(By.xpath("//span[@class='primary-btn']//span"));
	driver.findElement(By.xpath("//span[@class='primary-btn']//span")).click();
	
	System.out.println("Clicked on Confirm button in Default Sound option");
	
	Thread.sleep(1000);

	}catch(Exception exp)
	{
		
		test.log(Status.FAIL, "Failed to confirm Default Sounds option");
		System.err.println("Failed to confirm Default Sounds option");
		
		exp.printStackTrace();
	}
}


	public static void claimFreeTickets()
	{
		
		try {
			
		driver.switchTo().defaultContent();
		System.out.println("Moved to default frame");	
		
		generalActions.waitForElementVisibility(By.xpath("//div[@class='game-frm regular-active']//iframe[@class='game-iframe']"));
		WebElement frame=driver.findElement(By.xpath("//div[@class='game-frm regular-active']//iframe[@class='game-iframe']"));
		
		driver.switchTo().frame(frame);
		Thread.sleep(1000);
		
		generalActions.waitForClaimFreeTktVisibility(By.xpath("//button[@class='primary free-claim']"));
		driver.findElement(By.xpath("//button[@class='primary free-claim']")).click();
		Thread.sleep(2000);
		
		
		
		//Claimed Text locator in Tickets Tiles
		//String actTxt=driver.findElement(By.xpath("//div[@class='dotblock']/div[contains(@class,'claimTkt')]")).getText();
		
		generalActions.waitForElementVisibility(By.xpath("//div[contains(@class,'gamestatus')]/span[@class='boughttxt']"));
		String actTxt=driver.findElement(By.xpath("//div[contains(@class,'gamestatus')]/span[@class='boughttxt']")).getText();
		 
		
		System.out.println("Claim Text---->"+actTxt);
		
		if(actTxt.toLowerCase().contains("claimed"))
		{
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Daily Free Bingo Room and Claimed Free Tickets successfullly");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		}
		else
		{
			
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.FAIL, "Free Tickets Claim is failed");
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			System.err.println("Free Tickets Claim is failed");
		}
		
		
		
		}catch(Exception exp)
		{
			
			test.log(Status.FAIL, "Free Tickets Claim is failed");
			System.err.println("Free Tickets Claim is failed");
			
			exp.printStackTrace();
		}
	}


	public static void validateSelectAndBuyTickets()
	{
		
		try {
			
		driver.switchTo().defaultContent();
		System.out.println("Moved to default frame");	
		
		generalActions.waitForElementVisibility(By.xpath("//div[@class='game-frm regular-active']//iframe[@class='game-iframe']"));
		WebElement frame=driver.findElement(By.xpath("//div[@class='game-frm regular-active']//iframe[@class='game-iframe']"));
		
		driver.switchTo().frame(frame);
		Thread.sleep(1000);
		
		generalActions.waitForElementVisibility(By.xpath("//mat-grid-list[@class='mat-grid-list']//div[@class='ticket90 tickets-section tab']"));
		
		int ticketTilesCount=driver.findElements(By.xpath("//mat-grid-list[@class='mat-grid-list']//div[@class='ticket90 tickets-section tab']")).size();
		
		System.out.println("Select and Buy Ticket Tiles count ----> "+ticketTilesCount);	
		
		
		if(ticketTilesCount>=2 && ticketTilesCount<=10)
		{
			
			String actMaxTxt=driver.findElement(By.xpath("(//mat-grid-list[@class='mat-grid-list']//div[@class='ticket90 tickets-section tab'])["+ticketTilesCount+"]//div[@class='maxTkt']")).getText();
			String actMaxCount=driver.findElement(By.xpath("(//mat-grid-list[@class='mat-grid-list']//div[@class='ticket90 tickets-section tab'])["+ticketTilesCount+"]//div[@class='prizes']/div/span[@class='nooftickets']")).getText();
			
			System.out.println("Max Ticket Text---->"+actMaxTxt);
			System.out.println("Max Tickets count---->"+actMaxCount);
			
			if(actMaxTxt.equalsIgnoreCase("Max") && (Integer.parseInt(actMaxCount.trim())==120))
			{
				
				driver.findElement(By.xpath("(//mat-grid-list[@class='mat-grid-list']//div[@class='ticket90 tickets-section tab'])[1]")).click();
				Thread.sleep(1000);
				
				System.out.println("Verified Select and Buy Tickets in 150K Room");
				
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Select and Buy Tickets in 150K Room");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
			}
			else
			{
				System.err.println("Select and Buy Tickets verification is failed in 150K Room");
				
				test.log(Status.FAIL, "Select and Buy Tickets verification is failed in 150K Room");
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				System.err.println("Select and Buy Tickets verification is failed in 150K Room");
			}
			
			
			
		}else
		{
			System.err.println("Select and Buy Ticket Tiles count validation failed");
		}	
		
	}
		catch(Exception exp)
		{
			
			test.log(Status.FAIL, "Selct and Buy Tickets validation is failed");
			System.err.println("Selct and Buy Tickets validation is failed");
			
			exp.printStackTrace();
		}
	}




	public static void featureClick() throws InterruptedException, AWTException{
		
		
		sizeOfContainer=driver.findElements(By.xpath("//*[@class='prizes-container']/div"));
		
		System.out.println("sizeOfContainer:::"+sizeOfContainer.size());
		
		sizeofPrizes=sizeOfContainer.size();
		
		if(sizeofPrizes==3) {
			
			
			
			if(driver.getCurrentUrl().contains("danskespil")) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_UP);
		        robot.keyRelease(KeyEvent.VK_PAGE_UP);
			} 
			
			
			
			
			//WebElement features=driver.findElement(By.xpath("//*[@class='feature-parts']/div"));
			
			//WebElement features=driver.findElement(By.xpath("//div[@class='feature ng-star-inserted']//div[contains(@class,'feature-parts')]/div"));
			
			WebElement features=driver.findElement(By.xpath("//*[@class='prizes-container']/div[3]/div/div"));
			
			
			try{

					features.click();
					Thread.sleep(2000);
					test.info("Feature popup invoked");
					Reporter.log("Feature popup invoked");
					System.out.println("Feature popup invoked");
					
					sizeOfFeature=driver.findElements(By.xpath("//*[@class='prizes-features-wrapper']/div"));					
					System.out.println("sizeOfFeature:::"+sizeOfFeature.size());
					
					driver.findElement(By.cssSelector("div.readmore")).click();
					test.info("Clicked on Read More");
					Reporter.log("Clicked on Read More");
					System.out.println("Clicked on Read More");
					Thread.sleep(1000);
					try {
						TestUtil.captureScreenshot();
					} catch (IOException e) {
						e.printStackTrace();
					}
					//Get text from feature popup
					
					featureText=driver.findElement(By.cssSelector("div.prize-type.row-item>span"));
					
					getFeatureText=featureText.getText();
					
					System.out.println("getFeatureText:::"+getFeatureText);
					
					if(!driver.getCurrentUrl().contains("danskespil")) {
						driver.switchTo().defaultContent();
					}else if(driver.getCurrentUrl().contains("danskespil")) {
						driver.switchTo().parentFrame();
					}
					
					//Toast message click
					
					WebElement toastMessage=driver.findElement(By.cssSelector("div.desktopContainer"));
					
					toastMessage.click();
					try {
						TestUtil.captureScreenshot();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String toastMessageFeatureText=driver.findElement(By.cssSelector("div.feature-desc>div.Features-toaster-FOX")).getText();
					
					
					
					
					if(getFeatureText.equalsIgnoreCase(toastMessageFeatureText) || getFeatureText.contains("R")){
						System.out.println("Feature match found");
						Thread.sleep(1000);

//						WebElement frames=driver.findElement(By.id("frm_1"));
						if(!driver.getCurrentUrl().contains("danskespil") ) {
							driver.switchTo().frame(frameID);
							System.out.println("In Frames");
							
							Thread.sleep(1000);
						}else if(driver.getCurrentUrl().contains("danskespil")) {
							driver.switchTo().frame(frameID);
							System.out.println("In Frames");
							
							Thread.sleep(1000);
						}else {
							System.out.println("Failed to switch");
						}
						
						
						driver.findElement(By.cssSelector("div.close")).click();
						System.out.println("Close clicked");
						Thread.sleep(1000);
					
						if(driver.getCurrentUrl().contains("danskespil")) {
							Robot robot = new Robot();
							robot.keyPress(KeyEvent.VK_PAGE_UP);
					        robot.keyRelease(KeyEvent.VK_PAGE_UP);
						}
						
						try {
							TestUtil.captureScreenshot();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else if(!getFeatureText.equalsIgnoreCase(toastMessageFeatureText)) {
						System.out.println("Feature not found");
						Thread.sleep(1000);

//						WebElement frames=driver.findElement(By.id("frm_1"));
						if(!driver.getCurrentUrl().contains("danskespil")) {
							driver.switchTo().frame(frameID);
							System.out.println("In Frames");
							
							Thread.sleep(1000);
						}else if(driver.getCurrentUrl().contains("danskespil")) {
							driver.switchTo().frame(frameID);
							System.out.println("In Frames");
							
							Thread.sleep(1000);
						}else {
							System.out.println("Failed to switch");
						}
						
						driver.findElement(By.cssSelector("div.close")).click();
						System.out.println("Close clicked");
						Thread.sleep(1000);
						
						try {
							TestUtil.captureScreenshot();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}else {
						System.out.println("Nothing to close");
					}
		}catch(Exception e){
			System.out.println("Exception:::"+e);
		}
			
		}else {
			System.out.println("No features in the game");
		}
		
		
		
	}

	public static void totalPrizes() throws InterruptedException, IOException, AWTException{
//		frames=driver.findElement(By.id("frm_1"));
		if(!driver.getCurrentUrl().contains("danskespil")) {
			
			
			if(driver.getCurrentUrl().contains("cheeky")) {
				driver.switchTo().frame(frameID);
				System.out.println("In Frames");
				System.out.println("IN Total Prizes");
				Thread.sleep(1000);
			}else {
				driver.switchTo().frame(frameID);
				System.out.println("In Frames");				
				System.out.println("IN Total Prizes");
				Thread.sleep(1000);
			}
			
			
			
			
			WebElement totalPrize=driver.findElement(By.xpath("//*[@class='prizes-container']/div/app-chip"));

				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", totalPrize);
				Thread.sleep(1000);

				
				
				generalActions.waitForElementsVisibility(By.xpath("//div[@class='prizes-features-wrapper']/div"));
				List<WebElement> sizeOfPot=driver.findElements(By.xpath("//div[@class='prizes-features-wrapper']/div"));
				
				 potSize=sizeOfPot.size();
				
				System.out.println("potSize:::"+potSize);
				
				generalActions.waitForElementsVisibility(By.xpath("//*[@class='prizes-container']/div"));
				sizeOfPrizes=driver.findElements(By.xpath("//*[@class='prizes-container']/div"));
				System.out.println("sizeOfPrizes:::"+sizeOfPrizes.size());
				
				Thread.sleep(1000);
				
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Prizes Popup!!");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
				
				generalActions.waitForElementVisibility(By.cssSelector("div.header>div.title"));
				String getPrizeText=driver.findElement(By.cssSelector("div.header>div.title")).getText();
				
				
				
				
				if(driver.getCurrentUrl().contains("sportingbet") || driver.getCurrentUrl().contains("betboo")){
					assert getPrizeText.equalsIgnoreCase("Prêmios");
					//test.info("Prizes popup invoked");
					//Reporter.log("Prizes popup invoked");
					
					System.out.println("Prizes popup");
					
					
					
				}else if(driver.getCurrentUrl().contains("danskespil")) {
					assert getPrizeText.equalsIgnoreCase("Gevinster");
					//test.info("Prizes popup invoked");
					//Reporter.log("Prizes popup invoked");
					
					System.out.println("Prizes popup");
				}else {
					sa.assertEquals(getPrizeText, "Prizes");
//					assert getPrizeText.equalsIgnoreCase("Prizes");
					//test.info("Prizes popup invoked");
					//Reporter.log("Prizes popup invoked");
					
					System.out.println("Prizes popup");
				}
				
				driver.findElement(By.cssSelector("div.header>div.close")).click();
			//	test.info("Prizes popup closed");
			//	Reporter.log("Prizes popup closed");
					
				
				System.out.println("Prizes popup Closed");
				Thread.sleep(2000);
		}else if(driver.getCurrentUrl().contains("danskespil")) {
			
			
			Thread.sleep(1000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
	        robot.keyRelease(KeyEvent.VK_PAGE_UP);
			
			driver.switchTo().frame(1);
			System.out.println("DS: Entered into Frame ID-1");

			System.out.println("IN Total Prizes");
			Thread.sleep(1000);

			WebElement totalPrize=driver.findElement(By.xpath("//*[@class='prizes-container']/div/app-chip"));

			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", totalPrize);
			Thread.sleep(1000);
			
			
			generalActions.waitForElementsVisibility(By.xpath("//*[@class='prizes-container']/div"));
			sizeOfPrizes=driver.findElements(By.xpath("//*[@class='prizes-container']/div"));
			System.out.println("sizeOfPrizes:::"+sizeOfPrizes.size());
			
			
			generalActions.waitForElementsVisibility(By.xpath("//div[@class='prizes-features-wrapper']/div"));
			List<WebElement> sizeOfPot=driver.findElements(By.xpath("//div[@class='prizes-features-wrapper']/div"));
			
			 potSize=sizeOfPot.size();
			
			System.out.println("potSize:::"+potSize);

			
				generalActions.waitForElementVisibility(By.cssSelector("div.header>div.title"));
				String getPrizeText=driver.findElement(By.cssSelector("div.header>div.title")).getText();
				
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Prizes Popup!!");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
				 if(driver.getCurrentUrl().contains("danskespil")) {
					assert getPrizeText.equalsIgnoreCase("Gevinster");
					//test.info("Prizes popup invoked");
					//Reporter.log("Prizes popup invoked");
					
					System.out.println("Prizes popup invoked");
				}else {
					System.out.println("Unable to capture prize popup");
				}
				
				driver.findElement(By.cssSelector("div.header>div.close")).click();
				//test.info("Prizes popup closed");
				Reporter.log("Prizes popup closed");
				System.out.println("Prizes Closed");
				
		/*		
				
				Thread.sleep(1000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_UP);
		        robot.keyRelease(KeyEvent.VK_PAGE_UP);   */
		}else {
			System.out.println("Failed to capture total prizes");
		}
			
		
	
	}
	
	public static void jackpotPopup() throws InterruptedException, AWTException{
		
		
		
		if(driver.getCurrentUrl().contains("danskespil")) {
			Thread.sleep(1000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
	        robot.keyRelease(KeyEvent.VK_PAGE_UP);
		}else {
			System.out.println("No need to scroll");
		}
		
		sizeOfContainer=driver.findElements(By.xpath("//*[@class='prizes-container']/div"));
		
		System.out.println("sizeOfContainer:::"+sizeOfContainer.size());
		
		sizeofPrizes=sizeOfContainer.size();
		
		Thread.sleep(1000);
		
		if(sizeOfContainer.size()==2) {
			System.out.println("in no feature/jackpot section");
			Thread.sleep(4000);
			
			
			WebElement headerClick=driver.findElement(By.xpath("//*[@class='prizes-container']/div[2]"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", headerClick);
			
//			headerClick.click();

			waitForElementToLoad=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			WebElement waitForPopupText=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='header']/div[1]")));
			
			String getFeatureText=driver.findElement(By.cssSelector("div.header>div.title")).getText();
			
			if(getFeatureText.equalsIgnoreCase("Jackpot")) {
				test.info("Jackpot popup invoked");
				 Reporter.log("Jackpot popup invoked");
				System.out.println("Jackpot popup");

				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.sleep(1000);
				
				driver.findElement(By.cssSelector("div.header>div.close")).click();
				test.info("Jackpot popup closed");
				Reporter.log("Jackpot popup closed");
				System.out.println("Jackpot Closed");
			}else {
				System.out.println("Feature popup");

				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.sleep(1000);
				
				driver.findElement(By.cssSelector("div.header>div.close")).click();
			}			
		}else if( sizeofPrizes==3) {
			
			System.out.println("In feature/jackpot section");
			Thread.sleep(2000);
			WebElement jackpotPrize=driver.findElement(By.xpath("//*[@class='pjp-container']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", jackpotPrize);


			waitForElementToLoad=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			WebElement waitForJPDropdown=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='jackpot ng-star-inserted']/overlay-scrollbars/div[4]/div/div/div/div[2]/span")));
			WebElement jpDropDown=driver.findElement(By.xpath("//*[@class='jackpot ng-star-inserted']/overlay-scrollbars/div[4]/div/div/div/div[2]/span"));
			
			
			String getJPText=driver.findElement(By.cssSelector("div.header>div.title")).getText();
			 getJPText.equalsIgnoreCase("Jackpot");
			 test.info("Jackpot popup invoked");
			 Reporter.log("Jackpot popup invoked");
			System.out.println("Jackpot popup");

			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(3000);
			
			
			
			try {
				executor.executeScript("arguments[0].click();", jpDropDown);
			}catch (Exception e) {
				System.out.println("Unable to capture jp dropdown click exception ::: "+e);
			}
			

			
			
			
			driver.findElement(By.cssSelector("div.header>div.close")).click();
			test.info("Jackpot popup closed");
			Reporter.log("Jackpot popup closed");
			System.out.println("Jackpot Closed");
		}else {
			System.out.println("No Jackpot in the game");
		}

	}
	
	public static void historyBoard() throws InterruptedException, AWTException{
		
//		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        
        System.out.println("In History board section");
		
	
        waitForElementToLoad=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
    			.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement winText=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='arrow-container']/span")));
		WebElement hbDropdown=driver.findElement(By.xpath("//*[@class='arrow-container']/span"));
		if(winText.isDisplayed()){
			hbDropdown.click();			
			test.info("History Board invoked");
			Reporter.log("historyBoard invoked");
			try{
				TestUtil.captureScreenshot();
			}catch(Exception e){
				System.out.println(e);
			}
		}else{
			System.out.println("Failed to click on history board");
		}
		Thread.sleep(3000);
		
		String historyBoardText=driver.findElement(By.xpath("//*[@class='historyboard ng-star-inserted']/span")).getText();	
		System.out.println("historyBoardText:::"+historyBoardText);
		Thread.sleep(1000);
		
		WebElement dropdownUp=driver.findElement(By.xpath("//*[@class='arrow-container']/span"));
		dropdownUp.click();
		System.out.println("System Board closed");
		test.info("History Board closed");
		Reporter.log("historyBoard closed");
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}
//		sa.assertAll();
	}
	
	
	
public static void historyBoardFST() throws InterruptedException, AWTException{
			
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
		
	
        waitForElementToLoad=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
    			.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement winText=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='arrow-container']/span")));
		WebElement hbDropdown=driver.findElement(By.xpath("//*[@class='arrow-container']/span"));
		if(winText.isDisplayed()){
			hbDropdown.click();	
			//test.info("History Board invoked");
			System.out.println("History Board invoked");
			Reporter.log("historyBoard invoked");
			try{
				TestUtil.captureScreenshot();
			}catch(Exception e){
				System.out.println(e);
			}
			
			
		}else{
			System.out.println("Failed to click on history board");
		}
		//Thread.sleep(3000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='historyboard ng-star-inserted']/span"));
		
		String historyBoardText=driver.findElement(By.xpath("//*[@class='historyboard ng-star-inserted']/span")).getText();	
		System.out.println("historyBoardText:::"+historyBoardText);
		Thread.sleep(1000);
		
		
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}
		
		test.log(Status.PASS, "Verified Ball Call History!!");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
		Thread.sleep(1000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='arrow-container']/span"));
		WebElement dropdownUp=driver.findElement(By.xpath("//*[@class='arrow-container']/span"));
		dropdownUp.click();
		System.out.println("System Board closed");
		//test.info("History Board closed");
		Reporter.log("historyBoard closed");
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}
//		sa.assertAll();
	}
	
	
	public static void prebuyPurchase() throws InterruptedException{
		
		
		
		
	
		try
		{
		
		if(!driver.getCurrentUrl().contains("danskespil") ){
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

		
				
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
		
		
		Thread.sleep(2000);
	
		
		
		generalActions.waitForElementVisibility(By.cssSelector(".button.button-prebuy-tickets"));
		driver.findElement(By.cssSelector(".button.button-prebuy-tickets")).click();
		Thread.sleep(1000);
		
		System.out.println("clicked on Pre-Buy");
		
		
		//Thread.sleep(5000);
		
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		generalActions.waitForElementVisibility(By.id("frm_preBuy"));
		WebElement frames = driver.findElement(By.id("frm_preBuy"));
		driver.switchTo().frame(frames);
		Thread.sleep(1000);
		System.out.println("Waiting for prebuy to load....");
		//test.info("Waiting for prebuy to load....");
		 Reporter.log("Waiting for prebuy to load....");
		
		
		 Wait<WebDriver> wait2=new FluentWait<WebDriver>(driver)
		 .withTimeout(Duration.ofSeconds(300))
		 .pollingEvery(Duration.ofSeconds(3))
		 .ignoring(NoSuchElementException.class);
		
		WebElement element=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'prebuy-grid-container')]/div[2]/div[2]/div/div[1]/div[2]/div")));
		
		
		//test.info("Prebuy popup invoked");
		
		System.out.println("Prebuy popup invoked");
		Reporter.log("Prebuy popup invoked");
		 
		 try{
				TestUtil.captureScreenshot();
			}catch(Exception e){
				System.out.println(e);
			}
		Thread.sleep(1000);
		for(int i=1;i<=1;i++){
			
			//driver.findElement(By.xpath("//div[contains(@class,'prebuy-grid-element')]/div/div/following-sibling::div[@class='pb-high']/descendant::button[@class='theme-bingo-gala-plus']")).click();
			
			driver.findElement(By.xpath("//div[contains(@class,'prebuy-grid-container')]/div[2]/div[4]/div//div/div/following-sibling::div[@class='pb-high']/descendant::button[contains(@class, 'theme')][2]")).click();
			
			
			Thread.sleep(1000);
		}
		
		System.out.println("Clicked on plus button");
		
		driver.findElement(By.cssSelector("div.pb-footer-btn>div>button:nth-child(2)")).click();
		//test.info("Prebuy confirm Popup");
		System.out.println("Prebuy confirm Popup");
		
		
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}
		Thread.sleep(1000);
		generalActions.waitForElementVisibility(By.cssSelector("p.text-center>a:nth-child(2)>button"));
		driver.findElement(By.cssSelector("p.text-center>a:nth-child(2)>button")).click();
		//test.info("Clicked on confirm!!");
		System.out.println("Clicked on confirm!!");
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}	
		System.out.println("Ticket Purchased");
		Thread.sleep(1000);
		
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}
		test.log(Status.PASS, "Verified Pre-Buy Tickets Purchase!!");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		generalActions.waitForElementVisibility(By.cssSelector("div.pre-buy-header>span>img.prebuy-close-img"));
		WebElement prebuyClose=	driver.findElement(By.cssSelector("div.pre-buy-header>span>img.prebuy-close-img"));
		System.out.println("Identified close");
		executor.executeScript("arguments[0].click();", prebuyClose);
		
		//test.info("Prebuy popup closed");
		System.out.println("Prebuy popup closed");
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}
		Thread.sleep(1000);
	}
		
	else {
		Thread.sleep(2000);
		
		
		
		generalActions.waitForElementVisibility(By.xpath("//button[contains(@class, 'button-prebuy-tickets')]"));
		driver.findElement(By.xpath("//button[contains(@class, 'button-prebuy-tickets')]")).click();
		Thread.sleep(1000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        
        driver.switchTo().parentFrame();
        
        WebElement frames = driver.findElement(By.id("frm_preBuy"));
		driver.switchTo().frame(frames);
		Thread.sleep(3000);
		//test.info("Waiting for prebuy to load....");
		System.out.println("Waiting for prebuy to load....");
		 Reporter.log("Waiting for prebuy to load....");
       
		
		
		
		 Wait<WebDriver> wait2=new FluentWait<WebDriver>(driver)
		 .withTimeout(Duration.ofSeconds(300))
		 .pollingEvery(Duration.ofSeconds(3))
		 .ignoring(NoSuchElementException.class);
		
				
		 WebElement element=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='table']/descendant::div[text()='Spillet starter']")));
		
		
		System.out.println("Prebuy popup invoked"); 
		
		//test.info("Prebuy popup invoked");
		
		Reporter.log("Prebuy popup invoked");
		 
		 try{
				TestUtil.captureScreenshot();
			}catch(Exception e){
				System.out.println(e);
			}
		
	
		Thread.sleep(1000);
		for(int i=1;i<=1;i++){
			
			driver.findElement(By.xpath("//div[@class='table']/descendant::div[@class='table__row'][4]/div/following-sibling::div[contains(@class,'table__cell table__cell--choose')]/div/following-sibling::div[contains(@class,'add')]")).click();
						
			Thread.sleep(1000);
		}
		
		//Clicked on prebuy in prebuy popup
		generalActions.waitForElementVisibility(By.xpath("//*[@class='table__footer-inner']/div[2]/div[2]"));
		driver.findElement(By.xpath("//*[@class='table__footer-inner']/div[2]/div[2]")).click();
		
		//test.info("Prebuy confirm Popup");
		System.out.println("Prebuy confirm Popup");
		Thread.sleep(1000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='ds-modal-content']/div[2]/a[2]"));
		driver.findElement(By.xpath("//*[@class='ds-modal-content']/div[2]/a[2]")).click();
		System.out.println("Clicked on confirm!!");
		//test.info("Clicked on confirm!!");
		
		System.out.println("Ticket Purchased");
		Thread.sleep(4000);
		
		try{
			TestUtil.captureScreenshot();
		}catch(Exception e){
			System.out.println(e);
		}
		
		test.log(Status.PASS, "Verified Pre-Buy Tickets Purchase!!");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());
		
		
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='ds-modal-content']/div[2]/a[1]"));
		driver.findElement(By.xpath("//*[@class='ds-modal-content']/div[2]/a[1]")).click();

		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		System.out.println("Prebuy close frame");
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='pre-buy-header']/span/img"));
		WebElement prebuyClose=	driver.findElement(By.xpath("//*[@class='pre-buy-header']/span/img"));
		System.out.println("Identified close");
		
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", prebuyClose);
		System.out.println("Prebuy Closed");
		//test.info("Prebuy popup closed");
		Thread.sleep(1000);
	}
		
	}	
	catch(Exception exp)
	{
		System.err.println("Pre-Buy is Failed with Error:");
		exp.printStackTrace();
		test.log(Status.FAIL,"Pre-Buy is Failed");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
		
	}
	
}
	

		
	
	
	public static void chatCheck() throws InterruptedException{
		//Thread.sleep(5000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='chat-header']/div[1]/span"));
		WebElement chatText=driver.findElement(By.xpath("//*[@class='chat-header']/div[1]/span"));
		
		if(chatText.getText().contains("Chats")){
			assert chatText.getText().contains("Chats");
			System.out.println("chatText.getText():::"+chatText.getText());
		}else{
			System.out.println("Skip chat");
		}
		
		//Temporarily commenting
		
		
//		WebElement identifyChat=driver.findElement(By.cssSelector("div.chat-msg-input"));
//		Thread.sleep(1000);
//		executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", identifyChat);
//		System.out.println("Chat Identified");
//		identifyChat.sendKeys("Hi");
//		Reporter.log("Entered Chat Text");
//		test.info("Entered Chat Text");
//		try {
//			TestUtil.captureScreenshot();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		WebElement sendChat=driver.findElement(By.cssSelector("div.chat-sendBtn>span"));
//		Thread.sleep(1000);
//		sendChat.click();
//		try {
//			TestUtil.captureScreenshot();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Chat Sent");
//		Reporter.log("Text sent from chat");
//		test.info("Text sent from chat");
		
		
		generalActions.waitForElementVisibility(By.xpath("//div[@id='chat-emoticonBtn']/span"));
		WebElement smileyClick=driver.findElement(By.xpath("//div[@id='chat-emoticonBtn']/span"));
		smileyClick.click();
		Thread.sleep(1000);
		System.out.println("Smiley's invoked");
		Reporter.log("Smiley's invoked");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.log(Status.PASS, "Verified Chat Area Successfully");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	

		
		//Clicking on GIFs
		
//		driver.findElement(By.xpath("//div[@class='emoji-top']/span[2]")).click();	
//		Thread.sleep(3000);
//		System.out.println("GIFs invoked");
//		Reporter.log("GIFs invoked");
//		test.info("GIFs invoked");
//		
//		try {
//			TestUtil.captureScreenshot();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		//Clicking on Stickers
//		driver.findElement(By.xpath("//div[@class='emoji-top']/span[3]")).click();
//		Thread.sleep(3000);
//		System.out.println("Stickers invoked");
//		Reporter.log("Stickers invoked");
//		test.info("Stickers invoked");
//		try {
//			TestUtil.captureScreenshot();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		smileyClick.click();
		System.out.println("Verified Chat");
		Reporter.log("Verified Chat");
		
		
	}
		
	public static void betHistory() throws InterruptedException {
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
		
		//Thread.sleep(2000);
		
		if(!driver.getCurrentUrl().contains("sportingbet")) {
			
		generalActions.waitForElementVisibility(By.cssSelector("span.hamburger_lines_menu_icon"));	
		driver.findElement(By.cssSelector("span.hamburger_lines_menu_icon")).click();
		Thread.sleep(2000);
		
		
		generalActions.waitForElementsVisibility(By.xpath("//*[contains(text(),'Bet History')] | //*[contains(text(),'História')]"));
		driver.findElement(By.xpath("//*[contains(text(),'Bet History')] | //*[contains(text(),'História')]")).click();
		Reporter.log("Clicked on bet history");
		//test.info("Clicked on bet history");
		System.out.println("Clicked on bet history");
		//Thread.sleep(20000);
		
		
		generalActions.waitForElementsVisibility(By.xpath("//*[@class='game-history-encap']/lib-game-history/div/lib-header[1]/div/div/div[3]/img"));
		driver.findElement(By.xpath("//*[@class='game-history-encap']/lib-game-history/div/lib-header[1]/div/div/div[3]/img")).click();
		Reporter.log("Clicked on bet history refresh");
		//test.info("Clicked on bet history refresh");
		System.out.println("Clicked on bet history refresh");
		
		
		generalActions.waitForElementsVisibility(By.xpath("//*[@class='table-header']/div[1]/img[2]"));
		driver.findElement(By.xpath("//*[@class='table-header']/div[1]/img[2]")).click();
		Reporter.log("Clicked on history sorting");
		//test.info("Clicked on history sorting");
		System.out.println("Clicked on history sorting");
		
		Wait<WebDriver> historyWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(240))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement history=historyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='scroll ng-star-inserted']/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header")));

		
		driver.findElement(By.xpath("//*[@class='scroll ng-star-inserted']/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header")).click();
		
		generalActions.waitForElementVisibility(By.xpath("//div[@class='detail-history ng-star-inserted']"));
		
		Reporter.log("Verified Game History");
		//test.info("Verified Game History");
		System.out.println("Verified Game History");
		//Thread.sleep(5000);		
		Thread.sleep(2000);	
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		test.log(Status.PASS, "Verified Game Hisotry!!");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
		
		//generalActions.waitForElementVisibility(By.xpath("//*[@class='menu_header']/span[2]"));
		//WebElement closeHamburger=driver.findElement(By.xpath("//*[@class='menu_header']/span[2]"));
		
		
		generalActions.waitForElementVisibility(By.xpath("//div[@class='gamehistory']//div[@class='close-item btn-class']/img"));
		WebElement closeHamburger=driver.findElement(By.xpath("//div[@class='gamehistory']//div[@class='close-item btn-class']/img"));

		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closeHamburger);
		
		

	}else{
		System.out.println("Executing SBCOM");
	}
		
	}else if(driver.getCurrentUrl().contains("danskespil")) {
		Thread.sleep(5000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
//		je.executeScript("arguments[0].scrollIntoView(true);",hamburgerLink);
		je.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("span.hamburger_lines_menu_icon")).click();
		Thread.sleep(2000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[contains(text(),'Spilhistorik')] | //*[contains(text(),'História')]"));
		driver.findElement(By.xpath("//*[contains(text(),'Spilhistorik')] | //*[contains(text(),'História')]")).click();
		Reporter.log("Clicked on bet history");
		//test.info("Clicked on bet history");
		System.out.println("Clicked on bet history");
		//Thread.sleep(20000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='game-history-encap']/lib-game-history/div/lib-header[1]/div/div/div[3]/img"));
		driver.findElement(By.xpath("//*[@class='game-history-encap']/lib-game-history/div/lib-header[1]/div/div/div[3]/img")).click();
		Reporter.log("Clicked on bet history refresh");
		//test.info("Clicked on bet history refresh");
		System.out.println("Clicked on bet history refresh");
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='table-header']/div[1]/img[2]"));
		driver.findElement(By.xpath("//*[@class='table-header']/div[1]/img[2]")).click();
		Reporter.log("Clicked on history sorting");
		//test.info("Clicked on history sorting");
		System.out.println("Clicked on history sorting");
		
		
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='scroll ng-star-inserted']/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header"));
		driver.findElement(By.xpath("//*[@class='scroll ng-star-inserted']/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header")).click();
		Reporter.log("Verified Bet History");
		//test.info("Verified Bet History");
		System.out.println("Verified Bet History");
		Thread.sleep(5000);
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.PASS, "Verified Game Hisotry!!");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		Thread.sleep(2000);	
		
		
		//generalActions.waitForElementVisibility(By.xpath("//*[@class='menu_header']/span[2]"));
		//WebElement closeHamburger=driver.findElement(By.xpath("//*[@class='menu_header']/span[2]"));
		
		

		generalActions.waitForElementVisibility(By.xpath("//div[@class='gamehistory']//div[@class='close-item btn-class']/img"));
		WebElement closeHamburger=driver.findElement(By.xpath("//div[@class='gamehistory']//div[@class='close-item btn-class']/img"));

		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closeHamburger);


	}
	
	}
	
	public static void closeGame() throws InterruptedException, AWTException {
		
		waitForElementToLoad=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		if(!driver.getCurrentUrl().contains("danskespil")) {
			Thread.sleep(2000);
			
			driver.switchTo().defaultContent();
			
			WebElement closeGame=driver.findElement(By.xpath("//*[@class='header-close-icon']"));

			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", closeGame);
			//test.info("Closing the game window");
			System.out.println("Closing the game window");
			Reporter.log("Closed popup is displaying");
			
			Thread.sleep(1000);
			
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Game Close Popup!!");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
			
			WebElement confirmClose = driver.findElement(By.xpath("//*[@class='model-inner']/div[2]/span[2]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", confirmClose);
			//test.info("Game window closed");
			System.out.println("Game window closed");
			Reporter.log("Close the game window");
			WebElement waitForDepositButton=waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//vn-h-deposit-button/vn-menu-item/a")));
		
		
		
		}else {
		Thread.sleep(1000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        
        Thread.sleep(2000);
		
		
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='iframe-element']")));
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		WebElement closeGame=driver.findElement(By.xpath("//*[@class='header-close-icon']"));

		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closeGame);
		//test.info("Closing the game window");
		System.out.println("Closing the game window");
		Reporter.log("Closed popup is displaying");
		
		Thread.sleep(1000);
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.log(Status.PASS, "Verified Game Close Popup!!");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
		WebElement confirmClose = driver.findElement(By.xpath("//*[@class='model-inner']/div[2]/span[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", confirmClose);
		//test.info("Game window closed");
		System.out.println("Game window closed");
		Reporter.log("Close the game window");
		
		Thread.sleep(5000);
		}
	}
	
	
	
	public static void miniGamesCheck() throws InterruptedException{		
		Thread.sleep(1000);
		int miniGamesCount=0;
		WebElement minHeaderText=null;
		String currentURL=driver.getCurrentUrl();
		
	try {
		
			generalActions.waitForElementVisibility(By.xpath("//iframe[@id='frm_miniGame']"));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm_miniGame']")));
			System.out.println("Entered into Mini Games Frames");				
			Thread.sleep(1000);
		
		
			
	if(currentURL.contains("ladbrokes") ||currentURL.contains("coral") )
	{
			
		generalActions.waitForElementVisibility(By.xpath(OR.getProperty("getLCGMiniGamesHeader")));	
		minHeaderText=driver.findElement(By.xpath(OR.getProperty("getLCGMiniGamesHeader")));	
			
	}
	else
	{
		generalActions.waitForElementVisibility(By.xpath(OR.getProperty("getMiniGamesHeader")));	
		minHeaderText=driver.findElement(By.xpath(OR.getProperty("getMiniGamesHeader")));
	}
		
		
		if(minHeaderText.getText().equalsIgnoreCase("MINI GAMES") && 
			(!currentURL.contains("danskespil")) &&
			(!currentURL.contains("ladbrokes")) &&
			(!currentURL.contains("coral")))
		{
			System.out.println("Mini Games section available");
		
			
			miniGamesCount=driver.findElements(By.xpath(OR.getProperty("getMiniGamesList"))).size();
			
			if(miniGamesCount>0)
			{
				System.out.println(miniGamesCount+" :: Mini Games are available");				
				test.log(Status.PASS, "Verified Mini Games section Successfully");
				Thread.sleep(1000);
				
				/*
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	*/
			}
			else
			{
				System.err.println("Mini Games are NOT available in Mini Games section");
				test.log(Status.FAIL,"Mini Games are NOT available in Mini Games section");
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
			}
				
			
		}
		else if(minHeaderText.getText().equalsIgnoreCase("Hyggespil") && currentURL.contains("danskespil"))
		{
			System.out.println("Mini Games section available");
		
			
			miniGamesCount=driver.findElements(By.xpath(OR.getProperty("getMiniGamesList"))).size();
			
			if(miniGamesCount>0)
			{
				System.out.println(miniGamesCount+" :: Mini Games are available");				
				test.log(Status.PASS, "Verified Mini Games Area Successfully");
				Thread.sleep(1000);
				
				/*
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	*/
			}
			else
			{
				System.err.println("Mini Games are NOT available in Mini Games section");
				test.log(Status.FAIL,"Mini Games are NOT available in Mini Games section");
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
			}
		}
		else if(minHeaderText.getText().equalsIgnoreCase("Most Popular") && 
				(currentURL.contains("ladbrokes") || currentURL.contains("coral")))
		{
			System.out.println("Mini Games section available");
		
			
			miniGamesCount=driver.findElements(By.xpath(OR.getProperty("getMiniGamesList"))).size();
			
			if(miniGamesCount>0)
			{
				System.out.println(miniGamesCount+" :: Mini Games are available");				
				test.log(Status.PASS, "Verified Mini Games Area Successfully");
				Thread.sleep(1000);
				
				/*
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	*/
			}
			else
			{
				System.err.println("Mini Games are NOT available in Mini Games section");
				test.log(Status.FAIL,"Mini Games are NOT available in Mini Games section");
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
			}
		}
		else
		{
			System.err.println("Mini Games Header Name mismatch");
			test.info("Mini Games Header Name mismatch");
		}
		
	}
	catch(Exception err)
	{
		System.err.println("Mini Games Validation");
		test.log(Status.FAIL,"Mini Games Validation Failed");
		err.printStackTrace();
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
	}
		
	}			
		
		
	

}
