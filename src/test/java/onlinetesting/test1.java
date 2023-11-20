/**
 * 
 */
package onlinetesting;

import org.testng.annotations.Test;

/**
 * 
 */
public class test1 {

	@Test
	public void instagram()
	{
		System.out.println("from instagram");
	}
	
	@Test
	public void facebook()
	{
		System.out.println("from facebook");
	}
	
	@Test(groups="shopping")
	public void myntra()
	{
		System.out.println("from myntra");
	}
	
	@Test(groups="shopping")
	public void flipcart()
	{
		System.out.println("from flipcart");
	}
	
}
