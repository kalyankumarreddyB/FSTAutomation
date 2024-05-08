package reusables;

import java.time.Duration;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseEngine.baseEngine;

public class CommonActions extends baseEngine {
	
	public Wait<WebDriver> wait;
	
	public void waitforElement(int timeOut, int pollTime, By element)
	{
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollTime))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
			
	public void waitforElementClickable(int timeOut, int pollTime, WebElement element)
	{
			wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(pollTime))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
				
		
	}
	
	public WebElement webDriverWaitforElementClickable(int time,WebElement element)
	{
			wait = new WebDriverWait(driver,time);				
					
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			return element;		
		
	}
	
	public void waitForElementsVisibility(By locator)
	{
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	
	public void waitForElementVisibility(By locator)
	{
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	
	public void waitForElementToBeClickable(By locator)
	{
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	
	public void waitForTicketPriceVisibility(By locator)
	{
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	public void waitForClaimFreeTktVisibility(By locator)
	{
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	
	
	
	public void waitForLoginErrorVisibility(By locator)
	{
		wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	
	
	
	
	public void waitForElementLocated(By locator)
	{
		wait=new WebDriverWait(driver, 300);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void waitforLoading(int time, By loader)
	{
			
			
			wait = new WebDriverWait(driver,time);				
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(loader));	
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));		
		
	}
	
	
	public boolean isStaleElement(WebElement element)
	{
			try {
				element.isDisplayed();
				return false;
				
			}catch (StaleElementReferenceException se) {
				
				return true;
				
			} 
			catch (Exception exp) {
				
				System.err.println("Got an expection other than StaleElement");
				exp.printStackTrace();
				return true;
			}
			
				
		
	}
	
	
	public void checkPageIsReady() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		if(js.executeScript("return document.readyState").toString().equals("complete"))
		{
			return;
		}
		
		for(int i=1;i<=60;i++)
		{
			try 
			{
				staticWait(1000);
				
			} catch (InterruptedException e)
			{
				if(js.executeScript("return document.readyState").toString().equals("complete"))
				{
					break;
				}			
			}
		}
		
	}
	
	public void staticWait(int time) throws InterruptedException
	{
		Thread.sleep(time);	
		
	}
	
	
	

}
