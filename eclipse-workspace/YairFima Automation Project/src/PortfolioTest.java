import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PortfolioTest {

private static String sDriverURL = "https://www.globes.co.il/portal/portfolio.aspx?fid=1954";
	
public static void main(String[] args) {
	//Test 2 : landing on portfolio page & login with correct password and going to portfolio page with stocks
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");

	 WebDriver driver= new ChromeDriver();
	 
	 driver.get(sDriverURL);
		 
	  Login(driver);
	  
		 driver.manage().window().maximize();

	  		 
	// driver.findElement(By.xpath("//*[@id='cancel_login']/img")).click(); // to dismiss window with x button
	 


	  WebElement add2tik = driver.findElement(By.xpath("//*[@id='contentColumn']/div[1]/a"));
	  
	  String jsFunction = add2tik.getAttribute("href");
	  
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript(jsFunction); 
	 




	}

private static void Login(WebDriver driver)
{
	 driver.findElement (By.id("Login_connect_Span")).click();
	 
	 driver.findElement(By.id("email")).sendKeys("yair-f@globes.co.il");
		 
	 driver.findElement(By.id("password")).sendKeys("globes18"); 
		 
	 driver.findElement (By.id("signin")).click();
}

}
