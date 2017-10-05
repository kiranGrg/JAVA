package newpackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiranroma
 */
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;

public class CreateExcelFile {



	File inputWorkbook;
        WritableWorkbook w;
        String[][] values;


	public CreateExcelFile(String[][] values, String inputFile, int cols, int rows){
            this.values = values;
            try{
		inputWorkbook  = new File(inputFile);
                w = Workbook.createWorkbook(inputWorkbook);
                WritableSheet s = w.createSheet("First Sheet",0);
                for(int i = 0; i<cols; i++){
                    for(int j = 0; j<rows + 1; j++){
                        s.addCell(new Label(i,j, values[j][i]));
                    }
                }
                
                w.write();
                w.close();
            }
            catch(WriteException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }

	}
	
}
