package testNGParameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver ;
	 
	@Test
	@Parameters({"env","browser","url", "emailId"})
	public void yahooLoginTest(String env,String browser,String url ,String emailId) {
		String projectPath = System.getProperty("user.dir");
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(emailId);
		driver.findElement(By.id("login-signin")).click();
		
}
}
