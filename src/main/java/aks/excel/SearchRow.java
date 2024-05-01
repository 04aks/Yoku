package aks.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import aks.app.Main;

public class SearchRow {
    Main main;
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
                        int amountInt = Integer.parseInt(amount);

                        if(main.mainFrame.mainPanel.leftPanel.filterOption == main.mainFrame.mainPanel.leftPanel.recievedOption){
                            amountIndex = recieveIndex;
                        }else{
                            amountIndex = sendIndex;
                            amountInt*=-1;
                        }

                        if (amountInt == row.getCell(amountIndex).getNumericCellValue() && ccp.equals(Long.toString(ccpNum)) && date.equals(row.getCell(dateIndex).getStringCellValue())) {
                            System.out.println(main.cellsManager.cellsList.get(cell.getRowIndex() - rowStarts).getTransactionCode() + "    " + (cell.getRowIndex() - rowStarts));
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
}
