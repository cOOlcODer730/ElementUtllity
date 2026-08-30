package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SVGElement {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://petdiseasealerts.org/forecast-map/#/");
		map-instance-86399
	}
	public static void switchToFrameByIDorName(String frameNameorId) {
		driver.switchTo().frame(frameNameorId);
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
	public static WebElement getElementWithWait(By locator,int timeout) {
		wait =new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static List<WebElement> getElementsWithWait(By locator,int timeout) {
		wait =new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	Public static void doMoveToElement(By locator) {
		
	}
	
	
	
}
