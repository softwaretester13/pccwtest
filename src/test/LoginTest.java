package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

@Test
public class LoginTest {

	private WebDriver driver;
	
	@BeforeClass
	public void testSetUp() {
		
		driver = new ChromeDriver();
	}
	
	
	public void verifyLoginPage() {

		String url = "https://practicetestautomation.com/practice-test-login";
 
        driver.get(url);
        driver.manage().window().maximize();
 
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
        username.clear();
        System.out.println("Entering the username");
        username.sendKeys("student");
 
        password.clear();
        System.out.println("entering the password");
        password.sendKeys("Password123");
 
        System.out.println("Clicking login button");
        submitButton.click();

        String title = "Logged In Successfully";
        
        WebElement successMessage = driver.findElement(By.cssSelector("h1.post-title"));
        wait.until(ExpectedConditions.visibilityOf(successMessage));

        String actualTitle = successMessage.getText();
 
        System.out.println("Verifying the page title has started");
        Assert.assertEquals(actualTitle,title,"Success message is not displayed");
 
        System.out.println("User logged in successfully");
 
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
