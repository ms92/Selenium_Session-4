package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyboardEvent {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://techfios.com/billing/?ng=login/");
	}
	
	@Test
	public void keyBoardEvent() {
		
	WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("// input[@id = 'username']"));
	WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("// input[@id ='password']"));
	WebElement SIGNIN_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
	
	USERNAME_ELEMENT.sendKeys("demo@techfios.com");
	PASSWORD_ELEMENT.sendKeys("abc123");
	
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();
	
	}
	
}
