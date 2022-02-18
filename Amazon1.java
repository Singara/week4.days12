package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.Amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("OnePlus 9 Pro",Keys.ENTER);
	
		System.out.println(driver.findElement(By.xpath("(//*[@class=\"a-price-whole\"])[1]")).getText());
		System.out.println(driver.findElement(By.xpath("(//*[@role=\"button\"]/i/span)[1]")).getText());
		WebElement starRating = driver.findElement(By.xpath("(//*[@role=\"button\"]/i/span)[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(starRating).click().perform();
		Thread.sleep(500);
		String attribute = driver.findElement(By.xpath("(//a[contains(@title,'5 stars')])[1]")).getAttribute("title");
		System.out.println("Number of percentage people rated 5 stars : "+attribute.substring(18, 21));
		
		driver.findElement(By.xpath("(//h2[contains(@class,\"a-size-mini\")])[1]")).click();	
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		
		WebElement findElement = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']"));
		File src = findElement.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/snap/Oneplus.jpg");
		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("attach-view-cart-button-form")).click();
		System.out.println(driver.findElement(By.xpath("(//span[@class='currencyINR'])[1]")).getText());
	}

}


