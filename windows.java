package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windows{

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.irctc.co.in/nget/train-search");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
driver.findElement(By.linkText("FLIGHTS")).click();
String title = driver.getTitle();
System.out.println(title);
Set<String> windowHandles = driver.getWindowHandles();
 List<String> handles = new ArrayList<String>(windowHandles);
driver.switchTo().window(handles.get(0));
driver.close();
	}

}
