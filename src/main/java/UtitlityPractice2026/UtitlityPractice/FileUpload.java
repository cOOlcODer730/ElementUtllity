package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		
		By choosefile_locator= By.id("file-upload");
		By uploadbtn_locator= By.xpath("//input[contains(@value,'Upload')]");
		String filepath ="C:\\Users\\thund\\Documents\\demodoc.txt";
		
		if(isDisplayed(choosefile_locator,2)) {
			doUploadFile(choosefile_locator,filepath);
		}
		else {
			System.out.println("File not uploaded");
		}
		doclick(uploadbtn_locator);
		
	}
	
/*
 * if type='file' attribute is present in the upload file html element then only upload file is possible using sendkeys 
 * method
 */
	public static void doUploadFile(By locator,String filepath) {
			getElement(locator).sendKeys(filepath);
	}
	public static void doclick(By locator) {
		getElement(locator).click();
}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
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
