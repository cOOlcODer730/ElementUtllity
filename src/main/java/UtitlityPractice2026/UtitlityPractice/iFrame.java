package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iFrame {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://selectorshub.com/iframe-scenario/");
				
				By firstcrush_locator= By.xpath("//input[@placeholder='First Crush']");
				By currentcrush_locator= By.xpath("//input[@placeholder='Current Crush Name']");
				By destiny_locator= By.xpath("//input[@placeholder='Destiny']");
				By containerHeader_locator=By.xpath("//h6[contains(@class,'elementor-heading-title ')]");
				
				switchToFrameByIDorName("pact1");
				doSendKeys(firstcrush_locator,"Arnab");
				
				switchToFrameByIDorName("pact2");
				doSendKeys(currentcrush_locator,"Arnab");
				
				switchToFrameByIDorName("pact3");
				doSendKeys(destiny_locator,"Arnab");
				
				switchToDefaultContent();
				String val= getTextValue(containerHeader_locator);
				System.out.println(val);
				
//				switchToParentFrame();
//				doSendKeys(currentcrush_locator,"tinni");
//				switchToParentFrame();
//				doSendKeys(firstcrush_locator,"tinni");
				
	}
	
	public static void switchToFrameByIDorName(String frameNameorId) {
		driver.switchTo().frame(frameNameorId);
	}
	public static void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	public static void switchToFrameByElement(By locator) {
		driver.switchTo().frame(getElement(locator));
	}
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public static void switchToFrameByIDorNameWithWait(String frameNameorId, int timeout) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameorId));	
	}
	public static void switchToFrameByFrameLocatorWithWait(By framelocator, int timeout) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
	}
	public static void switchToFrameByFrameElementWithWait(WebElement frameElement, int timeout) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	public static void switchToFrameByFrameIndexWithWait(int frameindex, int timeout) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
	}
	
	public static void doSendKeys(By locator,String value) {
		WebElement ele= getElement(locator);
		ele.clear();
		ele.sendKeys(value);
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static String getTextValue(By locator) {
		return getElement(locator).getText();
	}

}
