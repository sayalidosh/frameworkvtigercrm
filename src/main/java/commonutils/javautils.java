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
		 int ran = r.nextInt(100);
		 return ran;
	}
}
