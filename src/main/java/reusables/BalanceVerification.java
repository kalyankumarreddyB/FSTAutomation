package reusables;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import BaseEngine.baseEngine;

public class BalanceVerification extends baseEngine{
	
	
	public static String ticketPriceText="";
	
	public static void balBeforeWager() throws InterruptedException{
		
		ballType=driver.findElement(By.xpath("//*[@class='game-ball-container']/div/span"));
		getBallType=ballType.getText();
		System.out.println("ballType:::"+getBallType);
		
		
		System.out.println("GetBal");
		if(!driver.getCurrentUrl().contains("danskespil")) {
		driver.switchTo().defaultContent();
		WebElement getBalanceTextBefore=driver.findElement(By.xpath("//*[@class='balance ellipse']/span[2]"));
		String getBalanceBeforeWager=getBalanceTextBefore.getText();
		
		if(getBalanceBeforeWager.startsWith("R$")){
			
			
			/*
			
			balBeforeWagerCurrencyRemoval=getBalanceBeforeWager.replace("R$", "");
			balBeforeWagerCurrencyRemoval.trim();
			exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(",", ".");
			System.out.println("BalBeforeWager:::"+exactBalBeforeWager);
			//test.info("Getting balance before wager::"+exactBalBeforeWager);
			Reporter.log("Balance before wager captured");
			*/
			
	
			
			balBeforeWagerCurrencyRemoval=getBalanceBeforeWager.replace("R$", "");
			balBeforeWagerCurrencyRemoval.trim();
			
			balBeforeWagerCurrencyRemoval=balBeforeWagerCurrencyRemoval.replace(".", "");
			
			String[] strArr=balBeforeWagerCurrencyRemoval.split(",");
			
			int len=strArr.length;
			
			
			if(len>2)
				
			{
				for(int i=0;i<len-1;i++)
				{
					exactBalBeforeWager=exactBalBeforeWager+strArr[i];
				}
				
				exactBalBeforeWager=exactBalBeforeWager+"."+strArr[len-1];
			}
			else
			{
				exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(",", ".");
			}
			
			
			
			//exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(",", ".");
			System.out.println("BalBeforeWager:::"+exactBalBeforeWager);
			//test.info("Getting balance before wager::"+exactBalBeforeWager);
			Reporter.log("Balance before wager captured");
			
			
			
			
		}else if(getBalanceBeforeWager.startsWith("£")){
			balBeforeWagerCurrencyRemoval=getBalanceBeforeWager.replace("£", "");
			balBeforeWagerCurrencyRemoval.trim();
			exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(",", "");
			System.out.println("BalBeforeWager:::"+exactBalBeforeWager);
			//test.info("Getting balance before wager:::"+exactBalBeforeWager);
			Reporter.log("Balance before wager captured");
	}else if(getBalanceBeforeWager.startsWith("$")) {
		balBeforeWagerCurrencyRemoval=getBalanceBeforeWager.replace("$", "");
		balBeforeWagerCurrencyRemoval.trim();
		exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(".", ".");
		System.out.println("BalBeforeWager:::"+exactBalBeforeWager);
		//test.info("Getting balance before wager:::"+exactBalBeforeWager);
		Reporter.log("Balance before wager captured");
	}
	}else if(driver.getCurrentUrl().contains("danskespil")){
		System.out.println("In DS Frame");
		Thread.sleep(1000);
		
		WebElement getBalanceTextBefore=driver.findElement(By.xpath("//*[@class='balance ellipse']/span[2]"));
		String getBalanceBeforeWager=getBalanceTextBefore.getText();
		
		if(getBalanceBeforeWager.contains("kr")){
			
	/*		balBeforeWagerCurrencyRemoval=getBalanceBeforeWager.replace("kr.", "");
			balBeforeWagerCurrencyRemoval.trim();
			balBeforeWagerCurrencyRemoval=balBeforeWagerCurrencyRemoval.replace(".", "");
			exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(",", ".");
			System.out.println("BalBeforeWager:::"+exactBalBeforeWager);
			//test.info("Getting balance before wager::"+exactBalBeforeWager);
			Reporter.log("Balance before wager captured"); */
			
			
			balBeforeWagerCurrencyRemoval=getBalanceBeforeWager.replace("kr.", "");
			balBeforeWagerCurrencyRemoval.trim();
			balBeforeWagerCurrencyRemoval=balBeforeWagerCurrencyRemoval.replace(".", "");
			
			
			String[] strArr=balBeforeWagerCurrencyRemoval.split(",");
			
			int len=strArr.length;
			
			
			if(len>2)
				
			{
				for(int i=0;i<len-1;i++)
				{
					exactBalBeforeWager=exactBalBeforeWager+strArr[i];
				}
				
				exactBalBeforeWager=exactBalBeforeWager+"."+strArr[len-1];
			}
			else
			{
				exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(",", ".");
			}
			
			
			
			//exactBalBeforeWager=balBeforeWagerCurrencyRemoval.replace(",", ".");
			System.out.println("BalBeforeWager:::"+exactBalBeforeWager);
			//test.info("Getting balance before wager::"+exactBalBeforeWager);
			Reporter.log("Balance before wager captured");
			
			
			
			
			
			
		}else{
			System.out.println("Balance capture failed");
	}
		
	}

}
	
	
	public static void balanceAfterWager() throws InterruptedException, AWTException{
		
		Thread.sleep(2000);
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
		
		driver.switchTo().defaultContent();
		System.out.println("Moved to default frame");
		Wait<WebDriver> refreshWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement FH=refreshWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='refresh-balance']/i")));
		WebElement refresh=driver.findElement(By.xpath("//*[@class='refresh-balance']/i"));
		refresh.click();
		System.out.println("Clicked on balance refresh");
		WebElement getBalanceTextAfter=driver.findElement(By.xpath("//*[@class='balance ellipse']/span[2]"));
		String getBalanceAfterWager=getBalanceTextAfter.getText();
		if(getBalanceAfterWager.startsWith("R$")){
						
		/*	balAfterWagerCurrencyRemoval=getBalanceAfterWager.replace("R$", "");
			balAfterWagerCurrencyRemoval.trim();
			exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(",", ".");
			Reporter.log("Balance after wager is captured");
			//test.info("Getting balance after wager:::"+exactBalAfterWager);
			System.out.println("BalAfterWager:::"+exactBalAfterWager);  */
			
			
			
			balAfterWagerCurrencyRemoval=getBalanceAfterWager.replace("R$", "");
			balAfterWagerCurrencyRemoval.trim();
			balAfterWagerCurrencyRemoval=balAfterWagerCurrencyRemoval.replace(".", "");
			
			
			String[] strArr=balAfterWagerCurrencyRemoval.split(",");
			
			int len=strArr.length;
			
			
			if(len>2)
				
			{
				for(int i=0;i<len-1;i++)
				{
					exactBalAfterWager=exactBalAfterWager+strArr[i];
				}
				
				exactBalAfterWager=exactBalAfterWager+"."+strArr[len-1];
			}
			else
			{
				exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(",", ".");
			}	
			
		 // exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(",", ".");
			Reporter.log("Balance after wager is captured");
			//test.info("Getting balance after wager:::"+exactBalAfterWager);
			System.out.println("BalAfterWager:::"+exactBalAfterWager);
			
			
			
		}
		else if(getBalanceAfterWager.startsWith("£")){
			balAfterWagerCurrencyRemoval=getBalanceAfterWager.replace("£", "");
			balAfterWagerCurrencyRemoval.trim();
			exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(",", "");
			Reporter.log("Balance after wawger is captured");
			//test.info("Getting balance after wager:::"+exactBalAfterWager);
			System.out.println("BalAfterWager:::"+exactBalAfterWager);
		}
		else if(getBalanceAfterWager.startsWith("$")){
			balAfterWagerCurrencyRemoval=getBalanceAfterWager.replace("$", "");
			balAfterWagerCurrencyRemoval.trim();
			exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(".", ".");
			Reporter.log("Balance after wawger is captured");
			//test.info("Getting balance after wager:::"+exactBalAfterWager);
			System.out.println("BalAfterWager:::"+exactBalAfterWager);
		}	
		
		
	}else if(driver.getCurrentUrl().contains("danskespil")){
		
		
			
//        Thread.sleep(5000);

			//driver.switchTo().parentFrame();
			Thread.sleep(2000);
			Wait<WebDriver> refreshWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			WebElement FH=refreshWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='refresh-balance']/i")));
			WebElement refresh=driver.findElement(By.xpath("//*[@class='refresh-balance']/i"));
