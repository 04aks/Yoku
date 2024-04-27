package aks.app.mainframe.right;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import aks.app.Main;

public class RightPanelScroll implements MouseWheelListener{

    Main main;
    public RightPanelScroll(Main main){
        this.main = main;
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int scrollAmount = 20;
        if(e.getWheelRotation() > 0){
            if(main.mainFrame.mainPanel.rightPanel.subRightPanel.y - scrollAmount > main.mainFrame.mainPanel.rightPanel.subRightPanel.getHeight() - 20){
                main.mainFrame.mainPanel.rightPanel.subRightPanel.scroll -= scrollAmount;
            }
        }
        if(e.getWheelRotation() < 0){
            if(main.mainFrame.mainPanel.rightPanel.subRightPanel.scroll + scrollAmount >= 0){
                main.mainFrame.mainPanel.rightPanel.subRightPanel.scroll = 0;
                
            }else{
                main.mainFrame.mainPanel.rightPanel.subRightPanel.scroll += scrollAmount;
            }
        }
        
        main.mainFrame.mainPanel.rightPanel.subRightPanel.repaint();
        
    }
    
}
