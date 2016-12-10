package Pack1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import com.google.common.base.Function;

public class WaitforObjectFluentWait{
	public WebDriver driver;
	
	@Test
	public void gmail(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://sites.google.com/site/appsscripttutorial/user-interface/list-box");
		waitForElementToAppear(By.linkText("HOME"));
		System.out.println(driver.getTitle());
		/*driver.findElement(By.linkText("Gmail")).click();
		//waitForElementToAppear(By.id("Email"));
		driver.findElement(By.id("Email")).sendKeys("vardhan.kg");
		driver.findElement(By.id("next")).click();
		waitForElementToAppear(By.id("Passwd"));
		driver.findElement(By.id("Passwd")).sendKeys("testing123");
		driver.findElement(By.id("signIn")).click();*/
	}
	
	protected WebElement waitForElementToAppear(final By locator)
	{
		System.out.println("start");
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).
			  pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

	  WebElement element = null;
	  try {
		  element = wait.until(new Function<WebDriver,WebElement>(){

	      @Override
	      public WebElement apply(WebDriver driver)
	      {
	        return driver.findElement(locator);
	      }
	    });
	  }
	  catch (Exception e) {
	    try {
	      // I want the error message on what element was not found
	      driver.findElement(locator);
	    }
	    catch (NoSuchElementException renamedErrorOutput) {
	      // print that error message
	      renamedErrorOutput.addSuppressed(e);
	      // throw new
	      // NoSuchElementException("Timeout reached when waiting for element to be found!"
	      // + e.getMessage(), correctErrorOutput);
	      throw renamedErrorOutput;
	    }
	    e.addSuppressed(e);
	    throw new NoSuchElementException("Timeout reached when searching for element!"+e);
	  }

	  return element;
	}
	
}
