/**
 * 
 */
package framework1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutils.Baseclass;
import commonutils.ListenerImplimentation;
import commonutils.Webdriverutil;
import commonutils.excelutils;

@Listeners(ListenerImplimentation.class)
public class createcontacttestng extends Baseclass{
	
	 @Test
		public void module1() throws IOException, InterruptedException {
			
		//to fetch data from file
			
			Webdriverutil wutil=new Webdriverutil();
			excelutils exfile=new excelutils();
			//to read data from file
			
			
			//to read data from excelsheet
			String FIRSTNAME=exfile.getDataFromExcelFile("Sheet1", 1,2);
			String LASTNAME=exfile.getDataFromExcelFile("Sheet1", 1,3);
			String group=exfile.getDataFromExcelFile("Sheet1", 1, 1);
			String PARENTURL=exfile.getDataFromExcelFile("Sheet1", 1, 4);
			String CHILDURL=exfile.getDataFromExcelFile("Sheet1", 3, 4);
			
			
			   //click on contact
			   d1.findElement(By.xpath("//a[text()='Contacts']")).click();
			   Reporter.log("click on contact");
			   //click on plus image
			   d1.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			   Reporter.log("create contact");
			   
			   
			   //to enter firstname
			 d1.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
			 Reporter.log("enter thr first name");
			 //to enter lastname
			 d1.findElement(By.name("lastname")).sendKeys(LASTNAME);
			 Reporter.log("enter the last name");
//			 
			 String actualtitle = d1.getTitle();	
				String expectedtitle="pune";
				Assert.assertEquals(actualtitle, expectedtitle);
			 
			 //to click on group radio button
			 d1.findElement(By.cssSelector("input[value='T']")).click();
			 //dropdown webelement
		  	  WebElement dp = d1.findElement(By.name("assigned_group_id"));
		  	  //handle dropdown by visible text
		 	 wutil.handleDropdown(dp, group);
		 	 Reporter.log("handle the dropdown");
		 	 
		 	 //to click plus image in organiaztion image
		 	 d1.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
			   //to transfer control from parent to child 
				  wutil.switchtowindow(d1,CHILDURL);
				  Reporter.log("transfer the control from parent to child ");
				  //to enter data in searchfield 
				  d1.findElement(By.id("search_txt")).sendKeys("t");
				  d1.findElement(By.name("search")).click();
				  //to add oragniaztion name 
				  d1.findElement(By.xpath("//a[text()='TCS']")).click();
			//to transfer control from child to parent 
				  wutil.switchtowindow(d1,PARENTURL);
				  
	             //take screen shot of webpage
				// wutil.TakeScreenshot(d1,"screenshot");
				// Reporter.log("take the screenshot");
			      // for scrolling      
			    // Thread.sleep(2000);
			     wutil.scrolling(d1);			         			       			 		         
		  	 //to click on save button
	 	    d1.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	 	   Reporter.log("save the conatct");
		 	
	
}
	 @Test
		public void acttime() {
			System.out.println("actitme ");
		}
		
		@Test(dependsOnMethods="module1")
		public void facebook() {
		}
}
