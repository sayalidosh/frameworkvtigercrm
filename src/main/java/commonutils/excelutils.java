package commonutils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutils {
 
	public String getDataFromExcelFile(String sheetname,int rownumber,int cellnumber) throws EncryptedDocumentException, IOException
	{
		 FileInputStream fil=new FileInputStream("src\\test\\resources\\exceldata.xlsx");
		   Workbook wb = WorkbookFactory.create(fil);
		  Sheet sh = wb.getSheet(sheetname);
		 Row rw = sh.getRow(rownumber);
		Cell c1 = rw.getCell(cellnumber);
		String data = c1.getStringCellValue();
		return data;
	}
}
