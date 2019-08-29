package com.yair_f.globespages;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class GlobesHomePage {
   WebDriver driver;
public GlobesHomePage(WebDriver driver){
		
	this.driver=driver;	

	}

By alertPopup=By.cssSelector(".btnBlocked");

By loginConnectButton=By.id("Login_connect_Span");

By mainArticle =By.cssSelector("#mainArticleImg");

By sherutBtn = By.className("sherut");

By eNewsPaperBtn = By.cssSelector(".sherut > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1");

By userMenu = (By.className("userPH"));

By disconnectBtn = By.linkText("התנתקות");

public WebElement alertPopup() {

return driver.findElement(alertPopup);

    }
public WebElement loginConnectButton() {

return driver.findElement(loginConnectButton);

    }
public WebElement mainArticle() {

return driver.findElement(mainArticle);

    }
public WebElement sherutBtn() {

return driver.findElement(sherutBtn);

    }
public WebElement eNewsPaperBtn() {

return driver.findElement(eNewsPaperBtn);

    }
public WebElement userMenu() {

return driver.findElement(userMenu);

    }
public WebElement disconnectBtn() {

return driver.findElement(disconnectBtn);

    }
}