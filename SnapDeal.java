package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws IOException {
		
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("pushDenied")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement mensFashionElement = driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));
		Actions action = new Actions(driver);
		action.moveToElement(mensFashionElement).click().perform();
		driver.findElement(By.xpath("(//span[contains(text(),\"Sports Shoes\")])[1]")).click();
		String numberOfSportShoes = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		System.out.println(numberOfSportShoes);
		driver.findElement(By.xpath("//div[contains(text(),'Training Shoes')]")).click();
		List<WebElement> priceListUnsorted = driver.findElements(By.xpath("//span[@data-price]"));
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("//*[@class=\"sort-value\"]/li[2]")).click();
		List<WebElement> priceListSorted = driver.findElements(By.xpath("//span[@data-price]"));
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		WebElement firstTrainingShoe = driver.findElement(By.xpath("(//picture/img)[1]"));
		
		action.moveToElement(firstTrainingShoe).click(driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"))).perform();
		
		System.out.println("Price of the product is : " + driver.findElement(By.className("payBlkBig")).getText());
		System.out.println("Discount % of the product is : " + driver.findElement(By.xpath("//*[contains(@class,'percent-desc')]")).getText());
		WebElement shoeImage = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
		File snaps = shoeImage.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap/shoe.jpg");
		FileUtils.copyFile(snaps, dest);
		driver.quit();
	}

}


