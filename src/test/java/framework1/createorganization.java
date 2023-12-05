/**
 * 
 */
package framework1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import commonutils.Webdriverutil;
import commonutils.excelutils;
import commonutils.fileutils;
import commonutils.javautils;

/**
 * 
 */
public class createorganization {
@Test
public void organization() throws IOException, InterruptedException {
	
	
		final WebDriver d1;
		fileutils Pfile=new fileutils();
		Webdriverutil wutil=new Webdriverutil();
		excelutils exfile=new excelutils();
		javautils jutil=new javautils();
		//read data from properties file
		String BROWSER = Pfile.getDataFromPropertyFile("browser");
		String URL = Pfile.getDataFromPropertyFile("url");
		String USERNAME = Pfile.getDataFromPropertyFile("un");
		String PWD = Pfile.getDataFromPropertyFile("password");
		//read data from excel file
		String Orgname = exfile.getDataFromExcelFile("Sheet1", 1, 0);
		String group=exfile.getDataFromExcelFile("Sheet1", 1, 1);
		
	      if(BROWSER.equals("Chrome"))
	      {
	    	d1=new ChromeDriver();  
	      }
	      else if (BROWSER.equals("firefox"))
	      {
	    	  d1=new FirefoxDriver();
	      }
	      else
	      {
	    	  d1=new EdgeDriver();
	      }
	    //maximize window
	      wutil.maximize(d1);
	    //to apply implicit wait
	     
	      wutil.implicitwait(d1);
	      //to luanch the url
	       d1.get(URL);
	     //login to application
	       d1.findElement(By.name("user_name")).sendKeys(USERNAME);
		   d1.findElement(By.name("user_password")).sendKeys(PWD);
		   d1.findElement(By.id("submitButton")).click();
		   //click on orgnization 
		   d1.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		   //click on plus image
		   d1.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		   //to enter org name
	       d1.findElement(By.name("accountname")).sendKeys(Orgname+jutil.getRandomnumver());
	     //to click on group radio button
	       d1.findElement(By.cssSelector("input[value='T']")).click();
	     //dropdown webelement
  	      WebElement dp = d1.findElement(By.name("assigned_group_id"));
  	  //handle dropdown by visible text
	 	 wutil.handleDropdown(dp, group);
	 	 
	 	  WebElement box = d1.findElement(By.name("notify_owner"));
	 	  wutil.ClickAction(d1, box);
	 	 //to click on save button
	 	 d1.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		 //admin image
	 	 Thread.sleep(5000);
		 	WebElement mouse = d1.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		 // mouse hovering on admin image 
		 	 Thread.sleep(5000);
		 	wutil.Mousceover(d1,mouse);
		 	//click on sign out 
		 	d1.findElement(By.xpath("//a[text()='Sign Out']")).click();
	       
	     
	       
	}

}
 