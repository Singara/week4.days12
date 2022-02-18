package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

     public class WebTable2 {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		
		List<String> firstList = new ArrayList<String>();
		List<WebElement> listRows = driver.findElement(By.xpath("//div[@id='table_id_filter']/following::table/tbody")).findElements(By.tagName("tr"));
		for (WebElement eachRow : listRows) {
			List<WebElement> listColumns = eachRow.findElements(By.tagName("td"));
			firstList.add(listColumns.get(1).getText());
		}
		Collections.sort(firstList);
		driver.findElement(By.xpath("(//th[@colspan='1'])[2]")).click();
		
		List<String> secondList = new ArrayList<String>();
		List<WebElement> listRows1 = driver.findElement(By.xpath("//div[@id='table_id_filter']/following::table/tbody")).findElements(By.tagName("tr"));
		for (WebElement eachRow : listRows1) {
			List<WebElement> listColumns = eachRow.findElements(By.tagName("td"));
			secondList.add(listColumns.get(1).getText());
		}
		System.out.println(firstList.equals(secondList));;
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/snap/img002.jpg");
		FileUtils.copyFile(source, dest);
	}
}


