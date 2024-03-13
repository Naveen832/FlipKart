package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.GenericMethods;


public class Flipkart_Flow extends GenericMethods{
	WebDriver driver;
	public Flipkart_Flow(WebDriver driver) {
		this.driver=driver;
	}
	
	By Searchfield = By.xpath("//input[@placeholder='Search for Products, Brands and More']");
	By Laptop = By.xpath("//div[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[2]");
	By Addtocart = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	By Shoppingcart = By.xpath("//a[@class='_3SkBxJ']");
	public void AddtoCart() {
		Assert.assertTrue(isElementPresent(By.xpath("//div[@class='_16ZfEv']/a/picture/img")), "Homepage is displayed");
	    WebElement search = driver.findElement(Searchfield);
	    waits(driver, Duration.ofSeconds(10), Searchfield);
	    sendKeys(search, "laptop");
	    search.sendKeys(Keys.ENTER);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement selectinglaptop = driver.findElement(Laptop);
	    waits(driver, Duration.ofSeconds(10), Laptop);
	    js.executeScript("arguments[0].click();", selectinglaptop);
	    String parent_win = driver.getWindowHandle();
	    Set<String> set = driver.getWindowHandles();
	    Iterator<String> I = set.iterator();
	    while (I.hasNext()) {
	        String child_win = I.next();
	        if (!(parent_win.equals(child_win))) {
	            driver.switchTo().window(child_win);
	        }
	    }
	    WebElement addcart = driver.findElement(Addtocart);
	    waits(driver, Duration.ofSeconds(10),Addtocart );
	    js.executeScript("arguments[0].click();", addcart);
	    WebElement cart = driver.findElement(Shoppingcart);
	    waits(driver, Duration.ofSeconds(10),Shoppingcart );
	    Click(cart);
	}

}