//			refresh.click();
			System.out.println("Clicked on balance refresh");
			WebElement getBalanceTextAfter=driver.findElement(By.xpath("//*[@class='balance ellipse']/span[2]"));
			String getBalanceAfterWager=getBalanceTextAfter.getText();
			if(getBalanceAfterWager.contains("kr")){
				
				
		/*		balAfterWagerCurrencyRemoval=getBalanceAfterWager.replace("kr.", "");
				balAfterWagerCurrencyRemoval.trim();
				balAfterWagerCurrencyRemoval=balAfterWagerCurrencyRemoval.replace(".", "");
				exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(",", ".");
				Reporter.log("Balance after wager is captured");
				//test.info("Getting balance after wager:::"+exactBalAfterWager);
				System.out.println("BalAfterWager:::"+exactBalAfterWager);  */
				 
				
				balAfterWagerCurrencyRemoval=getBalanceAfterWager.replace("kr.", "");
				balAfterWagerCurrencyRemoval.trim();
				balAfterWagerCurrencyRemoval=balAfterWagerCurrencyRemoval.replace(".", "");
				
				
				String[] strArr=balAfterWagerCurrencyRemoval.split(",");
				
				int len=strArr.length;
				
				
				if(len>2)
					
				{
					for(int i=0;i<len-1;i++)
					{
						exactBalAfterWager=exactBalAfterWager+strArr[i];
					}
					
					exactBalAfterWager=exactBalAfterWager+"."+strArr[len-1];
				}
				else
				{
					exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(",", ".");
				}	
				
				//exactBalAfterWager=balAfterWagerCurrencyRemoval.replace(",", ".");
				Reporter.log("Balance after wager is captured");
				//test.info("Getting balance after wager:::"+exactBalAfterWager);
				System.out.println("BalAfterWager:::"+exactBalAfterWager);
				
				
				
			}else {
				System.out.println("Balance capture failed");
			}

	}
		
		
}
	
	public static void balance(){
		
		try {
			balanceBeforeWagering=Double.parseDouble(exactBalBeforeWager);
			balanceAfterWagering=Double.parseDouble(exactBalAfterWager);
	
			
			
			System.out.println("BalanceBeforeWager Double value-->"+balanceBeforeWagering);
			System.out.println("BalanceAfterWager Double value-->"+balanceAfterWagering);
			
			
			wageredAmount= balanceBeforeWagering-balanceAfterWagering;
			
			 DecimalFormat df = new DecimalFormat("######.##");
			
			
			//test.info("Wagered Amount:::"+df.format(wageredAmount));
			Reporter.log("Wagered Amount");
			
			System.out.println("WageredAmount-->"+df.format(wageredAmount));
			
		}catch(NumberFormatException e) {
			System.out.println(e);
		}
		
		}

	public static void getTicketPrice(String ticketPrice)
	{
		
		
		if(ticketPrice.startsWith("R$")){
			ticketPriceText=ticketPrice.replace("R$", "");
			ticketPriceText.trim();
			ticketPriceText=ticketPriceText.replace(",", ".");
			
			Reporter.log("ticketPrice is captured");
			System.out.println("TicketPrice:::"+ticketPriceText);
		}
		else if(ticketPrice.startsWith("£")){
			ticketPriceText=ticketPrice.replace("£", "");
			ticketPriceText.trim();
			ticketPriceText=ticketPriceText.replace(",", "");
			
			Reporter.log("ticketPrice is captured");
			System.out.println("TicketPrice:::"+ticketPriceText);
		}
		else if(ticketPrice.startsWith("$")){
			ticketPriceText=ticketPrice.replace("$", "");
			ticketPriceText.trim();
			ticketPriceText=ticketPriceText.replace(".", ".");
			
			Reporter.log("ticketPrice is captured");
			System.out.println("TicketPrice:::"+ticketPriceText);
		}
		else if(ticketPrice.contains("kr")){
			ticketPriceText=ticketPrice.replace("kr.", "");
			ticketPriceText.trim();
			ticketPriceText=ticketPriceText.replace(",", ".");
			
			Reporter.log("ticketPrice is captured");
			System.out.println("TicketPrice:::"+ticketPriceText);
			
		}else {
			System.out.println("Ticket Price capture failed");
		}
		

	}
	
	
	public static boolean validateBalance()
	{
		boolean flag=true;
		String expectedTicketPrice="";
		String actualTicketPrice="";
		DecimalFormat df = new DecimalFormat("######.##");
		
		
		ticketPrice=Double.parseDouble(ticketPriceText);
		
		expectedTicketPrice=df.format(ticketPrice);
		actualTicketPrice=df.format(wageredAmount);
		
		System.out.println("Expected Ticket price---->"+expectedTicketPrice);
		System.out.println("Actual Ticket price---->"+actualTicketPrice);
		
		
		if(!(actualTicketPrice.equalsIgnoreCase("0")))
		{
		
			if(expectedTicketPrice.equalsIgnoreCase(actualTicketPrice))
				{
			
				test.log(Status.PASS, "Verified Balance after Wagering [Wagered Amount::+"+actualTicketPrice+"]");
			
				}
			else
				{
					test.log(Status.FAIL, "Balance verification is failed with WageredAmount::"+actualTicketPrice+"and Total Tickets Cost::"+expectedTicketPrice);
					flag=false;
				}
		}
		else
		{
			test.log(Status.PASS, "Tickets Purchased with FREE TICKETS successfully [Wagered Amount::+"+actualTicketPrice+"]");
		}
		
		
		return flag;
		
	}



}
