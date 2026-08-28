package UtitlityPractice2026.UtitlityPractice;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTitileURLCheck {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
			//Test=1
			if(doCheckPageTitleContains("iframe"))
					{
				System.out.println("Test Pass");
			}
			else {
				System.out.println("Test fail");
			}
			//Test=2
			if(doCheckPageTitleIs("Xpath Practice Page | Shadow dom, nested shadow dom, iframe, nested iframe and more complex automation scenarios."))
			{
				System.out.println("Test Pass");
			}
			else {
				System.out.println("Test fail");
			}
			//Test=3
			if(doCheckCurrentURLContains("-practice-"))
			{
				System.out.println("Test Pass");
			}
			else {
				System.out.println("Test fail");
			}
			//Test=4
			if(doCheckCurrentURLToBe("https://selectorshub.com/xpath-practice-page/"))
			{
				System.out.println("Test Pass");
			}
			else {
				System.out.println("Test fail");
			}
			
	}

//	public static boolean doNullCheck(String str) {
//		if(str.length()==0) {
//			return 
//		}
//			
//	}
	
	
	public static boolean doCheckPageTitleContains(String fractionTitle) {
			wait = new WebDriverWait(driver,Duration.ofSeconds(3));
			try{
				return wait.until(ExpectedConditions.titleContains(fractionTitle));
			}
			catch(TimeoutException e)
			{
				e.printStackTrace();
				System.out.println("The given"+fractionTitle+ "is not correct");
				return false;
			}
	}
	public static boolean doCheckPageTitleIs(String Title) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		try{
			return wait.until(ExpectedConditions.titleIs(Title));
		}
		catch(TimeoutException e)
		{
			e.printStackTrace();
			System.out.println("The given"+Title+ "is not correct");
			return false;
		}
	}
	public static boolean doCheckCurrentURLContains(String fractionURL) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		try{
			return wait.until(ExpectedConditions.urlContains(fractionURL));
		}
		catch(TimeoutException e)
		{
			e.printStackTrace();
			System.out.println("The given"+fractionURL+ "is not correct");
			return false;
		}
	}
	public static boolean doCheckCurrentURLToBe(String URL) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		try{
			return wait.until(ExpectedConditions.urlToBe(URL));
		}
		catch(TimeoutException e)
		{
			e.printStackTrace();
			System.out.println("The given"+URL+ "is not correct");
			return false;
		}
	}
	
	
}


