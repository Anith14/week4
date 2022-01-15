package week4.day2;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;
	public class Amazon {
		public static void main(String[] args) throws IOException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
			driver.findElement(By.id("nav-search-submit-button")).click();
			String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
			System.out.println(text);
			String a = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']//span")).getText();
	        System.out.println(a); 
	        String b = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
	        System.out.println(b); 
	        WebElement phone = driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']"));
	        phone.click();
	        Set<String> window = driver.getWindowHandles();
	        List<String> handles = new ArrayList <String>(window);
	        driver.switchTo().window(handles.get(1));
	        File Source = phone.getScreenshotAs(OutputType.FILE) ; 
	        File destination = new File ("./oneplus.png");
	        FileUtils.copyFile(Source, destination);    
	        driver.findElement(By.id("add-to-cart-button")).click();
	        String c = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
	        System.out.println(c);
	        boolean d = driver.getPageSource().contains(text);
	        System.out.println(d);
	        
	        
		}

}
