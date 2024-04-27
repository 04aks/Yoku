package aks.app.threads;

import javax.swing.SwingWorker;

import aks.app.Main;

public class PrepareExcelThread extends SwingWorker<Void, Void>{
    Main main;
    public PrepareExcelThread(Main main){
        this.main = main;
    }
    @Override
    protected Void doInBackground() throws Exception {
        main.cellsManager.prepareCells();
        main.excelEx.fetchData(main.excelEx.sheet);
        main.excelEx.getTableTitle();

        main.mainFrame.mainPanel.repaint();
        return null;
    }
}
