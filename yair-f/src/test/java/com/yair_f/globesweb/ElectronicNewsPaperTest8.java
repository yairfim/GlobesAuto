package com.yair_f.globesweb;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yair_f.globespages.EnewsPaperPage;
import com.yair_f.globespages.GlobesHomePage;

import config.PropertiesFile;

public class ElectronicNewsPaperTest8 {
	
	RemoteWebDriver driver;
	
	@BeforeTest
	public void initBrowser (){
		  try 
		 {
			 System.out.println("Start InitBrowser function...");
			 
			 System.setProperty("webdriver.chrome.driver", Paths.get("").toAbsolutePath() + "/src/main/java/webdriver/chromedriver.exe");
			  
			  driver = new ChromeDriver();
               }  
		   catch(Exception ex){
			 System.out.println("InitBrowser error occured: " + ex.getMessage()); 
		    }
		     System.out.println("End InitBrowser function...");
	    } 
	@Test 
	public void electronicNewsPaper () throws Exception {
		
	       String homePageUrl = PropertiesFile.getInstance().getConfig("homePageUrl");

	       driver.get(homePageUrl);
	       
	       GlobesHomePage hp=new  GlobesHomePage(driver);
		   
		   hp.alertPopup().click();
		   
		   hp.sherutBtn();
	      
		   Actions action = new Actions(driver);
		  
		   action.moveToElement(hp.sherutBtn()).build().perform();
		      
		   Thread.sleep(3000);
		
		   hp.eNewsPaperBtn().click();
		      
		   Thread.sleep(5000);
		   
		   EnewsPaperPage en = new  EnewsPaperPage(driver); 
		   
		   en.eNewsDailyEdition().click();
		      
		   System.out.println("User is successfuly log into EnewsPaper Daily Edition ");
	      }
	
	@AfterTest
	 public void shutDownSelenium() {
		  System.out.println("AfterTest...");
		  
	      driver.quit();
	}
}
