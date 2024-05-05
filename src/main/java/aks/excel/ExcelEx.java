package aks.excel;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import aks.app.Main;

public class ExcelEx {
    Main main;
    String fileAddress;
    File file;
    public String tableTitle, subTitle;
    public Sheet sheet;
    public ExcelEx(Main main){
        this.main = main;
    }
    public int chooseFile(){

        FileDialog fileDialog = new FileDialog(main.startFrame.frame, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String fileName = fileDialog.getFile();

        if(fileName != null){
            int lastDotIndex = fileName.lastIndexOf(".");
            String fileExt;
            if(lastDotIndex != -1){
                fileExt = fileName.substring(lastDotIndex+1);
                if(fileExt.equals("xlsx")){
                    fileAddress = fileDialog.getDirectory();
                    file = new File(fileAddress+"/"+fileName);
                    return 1;
                }
            }
        }
        return 0;
        
    }
    public Sheet fetchSheet(){

        if(file != null){
            try{
                FileInputStream fis = new FileInputStream(file);
                Workbook workbook = WorkbookFactory.create(fis);
                sheet = workbook.getSheetAt(0);
                return sheet;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public int maxRows(Sheet sheet){

        return sheet.getLastRowNum();
    }
    public void fetchData(Sheet sheet){

        int index = 0;
        int startsAt = 5;
        for(Row row : sheet){
            main.cellsManager.excelCells[index] = new ExcelCells();

            if(row.getRowNum() >= startsAt){
                for(Cell cell : row){
                    if(cell.getColumnIndex() == 0){
                        main.cellsManager.excelCells[index].setTransactionDate(cell.getStringCellValue());
                    }   
                    if(cell.getColumnIndex() == 1){
                        main.cellsManager.excelCells[index].setTransactionCode(cell.getStringCellValue());
                    }       
                    if(cell.getColumnIndex() == 2){
                        long ccp = (long)cell.getNumericCellValue();
                        main.cellsManager.excelCells[index].setOtherParty(Long.toString(ccp));
                    }     
                    if(cell.getColumnIndex() == 3){
                        main.cellsManager.excelCells[index].setSent(cell.getNumericCellValue());
                    }  
                    if(cell.getColumnIndex() == 4){
                        main.cellsManager.excelCells[index].setRecieved(cell.getNumericCellValue());
                    }  
                    if(cell.getColumnIndex() == 5){
                        main.cellsManager.excelCells[index].setTax(cell.getNumericCellValue());
                    }  
                    if(cell.getColumnIndex() == 6){
                        main.cellsManager.excelCells[index].setRemaining(cell.getNumericCellValue());
                    }  
                }
                main.cellsManager.cellsList.offerLast(main.cellsManager.excelCells[index]);
                main.mainFrame.mainPanel.repaint();
                index++;
            }
        }
    }
    public void getTableTitle(){

        subTitle = sheet.getRow(0).getCell(1).getStringCellValue();
        tableTitle = sheet.getRow(1).getCell(1).getStringCellValue();
    }
}
