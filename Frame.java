package week4.day1;

	import java.io.File;
	import java.io.IOException;
	import java.util.List;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Frame {

		public static void main(String[] args) throws InterruptedException, IOException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/frame.html");
			driver.manage().window().maximize();
			driver.switchTo().frame(0);
			driver.findElement(By.id("Click")).click();
			Thread.sleep(2000);
			String text = driver.findElement(By.id("Click")).getText();
			System.out.println(text);
			File source = driver.getScreenshotAs(OutputType.FILE);
			File destination = new File("shot/frame.png");
			FileUtils.copyFile(source, destination);
			driver.switchTo().defaultContent();
			List<WebElement> f = driver.findElements(By.tagName("iframe"));
		    int i = f.size();
		    System.out.println(i);

}
	}
