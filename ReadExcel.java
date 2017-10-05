


import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

class ReadExcel {

    File inputWorkbook;
    //private String inputFile;
    Workbook w;

    public ReadExcel(String inputFile) {
        inputWorkbook = new File(inputFile);
    }
    /*public void setInputFile() {
    this.inputFile = inputFile;

    }*/

    public String[][] read() throws IOException {
        String[][] values = null;


        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines
            values = new String[sheet.getColumns()][sheet.getRows()];
            //System.out.println("row : "+sheet.getRows());
            //System.out.println("col : "+sheet.getColumns());
            //lets take it from j =0 and i =1 to avoid header of excel files
            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 1; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    //System.out.println("I got a number "
                    //		+ cell.getContents());
                    //System.out.println("******************************************************("+j+","+i+")");
					/*if (cell.getType() == CellType.LABEL) {
                    System.out.println("I got a label "
                    + cell.getContents());
                    }

                    if (cell.getType() == CellType.NUMBER) {
                    System.out.println("I got a number "
                    + cell.getContents());
                    }*/

                    values[j][i - 1] = String.valueOf((cell.getContents()));

                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
            return null;
        }
        return values;
    }

    public int getRow() {
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines
            return sheet.getRows();
        } catch (Exception e) {
            return 0;
        }

    }

    public int getCol() {
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines
            return sheet.getColumns();
        } catch (Exception e) {
            return 0;
        }

    }

    /*public static void main(String[] args) throws IOException {
    ReadExcel test = new ReadExcel();
    test.setInputFile("data.xls");
    test.read();
    }*/
}
