package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropdown {
WebDriver driver;

@Before
public void init() {
	System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	
	driver.get("https://techfios.com/billing/?ng=admin/");
}


@Test
public void dropDown() {
	
	WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("// input[@id = 'username']"));
	WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("// input[@id ='password']"));
	WebElement SIGNIN_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
	
	USERNAME_ELEMENT.sendKeys("demo@techfios.com");
	PASSWORD_ELEMENT.sendKeys("abc123");
	SIGNIN_ELEMENT.click();
	
	WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
	Assert.assertEquals("Dashboard page not found!", "Dashboard", DASHBOARD_TITLE_ELEMENT.getText());
	
	driver.findElement(By.xpath("//span[text()='Customers']")).click();
	driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
	
	WebElement CONTACTS_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[text()=' Contacts ']"));
	Assert.assertEquals("Contacts page not found!","Contacts",CONTACTS_TITLE_ELEMENT.getText());
	
	
	driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Mamata");
	
	WebElement COMPANY_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@id='cid']"));
	Select sel = new Select(COMPANY_DROPDOWN_ELEMENT);
	sel.selectByVisibleText("Techfios");
	
}

}
