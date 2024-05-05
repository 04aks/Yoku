package aks.excel;

import java.util.LinkedList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import aks.app.Main;

public class SearchRow {
    Main main;
    public LinkedList<ExcelCells> filtered = new LinkedList<ExcelCells>();
    public SearchRow(Main main){
        this.main = main;
    }
    public void searchPayements(String amount, String ccp, String date){

        int amountIndex;
        int sendIndex = 3;
        int recieveIndex = 4;
        int ccpIndex = 2;
        int dateIndex = 0;

        int rowStarts = 5;
        for(Row row : main.excelEx.sheet){
            if(row.getRowNum() >= rowStarts){
                for(Cell cell : row){

                    //FILTERING RECIEVED MONEY
                    

                    if(!amount.isEmpty()){
                        long ccpNum = (long)row.getCell(ccpIndex).getNumericCellValue();
                        String excelDate = row.getCell(dateIndex).getStringCellValue();
                        int amountInt = Integer.parseInt(amount);
                        int cellIndex = cell.getColumnIndex();
                        

                        if(main.mainFrame.mainPanel.leftPanel.filterOption == main.mainFrame.mainPanel.leftPanel.recievedOption){
                            amountIndex = recieveIndex;
                        }else{
                            amountIndex = sendIndex;
                            amountInt*=-1;
                        }

                        // if (amountInt == row.getCell(amountIndex).getNumericCellValue() && ccp.equals(Long.toString(ccpNum)) && date.equals(row.getCell(dateIndex).getStringCellValue())) {
                        //     System.out.println(main.cellsManager.cellsList.get(cell.getRowIndex() - rowStarts).getTransactionCode() + "    " + (cell.getRowIndex() - rowStarts));
                        //     break;
                        // }
                        if(amountInt == row.getCell(amountIndex).getNumericCellValue()){

                            boolean ccpMatches = false, dateMatches = false;
                            if(ccp.equals(Long.toString(ccpNum))){
                                ccpMatches = true;
                            }
                            if(date.equals(excelDate)){
                                dateMatches = true;
                            }else{dateMatches = false;}



                            
                            
                            if(!ccp.isEmpty() && !date.isEmpty() && ccpMatches && dateMatches){
                                System.out.println("third condition");
                                updateFilteredList(row, rowStarts);                                
                            }
                            if(!ccp.isEmpty() && date.isEmpty() && ccpMatches && !dateMatches){
                                System.out.println("first condition");
                                updateFilteredList(row, rowStarts);
                            }
                            if(ccp.isEmpty() && !date.isEmpty() && !ccpMatches && dateMatches){
                                System.out.println("second condition");
                                updateFilteredList(row, rowStarts);
                            }
                            
                            break;
                        }
                        
                    }
                    

                    //FILTERING SENT MONEY 
                    // if(main.mainFrame.mainPanel.leftPanel.filterOption == main.mainFrame.mainPanel.leftPanel.sentOption){
                    //     if(cell.getColumnIndex() == sendIndex){
                    //         if (Integer.parseInt(amount) == cell.getNumericCellValue()*-1) {
                    //             System.out.println("-_-");
                    //         }
                    //     }
                    // }
                }
            }
        }
    }
    public void updateFilteredList(Row row, int rowStarts){

        filtered.offerLast(main.cellsManager.cellsList.get(row.getRowNum() - rowStarts));
        System.out.println(filtered);
        if(!main.mainFrame.mainPanel.rightPanel.subRightPanel.drawFiltered){
            main.mainFrame.mainPanel.rightPanel.subRightPanel.drawFiltered = true;
        }
        main.mainFrame.mainPanel.rightPanel.subRightPanel.repaint();
    }
}
