package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(" https://www.snapdeal.com/");
		
		WebElement element = driver.findElement(By.xpath("//div[@id=\'leftNavMenuRevamp\']/div[1]/div[2]/ul/li[7]/a/span"));
		WebElement element1 = driver.findElement(By.xpath("(//span[text()='Shirts'])[2]"));
		Actions builder= new Actions(driver);
		builder.moveToElement(element).pause(2000).click(element1).perform();
		WebElement element2 = driver.findElement(By.xpath("//div[@id=\'636517591500\']/div[2]/a/picture/img"));
		WebElement element3 = driver.findElement(By.xpath("//div[@id=\'636517591500\']/div[2]/div/div"));
		builder.moveToElement(element2).pause(2000).click(element3).perform();
	}
}