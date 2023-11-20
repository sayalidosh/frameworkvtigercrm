/**
 * 
 */
package testng1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * 
 */
public class anotation1 {
@Test
public void home()
{
	System.out.println("home page ");
}
@Test
public void home1()
{
	System.out.println("home page1 ");
}
@BeforeMethod
public void BM() {
	System.out.println("login");
}
@AfterMethod
public void AM() {
	System.out.println("logout");
}
@BeforeClass
public void BC() {
	System.out.println("launch the browser");
}
@AfterClass
public void AC() {
	System.out.println("close thw browser");
}
@BeforeSuite
public void BS()
{
	System.out.println("connect to Db");
}
@AfterSuite
public void AS() {
	System.out.println("disconnect to DB");
}







}
