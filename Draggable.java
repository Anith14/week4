package week4.day2;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Draggable {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("https://jqueryui.com/draggable");
			driver.switchTo().frame(0);
			WebElement src = driver.findElement(By.id("draggable"));
			System.out.println(src.getText());
			Actions builder= new Actions(driver);
			builder.contextClick().perform();
		

		}
}
