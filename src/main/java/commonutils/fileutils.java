package commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileutils {

	
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("src\\test\\resources\\data.properties.txt");
		Properties p=new Properties();
	      p.load(fis);
	      String value=p.getProperty(key);
	      return value;
	      
	}
}
