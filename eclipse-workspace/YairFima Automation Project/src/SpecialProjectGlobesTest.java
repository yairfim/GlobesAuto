import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SpecialProjectGlobesTest {

	public static void main(String[] args) throws InterruptedException {
	//Test 1 : Share The Main Project to mail option
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");

	 
	 WebDriver driver= new ChromeDriver();
		 
	 driver.get("https://www.globes.co.il/news/article.aspx?did=1001284014");
	 
	 driver.findElement(By.id("shareTxt")).click();
	 
	driver.findElement(By.xpath("//*[@id='GPage_main']/div[6]/span/a[3]")).click();
	
	 Thread.sleep(5000);
	 
	 driver.findElement(By.className("closetext")).click();
	 
	 driver.manage().window().maximize();

	 
	
			 
	}

}
