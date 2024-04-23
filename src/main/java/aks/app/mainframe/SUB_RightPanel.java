package aks.app.mainframe;

import java.awt.Dimension;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_RightPanel extends JPanel{
    Main main;
    public SUB_RightPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(100,100));
        setBackground(Strings.HERO_COLOR);
    }
}
