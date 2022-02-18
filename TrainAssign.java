package week4.day2;

import java.time.Duration;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainAssign {


	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("https://erail.in/"); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement from = driver.findElement(By.id("txtStationFrom"));
        from.clear();
        from.sendKeys("TPJ", Keys.TAB);
        WebElement to = driver.findElement(By.id("txtStationTo"));
        to.clear();
        to.sendKeys("MDU", Keys.TAB);
        driver.findElement(By.id("chkSelectDateOnly")).click();
        WebElement webTable = driver.findElement(By.xpath("//div[@id='divTrainsList']/table"));
        List<WebElement> listRows = webTable.findElements(By.tagName("tr"));
        for (WebElement eachRow : listRows) {
        List<WebElement> listColumn = eachRow.findElements(By.tagName("td"));
			if(listColumn.get(1).getText().contains("SF")){
				System.out.println(listColumn.get(1).getText());
				System.out.println(listColumn.get(0).getText());
			}
		}
	}

}


