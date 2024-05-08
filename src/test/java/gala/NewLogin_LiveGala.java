package gala;

import java.awt.Button;
 
import java.time.Duration;

import java.util.List;
 
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.openqa.selenium.WebElement;
 
public class NewLogin_LiveGala {
 
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Satish/Drivers/chromedriver.exe");
 
		WebDriver driver = new ChromeDriver();
 
		
		driver.manage().timeouts().implicitlyWait(0, null);
		
 
		driver.manage().window().maximize();
 
		driver.get("https://bingo.galabingo.com/en/bingo/schedule");
 
		Thread.sleep(3000);
 
		driver.findElement(By.linkText("LOG IN")).click();
 
		driver.findElement(By.id("userId")).sendKeys("Raghavendra0884");
 
		Thread.sleep(1000);
 
		driver.findElement(By.name("password")).sendKeys("Ra@123456");
 
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='login w-100 btn btn-primary']")).click();
 
		Thread.sleep(10000);
 
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

		Thread.sleep(10000);
 
		List<WebElement> getRooms = driver.findElements(By.xpath("//div[contains(@class,'schedule-item__title ng-tns-c')]"));
 
		String roomName = "Bargain Wins";
 
		System.out.println("This is getrooms size" + getRooms.size());
 
		for (int i = 0; i < getRooms.size(); i++) {
 
			String currentRoomName = driver

					.findElements(By.xpath("//div[contains(@class,'schedule-item__title ng-tns-c')]")).get(i).getText();
 
			System.out.println(currentRoomName);
 
			if (currentRoomName.contains(roomName)) {
 
				WebElement play = driver.findElements(By.xpath("//button/span[text()='PLAY']")).get(i);
 
				// Object type cast
 
				JavascriptExecutor js = (JavascriptExecutor) driver;
 
				js.executeScript("arguments[0].click();", play);

			}

		}
 
		
/*
	WebElement element = driver.findElement(By.xpath(

		 * "//div[@class='bingo-rooms']/descendant::div[normalize-space()='Bargain Wins']/ancestor::div[contains(@class,'schedule-item__main')]/descendant::button[contains(@class,'play-btn')]"

		 * ));

		 * 

		 * System.out.println(element.getLocation().getX());

		 * 

		 * System.out.println(element.getLocation().getX());

		 * 

		 * int x = element.getLocation().getX();

		 * 

		 * int y = element.getLocation().getY();

		 * 

		 * 

		 * 

		 * 

		 * 

		 * 

		 * //String location= element.getLocation().toString();

		 * 

		 * 

		 * 

		 * // Javascript executor

		 * ((JavascriptExecutor)driver).executeScript("window.scrollBy("+String.valueOf(

		 * x)+","+String.valueOf(y)+")");

		 * 

		 * Thread.sleep(1000);

		 * 

		 * //driver.findElement(By.

		 * xpath("//div[@class='bingo-rooms']/descendant::div[normalize-space()='Bargain Wins']/ancestor::div[contains(@class,'schedule-item__main')]/descendant::button[contains(@class,'play-btn')]"

		 * )).click();

		 * 

		 * System.out.println(driver.getTitle());

		 * 

		 * //Bingo Schedule | Play Now | Gala Bingo

		 * 

		 * Assert.assertEquals(driver.getTitle()

		 * ,"Bingo Schedule | Play Now | Gala Bingo");

		 * 

		 * driver.findElement(By.xpath("//span[text()='Home']")).click();

		 * 

		 * Thread.sleep(10000);

		 * 

		 * //driver.findElement(By.

		 * xpath("//div[@class='h-product-nav tab-nav navbar-nav']/vn-menu-item[2]")).

		 * click();

		 * 

		 * driver.findElement(By.

		 * xpath("//div[@class='h-product-nav tab-nav navbar-nav']/vn-menu-item/preceding-sibling::vn-menu-item/preceding-sibling::vn-menu-item/preceding-sibling::vn-menu-item/preceding-sibling::vn-menu-item/preceding-sibling::vn-menu-item/preceding-sibling::vn-menu-item/following-sibling::vn-menu-item[1]"

		 * )).click();

		 */
 
	}
 
}
