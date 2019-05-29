import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class EnewsPaperTesT {

	public static void main(String[] args) throws InterruptedException {
// Test 7 : open the electronic newspaper on globes with credentials 
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
			
		 WebDriver driver= new ChromeDriver();
		 
		   driver.get("https://www.globes.co.il");
		 
		 driver.findElement (By.id("Login_connect_Span")).click();
		 
		 driver.findElement(By.id("email")).sendKeys("yair-f@globes.co.il");
		 
		 driver.findElement(By.id("password")).sendKeys("globes18");
		 
		 driver.findElement (By.id("signin")).click(); 
		  Thread.sleep(3000);

		 
		 WebElement element = driver.findElement(By.className("sherut"));

	        Actions action = new Actions(driver);

	        action.moveToElement(element).build().perform();

	        driver.findElement(By.xpath("//*[@id='top']/div[2]/div/ul/li[2]/a")).click();
	        
			  Thread.sleep(3000);
			
	        driver.findElement(By.xpath("//*[@id='magazinim-boxes']/div[1]/a[1]/img")).click();
		 
		 
		 
	}

}
