import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FogotPasswordTest {

public static void main(String[] args)  {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");
			
		 WebDriver driver= new ChromeDriver();
		 
		 driver.get("https://www.globes.co.il");
		 
		 driver.findElement (By.id("Login_connect_Span")).click();
		 
		 driver.findElement (By.id("forgot_password")).click();
		 
	     driver.findElement (By.id("email")).sendKeys("yair-f@globes.co.il");
		 
	     WebElement ResetBtn =  driver.findElement (By.id("reset_password"));
	     
         // click on the reset button 
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click()", ResetBtn);
	     
	     // mail sent successfully to user for reset password 
	     System.out.println("שלום yair-f@globes.co.il,\r\n" + 
	     		"\r\n" + 
	     		"להחלפת סיסמה חדשה לחץ על הקישור או העתק אותו לדפדפן: \r\n" + 
	     		"https://www.globes.co.il/news/login/change_password.aspx?token=CF4E5DDB-0173-403E-8679-C8C876EC995B&user_id=983312 \r\n" + 
	     		"\r\n" + 
	     		"עליך להיכנס לכתובת זו בתוך 24 שעות. לאחר מכן תידרש לבצע את התהליך מתחילתו. \r\n" + 
	     		"אם בקשה זו לא הגיעה ממך, אנא התעלם מהודעה זו והסיסמה לא תשתנה \r\n" + 
	     		"\r\n" + 
	     		"תודה, \r\n" + 
	     		"צוות גלובס \r\n" + 
	     		"");
	      
	  
	     


 		 
	}

}
