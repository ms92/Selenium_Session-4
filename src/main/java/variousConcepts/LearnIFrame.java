package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnIFrame {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://docs.oracle.com/javase/8/docs/api/");
	}
	
	@Test
	public void dealwithIFrame() {
	
		//dealing with first frame
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt.color")).click();
		
		//dealing with 2nd frame
		driver.switchTo().parentFrame();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("ColorSpace")).click();
		
		//dealing with third frame
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		System.out.println(driver.getTitle());
		
	}
	
}
