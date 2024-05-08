package reusables;



import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseEngine.baseEngine;
import Utilities.TestUtil;


public class winnerWindows extends InGameClick{
	
	
	public static void windows() throws InterruptedException {
		

		System.out.println("Pot size in winner window:::"+potSize);
		System.out.println("Ball type is:::"+getBallType);
		if(!driver.getCurrentUrl().contains("danskespil")) {
			driver.switchTo().defaultContent() ;
			System.out.println("Switched to default frame in WinnerWindows class");
		}else if(driver.getCurrentUrl().contains("danskespil")) {
			driver.switchTo().parentFrame();
			System.out.println("Switched to default frame in WinnerWindows class - DS");
		}else {
			System.out.println("Failed to switch to frame");
		}
		
		Thread.sleep(1000);
		
		
		if(potSize==3) {
			Windows.FHColor();
		}
		else if( (potSize==4 || potSize==5) && (getBallType.equalsIgnoreCase("80") || getBallType.equalsIgnoreCase("75")|| getBallType.equalsIgnoreCase("50"))) {
			Windows.lineOneColor();
			Windows.FHColor();
		}
		else if(potSize==5) {
			System.out.println("Waiting for winner window");
			Windows.lineOneColor();
			Windows.lineTwoColor();
			Windows.FHColor();
		}
		else if((potSize==6 || potSize==7) && getBallType.equalsIgnoreCase("80")) {
			Windows.lineOneColor();
			Windows.lineTwoColor();
			Windows.lineThreeColor();
			Windows.FHColor();
		}
		else if((potSize==7 || potSize==8) && getBallType.equalsIgnoreCase("75")) {
			Windows.lineOneColor();
			Windows.lineTwoColor();
			Windows.lineThreeColor();
			Windows.lineFourColor();
			Windows.FHColor();
			//Thread.sleep(20000);
		}
		else if((potSize==6 || potSize==7)  && getBallType.equalsIgnoreCase("90")) {
			Windows.lineOneColor();
			Windows.lineTwoColor();
			Windows.FHColor();

			//Thread.sleep(10000);
		}

		
		else if((potSize==6)  && getBallType.equalsIgnoreCase("75")) {
			Windows.lineOneColor();
			Windows.lineTwoColor();
			Windows.lineThreeColor();
			Windows.lineFourColor();
			Windows.FHColor();

			//Thread.sleep(10000);
		}

/*		
		else if(potSize==7 && getBallType.equalsIgnoreCase("90")) {
			Windows.lineOneColor();
			Windows.lineTwoColor();			
			Windows.FHColor();
			Thread.sleep(40000);
			
		}
		else if(potSize==8 && getBallType.equalsIgnoreCase("75")) {
		
			Windows.lineOneColor();
			Windows.lineTwoColor();
			Windows.lineThreeColor();
			Windows.lineFourColor();
			Windows.FHColor();

			
			Thread.sleep(20000);
		}           */
		else {
			System.out.println("Failed to capture winner window");
		}

	}
	

}
