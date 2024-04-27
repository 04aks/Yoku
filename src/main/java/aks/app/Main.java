package aks.app;

import aks.app.mainframe.MainFrame;
import aks.app.opening.StartFrame;
import aks.excel.ExcelEx;
import aks.excel.CellsManager;

public class Main {

    public Utils utils = new Utils();
    public UI ui = new UI(this);
    public MainFrame mainFrame;
    public StartFrame startFrame;
    public ExcelEx excelEx = new ExcelEx(this);
    public CellsManager cellsManager = new CellsManager(this);
    
    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        startFrame = new StartFrame(this);
    }
}