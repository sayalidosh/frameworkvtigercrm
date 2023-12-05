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
import commonutils.javautils;

@Listeners(ListenerImplimentation.class)
public class createorganizationtestng extends Baseclass{
		

		@Test
		public void organization() throws IOException, InterruptedException {
							
				Webdriverutil wutil=new Webdriverutil();
				excelutils exfile=new excelutils();
				javautils jutil=new javautils();
			
							
				//read data from excel file
				String Orgname = exfile.getDataFromExcelFile("Sheet1", 1, 0);
				String group=exfile.getDataFromExcelFile("Sheet1", 1, 1);
				 
			
				
			     //click on orgnization 
				   d1.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
				   Reporter.log("create the organization");
				   //click on plus image
				   d1.findElement(By.cssSelector("img[title='Create Organization...']")).click();
				   
				   Reporter.log("fill the organization");
				   //to enter org name
			       d1.findElement(By.name("accountname")).sendKeys(Orgname+jutil.getRandomnumver());
			       Reporter.log("fill the organization name ");
			     //to click on group radio button
			       d1.findElement(By.cssSelector("input[value='T']")).click();
			       Reporter.log("to click on group radio button");
			       
			       String actualtitle = d1.getTitle();	
					String expectedtitle="pune";
					Assert.assertEquals(actualtitle, expectedtitle);
			       
			     //dropdown webelement
		  	      WebElement dp = d1.findElement(By.name("assigned_group_id"));
		  	  //handle dropdown by visible text
			 	 wutil.handleDropdown(dp, group);
			 	 Reporter.log("handle the dropdown");
			 	  WebElement box = d1.findElement(By.name("notify_owner"));
			 	  wutil.ClickAction(d1, box);
			 	 //to click on save button
			 	 d1.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			 	 Thread.sleep(4000);
			 	 Reporter.log("to click on save");
			     
	}
		@Test
		public void acttime() {
			System.out.println("actitme ");
		}
		
		@Test(dependsOnMethods="organization")
		public void facebook() {
			
		}
	}

