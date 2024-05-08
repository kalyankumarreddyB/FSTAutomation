package Execution;


import org.openqa.selenium.html5.WebStorage;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import BaseEngine.baseEngine;
import Utilities.parameterizationExcel;
import reusables.BalanceVerification;
import reusables.GetGameList;
import reusables.InGameClick;
import reusables.Login;
import reusables.Logout;
import reusables.TicketPurchase;
import reusables.Windows;
import reusables.winnerWindows;

public class ExecutionEngine2 extends baseEngine{
	
	@Test
	public  void AlllabelsFST() throws Exception{

	
	
//		System.out.println("excelURL:::"+ URL);
		String runMode=excel.getCellData("labelsFST", 4, 1);
		if(!runMode.equalsIgnoreCase("Y")){
			throw new SkipException("Run mode is No");
		}
	
			driver.get(excel.getCellData("labelsFST", 4, 0));
			Thread.sleep(7000);
//			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
//			Reporter.log("Site Launched:::"+URL);
//			test.info("Logged into the Portal:::"+URL);
			
			
			Login.authentication(
								excel.getCellData("labelsFST", 4, 0),
								excel.getCellData("labelsFST", 4, 2),
								excel.getCellData("labelsFST", 4, 3));
//			for(int gameCol=1;gameCol<=excel.getRowCount("CheekyBingo");gameCol++) {
//				System.out.println("In for loop");
//			if(excel.getCellData("CheekyBingo", gameCol, 1).equalsIgnoreCase("Y")) {
//			GetGameList.gameData(excel.getCellData("CheekyBingo", gameCol, 0));
//			InGameClick.soundOption();
//			InGameClick.skip();
//			
//			BalanceVerification.balBeforeWager();
//			TicketPurchase.ticketPurchase();
//			BalanceVerification.balanceAfterWager();
//			BalanceVerification.balance();
//			InGameClick.totalPrizes();
//			InGameClick.jackpotPopup();
//			InGameClick.featureClick();	
//			InGameClick.historyBoard();
////			Windows.lineOneColor();
////			Windows.lineTwoColor();
////			Windows.FHColor();
//			winnerWindows.windows();
//			Thread.sleep(5000);
//			Windows.winnerSummary();
//			Thread.sleep(2000);
////			InGameClick.betHistory();
//			InGameClick.prebuyPurchase();
////			InGameClick.chatCheck();
//
//			
//			((WebStorage) driver).getLocalStorage().clear();
//			InGameClick.closeGame();

			
//			}
//			else {
//				System.out.println("Staus of game is NO!!!!");
//			}
//			}
			
			
			Logout.logout(URL);

//			System.out.println(result.getStatus());
			
			
			sa.assertAll();
	}
	
	
}

