package reusables;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Utilities.TestUtil;
import reusables.CommonActions;


import BaseEngine.baseEngine;

public class Windows extends baseEngine{
	
	public static CommonActions generalActions=new CommonActions();

	public static void lineOneColor() throws InterruptedException {
		if(!driver.getCurrentUrl().contains("danskespil")) {
		driver.switchTo().defaultContent() ;
		System.out.println("Switched to default frame");

		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement oneLine=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
		Thread.sleep(2000);
		WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
		Actions act = new Actions(driver);
		act.moveToElement(winText).click().build().perform();
		
		String oneLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
		System.out.println("oneLineText:::"+oneLineText);
		
		if(oneLine.getText().equalsIgnoreCase("You Win")||oneLine.getText().equalsIgnoreCase("Você ganhou")){
			assert oneLineText.equalsIgnoreCase("You Win")||  oneLineText.equalsIgnoreCase("Temos um vencedor");
			//test.info("Line one Winner Window");
			Reporter.log("oneLine Winner Window");
			System.out.println("Line one Winner Window");
		
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line One Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
		}else if(oneLine.getText().equalsIgnoreCase("We Have a Winner!")||oneLine.getText().equalsIgnoreCase("Temos um vencedor")){
			assert oneLineText.equalsIgnoreCase("We Have a Winner!") ||  oneLineText.equalsIgnoreCase("Temos um vencedor");
			//test.info("Line one Non-Winner Window");
			Reporter.log("oneLine Non Winner Window");
			System.out.println("Line one Non-Winner Window");
			
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line One Non-Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
			
			
		}else if(oneLineText.equalsIgnoreCase("We Have Winners!")||oneLine.getText().equalsIgnoreCase("Vencedores!")){
			assert oneLineText.equalsIgnoreCase("We Have Winners!")||  oneLineText.equalsIgnoreCase("Vencedores!");
			//test.info("Line one Multi-Winner Window");
			Reporter.log("oneLine Multi Winner Window");
			System.out.println("Line one Multi-Winner Window");
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Line One Multi-Winner Window");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
		}else{
			System.out.println("No window");
		}
		Thread.sleep(10000);
		}else {
			
	
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			WebElement oneLine=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
			Thread.sleep(1000);
			if(!oneLine.isDisplayed()) {
				System.out.println("Failed to capture winner window");
			}else {
				
			
			WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
			Actions act = new Actions(driver);
			act.moveToElement(winText).click().build().perform();
			
			String oneLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
			System.out.println("oneLineText:::"+oneLineText);
			
			if(oneLineText.equalsIgnoreCase("Du vandt") 
			|| oneLineText.equalsIgnoreCase("DER ER EN VINDER") 
			|| oneLineText.equalsIgnoreCase("Der er vindere")) {
				assert oneLineText.equalsIgnoreCase("Du vandt") || oneLineText.equalsIgnoreCase("DER ER EN VINDER") 
				|| oneLineText.equalsIgnoreCase("Der er vindere");
				//test.info("Line one Winner Window");
				Reporter.log("oneLine Winner Window");
				System.out.println("Line one Winner Window");
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Line One Winner Window");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			}
			
			else{
				System.out.println("No window");
			}
			
			Thread.sleep(10000);
		}
		}
	}
	
	
	public static void lineTwoColor() throws InterruptedException {
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
		
		Wait<WebDriver> lineTwo=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement twoLine=lineTwo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
		Thread.sleep(2000);
		WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
		Actions act = new Actions(driver);
		act.moveToElement(winText).click().build().perform();
		
		String twoLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
		System.out.println("twoLineText:::"+twoLineText);
		
		if(twoLine.getText().equalsIgnoreCase("You Win")||twoLine.getText().equalsIgnoreCase("Você ganhou")){
//			sa.assertEquals(oneLineText, "YOU WIN");
			assert twoLineText.equalsIgnoreCase("You Win")||  twoLineText.equalsIgnoreCase("Temos um vencedor");
			//test.info("Line two Winner Window");
			Reporter.log("twoLine Winner Window");
			System.out.println("Line Two Winner Window");
			
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line Two Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
		}else if(twoLine.getText().equalsIgnoreCase("We Have a Winner!")||twoLine.getText().equalsIgnoreCase("Temos um vencedor")){
//			sa.assertEquals(oneLineText, "WE HAVE A WINNER!");
			assert twoLineText.equalsIgnoreCase("We Have a Winner!") ||  twoLineText.equalsIgnoreCase("Temos um vencedor");
			//test.info("Line two Non-Winner Window");
			Reporter.log("twoLine Non Winner Window");
			System.out.println("Line Two Non-Winner Window");
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line Two Non-Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		}else if(twoLine.getText().equalsIgnoreCase("We Have Winners!")||twoLine.getText().equalsIgnoreCase("Vencedores!")){

//			sa.assertEquals(twoLineText, "WE HAVE WINNERS!");
//			sa.assertAll();
			assert twoLineText.equalsIgnoreCase("We Have Winners!")||  twoLineText.equalsIgnoreCase("Vencedores!");
			//test.info("Line two Multi-Winner Window");
			Reporter.log("twoLine Multi Winner Window");
			System.out.println("Line Two Multi-Winner Window");
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line Two Multi-Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
	}else{
			System.out.println("No window");
		}
		Thread.sleep(10000);
		
		}else {
			
			Wait<WebDriver> lineTwo=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//			waitingTime();
			WebElement twoLine=lineTwo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
			Thread.sleep(2000);
			WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
			Actions act = new Actions(driver);
			act.moveToElement(winText).click().build().perform();
			
			String twoLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
			System.out.println("twoLineText:::"+twoLineText);
			
			if(twoLineText.equalsIgnoreCase("Du vandt") 
			|| twoLineText.equalsIgnoreCase("Der er en vinder") 
			|| twoLineText.equalsIgnoreCase("Der er vindere")){
//				sa.assertEquals(oneLineText, "YOU WIN");
				assert twoLineText.equalsIgnoreCase("Du vandt") || twoLineText.equalsIgnoreCase("Der er en vinder") 
				|| twoLineText.equalsIgnoreCase("Der er vindere");
				//test.info("Line two Winner Window");
				Reporter.log("twoLine Winner Window");
				System.out.println("Line two Winner Window");
			
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Line Two Winner Window");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			}

			else{
				System.out.println("No window");
			}
			Thread.sleep(10000);
		}
		}


	public static void lineThreeColor() throws InterruptedException {
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
		
		Wait<WebDriver> lineThree=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//		waitingTime();
		WebElement threeLine=lineThree.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
		Thread.sleep(2000);
		WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
		Actions act = new Actions(driver);
		act.moveToElement(winText).click().build().perform();
		
		String threeLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
		System.out.println("threeLineText:::"+threeLineText);
		
		if(threeLine.getText().equalsIgnoreCase("You Win")||threeLine.getText().equalsIgnoreCase("Você ganhou")){
//			sa.assertEquals(oneLineText, "YOU WIN");
			assert threeLineText.equalsIgnoreCase("You Win")||  threeLineText.equalsIgnoreCase("Temos um vencedor");
			//test.info("Line three Winner Window");
			Reporter.log("threeLine Winner Window");
			System.out.println("Line Three Winner Window");
			
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line Three Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
		}else if(threeLine.getText().equalsIgnoreCase("We Have a Winner!")||threeLine.getText().equalsIgnoreCase("Temos um vencedor")){
//			sa.assertEquals(oneLineText, "WE HAVE A WINNER!");
			assert threeLineText.equalsIgnoreCase("We Have a Winner!") ||  threeLineText.equalsIgnoreCase("Temos um vencedor");
			//test.info("Line three Non-Winner Window");
			Reporter.log("threeLine Non Winner Window");
			System.out.println("Line Three Non-Winner Window");
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line Three Non-Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
		}else if(threeLine.getText().equalsIgnoreCase("We Have Winners!")||threeLine.getText().equalsIgnoreCase("Vencedores!")){

//			sa.assertEquals(twoLineText, "WE HAVE WINNERS!");
//			sa.assertAll();
			assert threeLineText.equalsIgnoreCase("We Have Winners!")||  threeLineText.equalsIgnoreCase("Vencedores!");
			//test.info("Line three Multi-Winner Window");
			Reporter.log("threeLine Multi Winner Window");
			System.out.println("Line Three Multi-Winner Window");
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line Three Multi-Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
	}else{
			System.out.println("No window");
		}
		Thread.sleep(10000);
		}else {
			
			Wait<WebDriver> lineThree=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//			waitingTime();
			WebElement threeLine=lineThree.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
			Thread.sleep(2000);
			WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
			Actions act = new Actions(driver);
			act.moveToElement(winText).click().build().perform();
			
			String threeLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
			System.out.println("ThreeLineText:::"+threeLineText);
			
			if(threeLine.getText().equalsIgnoreCase("Du vandt") 
			|| threeLine.getText().equalsIgnoreCase("Der er en vinder") 
			|| threeLine.getText().equalsIgnoreCase("Der er vindere")){
//				sa.assertEquals(oneLineText, "YOU WIN");
				assert threeLineText.equalsIgnoreCase("Du vandt") || threeLine.getText().equalsIgnoreCase("Der er en vinder") 
				|| threeLine.getText().equalsIgnoreCase("Der er vindere");
				//test.info("Line three Winner Window");
				Reporter.log("threeLine Winner Window");
				System.out.println("Line Three Winner Window");
			
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Line Three Winner Window");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			}

			else{
				System.out.println("No window");
			}
			Thread.sleep(10000);
		}
		}


public static void lineFourColor() throws InterruptedException {
	
	if(!driver.getCurrentUrl().contains("danskespil")) {
	
	Wait<WebDriver> lineFour=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
			.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//	waitingTime();
	WebElement fourLine=lineFour.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
	Thread.sleep(2000);
	WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
	Actions act = new Actions(driver);
	act.moveToElement(winText).click().build().perform();
	
	String fourLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
	System.out.println("fourLineText:::"+fourLineText);
	
	if(fourLine.getText().equalsIgnoreCase("You Win")||fourLine.getText().equalsIgnoreCase("Você ganhou")){
//		sa.assertEquals(oneLineText, "YOU WIN");
		assert fourLineText.equalsIgnoreCase("You Win")||  fourLineText.equalsIgnoreCase("Temos um vencedor");
		//test.info("Line four Winner Window");
		Reporter.log("fourLine Winner Window");
		System.out.println("Line four Winner Window");
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.PASS, "Verified Line Four Winner Window");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
	}else if(fourLine.getText().equalsIgnoreCase("We Have a Winner!")||fourLine.getText().equalsIgnoreCase("Temos um vencedor")){
//		sa.assertEquals(oneLineText, "WE HAVE A WINNER!");
		assert fourLineText.equalsIgnoreCase("We Have a Winner!") ||  fourLineText.equalsIgnoreCase("Temos um vencedor");
		//test.info("Line four Non-Winner Window");
		Reporter.log("fourLine Non Winner Window");
		System.out.println("Line Four Non-Winner Window");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.PASS, "Verified Line Four Winner Window");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
	}else if(fourLine.getText().equalsIgnoreCase("We Have Winners!")||fourLine.getText().equalsIgnoreCase("Vencedores!")){

//		sa.assertEquals(twoLineText, "WE HAVE WINNERS!");
//		sa.assertAll();
		assert fourLineText.equalsIgnoreCase("We Have Winners!")||  fourLineText.equalsIgnoreCase("Vencedores!");
		//test.info("Line four Multi-Winner Window");
		Reporter.log("fourLine Multi Winner Window");
		System.out.println("Line four Multi-Winner Window");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.PASS, "Verified Line Four Multi-Winner Window");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
}else{
		System.out.println("No window");
	}
	Thread.sleep(10000);
	}else {
		
		Wait<WebDriver> lineFour=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//		waitingTime();
		WebElement fourLine=lineFour.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='model-content']/div/h5")));
		Thread.sleep(2000);
		WebElement winText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5"));
		Actions act = new Actions(driver);
		act.moveToElement(winText).click().build().perform();
		
		String fourLineText=driver.findElement(By.xpath("//*[@class='model-content']/div/h5")).getText();
		System.out.println("FourLineText:::"+fourLineText);
		
		if(fourLine.getText().equalsIgnoreCase("Du vandt") 
		|| fourLine.getText().equalsIgnoreCase("Der er en vinder") 
		|| fourLine.getText().equalsIgnoreCase("Der er vindere")){
//			sa.assertEquals(oneLineText, "YOU WIN");
			assert fourLineText.equalsIgnoreCase("Du vandt") || fourLine.getText().equalsIgnoreCase("Der er en vinder") 
			|| fourLine.getText().equalsIgnoreCase("Der er vindere");
			//test.info("Line four Winner Window");
			Reporter.log("fourLine Winner Window");
			System.out.println("Line four Winner Window");
			
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Line Four Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
		}

		else{
			System.out.println("No window");
		}
		Thread.sleep(10000);
	}
	}

	
	public static void FHColor() throws InterruptedException {
		
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
//			ballType=driver.findElement(By.xpath("//*[@class='game-ball-container']/div/span"));
//			System.out.println("ballType:::"+ballType.getText());
		Wait<WebDriver> FHwait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		WebElement FH=FHwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='winner-window-wrapper']/div/div/p")));
		Thread.sleep(1000);
		System.out.println("Wait over");
		WebElement winner = driver.findElement(By.xpath("//*[@id='winner-window-wrapper']/div/div/p"));
		String winnerText = winner.getText();
		if (winnerText.equalsIgnoreCase("CHECK ALL WINNERS") || winnerText.equalsIgnoreCase("VERIFIQUE TODOS OS VENCEDORES")) {
			//test.info("Full House Window");
			System.out.println("Full House Window");
			Reporter.log("Full House Window");
			System.out.println("CHECK ALL WINNERS found");
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Full House Winner Window");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			
			Thread.sleep(10000);
			

		}
		}	else if(driver.getCurrentUrl().contains("danskespil")){
//			driver.switchTo().parentFrame();
//			System.out.println("ballType from full house winner window:::"+ballType.getText());
			Wait<WebDriver> FHwait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			WebElement FH=FHwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='winner-window-wrapper']/div/div/p")));
