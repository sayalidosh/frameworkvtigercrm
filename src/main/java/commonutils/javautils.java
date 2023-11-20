/**
 * 
 */
package commonutils;

import java.util.Random;

/**
 * 
 */
public class javautils {

	
	public int getRandomnumver()
	{
		Random r=new Random();
		 int ran = r.nextInt(10);
		 return ran;
	}
}
