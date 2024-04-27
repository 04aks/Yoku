package aks.excel;

import java.util.LinkedList;

import aks.app.Main;

public class CellsManager {
    Main main;
    
    ExcelCells[] excelCells;
    public LinkedList<ExcelCells> cellsList = new LinkedList<ExcelCells>();

    public CellsManager(Main main){
        this.main = main;
    }

    public void prepareCells(){

        main.excelEx.sheet = main.excelEx.fetchSheet();
        excelCells = new ExcelCells[main.excelEx.maxRows(main.excelEx.sheet)];
    }
}
