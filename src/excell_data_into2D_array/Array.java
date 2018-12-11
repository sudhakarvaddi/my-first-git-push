package excell_data_into2D_array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Array {
	public static void main(String[] args) {
		read_Excel_Into_2D_Array("Config//Book1.xlsx");
	}

public static void read_Excel_Into_2D_Array(String FilePath ) {
	String[][] data=null;
	FileInputStream fis;
	try {
		fis = new FileInputStream(FilePath);
		XSSFWorkbook book= new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet("Sheet1");
		int rowNum=sheet.getLastRowNum();
		    data=new String[rowNum+1][];
		    for(int i=0;i<=rowNum;i++) {
		    	int colNum=sheet.getRow(i).getPhysicalNumberOfCells();
		    	data[i]=new String[colNum];
		    	for(int j=0;j<colNum;j++) {
		    		XSSFCell ocell=sheet.getRow(i).getCell(j);	    		
		    		CellType type=ocell.getCellTypeEnum();
		    		switch (type){
					case STRING:
						data[i][j]=ocell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j]=String.valueOf(ocell.getStringCellValue());
						break;
					case BOOLEAN:
						break;
					default:
						break;
					}
		    		//System.out.print(data[i][j]+"  ");
		    	}
		    	//System.out.println();
		    }
		System.out.println(data[0][5]);	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
}
