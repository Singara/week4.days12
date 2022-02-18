package week4.day2;

import java.awt.Frame;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		//TODO wait for DO to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions actions = new Actions(driver); 
		
		 driver.switchTo().frame(0);
		   WebElement findElement = driver.findElement(By.id("draggable"));
		  actions.dragAndDropBy(findElement, 10, 50).perform();
		  driver.switchTo().parentFrame();
		  
		  //Droppable driver.findElement(By.linkText("Droppable")).click();
		  driver.switchTo().frame(0); 
		  WebElement findElement1 =driver.findElement(By.id("draggable")); 
		  System.out.println(findElement);
		  System.out.println(findElement1); 
		  WebElement findElement2=driver.findElement(By.id("droppable")); 
		  actions.dragAndDrop(findElement1,findElement2).perform(); 
		  driver.switchTo().parentFrame();
		 	
		//resizable
		driver.findElement(By.linkText("Resizable")).click();
		driver.switchTo().frame(0);
		WebElement findElement3 = driver.findElement(By.xpath("(//div[@id='resizable']/div)[3]"));
		actions.clickAndHold(findElement3).moveByOffset(100,20).perform();
		driver.switchTo().parentFrame();
		
		//Selectable
		  driver.findElement(By.linkText("Selectable")).click();
		  driver.switchTo().frame(0);
		  actions.click(driver.findElement(By.xpath("//li[text()='Item 2']"))).perform(
		  ); driver.switchTo().parentFrame();
		 
		//Sortable
		driver.findElement(By.linkText("Sortable")).click();
		driver.switchTo().frame(0);
		actions.dragAndDrop(driver.findElement(By.xpath("//li[text()='Item 2']")),driver.findElement(By.xpath("//li[text()='Item 6']"))).pause(2).perform();
		driver.switchTo().parentFrame();
		
	}

}


