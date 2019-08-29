package com.yair_f.globesweb;
import java.nio.file.Paths;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.yair_f.globespages.GlobesArticlePage;
import com.yair_f.globespages.GlobesHomePage;
import com.yair_f.globespages.GlobesLoginPage;
import com.yair_f.globespages.SavedArticlesPage;
import config.PropertiesFile;

public class AddArticleToSaveListTest7 {

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
	public void addArticle () throws Exception {
		     String savedArticleID =      PropertiesFile.getInstance().getConfig("savedArticleID");
		     String savedArticleListURL = PropertiesFile.getInstance().getConfig("savedArticleListUrl");
		     String email =               PropertiesFile.getInstance().getConfig("email");
		     String password =            PropertiesFile.getInstance().getConfig("password");
		     		     
		      driver.get(savedArticleID);
		     
	          driver.manage().window().maximize();
		     
		       GlobesHomePage hp=new  GlobesHomePage(driver);
			   
			   hp.alertPopup().click();
			    
		       JavascriptExecutor js = (JavascriptExecutor) driver;

		       GlobesArticlePage ap=new  GlobesArticlePage(driver);
		       
			    js.executeScript("arguments[0].scrollIntoView();",  ap.favoriteListBtn());
			   
			    Thread.sleep(300);
			 
			     ap.favoriteListBtn().click();
			  
				 GlobesLoginPage lp=new  GlobesLoginPage(driver);

				 lp.emailField().sendKeys(email);
				 
				 lp.passWordField().sendKeys(password);
				 
				 lp.loginBtn().click();
				 
			     System.out.println(email + " is succesfuly log in to globes"); 

			     Thread.sleep(3000);
			 
			     driver.get(savedArticleListURL);
			     
				 System.out.println (driver.getTitle());
			     
			     SavedArticlesPage sap = new SavedArticlesPage(driver);

			     WebElement arrElements = sap.saved();
			    
				System.out.println("Article " + savedArticleID + " exists in saved list!!!");	
			 }		   
	@AfterTest
	public void shutDownSelenium() {
		           System.out.println("AfterTest...");
		           
	               driver.quit();
	    }
	}
	
	
	
	
	
	
	
	
	
	
	

