package Execution;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import reusables.borgataGetGameList;

public class Borgata extends baseEngine{
	
	@Test(dataProviderClass=parameterizationExcel.class,dataProvider="borgata")
	
	public void borgataOnline(String URL,String runMode,String username,String password) throws Exception {
		
		if(!runMode.equalsIgnoreCase("Y")){
			throw new SkipException("Run mode is No");
		}
		
			driver.get(URL);
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			Reporter.log("Site Launched:::"+URL);
			test.info("Logged into the Portal:::"+URL);
			Login.authentication(URL,username,password);
			borgataGetGameList.borgataGameData();
			InGameClick.skip();
			BalanceVerification.balBeforeWager();
			TicketPurchase.ticketPurchase();
			BalanceVerification.balanceAfterWager();
			BalanceVerification.balance();
			InGameClick.totalPrizes();
			InGameClick.jackpotPopup();
			InGameClick.featureClick();	
			InGameClick.historyBoard();
			Windows.lineOneColor();
			Windows.lineTwoColor();
			Windows.FHColor();
			Thread.sleep(5000);
			Windows.winnerSummary();
			Thread.sleep(2000);
			InGameClick.betHistory();
			driver.switchTo().defaultContent();
			InGameClick.prebuyPurchase();
//			InGameClick.chatCheck();
			InGameClick.closeGame();
			Logout.logout(URL);
			
			sa.assertAll();
		
		
	}

}
