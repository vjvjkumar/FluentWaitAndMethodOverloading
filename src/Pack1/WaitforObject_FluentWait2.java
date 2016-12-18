package Pack1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class WaitforObject_FluentWait2 {
	
	private WebDriver driver;
	@Test
	public void waitForObjectFluentWait()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		//now creating object of FluentWait class and pass WebDriver as input
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
										.withTimeout(30, TimeUnit.SECONDS)
										.pollingEvery(1, TimeUnit.SECONDS)
										.ignoring(NoSuchElementException.class);
		
		// now creating a Function here which accepts WebDriver as INPUT and WebElement as OUTPUT
		WebElement element = wait.until(new Function<WebDriver, WebElement>()
				{

					@Override
					public WebElement apply(WebDriver driver)  // this "apply" method- is which accepts WebDriver as input
					{
						// TODO Auto-generated method stub
						
						WebElement element1 = driver.findElement(By.xpath("//p[@id='demo']"));  // find the element
						
						// Will capture the inner Text and will compare with WebDriver
						// If condition is true then it will return the element and wait will be over
						
							String value =	element1.getAttribute("innerHTML");
							
							if(value.equalsIgnoreCase("WebDriver"))
							{
							return element1;	
							}
							// If condition is not true then it will return null and it will keep checking until condition is not true
							else
							{
							System.out.println("object is : "+value);
							return null;
							}
							}
							});
						System.out.println("Element is visible : "+ element.isDisplayed());
				}

}
