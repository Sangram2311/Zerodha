package Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Configu.Configuration;

public class B {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Configuration.driverpath);
		WebDriver driver = new ChromeDriver();
		driver.get(Configuration.appUrl);
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys("harry");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("1256");
		
		driver.close();
	}
}
