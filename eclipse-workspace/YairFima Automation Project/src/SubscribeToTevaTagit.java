import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// TEST 8 : login and subscribe to Tagit TEVA

public class SubscribeToTevaTagit {

public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
		
		 WebDriver driver= new ChromeDriver();
		 
		 // go to tagit Teva Page
		 driver.get("https://www.globes.co.il/news/%D7%98%D7%91%D7%A2.tag");
		 
		 System.out.println (driver.getTitle());   

		 
		 // go to login section
		
		 driver.findElement (By.id("Login_connect_Span")).click();
		 // fill correct credentials in fields
		 
		 driver.findElement(By.id("email")).sendKeys("yair-f@globes.co.il");
		 
		 driver.findElement(By.id("password")).sendKeys("globes18");
		 //click on signin button
		 
		 driver.findElement (By.id("signin")).click();
		 // succesfully signin in globes.co.il
		 
		   Thread.sleep(3000);

		 
		 WebElement TagitBtn = driver.findElement(By.xpath("//*[@id=\"tagit_top_line\"]/div/a"));
		 
		  String jsFunction = TagitBtn.getAttribute("href");
		  
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  js.executeScript(jsFunction);
		  
			 System.out.println ("tagit teva was added succesfully");

		 		  
		  
		
		  

		 
	}

}
