package aks.app.mainframe.right;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_RightPanel extends JPanel{
    Main main;
    public SubRightPanel subRightPanel;
    public SUB_RightPanel(Main main){
        this.main = main;
        setBackground(Strings.HERO_COLOR);
        subRightPanel = new SubRightPanel(main);
        setLayout(new BorderLayout());
        add(subRightPanel, BorderLayout.CENTER);
        
    }
    // @Override
    // public void mouseWheelMoved(MouseWheelEvent e) {
    //     int scrollAmount = 50;
    //     if(e.getWheelRotation() < 0){
            
    //         if(y - scrollAmount < 0){
    //             System.out.println("up");
    //             scroll-=scrollAmount;
    //         }else{System.out.println("fuck");}
    //     }
    //     if(e.getWheelRotation() > 0){
    //         if(y + scrollAmount <= getHeight()){
    //             scroll+=scrollAmount;
    //             System.out.println("down");
    //         }else{System.out.println("fk");}
    //     }

    //     repaint();
    // }
}
