package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ActionsClass {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions act;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		act= new Actions(driver);
		
		By searchtextbox_locator = By.xpath("//input[contains(@placeholder,'Search for Products...')]");
		
		doActionSendKeysWithWait(searchtextbox_locator,3,"fish");
		clickEnter();

	}
	
	public static void doActionClick(By locator, int timeout) {
		act.click(getElementWithWait(locator,timeout)).build().perform();
	}
	
	public static void doActionSendKeysWithWait(By locator,int timeout,String value) {
		act.sendKeys(getElementWithWait(locator,timeout), value).build().perform();
	}
	
	public static void doActionSendKeys(By locator,String value) {
		act.sendKeys(getElement(locator),value).build().perform();
	}
	
	public static void doMoveToElement() {
		
	}
	
	public static void clickEnter() {
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static WebElement getElementWithWait(By locator,int timeout) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
