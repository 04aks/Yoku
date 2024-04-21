package aks.app.mainframe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_TopPanel extends JPanel{
    Main main;
    public SUB_TopPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(100,50));
        setBackground(Strings.HERO_COLOR);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BufferedImage logo = main.utils.importImage(Strings.ICON_PATH_SMALL);
        int x = 10;
        //THE IMAGE IS SQUARE SHAPED height = width
        // int scaled = (int)(logo.getWidth() * 0.3);
        int y = (getHeight() - logo.getHeight())/2;
        g2.drawImage(logo, x, y, null);
    }
}
