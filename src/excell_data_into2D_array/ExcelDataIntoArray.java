package excell_data_into2D_array;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataIntoArray {
	public static String[][] readingExcelDataUsingArray() {
		String[][] Array = null;

		File f = new File("Config/Book1.xlsx");
		try {
			FileInputStream fr = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fr);
			XSSFSheet sheet = wb.getSheetAt(0);
			int totalrows = sheet.getLastRowNum();

			Array = new String[totalrows + 1][];
			for (int i = 0; i <= totalrows; i++) {
				int cols = sheet.getRow(i).getPhysicalNumberOfCells();
				Array[i] = new String[cols];
				for (int j = 0; j < cols; j++) {
					XSSFCell ocell = sheet.getRow(i).getCell(j);
					CellType type = ocell.getCellTypeEnum();
					switch (type) {
					case STRING:
						Array[i][j] = ocell.getStringCellValue();

						break;
					case NUMERIC:
						Array[i][j] = String.valueOf(ocell.getStringCellValue());

					case BOOLEAN:
					default:
						break;

					}

				}

			}
			fr.close();
			wb.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

			e.printStackTrace();
		}
		return Array;

	}

	public static void readingDataFromArray() {
		String val=null;
		String[][] data = readingExcelDataUsingArray();
		int rownum = data.length;
		for (int i = 1; i < rownum; i++) {
			String user = data[i][0];
			if (user.equalsIgnoreCase("dsalkdjsa")) {
			int colnum = data[i].length;
			for (int j = 1; j < colnum; j++) {
				String header = data[0][j];
				if (header.equalsIgnoreCase("val2")) {
					val = data[i][j];
					
					break;
				}
			}
		}
		
		}
		System.out.println(val);
		}
	public static void main(String[] args) {

		readingDataFromArray();
	}

}
