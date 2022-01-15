package week4.day2;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import com.beust.jcommander.JCommander.Builder;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class MultiSelect {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://leafground.com/pages/Dropdown.html");
			WebElement firstone = driver.findElement(By.xpath("//div[@id=\'contentblock\']/section/div[6]/select/option[2]"));
			WebElement lastone = driver.findElement(By.xpath("//div[@id=\'contentblock\']/section/div[6]/select/option[5]"));
			Actions builder=new Actions(driver);
			builder.keyDown(Keys.CONTROL).click(firstone).click(lastone).keyUp(Keys.CONTROL).perform();
		}
}
