package aks.app.mainframe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_LeftPanel extends JPanel{
    Main main;
    public SUB_LeftPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(450,100));
        setBackground(Strings.HERO_COLOR);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);


    }
}