//			Thread.sleep(2000);
			System.out.println("Wait over");
			WebElement winner = driver.findElement(By.xpath("//*[@id='winner-window-wrapper']/div/div/p"));
			String winnerText = winner.getText();
			if (winnerText.equalsIgnoreCase("Tjek alle vindere")) {
				//test.info("Full House Window");
				Reporter.log("Full House Window");
				System.out.println("CHECK ALL WINNERS found");
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.log(Status.PASS, "Verified Full House Winner Window");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				
				Thread.sleep(10000);
				
				try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_UP);
		        robot.keyRelease(KeyEvent.VK_PAGE_UP);
				}catch(Exception exp)
				{
					exp.printStackTrace();
				}
		        
		        Thread.sleep(1000);
				
//				if(sizeOfContainer.size()==4 && getFeatureText.contains("Roll")) {
//					System.out.println("Wait for roll on to complete");
//					Thread.sleep(50000);
//					System.out.println("Roll on completed");
//				}else if(sizeOfContainer.size()==4 && !getFeatureText.contains("Roll")) {
//					System.out.println("Normal feature");
////					Thread.sleep(50000);
////					System.out.println("Roll on completed");
//				}
//				else if(sizeOfContainer.size()==3){
//					System.out.println("No Roll On");
//				}
//				else {
//					System.out.println("Failed to capture summary window");
//				}
			} else {
				System.out.println("<--Sarcastic Me-->");
			}
			
		}
	
	}
	
	public static void winnerSummary() throws InterruptedException, AWTException{
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
			
		if(!driver.getCurrentUrl().contains("foxy")) {
			
			
			
		generalActions.waitForElementVisibility(By.cssSelector("span.hamburger_lines_menu_icon"));	
		driver.findElement(By.cssSelector("span.hamburger_lines_menu_icon")).click();
		//Thread.sleep(4000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[contains(text(),'Winners')] | //*[contains(text(),'Vencedores')]"));	
		WebElement summaryWindow=driver.findElement(By.xpath("//*[contains(text(),'Winners')] | //*[contains(text(),'Vencedores')]"));
		
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", summaryWindow);
		
		Wait<WebDriver> waitForSeeWinners=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement waitForSeeWinnersText=waitForSeeWinners.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']/h4")));
		
		
		
		WebElement getWinnetText=driver.findElement(By.xpath("//*[@class='title']/h4"));
		//test.info("Summary Window invoked");
		
		System.out.println("Summary Window invoked");
		
		String getWinnerTextWinners=getWinnetText.getText();
		
		if(getWinnerTextWinners.equalsIgnoreCase("WINNERS") || getWinnerTextWinners.equalsIgnoreCase("Vencedores")){
			Thread.sleep(1000);
			
			assert getWinnerTextWinners.equalsIgnoreCase("WINNERS")|| getWinnerTextWinners.equalsIgnoreCase("Vencedores");
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.PASS, "Verified Winners Summary!!");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			Thread.sleep(1000);
			
			System.out.println("Winners Summary Captured");
			
			
			
		}else{
			System.out.println("Capture to fail WinnersWindowSummary");
		}
		Thread.sleep(2000);
		
		
		generalActions.waitForElementLocated(By.xpath("//*[@class='title']/div/img"));
		driver.findElement(By.xpath("//*[@class='title']/div/img")).click();
		
		
		}else if(driver.getCurrentUrl().contains("foxy")) {
			
			
			
			generalActions.waitForElementVisibility(By.cssSelector("span.hamburger_lines_menu_icon"));	
			driver.findElement(By.cssSelector("span.hamburger_lines_menu_icon")).click();
			Thread.sleep(1000);
			
			
			generalActions.waitForElementVisibility(By.xpath("//*[@class='main_menu']/li[6]/label"));	
			WebElement summaryWindow=driver.findElement(By.xpath("//*[@class='main_menu']/li[6]/label"));
			
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", summaryWindow);
			
			Wait<WebDriver> waitForSeeWinners=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			WebElement waitForSeeWinnersText=waitForSeeWinners.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']/h4")));
			
			WebElement getWinnetText=driver.findElement(By.xpath("//*[@class='title']/h4"));
			//test.info("Summary Window invoked");
			System.out.println("Summary Window invoked");
			
			String getWinnerTextWinners=getWinnetText.getText();
			
			if(getWinnerTextWinners.equalsIgnoreCase("WINNERS") || getWinnerTextWinners.equalsIgnoreCase("Vencedores")){
				Thread.sleep(1000);
				
				assert getWinnerTextWinners.equalsIgnoreCase("WINNERS")|| getWinnerTextWinners.equalsIgnoreCase("Vencedores");
				try {
					TestUtil.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				test.log(Status.PASS, "Verified Winners Summary!!");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
				Thread.sleep(1000);
				
				System.out.println("Winners Summary Captured");
				
			}else{
				System.out.println("Capture to fail WinnersWindowSummary");
			}
			Thread.sleep(2000);
			
			
			generalActions.waitForElementVisibility(By.xpath("//*[@class='title']/div/img"));
			driver.findElement(By.xpath("//*[@class='title']/div/img")).click();
			
		}		else {
			System.out.println("Failed to capture winner window");
		}
	}else if(driver.getCurrentUrl().contains("danskespil")) {
			
		Thread.sleep(4000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
//		je.executeScript("arguments[0].scrollIntoView(true);",hamburgerLink);
		je.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("span.hamburger_lines_menu_icon")).click();
		Thread.sleep(2000);
		
		
		
		
		
		
		/*
		
		generalActions.waitForElementVisibility(By.cssSelector("span.hamburger_lines_menu_icon"));
		WebElement hamburgerLink=driver.findElement(By.cssSelector("span.hamburger_lines_menu_icon"));
		Thread.sleep(1000);
		hamburgerLink.click();

		Thread.sleep(1000);  */
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='main_menu']/li[6]/label"));
		WebElement summaryWindow=driver.findElement(By.xpath("//*[@class='main_menu']/li[6]/label"));
		
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", summaryWindow);
		
		Wait<WebDriver> waitForSeeWinners=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement waitForSeeWinnersText=waitForSeeWinners.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']/h4")));
		//test.info("Summary Window invoked");
		
		System.out.println("Summary Window invoked");
		
		WebElement getWinnetText=driver.findElement(By.xpath("//*[@class='title']/h4"));
		
		getWinnerTextWinners=getWinnetText.getText();
		
		if(getWinnerTextWinners.equalsIgnoreCase("Vindere") ){
			Thread.sleep(1000);
			
			assert getWinnerTextWinners.equalsIgnoreCase("Vindere");
			try {
				TestUtil.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.log(Status.PASS, "Verified Winners Summary!!");
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
			Thread.sleep(1000);
			
			System.out.println("Winners Summary Captured");
			
		}else{
			System.out.println("Capture to fail WinnersWindowSummary");
		}
		Thread.sleep(2000);
		
		generalActions.waitForElementVisibility(By.xpath("//*[@class='title']/div/img"));
		driver.findElement(By.xpath("//*[@class='title']/div/img")).click();
		
		
	}

	}

	

	
	
}
	
