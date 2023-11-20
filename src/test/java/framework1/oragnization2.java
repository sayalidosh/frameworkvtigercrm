package framework1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class oragnization2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final WebDriver d1;
		FileInputStream fis=new FileInputStream("src\\test\\resources\\data.properties.txt");
		Properties p=new Properties();
	      //to read the location of property file
	      p.load(fis);
	      String BROWSER=p.getProperty("browser");
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
	      d1.manage().window().maximize();
	      d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      String URL = p.getProperty("url");
	      String USERNAME = p.getProperty("un");
	      String PWD = p.getProperty("password");
	    
	       d1.get(URL);
	       d1.findElement(By.name("user_name")).sendKeys(USERNAME);
		   d1.findElement(By.name("user_password")).sendKeys(PWD);
		   d1.findElement(By.id("submitButton")).click();
		   d1.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		   d1.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		 
		   FileInputStream fil=new FileInputStream("src\\test\\resources\\exceldata.xlsx");
		   Workbook wb = WorkbookFactory.create(fil);    
	       Sheet sh = wb.getSheet("Sheet1");
	       Row rw = sh.getRow(1);     
	       Cell c1 = rw.getCell(0);
	       String data = c1.getStringCellValue();

	       d1.findElement(By.name("accountname")).sendKeys(data);
	       d1.findElement(By.cssSelector("input[value='T']")).click();
  	  WebElement dp = d1.findElement(By.name("assigned_group_id"));
	      Row rw1 = sh.getRow(1);     
          Cell c11 = rw1.getCell(1);
     String data1 = c11.getStringCellValue();
	 	   Select s=new Select(dp);
	 	   s.selectByValue(data1);
	       
	       
	       
	     
	   
	}	   
}
