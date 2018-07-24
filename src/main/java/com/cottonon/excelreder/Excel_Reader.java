package com.cottonon.excelreder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cottonon.base.TestBase;

public class Excel_Reader extends TestBase{
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public String path;
	public Excel_Reader(String path)
	{
		this.path=path;
		try {
			
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public String[][] getexceldata(String sheetname) throws IOException
	{
		String datasets[][]=null;
		sheet=workbook.getSheet(sheetname);
		int totalrow = sheet.getLastRowNum()+1;
		int totalcolumn = sheet.getRow(0).getLastCellNum();
		
		datasets = new String[totalrow-1][totalcolumn];
		
		for(int i=1;i<totalrow;i++)
		{
			XSSFRow rows = sheet.getRow(i);
			for(int j=0;j<totalcolumn;j++)
			{
				XSSFCell cell = rows.getCell(j);
				
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				{
					datasets[i-1][j]=cell.getStringCellValue();
				}
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					String celltext=String.valueOf(cell.getNumericCellValue());
					datasets[i-1][j]=celltext;
				}
				else
					datasets[i-1][j]=String.valueOf(cell.getBooleanCellValue());
			}
		}
		return datasets;
	}
}
