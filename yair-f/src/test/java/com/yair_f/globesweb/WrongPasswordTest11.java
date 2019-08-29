package com.yair_f.globesweb;
import java.nio.file.Paths;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.yair_f.globespages.GlobesHomePage;
import com.yair_f.globespages.GlobesLoginPage;

public class WrongPasswordTest11 {
	
	 RemoteWebDriver driver;
 @BeforeTest
 public  void initBrowser() throws Exception {
		 
				 System.out.println("Start InitBrowser function...");
				 
				 System.setProperty("webdriver.chrome.driver", Paths.get("").toAbsolutePath() + "/src/main/java/webdriver/chromedriver.exe");

			     driver = new ChromeDriver();
    }
	@DataProvider(name="getData")
	public Object [][] getData()
	{
		 Object [][] data = new Object [1][3];
		 
		 data [0][0] = "https://www.globes.co.il";
		 data [0][1] = "globestest18@gmail.com";
		 data [0][2] = "globes11";
		 
		return data;
	 }
	
	 @Test(dataProvider="getData")
	 public  void wrongPassword(String homeUrl,String userName,String password) throws Exception {
		 
	      driver.get(homeUrl);
	     
		  System.out.println (driver.getTitle());

	      GlobesHomePage hp=new  GlobesHomePage(driver);
		   
		  hp.alertPopup().click();
		  
		  hp.loginConnectButton().click();
		  
		  GlobesLoginPage lp = new GlobesLoginPage(driver);
		  
		  lp.emailField().sendKeys(userName);
		  
		  lp.passWordField().sendKeys(password);
		  
		  lp.loginBtn().click();
	     
	      Thread.sleep(2000);
	      
	      WebElement errorMessage = lp.errorMessage(); 
	      
	      String errorMessageTemplate = "דוא\"ל או סיסמה לא נכונים";
	      
	      String errorMessageText = errorMessage.getText();	      
	      
	     Assert.assertEquals(errorMessageTemplate,errorMessageText);
	      
	     System.out.println (errorMessageTemplate);
		}
	 @AfterTest
	 public void shutDownSelenium () {
	         System.out.println("AfterTest...");
	         
		     driver.quit();
	 }			 
}