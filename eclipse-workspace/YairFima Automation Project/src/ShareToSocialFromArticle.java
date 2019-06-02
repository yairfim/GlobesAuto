import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShareToSocialFromArticle {

public static void main(String[] args) {
	//Test 3 :  share  random article to facebook from globes article
	
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
		 
 WebDriver driver= new ChromeDriver();
 
 
 driver.get("https://www.globes.co.il");
 
 driver.findElement(By.xpath("//*[@id='topWrap']/div[1]/div[1]/h2/a")).click();

 // log in and share Link to share on facebook

 FacebookLoginAndShare(driver);
 
 System.out.println("article succesfully shared on facebook feed ");
 
	}
private static void FacebookLoginAndShare (WebDriver dr) {
	 String facebookURL = dr.findElement(By.className("facebook")).getAttribute("href");
	 
	 dr.get(facebookURL);
	 
	 dr.findElement(By.id("email")).sendKeys("globestest18@gmail.com");

	 dr.findElement(By.id("pass")).sendKeys("globes2018");

	 dr.findElement(By.name("login")).click();
	 
	 dr.findElement(By.id("u_0_24")).click();
	 
	 dr.get("https://www.facebook.com/globestest.globestest.7");
}
}
