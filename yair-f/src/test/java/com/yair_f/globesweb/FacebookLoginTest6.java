package com.yair_f.globesweb;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.yair_f.globespages.FacebookPage;
import com.yair_f.globespages.GlobesHomePage;
import com.yair_f.globespages.GlobesLoginPage;
import config.PropertiesFile;

public class FacebookLoginTest6 {
	
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
 public void facebookLogin () throws Exception  {
		try 
		 {
		  System.out.println("Start LoginSession function...");
		  
		     String homePageUrl = PropertiesFile.getInstance().getConfig("homePageUrl");
		     String email =       PropertiesFile.getInstance().getConfig("email");
		     String password =    PropertiesFile.getInstance().getConfig("password");
		     
		     driver.get(homePageUrl);
		     
		     GlobesHomePage hp=new  GlobesHomePage(driver);
			   
			  hp.alertPopup().click();
	  
	         Thread.sleep(3000);
	         
             hp.loginConnectButton().click();
             
        	 GlobesLoginPage lp=new  GlobesLoginPage(driver);
        	 
             lp.facebookBtn().click();
     
            Set<String>ids=driver.getWindowHandles();
     
           Iterator<String> it=ids.iterator();
     
           String parentid=it.next();
     
          String childid=it.next();
    		 
          driver.switchTo().window(childid);
     
	     System.out.println (driver.getTitle());

	     FacebookPage fp =new  FacebookPage(driver);
        
         fp.fbEmail().sendKeys(email);
        
         fp.fbPassword().sendKeys(password);
        
         fp.fbLoginBtn().click();
        
      System.out.println(email+  " is succesfully log in with facebook account ");
		 }
     catch(Exception ex)
	 {
		 System.out.println("LoginSession error occured: " + ex.getMessage()); 
	 
         System.out.println("End LoginSession function...");
     }

   }  
 @AfterTest
 public void shutDownSelenium() {
		 System.out.println("AfterTest...");
		 
	      driver.quit();
	}
}
