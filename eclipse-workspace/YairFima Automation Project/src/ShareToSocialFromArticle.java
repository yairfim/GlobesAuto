import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShareToSocialFromArticle {

public static void main(String[] args) {
	//Test to share article to facebook
	
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
		 
 WebDriver driver= new ChromeDriver();
 
 
 driver.get("https://www.globes.co.il");
 
 driver.findElement(By.xpath("//*[@id='topWrap']/div[1]/div[1]/h2/a")).click();

 
 // Get Link to share on facebook
 String facebookURL = driver.findElement(By.className("facebook")).getAttribute("href");
 
 driver.get(facebookURL);
 
 driver.findElement(By.id("email")).sendKeys("globestest18@gmail.com");

 driver.findElement(By.id("pass")).sendKeys("globes2018");

 driver.findElement(By.name("login")).click();
 
 driver.findElement(By.id("u_0_24")).click();
 
 driver.get("https://www.facebook.com/globestest.globestest.7");
 

	}

}
