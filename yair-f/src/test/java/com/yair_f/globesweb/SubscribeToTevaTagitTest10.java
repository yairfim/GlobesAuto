package com.yair_f.globesweb;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yair_f.globespages.GlobesHomePage;
import com.yair_f.globespages.GlobesLoginPage;
import com.yair_f.globespages.TagitPage;

import config.PropertiesFile;

public class SubscribeToTevaTagitTest10 {
	
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
	public  void subscribeToTagit() throws Exception  {
             String tevaTagitUrl= PropertiesFile.getInstance().getConfig("tevaTagitUrl");
             String email=        PropertiesFile.getInstance().getConfig("email");
	         String password=     PropertiesFile.getInstance().getConfig("password");

			 driver.get(tevaTagitUrl);
			 
			 GlobesHomePage hp=new  GlobesHomePage(driver);
			   
			  hp.alertPopup().click();
			
	         driver.manage().window().maximize();
	         
	         hp.loginConnectButton().click();

	         GlobesLoginPage lp=new  GlobesLoginPage(driver);
	         
	         lp.emailField().sendKeys(email);
	         
	         lp.passWordField().sendKeys(password);
	         
	         lp.loginBtn().click();
 
			 Thread.sleep(3000);
			 
			 TagitPage tp=new TagitPage(driver);
			 
			 tp.tagitBtn().click();

			 String jsFunction =tp.tagitBtn().getAttribute("href");
			  
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			  
			 js.executeScript(jsFunction);
			 
			 System.out.println (driver.getTitle());  
			 
			 Thread.sleep(2000);
			 
			 String expectedMessage = "נרשמת בהצלחה";
			 
		  System.out.println (" Tagit Teva was added succesfully ");
	}
	 @AfterTest
	 public void shutDownSelenium () {
	         System.out.println("AfterTest...");
	         
		      driver.quit();
				 

			 		  
			  
			
			  

			 
		}

	

}
