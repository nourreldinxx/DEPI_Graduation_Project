package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadExcelLoginData {
	FileInputStream stream = null;
	
	public FileInputStream connectExcelFile() {
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\Excel\\LoginData.xlsx";
		
		File file = new File(filePath);
		
		if(file.exists())
			try {
				stream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				System.out.println("Error Occupied "+e.getMessage());
			}
		else
			System.out.println("File not found");
		
		return stream;
	}
	
	public Object[][] getExcelLoginData() throws IOException{
		stream = connectExcelFile();
		
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet loginSheet = workBook.getSheetAt(0);
		
		int nRows = loginSheet.getLastRowNum();
		int nCols = 3;
		
		Object[][] excelData = new Object[nRows][nCols];
		
		for(int i = 0 ; i < nRows; ++i) {
			XSSFRow currentRow = loginSheet.getRow(i);
			for(int j = 0 ; j < nCols ; ++j) {
				excelData[i][j] = currentRow.getCell(j).toString();
			}
		}
		
		workBook.close();
		return excelData;
	}
}
