package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDown {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.astrosage.com/horoscope/");
		 
		 By gender_locator= By.name("astrogender");
		 By day_locator=By.name("astroday");
		 By month_locator=By.name("astromonth");
		 
		 if(isDisplayed(gender_locator,3)) {
			 doSelectByValue(gender_locator,"female");
		 }
		 else
			 System.out.println("Gender not selected");
		 
		 doSelectByVisibleText(day_locator,"7");
		 doSelectByVisibleText(month_locator,"7");
//		 Thread.sleep(2000);
//		 doDeselectByValue(gender_locator,"female");
		 Thread.sleep(2000);
//		 doSelectByValue(gender_locator,"male");
//		 doDeselectByVisibleText(day_locator,"07");
//		 Thread.sleep(2000);
		 doSelectByVisibleText(day_locator,"21");
		

	}
	
	
	
	public static void doSelectByValue(By locator,String value) {
  		Select select= new Select(getElement(locator));
		select.selectByValue(value);
	}
	public static void doSelectByIndex(By locator,int index) {
		Select select= new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void doSelectByVisibleText(By locator,String visibletext) {
		Select select= new Select(getElement(locator));
		select.selectByVisibleText(visibletext);
	}
	public static void doSelectByContainsVisibleText(By locator,String partialvisibletext) {
		Select select= new Select(getElement(locator));
		select.selectByContainsVisibleText(partialvisibletext);
	}
	
	
	public static void doDeselectAll(By locator) {
		Select select= new Select(getElement(locator));
		select.deselectAll();;
	}
	
	public static void doDeselectByValue(By locator,String value) {
		Select select= new Select(getElement(locator));
		select.deselectByValue(value);
	}
	public static void doDeselectByIndex(By locator,int index) {
		Select select= new Select(getElement(locator));
		select.deselectByIndex(index);
	}
	public static void doDeselectByVisibleText(By locator,String visibletext) {
		Select select= new Select(getElement(locator));
		select.deselectByVisibleText(visibletext);;
	}
	public static void doDeselectByContainsVisibleText(By locator,String partialvisibletext) {
		Select select= new Select(getElement(locator));
		select.deSelectByContainsVisibleText(partialvisibletext);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static WebElement getElementWithWait(By locator,int timeout) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static boolean isDisplayed(By locator,int timeout) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
