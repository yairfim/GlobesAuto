import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterToGlobes {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
		 
		 WebDriver driver= new ChromeDriver();
		 
		 driver.get("https://www.globes.co.il");
		 
		 driver.findElement (By.id("Login_connect_Span")).click();
		 
		 driver.findElement (By.id("register")).click();

		 driver.findElement(By.id("email")).sendKeys("testemail@gmail.com");
		 
		 driver.findElement(By.id("password")).sendKeys("globes20");
		 
		  WebElement checkbox = driver.findElement(By.id("cb"));
		  // checkbox.click();
		    ((JavascriptExecutor)driver).executeScript("arguments[0].click()",checkbox );
		    
		    driver.findElement(By.id("register_and_signin")).click();

 System.out.println("the mail user is succesfuly registerd on globes ");
 }


		 

	}


