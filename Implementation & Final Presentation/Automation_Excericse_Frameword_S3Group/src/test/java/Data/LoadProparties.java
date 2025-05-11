package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProparties {
  static String FilePath=System.getProperty("user.dir")+"\\src\\main\\java\\proparites\\UserData.properties";
     public static Properties userData=LoadjavaProparties(FilePath);
private static Properties LoadjavaProparties(String filePath2) {
	Properties pro=new Properties();
	try {
		FileInputStream stream=new FileInputStream(FilePath);
		try {
			pro.load(stream);
		} catch (IOException e) {
			System.out.println("Error Occupied"+e.getMessage());
			//e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		System.out.println("Error Occupied"+e.getMessage());
		//e.printStackTrace();
	}
	return pro;
}


}
