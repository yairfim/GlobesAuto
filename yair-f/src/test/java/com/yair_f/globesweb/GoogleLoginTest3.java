package com.yair_f.globesweb;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yair_f.globespages.GlobesHomePage;
import com.yair_f.globespages.GlobesLoginPage;
import com.yair_f.globespages.GooglePage;

import config.PropertiesFile;

 public class GoogleLoginTest3 {
	
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
 public  void googleLogin () throws Exception {

            String homePageUrl = PropertiesFile.getInstance().getConfig("homePageUrl");
            String email =       PropertiesFile.getInstance().getConfig("email");
            String password =    PropertiesFile.getInstance().getConfig("password");
		
		  driver.get(homePageUrl);
		 
		  GlobesHomePage hp=new  GlobesHomePage(driver);
		   
		  hp.alertPopup().click();
		  
		  hp.loginConnectButton().click();
		  
		 GlobesLoginPage lp=new  GlobesLoginPage(driver);
		 
		 lp.googleBtn().click();
    
		 System.out.println("Inside Google Login"); 

         Set<String>ids=driver.getWindowHandles();
             
         Iterator<String> it=ids.iterator();
             
         String parentid=it.next();
             
         String childid=it.next();
            		 
         driver.switchTo().window(childid);
             
        System.out.println (driver.getTitle());
        
        GooglePage gp = new  GooglePage(driver);
        
        gp.googleUserName().sendKeys(email);
        
        gp.nextBtn().click();
                
	    Thread.sleep(1000);
	    
	    gp.googlePassword().sendKeys(password);
	    
	    gp.NextBtnLogin().click();
	 
	    System.out.println(email+ " succesffuly Log in to Globes with Google Account");	        			 
       }
 @AfterTest
 public void shutDownSelenium() {
	 System.out.println("AfterTest...");
	 
     driver.quit();
}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
