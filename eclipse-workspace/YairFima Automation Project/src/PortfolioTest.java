import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PortfolioTest {

public static void main(String[] args) {
	//Test 2 : landing on portfolio page & login with incorrect password . 
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");

	 WebDriver driver= new ChromeDriver();
	 
	 driver.get("https://www.globes.co.il/portal/portfolio.aspx?fid=1954");
		 
	 driver.findElement (By.id("Login_connect_Span")).click();
		 
	 driver.findElement(By.id("email")).sendKeys("yair-f@globes.co.il");
		 
	 driver.findElement(By.id("password")).sendKeys("gloes18");
		 
	 driver.findElement (By.id("signin")).click();
	 		 
	 driver.findElement(By.xpath("//*[@id='cancel_login']/img")).click(); // x button

	 
	 




	}

}
