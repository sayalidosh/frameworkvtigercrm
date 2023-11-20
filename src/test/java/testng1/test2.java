/**
 * 
 */
package testng1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


/**
 * 
 */
public class test2 {
      SoftAssert s=new SoftAssert();
	@Test
	public void vtiger() {
		WebDriver d1=new ChromeDriver();
		d1.get("https://demo.vtiger.com/");
		String Actualtitle=d1.getTitle();
		String expectedtitle="vtiger";
        s.assertEquals(Actualtitle, expectedtitle);
        System.out.println(Actualtitle);
        System.out.println("good rng");
        s.assertAll();

	}
	
	
	
	@Test
	public void vtigercrm() {
		WebDriver d1=new ChromeDriver();
		d1.get("http://localhost:8888/");
		 WebElement loginbtn = d1.findElement(By.id("submitButton"));
		// Assert.assertTrue(loginbtn.isSelected());
		 Assert.assertFalse(loginbtn.isSelected());
		 System.out.println("hiii");
	}
}
