package com.yair_f.globesweb;
import java.io.IOException;
import java.nio.file.Paths;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.yair_f.globespages.GlobesHomePage;
import com.yair_f.globespages.GlobesLoginPage;
import config.PropertiesFile;

public class RegisterToGlobesTest4 {
	
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
  public void registration () throws IOException {
     String homePageUrl= PropertiesFile.getInstance().getConfig("homePageUrl");
	 String newUserMail = PropertiesFile.getInstance().getConfig("newUserMail");
     String password = PropertiesFile.getInstance().getConfig("password");
     
	 driver.get(homePageUrl);
	 
	  GlobesHomePage hp=new  GlobesHomePage(driver);
	   
	  hp.alertPopup().click();
	  
	  hp.loginConnectButton().click();
	  
	  GlobesLoginPage lp=new  GlobesLoginPage(driver);
	  
	  lp.registerlink().click();
	  
	  lp.emailField().sendKeys(newUserMail);
	  
	  lp.passWordField().sendKeys(password);
	 
	  lp.checkBox();

	 ((JavascriptExecutor)driver).executeScript("arguments[0].click()",lp.checkBox());
	 
	  lp.createAccountBtn().click();
	  
      System.out.println(newUserMail+  " succesfuly registerd on globes ");
      }
  @AfterTest
  public void shutDownSelenium() {
 	 System.out.println("AfterTest...");
 	 
     //driver.quit();
    }
 	
}
