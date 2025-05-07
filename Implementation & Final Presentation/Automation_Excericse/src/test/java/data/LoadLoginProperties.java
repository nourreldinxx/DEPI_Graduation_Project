package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadLoginProperties {
	 static String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\LoginData.properties";
	 static public Properties userData = LoadLoginProperties(filePath);
	
	private static Properties LoadLoginProperties(String filePath) {
		Properties pro = new Properties();
		
		try {
			FileInputStream stream = new FileInputStream(filePath);
			try {
				pro.load(stream);
			} catch (IOException e) {
				System.out.println("Error Occupied "+e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error Occupied "+e.getMessage());
		}
		
		return pro;
	}
}
