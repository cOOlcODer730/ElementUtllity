package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertCheck {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(3000);
		
		By jsAlert_locator= By.xpath("//button[text()='Click for JS Alert']");
		By jsConfirm_locator= By.xpath("//button[text()='Click for JS Confirm']");
		By jsPrompt_locator= By.xpath("//button[text()='Click for JS Prompt']");
		
		doClick(jsAlert_locator);
		System.out.println(getTextAlert(5));
		acceptAlert(5);
		doClick(jsConfirm_locator);
		System.out.println(getTextAlert(5));
		dismissAlert(5);
		doClick(jsConfirm_locator);
		System.out.println(getTextAlert(5));
		acceptAlert(5);
		doClick(jsPrompt_locator);
		System.out.println(getTextAlert(3));
		sendKeysToAlert("Arnab",3);
		acceptAlert(3);
		doClick(jsPrompt_locator);
		System.out.println(getTextAlert(7));
		sendKeysToAlert("Bubun",7);
		dismissAlert(7);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static Alert switchToAlert(){
		 return driver.switchTo().alert();
	}
	
	public static void acceptAlert(){
		switchToAlert().accept();
			
	}
	public static void dismissAlert(){
		switchToAlert().dismiss();	
	}
	public static void sendKeysToAlert(String value){
		switchToAlert().sendKeys(value);	
	}
	
	public static String getTextAlert() {
		 return switchToAlert().getText();
	}
	public static Alert waitForSwitchToAlert(int timeout){
		 wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		 Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		 return alert;
	}
	public static void acceptAlert(int timeout){
		waitForSwitchToAlert(timeout).accept();
			
	}
	public static void dismissAlert(int timeout){
		waitForSwitchToAlert(timeout).dismiss();	
	}
	public static void sendKeysToAlert(String value,int timeout){
		waitForSwitchToAlert(timeout).sendKeys(value);
	}
	public static String getTextAlert(int timeout) {
		 return waitForSwitchToAlert(timeout).getText();
	}
	
}
