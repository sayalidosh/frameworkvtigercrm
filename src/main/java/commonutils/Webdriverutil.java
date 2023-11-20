package commonutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webdriverutil {

	public void maximize(WebDriver d1)
	{
		d1.manage().window().maximize();
	}
	
	public void minimize(WebDriver d1)
	{
		d1.manage().window().minimize();
	}
	
	public void implicitwait(WebDriver d1)
	{
		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handleDropdown(WebElement elementname,String data)
	{
		  Select s=new Select(elementname);
	 	  s.selectByVisibleText(data);
	       
	}
	public void handleDropdown(WebElement elementname,int index)
	{
		  Select s=new Select(elementname);
	 	  s.selectByIndex(index);
	       
	}
	public void ClickAction(WebDriver d1,WebElement elementname)
	{
		Actions a=new Actions(d1);
		a.click(elementname);
		a.perform();
		
	}
	public void Rightclick(WebDriver d1,WebElement elementname) {
		Actions a=new Actions(d1);
		a.contextClick(elementname);
		a.perform();
	}
	
	public void Doubleclick(WebDriver d1,WebElement elementname) {
		Actions a=new Actions(d1);
	    a.doubleClick(elementname);
		a.perform();
	}
	public void DragAndDrop(WebDriver d1,WebElement drag,WebElement drop) {
		Actions a=new Actions(d1);
	    a.dragAndDrop(drag,drop);
		a.perform();
	}
	
	public void Mousceover(WebDriver d1,WebElement elementname) {
		Actions a=new Actions(d1);
	    a.moveToElement(elementname);
		a.perform();
	}
	
	public void scrolling(WebDriver d1)
	{
		JavascriptExecutor jse= (JavascriptExecutor) d1;
	     jse.executeScript("window.scrollBy(0,900)");
	}
	public void TakeScreenshot(WebDriver d1) throws IOException
	{
		 TakesScreenshot driver= (TakesScreenshot) d1;
	       
         File TEMPFILE = driver.getScreenshotAs(OutputType.FILE);
         File newfile=new File("./images/vtiger.jpg");
         FileUtils.copyFile(TEMPFILE,newfile);
	}
	public void switchtowindow(WebDriver d1, String childurl)
	{
		  Set<String> ids = d1.getWindowHandles();
		  for(String allid :ids)
			  {
				 String allurl = d1.switchTo().window(allid).getCurrentUrl();
				 System.out.println(allurl);
				 
				 
				 if(allid.contains(childurl))
				 {
					 break;
				 }
				 
				
			  }
	}
	
}
