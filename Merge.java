package week4.day1;


	import java.util.LinkedList;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Merge {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//a[text() ='Merge Contacts']")).click();
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
			Set<String> windowhandle = driver.getWindowHandles();
			List<String> windows = new LinkedList<String>(windowhandle);
			driver.switchTo().window(windows.get(1));
			driver.findElement(By.xpath("//a[@class='linktext']")).click();
			driver.switchTo().window(windows.get(0));
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			Set<String> windowhandle1 = driver.getWindowHandles();
			List<String> windows1 = new LinkedList<String>(windowhandle1);
			driver.switchTo().window(windows1.get(1));
			driver.findElement(By.xpath("(//div[contains(@class,'col-partyId')])[1]")).click();
			driver.switchTo().window(windows1.get(0));
			driver.findElement(By.linkText("Merge")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
	
		}
}
