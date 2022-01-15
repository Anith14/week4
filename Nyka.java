package week4.day2;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Nyka {

		public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.nykaa.com/");
			driver.manage().window().maximize();
			Actions builder = new Actions(driver);
			WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
			builder.moveToElement(brand).perform();
			driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
			driver.findElement(By.linkText("L'Oreal Paris")).click();
			String title = driver.getTitle();
			System.out.println(title);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[@class='sort-name']")).click();
			driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']")).click();
			driver.findElement(By.xpath("(//div[@class='filter-open css-nbw8dp'])[1]")).click();
	        driver.findElement(By.xpath("(//span[text()='Hair'])[1]")).click();
	        driver.findElement(By.xpath("(//span[text()='Hair Care'])[1]")).click();
	        driver.findElement(By.xpath("(//span[text()='Shampoo'])[1]")).click();
		    driver.findElement(By.xpath("(//span[text()='Concern'])[1]")).click();
		    driver.findElement(By.xpath("(//span[text()='Color Protection'])[1]")).click();
		    String filters = driver.findElement(By.xpath("//span[text()='Filters Applied']")).getText();
		    System.out.println(filters);
		    driver.findElement(By.xpath("(//div[@class='css-10zjw4o'])[1]")).click();
		    Set<String> window = driver.getWindowHandles();
		    List <String> handles = new ArrayList<String>(window);
		    driver.switchTo().window(handles.get(1));
		    WebElement sel = driver.findElement(By.xpath("//select[@title='SIZE']"));
		    Select select = new Select(sel);
		    select.selectByValue("0");
		    String rate = driver.findElement(By.xpath("(//span[text()='MRP:'])[1]")).getText();
		    System.out.println(rate);
		    driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		    driver.findElement(By.xpath("//button[@type='button'][1]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//button[@type='button']//span[text()='PROCEED']")).click();
		    driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		   
		}
}
