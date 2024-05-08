package cheeky;

import static org.testng.Assert.assertEquals;

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

public class Cheeky extends baseEngine{
	
	
	@Test
	
	public  void cheekyBingo() throws Exception {
		
		
		URL=excel.getCellData("labelsFST", 2, 0);
		String runMode=excel.getCellData("labelsFST", 2, 1);
		if(!runMode.equalsIgnoreCase("Y")){
			throw new SkipException("Run mode is No");
		}
	
			driver.get(URL);
			Thread.sleep(3000);

			Reporter.log("Site Launched:::"+URL);
			test.info("Logged into the Portal:::"+URL);
			Login.authentication(
					URL,
					excel.getCellData("labelsFST", 2, 2),
					excel.getCellData("labelsFST", 2, 3));
//				Assert.assertEquals(true, false);
			for(int gameCol=1;gameCol<=excel.getRowCount("CheekyBingo");gameCol++) {
				System.out.println("In for loop");
				if(excel.getCellData("CheekyBingo", gameCol, 1).equalsIgnoreCase("Y")) {
				GetGameList.gameData(excel.getCellData("CheekyBingo", gameCol, 0));
				InGameClick.skip();
				BalanceVerification.balBeforeWager();
				TicketPurchase.ticketPurchase();
				BalanceVerification.balanceAfterWager();
				BalanceVerification.balance();
				InGameClick.totalPrizes();
				InGameClick.jackpotPopup();
				InGameClick.featureClick();	
				InGameClick.historyBoard();
//				Windows.lineOneColor();
//				Windows.lineTwoColor();
//				Windows.FHColor();
				winnerWindows.windows();
				Thread.sleep(2000);
				Windows.winnerSummary();
				Thread.sleep(2000);
//				InGameClick.betHistory();
				InGameClick.prebuyPurchase();
				InGameClick.chatCheck();

				((WebStorage) driver).getLocalStorage().clear();
				InGameClick.closeGame();

				}
				else {
					System.out.println("Staus of game is NO!!!!");
				}
				}
				
				
				Logout.logout(URL);

			
			
			sa.assertAll();
		
		
	}
	

	
	

}
