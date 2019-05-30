import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GlobesLoginTest1 {

public static void main(String[] args) {

//create driver object for chrome browser
	
// Test 1 of globes login with correct "email" and "password"	
	
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
	
 WebDriver driver= new ChromeDriver();
 
 driver.get("https://www.globes.co.il");
 
 driver.findElement (By.id("Login_connect_Span")).click();
 
 driver.findElement(By.id("email")).sendKeys("yair-f@globes.co.il");
 
 driver.findElement(By.id("password")).sendKeys("globes18");
 
 driver.findElement (By.id("signin")).click();
 
 System.out.println (driver.getTitle());
 
 System.out.println("yair-f@globes is succesfuly log in to globes");      
 
 
 
  
 	}

}
