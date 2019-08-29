package com.yair_f.globesweb;
import java.nio.file.Paths;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.yair_f.globespages.GlobesHomePage;
import config.PropertiesFile;

 public class LogOutTest2 {
	
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
 public  void disconnectUser()  {
			 try 
			 {
				  LoginTest1 loginTest = new LoginTest1(); 
				  loginTest.driver = driver;
				  
				  loginTest.loginSession();
				 
		          driver.manage().window().maximize();
		         
			     String email= PropertiesFile.getInstance().getConfig("email");

				 Thread.sleep(5000);

				 System.out.println("Start DisconnectUser function...");
				 
			       GlobesHomePage hp=new  GlobesHomePage(driver);
			       
				 Actions action = new Actions(driver);
		
				 action.moveToElement( hp.userMenu()).build().perform();

				 hp.userMenu().click();
			
			     System.out.println(email + " is Disconnected from globes"); 
			    }
			     catch(Exception ex)
			 {
				 System.out.println("DisconnectUser error occured: " + ex); 
			 }
			    System.out.println("End DisconnectUser function...");
		 }
  @AfterTest
  public void shutDownSelenium() {
			 System.out.println("AfterTest...");
			 
		      driver.quit();
			 
	
		 }
	
	
	
	
	
	
	

}
