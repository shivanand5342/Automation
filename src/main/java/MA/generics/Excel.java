package MA.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public String xlPath= null;
	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	private Workbook wb=null;
	private Sheet sheet=null;
	private Row row=null;
	private Cell cell=null;
	
	
	public Excel(String xlPath) {
	this.xlPath=xlPath;
	try {
		fis=new FileInputStream(xlPath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		fis.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	
	// returns the row count in a sheet
	public int getRowCount(String sheetName) {
		return sheet.getLastRowNum()+1;
	}
	
	// returns the data from a cell
	public String getCellData( String sheetName, int UNrowNum, int PWcolumnNum) {
		String cellData=null;
		
		try {
			cellData=wb.getSheet(sheetName).getRow(UNrowNum).getCell(PWcolumnNum).toString();
		}catch(Exception e) {
			System.out.println("There is no data exists in the cell");
			e.printStackTrace();
		}
		return cellData;
	}
	
   
}
