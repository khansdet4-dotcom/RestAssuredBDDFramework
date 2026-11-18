package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GenericUtils {
	public static String getPropertyValue(String fileName,String key) {
		String retVal = null;
		
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/"+fileName+".properties");
			Properties pro = new Properties();
			pro.load(fis);
			retVal = pro.getProperty(key);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
