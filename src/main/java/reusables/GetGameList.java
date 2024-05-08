package reusables;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import BaseEngine.baseEngine;

	public class GetGameList extends baseEngine{
		
		public static boolean flag=false;
		
		public static List<WebElement> list=new ArrayList<WebElement>();
		public static CommonActions generalActions=new CommonActions();
		
	public static void gameData(String gameName) throws InterruptedException, EncryptedDocumentException, IOException{

		
	if(!driver.getCurrentUrl().contains("danskespil")) {
			
			
	if(driver.getCurrentUrl().contains("gala")){
		
		//Get game list
		list = driver.findElements(By.xpath(OR.getProperty("getGalaGameList")));
		System.out.println("List::"+list);
		Reporter.log("Getting game list");
		test.info("Getting Game list");
			
			
		for (int i = 0; i < list.size(); i++) {
			
			try {
			
			System.out.println("Size of the list:::" + list.size());
			Thread.sleep(1000);
			//Get game name
				 
			String currentRoomName = driver

						.findElements(By.xpath("//div[contains(@class,'schedule-item__title ng-tns-c')]")).get(i).getText();
	 
			System.out.println("Current Room--->"+currentRoomName);
	 
				if (currentRoomName.equalsIgnoreCase(gameName)) 
				{
					
					System.out.println("Room Found");
					WebElement play = driver.findElements(By.xpath("//button/span[text()='PLAY']")).get(i);
	 
					// Object type cast
					//Launching the game
	 
					executor = (JavascriptExecutor) driver;
	 
					executor.executeScript("arguments[0].click();", play);
					
					test.info("Game Launched:::");
					break;
				}
			}
			catch (Exception e) {
				Thread.sleep(2000);
				e.printStackTrace();
				System.out.println("Flickering Exception occured");
				list = driver.findElements(By.xpath(OR.getProperty("getGalaGameList")));					
			}	
			
				
			
		}
		
	}
	else if(driver.getCurrentUrl().contains("foxy"))
	{						
				
		
				//Get game list
				list = driver.findElements(By.xpath(OR.getProperty("getFoxyGameList")));
				System.out.println("List::"+list);
				Reporter.log("Getting game list");
				test.info("Getting Game list");
				
				int totalGames=list.size();
				
				System.out.println("Size of the list:::"+totalGames);
				
				for (int i = 0; i < totalGames; i++) {
					
					
					try {	
					Thread.sleep(1000);
					//Get game name
					
					String currentRoomName = list.get(i).getText();
			 
					System.out.println("Current Room--->"+currentRoomName);
			 
						if (currentRoomName.equalsIgnoreCase(gameName)) 
						{
							
							System.out.println("Room Found");
							
							//WebElement gameMouseOver = list.get(i);
							
							//WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
							
							WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
							
							
							Actions act = new Actions(driver);
							act.moveToElement(gameMouseOver).click().build().perform();
							
							
							WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='PLAY HERE']"));
									 
							// Object type cast
							//Launching the game
			 
							executor = (JavascriptExecutor) driver;
			 
							executor.executeScript("arguments[0].click();", play);
							
							test.info("Game Launched:::");
							break;
						}
					}
					catch (Exception e) {
						Thread.sleep(2000);
						e.printStackTrace();
						System.out.println("Flickering Exception occured");
						list = driver.findElements(By.xpath(OR.getProperty("getFoxyGameList")));					
					}	
					
						
						
				}
	}
	
	else if(driver.getCurrentUrl().contains("coral"))
	{						
					
				//Get game list
				list = driver.findElements(By.xpath(OR.getProperty("getCoralGameList")));
				System.out.println("List::"+list);
				Reporter.log("Getting game list");
				test.info("Getting Game list");
				
				int totalGames=list.size();
				
				System.out.println("Size of the list:::"+totalGames);
				
				for (int i = 0; i < totalGames; i++) {
					
					try {
					
					Thread.sleep(1000);
					//Get game name
					
					String currentRoomName = list.get(i).getText();
			 
					System.out.println("Current Room--->"+currentRoomName);
			 
						if (currentRoomName.equalsIgnoreCase(gameName)) 
						{
							
							System.out.println("Room Found");
							
							//WebElement gameMouseOver = list.get(i);
							
							//WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
							
							WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
							
							
							Actions act = new Actions(driver);
							act.moveToElement(gameMouseOver).click().build().perform();
							
							
							WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='PLAY HERE']"));
							
							
							
							// Object type cast
							//Launching the game
			 
							executor = (JavascriptExecutor) driver;
			 
							executor.executeScript("arguments[0].click();", play);
							
							test.info("Game Launched:::");
							break;
						}
				}
					catch (Exception e) {
						Thread.sleep(2000);
						e.printStackTrace();
						System.out.println("Flickering Exception occured");
						list = driver.findElements(By.xpath(OR.getProperty("getCoralGameList")));					
					}	
					
				}
				
	}
	
	else if(driver.getCurrentUrl().contains("ladbrokes"))
	{						
				//Get game list
				list = driver.findElements(By.xpath(OR.getProperty("getLadbrokesGameList")));
				System.out.println("List::"+list);
				Reporter.log("Getting game list");
				test.info("Getting Game list");
				
				int totalGames=list.size();
				
				System.out.println("Size of the list:::"+totalGames);
				
				for (int i = 0; i < totalGames; i++) {
					
					try {
					
					Thread.sleep(1000);
					//Get game name
					
					String currentRoomName = list.get(i).getText();
			 
					System.out.println("Current Room--->"+currentRoomName);
			 
						if (currentRoomName.equalsIgnoreCase(gameName)) 
						{
							
							System.out.println("Room Found");
							
							//WebElement gameMouseOver = list.get(i);
							
							//WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
							
							WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
							
							
							Actions act = new Actions(driver);
							act.moveToElement(gameMouseOver).click().build().perform();
							
							
							WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='PLAY HERE']"));
							
							
							
							// Object type cast
							//Launching the game
			 
							executor = (JavascriptExecutor) driver;
			 
							executor.executeScript("arguments[0].click();", play);
							
							test.info("Game Launched:::");
							break;
						}
						
						
					}
				
				catch (Exception e) {
					Thread.sleep(2000);
					e.printStackTrace();
					System.out.println("Flickering Exception occured");
					list = driver.findElements(By.xpath(OR.getProperty("getLadbrokesGameList")));					
				}
			}
	}
	

	else if(driver.getCurrentUrl().contains("sportingbet"))
	{						
				

		
				//Get game list
				list = driver.findElements(By.xpath(OR.getProperty("getSportingBetGameList")));
				System.out.println("List::"+list);
				Reporter.log("Getting game list");
				test.info("Getting Game list");
				
				int totalGames=list.size();
				
				System.out.println("Size of the list:::"+totalGames);
				
				for (int i = 0; i < totalGames; i++) {
					
					try {
					
					Thread.sleep(1000);
					//Get game name
					
					String currentRoomName = list.get(i).getText();
			 
					System.out.println("Current Room--->"+currentRoomName);
			 
						if (currentRoomName.equalsIgnoreCase(gameName)) 
						{
							
							System.out.println("Room Found");
							
							//WebElement gameMouseOver = list.get(i);
							
							//WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
							
							WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
							
							
							Actions act = new Actions(driver);
							act.moveToElement(gameMouseOver).click().build().perform();
							
							
							WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='JOGAR AQUI']"));
							
							
							
							// Object type cast
							//Launching the game
			 
							executor = (JavascriptExecutor) driver;
			 
							executor.executeScript("arguments[0].click();", play);
							
							test.info("Game Launched:::");
							break;
						}
					}
					
					catch (Exception e) {
						Thread.sleep(2000);
						e.printStackTrace();
						System.out.println("Flickering Exception occured");
						list = driver.findElements(By.xpath(OR.getProperty("getSportingBetGameList")));					
					}
				}
	}
	else if(driver.getCurrentUrl().contains("betboo"))
	{						
				
				
		
				//Get game list
				list = driver.findElements(By.xpath(OR.getProperty("getBetbooBetGameList")));
				System.out.println("List::"+list);
				Reporter.log("Getting game list");
				test.info("Getting Game list");
				
				int totalGames=list.size();
				
				System.out.println("Size of the list:::"+totalGames);
				
				for (int i = 0; i < totalGames; i++) {
					
					try {
					
					Thread.sleep(1000);
					//Get game name
					
					String currentRoomName = list.get(i).getText();
			 
					System.out.println("Current Room--->"+currentRoomName);
			 
						if (currentRoomName.equalsIgnoreCase(gameName)) 
						{
							
							System.out.println("Room Found");
							
							//WebElement gameMouseOver = list.get(i);
							
							//WebElement gameMouseOver = driver.findElement(By.xpath("//*[contains(text(),'"+gameName+"')]"));
							
							WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
							
							
							Actions act = new Actions(driver);
							act.moveToElement(gameMouseOver).click().build().perform();
							
							
							WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='JOGAR AQUI']"));
							
							
							
							// Object type cast
							//Launching the game
			 
							executor = (JavascriptExecutor) driver;
			 
							executor.executeScript("arguments[0].click();", play);
							
							test.info("Game Launched:::");
							break;
						}
					}
					
					catch (Exception e) {
						Thread.sleep(2000);
						e.printStackTrace();
						System.out.println("Flickering Exception occured");
						list = driver.findElements(By.xpath(OR.getProperty("getBetbooBetGameList")));					
					}
				}
	}
	

	
	
	
	
	else
	{
		System.out.println("No Game Launch");
	}	
	
	
	}	
	else 
	{
		
		for(int rowCount=1;rowCount<=excel.getRowCount("Danskespil");rowCount++) {
			
			String gameNameDS=excel.getCellData("Danskespil", rowCount, 0);
			
			
			if(gameNameDS.equalsIgnoreCase("Bingostuen") && (excel.getCellData("Danskespil", rowCount, 1).equalsIgnoreCase("Y"))) {
				driver.findElement(By.xpath("//*[@class='bingo-game-list-view-games']/div["+rowCount+"]/a")).click();
				test.info("Game Launched:::");
				break;
			}else if(gameNameDS.equalsIgnoreCase("Bankohallen") && (excel.getCellData("Danskespil", rowCount, 1).equalsIgnoreCase("Y"))) {
				driver.findElement(By.xpath("//*[@class='bingo-game-list-view-games']/div["+rowCount+"]/a")).click();
				test.info("Game Launched:::");
				break;
			}else {
				System.out.println("Failed to launch DS rooms");
				test.info("ailed to launch DS rooms");
			}
			
			
			
		}
	
		
		Thread.sleep(20000);
	}
		
		
		
		
		
	/*
		
		
		if(!driver.getCurrentUrl().contains("danskespil")) {
			//Get game list
			List<WebElement> list = driver.findElements(By.xpath(OR.getProperty("getGameList")));
			System.out.println("List::"+list);
			Reporter.log("Getting game list");
			test.info("Getting Game list");
		for (int i = 1; i <= list.size(); i++) {
			System.out.println("Size of the list:::" + list.size());
			Thread.sleep(1000);
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
				//WebElement gameLaunch = driver.findElement(By.xpath("//*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[3]/div/input[2] | //*[@class='bingo-rooms']/div["+i+"]/div/bg-rooms-item-component/div/div/div[1]/div[2]/div/input[2]"));
				
				WebElement gameLaunch = driver.findElement(By.xpath("/html[1]/body[1]/vn-app[1]/vn-dynamic-layout-slot[5]/vn-main[1]/main[1]/div[1]/bg-main[1]/div[1]/div[1]/bg-roomslist-component[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/bg-rooms-item-component[1]/div[1]/div[1]/div[1]/div[3]/div[1]/input[2]"));
				
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
		
	*/	
		
		
		
			}
	
	
	
	
	public static boolean launchSpecificRoom(String gameName)
	{
		boolean flag=false;
		
		try{
		
		generalActions.checkPageIsReady();
		
		generalActions.waitForElementVisibility(By.xpath("//div[text()='"+gameName+"']/../ancestor::div[contains(@class,'schedule-item__main')]/div/following-sibling::div[contains(@class,'schedule-item-footer')]/button"));
		
		
		try {
		

		WebElement play = driver.findElement(By.xpath("//div[text()='"+gameName+"']/../ancestor::div[contains(@class,'schedule-item__main')]/div/following-sibling::div[contains(@class,'schedule-item-footer')]/button/following-sibling::button[contains(@class,'btn btn-primary')]"));
		
		
		//Launching the game

		executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", play);
		
		flag=true;
		
		}catch(Exception exp)
		{
			
			WebElement play = driver.findElement(By.xpath("//div[text()='"+gameName+"']/../ancestor::div[contains(@class,'schedule-item__main')]/div/following-sibling::div[contains(@class,'schedule-item-footer')]/button"));
			
			executor = (JavascriptExecutor) driver;

			executor.executeScript("arguments[0].click();", play);
			flag=true;
			
		}
		
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
		return flag;
		
	}
	
	
	
	
	public static boolean gameDataFST(String gameName) throws InterruptedException, EncryptedDocumentException, IOException{

		String lobbyTimer="";
		int lobbyTimerValue=0;
		if(!driver.getCurrentUrl().contains("danskespil")) {
				
		
					
	/************ Lobby Timer Logic for Gala Label****************/		
			
	/*		
		if(driver.getCurrentUrl().contains("gala")){
			
			//Get game list
			
			generalActions.checkPageIsReady();
			list = driver.findElements(By.xpath(OR.getProperty("getGalaGameList")));
			System.out.println("List::"+list);
			Reporter.log("Getting game list");
			//test.info("Getting Game list");
				
				
			for (int i = 0; i < list.size(); i++) {
				
				try {
				
				System.out.println("Size of the list:::" + list.size());
				//Thread.sleep(1000);
				//Get game name
					 
				String currentRoomName = driver

							.findElements(By.xpath("//div[contains(@class,'schedule-item__title ng-tns-c')]")).get(i).getText();
				
				System.out.println("Current Room--->"+currentRoomName);
				
				try {
				
				lobbyTimer=driver.findElement(By.xpath("//div[text()='"+currentRoomName+"']/../preceding-sibling::div[contains(@class, 'features-container')]//descendant::span[@class='timestamp']/span")).getText();
				
				System.out.println("Lobby Timer-->"+lobbyTimer);
				if((lobbyTimer.length()<=3))
				{
					lobbyTimer=lobbyTimer.replace("s", "");
					lobbyTimerValue=Integer.parseInt(lobbyTimer);
					System.out.println("Lobby Timer value-->"+lobbyTimerValue);
				}
				else
				{
					lobbyTimerValue=0;
					System.out.println("Lobby Timer value-->"+lobbyTimerValue);
				}
		
				//Thread.sleep(1000);
				}catch(Exception exp)
				{
					//Thread.sleep(1000);
					exp.printStackTrace();
					System.out.println("Timer Flickering Exception occured");
					lobbyTimer=driver.findElement(By.xpath("//div[text()='"+currentRoomName+"']/../preceding-sibling::div[contains(@class, 'features-container')]//descendant::span[@class='timestamp']/span")).getText();
					Thread.sleep(1000);
					if(!(lobbyTimer.contains("m:")))
					{
						lobbyTimer=lobbyTimer.replace("s", "");
						lobbyTimerValue=Integer.parseInt(lobbyTimer);
					}
					System.out.println("Lobby Timer value-->"+lobbyTimerValue);
					
				}
						 
					if ((currentRoomName.equalsIgnoreCase(gameName)) && 
						(lobbyTimer.contains("1m:")||lobbyTimer.contains("2m:")||lobbyTimer.contains("3m:")||(lobbyTimerValue>=30))) 
					{
						System.out.println("Room Found");
						
						
						//WebElement play = driver.findElements(By.xpath("//button/span[text()='PLAY']")).get(i);
						
						WebElement play = driver.findElement(By.xpath("//div[text()='"+currentRoomName+"']/../ancestor::div[contains(@class,'schedule-item__main')]/div/following-sibling::div[contains(@class,'schedule-item-footer')]/button/following-sibling::button[contains(@class,'btn btn-primary')]"));
		 
						// Object type cast
						//Launching the game
		 
						executor = (JavascriptExecutor) driver;
		 
						executor.executeScript("arguments[0].click();", play);
						
						//test.info("Game Launched:::");
						
						flag=true;
						
						break;
					}
				}
				catch (Exception e) {
					Thread.sleep(2000);
					e.printStackTrace();
					System.out.println("Flickering Exception occured");
					list = driver.findElements(By.xpath(OR.getProperty("getGalaGameList")));					
				}	
				
					
				
			}
			
		}    
		
		
		*/
			
			
		
		if(driver.getCurrentUrl().contains("gala")){
				
				//Get game list
				
				generalActions.checkPageIsReady();
				System.out.println("Getting game list");
				list = driver.findElements(By.xpath(OR.getProperty("getGalaGameList")));
				System.out.println("List::"+list);
				Reporter.log("Getting game list");
				//test.info("Getting Game list");
					
					
				for (int i = 0; i < list.size(); i++) {
					
					try {
					
					System.out.println("Size of the list:::" + list.size());
										
					//Get game name
						 
					String currentRoomName = driver

								.findElements(By.xpath("//div[contains(@class,'schedule-item__title ng-tns-c')]")).get(i).getText();
					
					System.out.println("Current Room--->"+currentRoomName);
					
												 
					if ((currentRoomName.equalsIgnoreCase(gameName))) 
						{
							System.out.println("Room Found");
							
							
							WebElement play = driver.findElement(By.xpath("//div[text()='"+currentRoomName+"']/../ancestor::div[contains(@class,'schedule-item__main')]/div/following-sibling::div[contains(@class,'schedule-item-footer')]/button/following-sibling::button[contains(@class,'btn btn-primary')]"));
			 
							//Launching the game
			 
							executor = (JavascriptExecutor) driver;
			 
							executor.executeScript("arguments[0].click();", play);
							
							//test.info("Game Launched:::");
							
							flag=true;
							
							break;
						}
					}
					catch (Exception e) {
						Thread.sleep(2000);
						e.printStackTrace();
						System.out.println("Flickering Exception occured");
						list = driver.findElements(By.xpath(OR.getProperty("getGalaGameList")));					
					}	
					
						
					
				}
				
			}    
					
		else if(driver.getCurrentUrl().contains("foxy"))
		{						
			
			list = driver.findElements(By.xpath(OR.getProperty("getFoxyGameList")));
			System.out.println("List::"+list);
			Reporter.log("Getting game list");
			//test.info("Getting Game list");
			
			int totalGames=list.size();
			
			System.out.println("Size of the list:::"+totalGames);
			
			for (int i = 0; i < totalGames; i++) {
				
				try {	
				
			
				
				String currentRoomName = list.get(i).getText();
		 
				System.out.println("Current Room--->"+currentRoomName);
				
		 
					if (currentRoomName.equalsIgnoreCase(gameName)) 
					{
						
						System.out.println("Room Found");
										
						WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
						
						
						Actions act = new Actions(driver);
						act.moveToElement(gameMouseOver).click().build().perform();
						
						
						WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='PLAY HERE']"));
								 
						// Object type cast
						//Launching the game
		 
						executor = (JavascriptExecutor) driver;
		 
						executor.executeScript("arguments[0].click();", play);
						
						//test.info("Game Launched:::");
						
						flag=true;
			
						break;
					}
				}
				catch (Exception e) {
					Thread.sleep(2000);
					e.printStackTrace();
					System.out.println("Flickering Exception occured");
					list = driver.findElements(By.xpath(OR.getProperty("getFoxyGameList")));					
				}	
				
					
					
			}		
		}
		
		else if(driver.getCurrentUrl().contains("coral"))
		{						
						
					//Get game list
					System.out.println("Getting game list");
					list = driver.findElements(By.xpath(OR.getProperty("getCoralGameList")));
					System.out.println("List::"+list);
					Reporter.log("Getting game list");
					//test.info("Getting Game list");
					
					int totalGames=list.size();
					
					System.out.println("Size of the list:::"+totalGames);
					
					for (int i = 0; i < totalGames; i++) {
						
						try {
						//Get game name
						
						String currentRoomName = list.get(i).getText();
				 
						System.out.println("Current Room--->"+currentRoomName);
				 
							if (currentRoomName.equalsIgnoreCase(gameName)) 
							{
								
								System.out.println("Room Found");
								
								WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
								
								
								Actions act = new Actions(driver);
								act.moveToElement(gameMouseOver).click().build().perform();
								
								
								WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='PLAY HERE']"));
								
								
								
								// Object type cast
								//Launching the game
				 
								executor = (JavascriptExecutor) driver;
				 
								executor.executeScript("arguments[0].click();", play);
								
								//test.info("Game Launched:::");
								
								flag=true;
								
								break;
							}
					}
						catch (Exception e) {
							Thread.sleep(2000);
							e.printStackTrace();
							System.out.println("Flickering Exception occured");
							list = driver.findElements(By.xpath(OR.getProperty("getCoralGameList")));					
						}	
						
					}
					
		}
		
		else if(driver.getCurrentUrl().contains("ladbrokes"))
		{						
					//Get game list
					list = driver.findElements(By.xpath(OR.getProperty("getLadbrokesGameList")));
					System.out.println("Getting Game list");
					System.out.println("List::"+list);
					Reporter.log("Getting game list");
					
					int totalGames=list.size();
					
					System.out.println("Size of the list:::"+totalGames);
					
					for (int i = 0; i < totalGames; i++) {
						
						try {
						//Get game name
						
						String currentRoomName = list.get(i).getText();
				 
						System.out.println("Current Room--->"+currentRoomName);
				 
							if (currentRoomName.equalsIgnoreCase(gameName)) 
							{
								
								System.out.println("Room Found");
								
								WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
								
								
								Actions act = new Actions(driver);
								act.moveToElement(gameMouseOver).click().build().perform();
								
								
								WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='PLAY HERE']"));
								
								
								
								// Object type cast
								//Launching the game
				 
								executor = (JavascriptExecutor) driver;
				 
								executor.executeScript("arguments[0].click();", play);
								
								flag=true;
								
								//test.info("Game Launched:::");
								
								break;
							}
							
							
						}
					
					catch (Exception e) {
						Thread.sleep(2000);
						e.printStackTrace();
						System.out.println("Flickering Exception occured");
						list = driver.findElements(By.xpath(OR.getProperty("getLadbrokesGameList")));					
					}
				}
		}
		

		else if(driver.getCurrentUrl().contains("sportingbet"))
		{						
				
					//Get game list
					System.out.println("Getting Game list");
					list = driver.findElements(By.xpath(OR.getProperty("getSportingBetGameList")));
					System.out.println("List::"+list);
					Reporter.log("Getting game list");
					//test.info("Getting Game list");
					
					int totalGames=list.size();
					
					System.out.println("Size of the list:::"+totalGames);
					
					for (int i = 0; i < totalGames; i++) {
						
						try {
							
						//Get game name
						
						String currentRoomName = list.get(i).getText();
				 
						System.out.println("Current Room--->"+currentRoomName);
				 
							if (currentRoomName.equalsIgnoreCase(gameName)) 
							{
								
								System.out.println("Room Found");
								
								WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
								
								
								Actions act = new Actions(driver);
								act.moveToElement(gameMouseOver).click().build().perform();
								
								
								WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='Jogar Aaui']"));
								
								
								
								// Object type cast
								//Launching the game
				 
								executor = (JavascriptExecutor) driver;
				 
								executor.executeScript("arguments[0].click();", play);
								
								flag=true;
								
								//test.info("Game Launched:::");
								
								break;
							}
						}
						
						catch (Exception e) {
							Thread.sleep(2000);
							e.printStackTrace();
							System.out.println("Flickering Exception occured");
							list = driver.findElements(By.xpath(OR.getProperty("getSportingBetGameList")));					
						}
					}
		}
		else if(driver.getCurrentUrl().contains("betboo"))
		{						
			
					//Get game list
					System.out.println("Getting game list");
					list = driver.findElements(By.xpath(OR.getProperty("getBetbooBetGameList")));
					System.out.println("List::"+list);
					Reporter.log("Getting game list");
					//test.info("Getting Game list");
					
					int totalGames=list.size();
					
					System.out.println("Size of the list:::"+totalGames);
					
					for (int i = 0; i < totalGames; i++) {
						
						try {
							
						//Get game name
						
						String currentRoomName = list.get(i).getText();
				 
						System.out.println("Current Room--->"+currentRoomName);
				 
							if (currentRoomName.equalsIgnoreCase(gameName)) 
							{
								
								System.out.println("Room Found");
								
								WebElement gameMouseOver = driver.findElement(By.xpath("//div[contains(@class,'name-section')]/span[contains(@class,'game-name') and normalize-space()='"+gameName+"']"));
								
								
								Actions act = new Actions(driver);
								act.moveToElement(gameMouseOver).click().build().perform();
								
								
								WebElement play=driver.findElement(By.xpath("//span[contains(@class,'game-name') and normalize-space()='"+gameName+"']/../../preceding-sibling::div[contains(@class,'thumb')]/descendant::input[@value='JOGAR AQUI']"));
								
								
								// Object type cast
								//Launching the game
				 
								executor = (JavascriptExecutor) driver;
				 
								executor.executeScript("arguments[0].click();", play);
								
								flag=true;
								
								//test.info("Game Launched:::");
								
								break;
							}
						}
						
						catch (Exception e) {
							Thread.sleep(2000);
							e.printStackTrace();
							System.out.println("Flickering Exception occured");
							list = driver.findElements(By.xpath(OR.getProperty("getBetbooBetGameList")));					
						}
					}
		}
		
		
		else
		{
			System.out.println("No Game Launch");
		}	
		
		
		}	
		else 
		{
			
			for(int rowCount=1;rowCount<=excel.getRowCount("Danskespil");rowCount++) {
				
				String gameNameDS=excel.getCellData("Danskespil", rowCount, 0);
				
				
				
				
				if(gameNameDS.equalsIgnoreCase("Bingostuen") && (excel.getCellData("Danskespil", rowCount, 1).equalsIgnoreCase("Y"))) {
					driver.findElement(By.xpath("//*[@class='bingo-game-list-view-games']/div["+rowCount+"]/a")).click();
					//test.info("Game Launched:::");
					System.out.println("Game Launched:::");
					flag=true;
					break;
				}else if(gameNameDS.equalsIgnoreCase("Bankohallen") && (excel.getCellData("Danskespil", rowCount, 1).equalsIgnoreCase("Y"))) {
					driver.findElement(By.xpath("//*[@class='bingo-game-list-view-games']/div["+rowCount+"]/a")).click();
					//test.info("Game Launched:::");
					System.out.println("Game Launched:::");
					flag=true;
					break;
				}else {
					System.out.println("Failed to launch DS rooms");
					//test.info("Failed to launch DS rooms");
					
				}
				
				
				
			}
		
			
			Thread.sleep(20000);
		}
			
			
			
			
		return flag;
			
			
				}
	
	
	
		}
	
