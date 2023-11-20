package testng1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ltest3 {
    @Test
	public void login() {
		System.out.println("login page");
		Assert.assertEquals("pune", "deccan");
	}
    
    @Test(dependsOnMethods="login")
   	public void home() {
    	System.out.println(" pagehome");
   	}
    
    @Test(dependsOnMethods="login")
    
   	public void logout() {
    	System.out.println("logout page");	
   	}
}
