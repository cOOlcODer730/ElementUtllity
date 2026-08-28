package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryADhandle {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://the-internet.herokuapp.com/entry_ad");
			
			By modaltitle_locator= By.xpath("//div[@class='modal-title']");
			By modalbody_locator= By.xpath("//div[@class='modal-body']");
			By close_locator= By.xpath("//p[text()='Close']");
			
//			if(isElementDisplayed(1,modaltitle_locator)) {
//				System.out.println("Element is diplayed");
//			}
//			else
//				System.out.println("Element is not displayed");
				
//			System.out.println(getText(modaltitle_locator));
//			System.out.println(getText(modalbody_locator));
//			doClick(close_locator);
//			System.out.println("done");
//			System.out.println(getTextWithWait(2,modaltitle_locator));
//			System.out.println(getTextWithWait(2,modalbody_locator));
			doClickWithWait(4,close_locator);
			System.out.println("done");
			
	}
	
	public static boolean isElementDisplayed(int timeout,By locator) {
		try{
			return waitforElementVisible(timeout,locator).isDisplayed();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static WebElement waitforElementVisible(int timeout, By locator) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static WebElement waitforElementPresence(int timeout, By locator) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static List<WebElement> waitforALLElementsPresence(int timeout, By locator) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public static List<WebElement> waitforALLElementsVisible(int timeout, By locator) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static String getTextWithWait(int timeout, By locator) {
		return waitforElementVisible(timeout,locator).getText();
	}
	
	public static void doClickWithWait(int timeout, By locator) {
		 waitforElementVisible(timeout,locator).click();
	}
	public static String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	public static void doClick(By locator) {
		 driver.findElement(locator).click();
	}

}
