package reusables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import BaseEngine.baseEngine;

public class borgataGetGameList extends baseEngine{
	
	
	public static void borgataGameData() throws InterruptedException{
	 

		List<WebElement> list = driver.findElements(By.xpath("//*[@class='bingo-rooms']/div/div"));
		System.out.println(list);
		Reporter.log("Getting game list");
		test.info("Getting Game list");
		
		for (int i = 1; i <= list.size(); i++) {
			System.out.println("Size of the list:::" + list.size());
			Thread.sleep(1000);
			
			WebElement gameList=driver.findElement(By.xpath("//*[@class='bingo-rooms']/div/div["+i+"]/bg-rooms-item-component/div/div/div[3]/div/span[1]"));
			String getGamesList = gameList.getText();
			System.out.println("GamesList:::" + getGamesList);
			
			if (driver.getCurrentUrl().contains("borgata")&&getGamesList.equalsIgnoreCase("BORGATA 75")) {
				System.out.println(i);
				System.out.println("Found");
				WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'Borgata 75')]"));
				Actions act = new Actions(driver);
				act.moveToElement(gameMouseOver).click().build().perform();
				System.out.println("On game name");
				Thread.sleep(1000);
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div/div["+i+"]/bg-rooms-item-component/div/div/div[1]/div[2]/div/input[2]"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				Reporter.log("Game Launched");
				System.out.println("Clicked2");
				break;
			}else {
				System.out.println("Game not found");
			}
		
		
	}
	

}
}
