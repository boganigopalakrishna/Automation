package DEMO;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HrmLogin {
	
	WebDriver driver;
	private static Logger loger = LogManager.getLogger(HrmLogin.class);
	@BeforeTest
	public void lunchApp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		loger.info("execuation started");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		loger.info("browser opend successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
	}
    @Test
    public void loginOperation() throws InterruptedException
    {
    	driver.findElement(By.name("username")).sendKeys("Admin");
    	driver.findElement(By.name("password")).sendKeys("admin123");
    	driver.findElement(By.xpath("//button[@type='submit']"));
    	Thread.sleep(3000);
    	loger.info("loagin successfully");
    }
    @AfterTest
    public void close()
    {
    	driver.close();
    	loger.info("execution done");
    }
}
