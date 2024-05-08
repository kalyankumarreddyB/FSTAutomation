package danskespil;

import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import BaseEngine.baseEngine;
import reusables.BalanceVerification;
import reusables.GetGameList;
import reusables.InGameClick;
import reusables.Login;
import reusables.Logout;
import reusables.TicketPurchase;
import reusables.Windows;
import reusables.winnerWindows;

public class Danskespil_FST  extends baseEngine{
	
	
	@Test
	
	public void danskespilBingo() throws Exception{
			
			boolean flag=false;
			int repeat=0;
		
			URL=excel.getCellData("labelsFST", 8, 0);
			String runMode=excel.getCellData("labelsFST", 8, 1);
			if(!runMode.equalsIgnoreCase("Y")){
				throw new SkipException("Run mode is No");
			}
		
				driver.get(URL);
				Thread.sleep(3000);
				Reporter.log("Site Launched:::"+URL);
				//test.info("Logged into the Portal:::"+URL);
		
				
			Assert.assertTrue(Login.authentication(
						URL,
						excel.getCellData("labelsFST", 8, 2),
						excel.getCellData("labelsFST", 8, 3)), "Login Failed");
				
			
				while(flag==false && repeat>=0)
				{
				
				for(int gameCol=1;gameCol<=excel.getRowCount("Danskespil");gameCol++) {
					System.out.println("In for loop");
					
					if(excel.getCellData("Danskespil", gameCol, 1).equalsIgnoreCase("Y")) 
					{		
					flag=GetGameList.gameDataFST(excel.getCellData("Danskespil", gameCol, 0));
					
					if(flag==true)
					{
					
					InGameClick.skip();
					
					BalanceVerification.balBeforeWager();
					TicketPurchase.ticketPurchaseFST();
					BalanceVerification.balanceAfterWager();
					BalanceVerification.balance();
					Assert.assertTrue(BalanceVerification.validateBalance(), "Balance Verification Failed");
					InGameClick.totalPrizes();
					InGameClick.historyBoardFST();
					winnerWindows.windows(); 
					Windows.winnerSummary();
					InGameClick.betHistory();
					InGameClick.prebuyPurchase();
	 				InGameClick.chatCheck();
					InGameClick.miniGamesCheck();

					((WebStorage) driver).getLocalStorage().clear();
					InGameClick.closeGame();
					
					break;
					}
					}
					
					else 
					{
						System.out.println("Staus of game is NO!!!!");
					}
					
				}
				
				repeat++;
			}
					
					
					Logout.logout(URL);

				
				
				sa.assertAll();		
			
			
			
			
			
			
			
			
			
	}

}
