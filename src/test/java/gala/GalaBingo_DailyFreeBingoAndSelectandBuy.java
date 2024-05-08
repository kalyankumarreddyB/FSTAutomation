package gala;

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

public class GalaBingo_DailyFreeBingoAndSelectandBuy extends baseEngine {
	
	
	@Test
	
	public void galaBingo() throws Exception{
		
	
		
	
		URL=excel.getCellData("labelsFST", 5, 0);
		String runMode=excel.getCellData("labelsFST", 5, 1);
		if(!runMode.equalsIgnoreCase("Y"))
		{
			throw new SkipException("Run mode is No");
		}
	
			driver.get(URL);
			Thread.sleep(3000);
			Reporter.log("Site Launched:::"+URL);
			//test.info("Logged into the Portal:::"+URL);
	
			
		Assert.assertTrue(Login.authentication(
					URL,
					excel.getCellData("labelsFST", 5, 2),
					excel.getCellData("labelsFST", 5, 3)), "Login Failed");
			
		
		
		
		
					GetGameList.launchSpecificRoom("Daily Free Bingo");
					InGameClick.skip();
					InGameClick.claimFreeTickets();
					
					
					((WebStorage) driver).getLocalStorage().clear();
					InGameClick.closeGame();
					
					GetGameList.launchSpecificRoom("£150k Bingo");
					InGameClick.skip();
					InGameClick.validateSelectAndBuyTickets();
					
				
/*				
				BalanceVerification.balBeforeWager();
				TicketPurchase.ticketPurchaseFST();
				BalanceVerification.balanceAfterWager();
				BalanceVerification.balance();
				BalanceVerification.validateBalance();
				InGameClick.totalPrizes();
				InGameClick.historyBoardFST();
				winnerWindows.windows(); 
				Thread.sleep(2000);   
				Windows.winnerSummary();
				Thread.sleep(2000);
				InGameClick.betHistory();
				InGameClick.prebuyPurchase();
 				InGameClick.chatCheck();
				InGameClick.miniGamesCheck();  */

				((WebStorage) driver).getLocalStorage().clear();
				InGameClick.closeGame();
									
				Logout.logout(URL);

			
			
		
	}

}
