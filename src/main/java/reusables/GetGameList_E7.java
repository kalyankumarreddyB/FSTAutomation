package reusables;


import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import BaseEngine.baseEngine;

	public class GetGameList_E7 extends baseEngine{
		
	public static void gameData(String gameName) throws InterruptedException, EncryptedDocumentException, IOException{

		System.out.println("Before List");
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
			//Get game list
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='bingo-rooms']/div/descendant::div[@class='ngucarousel-items']"));
			System.out.println("List::"+list);
			Reporter.log("Getting game list");
			test.info("Getting Game list");
		for (int i = 1; i <= list.size(); i++) {
			System.out.println("Size of the list:::" + list.size());
			Thread.sleep(2000);
			//Get game name
			WebElement gameList=driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[3]/div/span[2] | //*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[4]/div/span[2] | //*[@class='bingo-rooms']/div["+i+"]/div/bg-game-item-cozy-component/div/div/div[1]/div[1]/div[2]/div[2]/div[1]"));
			String getGamesList = gameList.getText();
			System.out.println("GamesList:::" + getGamesList);
			
			if (driver.getCurrentUrl().contains("cheeky")&&getGamesList.equalsIgnoreCase(""+gameName+"")) {	
			System.out.println("gameName:::"+gameName);
			System.out.println(i);
				System.out.println("Found");
				WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
				Actions act = new Actions(driver);
				act.moveToElement(gameMouseOver).click().build().perform();
				//Launching the game
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[3]/div/input[2] | //*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[2]/div[3]/div/input[2] | //*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[2]/div/input[2]"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				Reporter.log("Game Launched");
				test.info("Game Launched:::"+getGamesList);
				System.out.println("Clicked2");
				break;
			}else if(driver.getCurrentUrl().contains("foxy")&& getGamesList.equalsIgnoreCase(""+gameName+"")){				
				System.out.println(i);
				System.out.println("Found");
				
				Reporter.log("Game found");
				WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
				Actions act = new Actions(driver);
				act.moveToElement(gameMouseOver).click().build().perform();
				//Launching the game
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[3]/div/input[2] | //*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[2]/div/input[2]"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				Reporter.log("Game Launched");
				test.info("Game Launched:::"+getGamesList);
				System.out.println("Clicked2");
				break;
			}else if(driver.getCurrentUrl().contains("coral")&& getGamesList.equalsIgnoreCase(""+gameName+"")){				
				System.out.println(i);
				System.out.println("Found");
				
				Reporter.log("Game found");
				WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
				Thread.sleep(2000);
				Actions act = new Actions(driver);
				act.moveToElement(gameMouseOver).click().build().perform();
				System.out.println("Clicked");
				//Launching the game
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[3]/div/input[2]"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				test.info("Game Launched:::"+getGamesList);
				System.out.println("Clicked2");
				break;
			}else if(driver.getCurrentUrl().contains("ladbrokes")&& getGamesList.equalsIgnoreCase(""+gameName+"")){				
				System.out.println(i);
				System.out.println("Found");
				
				Reporter.log("Game found");
				WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
				Thread.sleep(1000);
				Actions act = new Actions(driver);
				act.moveToElement(gameMouseOver).click().build().perform();
				//Launching the game
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[3]/div/input[2]"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				test.info("Game Launched:::"+getGamesList);
				System.out.println("Clicked2");
				break;
			}else if(driver.getCurrentUrl().contains("sportingbet")&& getGamesList.equalsIgnoreCase(""+gameName+"")){				
				System.out.println(i);
				System.out.println("Found");
				
				Reporter.log("Game found");
				WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
				Thread.sleep(1000);
				Actions act = new Actions(driver);
				act.moveToElement(gameMouseOver).click().build().perform();
				System.out.println("Clicked on game name");
				//Launching the game
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[3]/div/input[2]"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				test.info("Game Launched:::"+getGamesList);
				System.out.println("Clicked2");
				break;
			}else if(driver.getCurrentUrl().contains("gala")&& getGamesList.equalsIgnoreCase(""+gameName+"")){
				System.out.println(i);
				System.out.println("Found");
				//Launching the game
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-game-item-cozy-component/div/div/div[2]/button[2]/span"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				test.info("Game Launched:::"+getGamesList);
				break;
			}else if(driver.getCurrentUrl().contains("betboo")&& getGamesList.equalsIgnoreCase(""+gameName+"")){				
				System.out.println(i);
				System.out.println("Found");
				
				Reporter.log("Game found");
				WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
				Thread.sleep(1000);
				Actions act = new Actions(driver);
				act.moveToElement(gameMouseOver).click().build().perform();
				//Launching the game
				WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[3]/div/input[2]"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", gameLaunch);
				test.info("Game Launched:::"+getGamesList);
				break;
			}
			else{
				System.out.println("No Game Launch");
			}
		}
		
	}else {
		
		for(int rowCount=1;rowCount<=excel.getRowCount("Danskespil");rowCount++) {
			
			String gameNameDS=excel.getCellData("Danskespil", rowCount, 0);
			
			
			if(gameNameDS.equalsIgnoreCase("Bingostuen") && (excel.getCellData("Danskespil", rowCount, 1).equalsIgnoreCase("Y"))) {
				driver.findElement(By.xpath("//*[@class='bingo-game-list-view-games']/div["+rowCount+"]/a")).click();
			}else if(gameNameDS.equalsIgnoreCase("Bankohallen") && (excel.getCellData("Danskespil", rowCount, 1).equalsIgnoreCase("Y"))) {
				driver.findElement(By.xpath("//*[@class='bingo-game-list-view-games']/div["+rowCount+"]/a")).click();
			}else {
				System.out.println("Failed to launch DS rooms");
			}
			
			
			
		}
	
		
		Thread.sleep(40000);
	}
		
			}
		}
	
