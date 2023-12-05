/**
 * 
 */
package testng1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
 */
public class crossbrowser {
	
	public WebDriver d1;
     @Parameters("Browser")
	@Test
	public void facebook(String Browser) {
    	 
    	 if(Browser.equalsIgnoreCase("Chrome")) {
    		 ChromeDriver d1=new ChromeDriver();
    	 }
    	 else if(Browser.equalsIgnoreCase("edge"))
    	 {
    		 EdgeDriver d1=new  EdgeDriver (); 
    	 }
    	 else
    	 {
    		 FirefoxDriver d1=new FirefoxDriver();    		 
    	 }
		
    	 d1.get("https://www.facebook.com/");
	}
}
