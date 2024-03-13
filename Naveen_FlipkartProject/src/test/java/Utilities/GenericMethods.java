package Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.DriverSetup;

public class GenericMethods  extends DriverSetup{
	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}
	public void Click(WebElement ele) {
		ele.click();;
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	public void waits(WebDriver driver,Duration time,By loc) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
}
	

	


