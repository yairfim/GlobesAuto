import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

// Test 6: add NESTLE stock to personal portfolio in globes

public class AddStockToPortfolio {

	public static void main(String[] args) throws InterruptedException {
		
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yair-f\\Desktop\\chromedriver.exe");

 WebDriver driver= new ChromeDriver();
	 
    JavascriptExecutor js = (JavascriptExecutor) driver;
     
    driver.get("https://www.globes.co.il/portal");
    
    //===================Login========================================
    
    driver.findElement (By.id("Login_connect_Span")).click();

    driver.findElement(By.id("email")).sendKeys("yair-f@globes.co.il");
    
    driver.findElement(By.id("password")).sendKeys("globes18");
    
    driver.findElement (By.id("signin")).click();
    
    Thread.sleep(3000);
    
    
  //=====================Scroll & Click to Stock Option===================== 
    
  //WebElement NestleStock = driver.findElement(By.xpath("//*[@id='euro_active']/tbody/tr[2]/td[1]/span/a"));
    
    
    WebElement NestleStock = driver.findElement(By.linkText("נסטלה"));
    
    
    
     
  js.executeScript("arguments[0].scrollIntoView();", NestleStock);
  
  Thread.sleep(300);
  
  js.executeScript("window.scrollBy(0, -110);");
  
  NestleStock.click();
  
  //===========================Click on Add To Portfolio Button===================
  
  WebElement add2tik = driver.findElement(By.className("add2tik"));
  
  String jsFunction = add2tik.getAttribute("href");
  
  js.executeScript(jsFunction);
  
  //=============================Click on Add Button inside IFRAME================= 

  WebElement frame= driver.findElement(By.id("SignWizard_popup_Iframe"));
  
  driver.switchTo().frame(frame);
  
  WebElement el = driver.findElement(By.name("ctl00$UC1$imgConfirmBuySaleMsg"));
  el.click();
  
  Thread.sleep(3000);      
  
  
  //===============================Select Option Checkbox============================
  
  WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='539940']"));
  
  js.executeScript("arguments[0].scrollIntoView();", checkbox);
	 
  Thread.sleep(300);
	 
  js.executeScript("window.scrollBy(0, -110);");
	 
   checkbox.click();
   
   System.out.println("nestle stock is succesfully added to portfolio");
  
	}

}
