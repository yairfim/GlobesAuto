package com.yair_f.globesweb;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.yair_f.globespages.FacebookPage;
import com.yair_f.globespages.GlobesArticlePage;
import com.yair_f.globespages.GlobesHomePage;
import config.PropertiesFile;

 public class ShareMainArticleToFbTest9 {
	 
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
  public  void shareArticleToFb () throws Exception {
	                 String homePageUrl = PropertiesFile.getInstance().getConfig("homePageUrl");
                     String email =       PropertiesFile.getInstance().getConfig("email");
                     String password =    PropertiesFile.getInstance().getConfig("password");
                     String fbProfileUrl= PropertiesFile.getInstance().getConfig("fbProfileUrl");

		              driver.get(homePageUrl);
		              
		              GlobesHomePage hp=new  GlobesHomePage(driver);
		       	   
		       	      hp.alertPopup().click();
	       
		  	          driver.manage().window().maximize();
		  	          
		  	          hp.mainArticle().click();

		 	          Thread.sleep(4000);
		 	          
		 	          GlobesArticlePage ap =new  GlobesArticlePage(driver);
		 	         
		             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ap.fbShareBtn());
		            
					 Thread.sleep(3000);
					   
					 ap.fbShareBtn().click();
					  
		             Set<String>ids=driver.getWindowHandles();
		             
		             Iterator<String> it=ids.iterator();
		             
		             String parentid=it.next();
		             
		             String childid=it.next();
		            		 
		             driver.switchTo().window(childid);
		             
		             FacebookPage fp =new  FacebookPage(driver);
		             
		             fp.fbEmail().sendKeys(email);
		             
		             fp.fbPassword().sendKeys(password);
		             
		             fp.fbLoginBtn().click();
		             
		             fp.fbPublishBtn().click();

		             driver.get(fbProfileUrl);
		             
		  	         driver.manage().window().maximize();

		             driver.navigate().refresh();

		             System.out.println(" Main article succesfully shared on facebook wall  ");
		     }
  @AfterTest
  public void shutDownSelenium() {
		            System.out.println("AfterTest...");
		            
		  	      // driver.quit();
	     }
	}



