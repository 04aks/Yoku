package aks.app.mainframe.right;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import aks.app.Main;

public class RightPanelScroll implements MouseWheelListener{

    Main main;
    SubRightPanel srp;
    public RightPanelScroll(Main main, SubRightPanel srp){
        this.main = main;
        this.srp = srp;
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int scrollAmount = 20;
        if(e.getWheelRotation() > 0){
            if(!srp.drawFiltered){
                if(srp.y - scrollAmount > srp.getHeight() - 20){
                    srp.scroll -= scrollAmount;
                }
            }
        }
        if(e.getWheelRotation() < 0){
            if(!srp.drawFiltered){
                if(srp.scroll + scrollAmount >= 0){
                    srp.scroll = 0;
                    
                }else{
                    srp.scroll += scrollAmount;
                }
            }
        }
        
        srp.repaint();
        
    }
    
}
