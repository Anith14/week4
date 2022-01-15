package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class leafSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/Dropdown.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
Actions build = new Actions(driver);
WebElement option1 = driver.findElement(By.xpath("//option[text()='Select your programs']/following::option[1]"));
WebElement option2 = driver.findElement(By.xpath("//option[text()='Select your programs']/following::option[4]"));
build.keyDown(Keys.CONTROL).click(option1).click(option2).keyUp(Keys.CONTROL).perform();

	}

}
