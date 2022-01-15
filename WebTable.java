package week4.day2;


import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://erail.in/");
		WebElement element = driver.findElement(By.id("txtStationFrom"));
		element.clear();
		element.sendKeys("ms");
		element.sendKeys(Keys.TAB);
		WebElement element2 = driver.findElement(By.id("txtStationTo"));
		element2.clear();
		element2.sendKeys("mdu");
		element2.sendKeys(Keys.TAB);
		WebElement element3 = driver.findElement(By.id("chkSelectDateOnly"));
		element3.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 int row= driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		 System.out.println(row);
	List <String> trainnames=new ArrayList<String>();
	for (int i = 1; i <=row; i++) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String findElement = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
		 trainnames.add(findElement);
	Set <String> setnames=new LinkedHashSet<String>	(trainnames);
	if(trainnames.size()!=setnames.size()) {
		System.out.println("dublicate train names there");
	
			
		}
	else {
		System.out.println("no dublicates are there");
	}
	}
	
	
	
	}
}
