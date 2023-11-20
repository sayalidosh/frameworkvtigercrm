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

public class createcontact {
     @Test
	public void module1() throws IOException, InterruptedException {
		final WebDriver d1;
	//to fetch data from file
		fileutils Pfile=new fileutils();
		Webdriverutil wutil=new Webdriverutil();
		excelutils exfile=new excelutils();
		//to read data from file
		String BROWSER = Pfile.getDataFromPropertyFile("browser");
		String URL = Pfile.getDataFromPropertyFile("url");
		String USERNAME = Pfile.getDataFromPropertyFile("un");
		String PWD = Pfile.getDataFromPropertyFile("password");
		
		//to read data from excelsheet
		String FIRSTNAME=exfile.getDataFromExcelFile("Sheet1", 1,2);
		String LASTNAME=exfile.getDataFromExcelFile("Sheet1", 1,3);
		String group=exfile.getDataFromExcelFile("Sheet1", 1, 1);
		String PARENTURL=exfile.getDataFromExcelFile("Sheet1", 1, 4);
		String CHILDURL=exfile.getDataFromExcelFile("Sheet1", 3, 4);
		
		//from luanch the user defined browser 
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
	     	//launch the url    
	       d1.get(URL);
	       //login to application
	       d1.findElement(By.name("user_name")).sendKeys(USERNAME);
		   d1.findElement(By.name("user_password")).sendKeys(PWD);
		   d1.findElement(By.id("submitButton")).click();
		   //click on contact
		   d1.findElement(By.xpath("//a[text()='Contacts']")).click();
		   //click on plus image
		   d1.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		   //to enter firstname
		 d1.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		 //to enter lastname
		 d1.findElement(By.name("lastname")).sendKeys(LASTNAME);	
		 //to click on group radio button
		 d1.findElement(By.cssSelector("input[value='T']")).click();
		 //dropdown webelement
	  	  WebElement dp = d1.findElement(By.name("assigned_group_id"));
	  	  //handle dropdown by visible text
	 	 wutil.handleDropdown(dp, group);
	 	 //to click plus image in organiaztion image
	 	 d1.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		   //to transfer control from parent to child 
			  wutil.switchtowindow(d1,CHILDURL);
			  
			  //to enter data in searchfield 
			  d1.findElement(By.id("search_txt")).sendKeys("t");
			  d1.findElement(By.name("search")).click();
			  //to add oragniaztion name 
			  d1.findElement(By.xpath("//a[text()='TCS']")).click();
//			//to transfer control from child to parent 
			  wutil.switchtowindow(d1,PARENTURL);
			  
             //take screen shot of webpage
			 wutil.TakeScreenshot(d1);
		      // for scrolling      
		     Thread.sleep(2000);
		     wutil.scrolling(d1);
		         
		         
		         
		         
		         
	  	 //to click on save button
 	    d1.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	 	 //admin image
	 	WebElement mouse = d1.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		// mouse hovering on admin image 
	 	wutil.Mousceover(d1,mouse);
	   //click on sign out 
	 	d1.findElement(By.xpath("//a[text()='Sign Out']")).click();
     }		   
}




