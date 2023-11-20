/**
 * 
 */
package testng1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 
 */
public class test1 {
@Test
	public void facebook() {
		WebDriver d1=new ChromeDriver();
		d1.get("https://www.facebook.com/");
	}


@Test(invocationCount=2)
public void zomato() {
	WebDriver d1=new ChromeDriver();
	d1.get("https://www.zomato.com/");
}


@Test
public void instagram() {
	WebDriver d1=new ChromeDriver();
	d1.get("https://www.instagram.com/");
}
}
