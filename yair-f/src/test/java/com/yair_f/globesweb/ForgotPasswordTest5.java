package com.yair_f.globesweb;
import java.io.IOException;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yair_f.globespages.GlobesHomePage;
import com.yair_f.globespages.GlobesLoginPage;

import config.PropertiesFile;

public class ForgotPasswordTest5 {

	       RemoteWebDriver driver;
 @BeforeTest
 public void initBrowser() {
		 try 
		 {
			 System.out.println("Start InitBrowser function...");
			 System.setProperty("webdriver.chrome.driver", Paths.get("").toAbsolutePath() + "/src/main/java/webdriver/chromedriver.exe");
				
			  driver = new ChromeDriver();	
		 }
		 catch(Exception ex)
		 {
			 System.out.println("InitBrowser error occured: " + ex.getMessage()); 
		 }
		    System.out.println("End InitBrowser function...");
    } 
 @Test 
 public void resetPassword() throws IOException {
	
	     String homePageUrl = PropertiesFile.getInstance().getConfig("homePageUrl");
         String email =       PropertiesFile.getInstance().getConfig("email");
         String password =    PropertiesFile.getInstance().getConfig("password");
         
		 driver.get(homePageUrl);
		 
		  GlobesHomePage hp=new  GlobesHomePage(driver);
		   
		  hp.alertPopup().click();
		  
		  hp.loginConnectButton().click();
		  
	      GlobesLoginPage lp=new  GlobesLoginPage(driver);
	      
	      lp.forgotPwd().click();
	     
	      lp.emailField().sendKeys(email);
	     
	      lp.resetBtn().click();

		 System.out.println (driver.getTitle());

	     System.out.println(" Mail is succesfully sent to " +email); 
		}
	     
 @AfterTest
 public void shutDownSelenium(){
	 System.out.println("AfterTest...");
	 
     driver.quit();
    }

		 
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


