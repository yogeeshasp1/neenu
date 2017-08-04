package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
   
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
	 File src =new File ("E:\\ApplicationTestData\\AppData.xlsx");
	 
	 try 
	 {
		FileInputStream fis = new FileInputStream(src);
		 wb= new XSSFWorkbook(fis);
	} 
	 catch (Exception e) {
		System.out.println("Excepetion is "  +e.getMessage());
	}
	 
	}
	
	public String  getData( int sheetIndex, int row,int coloumn)
	{
       String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(coloumn).getStringCellValue();
       return data;
	}
	
	public String  getData( String sheetName, int row,int coloumn)
	{
       String data=wb.getSheet(sheetName).getRow(row).getCell(coloumn).getStringCellValue();
       return data;
	}
	
	public int getNumberofRows(String sheetName)
	{
		int nor=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		return nor;
	}
}

