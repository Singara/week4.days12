
package week4.day1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
public class ScreenS {
    public static void main(String[] args) throws InterruptedException,IOException {  
    	System.setProperty("webdriver.chrome.driver","./C:\\Programs\\ChromeSetup.exe");
    	WebDriverManager.chromedriver().setup();
    	ChromeDriver driver = new ChromeDriver();
    	driver.get("http://www.leafground.com/pages/TextChange.html");
    	File firstsrc = driver.getScreenshotAs(OutputType.FILE);
    	File dest  = new File("./snaps/img.png");
    	FileHandler.copy(firstsrc, dest);
    	driver.close();
    	
    	
    	
    }
    	
		

	}


