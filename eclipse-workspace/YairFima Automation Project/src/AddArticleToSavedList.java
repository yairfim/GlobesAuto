

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddArticleToSavedList {
	//Test of adding specific article to saved articles page

public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
			
		 WebDriver driver= new ChromeDriver();
		 
		 String sArticleID = "https://www.globes.co.il/news/article.aspx?did=1001286537";
		 
		 driver.get(sArticleID);
		 	
		 driver.findElement(By.className("favList")).click();
 
		 driver.findElement(By.id("email")).sendKeys("yair-f@globes.co.il");
		 
		 driver.findElement(By.id("password")).sendKeys("globes18");
		 
		 driver.findElement (By.id("signin")).click();
		 
		 Thread.sleep(3000);
		 
		 driver.get("https://www.globes.co.il/news/home.aspx?fid=10041");


		 List<WebElement> arrElements = driver.findElements(By.className("ListArticles"));
		 
		 for(int i=0; i<arrElements.size(); i++)
		 {
			 WebElement singleElement = arrElements.get(i);
			 
			 WebElement link = singleElement.findElement(By.tagName("a"));
			 
			 String sArticleURL = link.getAttribute("href");
			 
			 if(sArticleURL.equals(sArticleID))
			 {
				 System.out.println("Article " + sArticleID + " exists in saved list!!!");				 
			 }
			 
			 
		 }
		 
		 
		
		 
	}

}