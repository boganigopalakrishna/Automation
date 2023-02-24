package DEMO;

import java.lang.System.Logger;
import java.time.Duration;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class HRM {
	
   WebDriver driver;
   
   @BeforeTest
   public void launchApp() throws InterruptedException
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.manage().window().minimize();
	   driver.get("https://opensource-demo.orangehrmlive.com/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   Thread.sleep(3000);
   }
   @Test
   public void operation()
   {
	   Thread.sleep(3000);
	   driver.findElement(By.name("username")).sendKeys("Admin");
	   driver.findElement(By.name("password")).sendKeys("admin123");
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	   Thread.sleep(3000);
	   
   }
   @AfterTest
   public void close()
   {
	   driver.close();
	  
   }
   
}

}
