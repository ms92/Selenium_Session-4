package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://www.dell.com/en-us?~ck=mn");
	}
	
	@Test
	public void mouseHover() {
	
		WebElement PRODUCT_ELEMENT = driver.findElement(By.xpath("//*[@id=\"l1\"]"));
		WebElement MONITOR_ELEMENT = driver.findElement(By.xpath("//*[@id=\"l1_6\"]/span"));
		WebElement HOME_MONITOR_ELEMENT = driver.findElement(By.xpath("//*[@id=\"dell-masthead\"]/div[3]/nav/ul/li[1]/ul/li[9]/ul/li[1]/a"));
	
		Actions action = new Actions(driver);
		action.moveToElement(PRODUCT_ELEMENT).build().perform();
		action.moveToElement(MONITOR_ELEMENT).build().perform();
		HOME_MONITOR_ELEMENT.click();
	}
	
}
