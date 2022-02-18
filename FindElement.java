package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindElement {
	
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
    driver.manage().window().maximize(); // Maximize the opened chrome browser window
    driver.get("https://erail.in/"); // Loads the URL in the opened browser
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WebElement from = driver.findElement(By.id("txtStationFrom"));
    from.clear();
    from.sendKeys("TPJ", Keys.TAB);
    WebElement to = driver.findElement(By.id("txtStationTo"));
    to.clear();
    to.sendKeys("MDU", Keys.TAB);
    driver.findElement(By.id("chkSelectDateOnly")).click();
    
    //Find element through a locator from a webpage
    WebElement elementTable = driver.findelement(By.xpath("//table[@class= "DataTable Trainlist"));
    
    		// Find the row from the elemenetTable found
    		List<WebElement> listRows  = elementTable.findElements(By.tagName("tr"));
    
    //Iterating Rows from the table
    for (int i=o;  i<listRows.size();i++)


}
