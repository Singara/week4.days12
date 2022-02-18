package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		WebElement findElement = driver.findElement(By.xpath("(//a[@href='/'])[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris",Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[2]")).click();
		System.out.println("The title contains L'Oreal Paris "+driver.getTitle().contains("L'Oreal Paris"));
		driver.findElement(By.xpath("(//*[@class=\"arrow-icon\"])[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		driver.findElement(By.xpath("//*[@id='first-filter']")).click();
		driver.findElement(By.xpath("(//span[@class='side-count'])[3]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-name '])[2]/following::span[1]")).click();
		driver.findElement(By.xpath("//*[contains(@for,'checkbox_Shampoo')]")).click();
		
		if(driver.findElement(By.xpath("//span[contains(text(),'applied')]")).isDisplayed()){
			System.out.println("Filter is applied successfully");
		}
		
		driver.findElement(By.xpath("(//*[contains(text(),'Long Hair Dreams')])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		System.out.println(driver.findElement(By.xpath("(//span[contains(text(),'₹')])[2]")).getText());
		driver.findElement(By.xpath("(//span[contains(text(),'ADD TO BAG')])[1]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("(//span[contains(text(),'Grand Total')]/following::div)[1]")).getText());
		driver.findElement(By.xpath("//span[contains(text(),'PROCEED')]")).click();
		driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
		driver.findElement(By.xpath("(//div[@class=\"value\"]/span)[1]")).click();
		driver.quit();
		
	}

}


