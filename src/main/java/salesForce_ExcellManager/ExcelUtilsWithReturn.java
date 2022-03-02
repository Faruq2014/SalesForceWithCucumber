package salesForce_ExcellManager;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsWithReturn {
	

	
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	
    // this is constructor
	public ExcelUtilsWithReturn(String excelPath, String sheetName) {
		try {
		 workbook = new XSSFWorkbook(excelPath);
		 sheet=workbook.getSheet(sheetName);	
		//System.out.println("constuctor");	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	public  int getRowCount() {
	int rowCount=0;
	 rowCount=sheet.getPhysicalNumberOfRows();
	System.out.println("number of row "+rowCount);
		return rowCount;
	}
	
	public  int getColCount() {
		int colCount=0; 
		 colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of column "+colCount);
		return colCount;
	}
	
	public  String getStringCellData(int row, int column) {
		String StringcellData=null;
		 StringcellData=sheet.getRow(row).getCell(column).getStringCellValue();
		System.out.println("Cell Data is: "+StringcellData);
		return StringcellData;
	}
	
	public  Double getNumericCellData(int row, int column) {
		Double cellDataNumeric=0.0; 
		 cellDataNumeric=sheet.getRow(row).getCell(column).getNumericCellValue();
		System.out.println("Cell Data is: "+cellDataNumeric);
		return cellDataNumeric;
	}
	
	
	
	public void itreator() {
		Iterator <Row> rowItr=sheet.iterator();
		
		while (rowItr.hasNext()) {
			Row row=rowItr.next();
		Iterator<Cell> cellItr=	row.cellIterator();
		while (cellItr.hasNext()) {
		Cell cell=cellItr.next();
		System.out.print(cell.toString()+ " | ");
		}
		System.out.println();
		}
	}
public static void main(String[] args) {
	ExcelUtilsWithReturn excel = new ExcelUtilsWithReturn("C:\\Users\\Faruq\\Desktop\\Library\\TEP\\CreateRow_Cell.xlsx","Sheet0");
	                       excel.getRowCount();
	                       excel.getColCount();
	                       excel.getStringCellData(0, 0);
	                       excel.getStringCellData(0, 1);
	                       excel.getStringCellData(1, 0);
	                      excel.getNumericCellData(1, 1);
	                      excel.getNumericCellData(2, 1);
	                      excel.getNumericCellData(3, 1);
	                      //*****************
	                      excel.getNumericCellData(0, 0);
}
	
}
