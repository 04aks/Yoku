package aks.app.mainframe.left;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        String title = "Search for Specific Transactions";
        int titleX = 20;
        int titleY = 60;
        main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 27, Color.LIGHT_GRAY);
        g2.drawString(title, titleX, titleY);
        String subtext = "search for a transaction based on the amount sent/recieved, \nthe account it was sent/recieved from and the date it was \nmade on.";
        main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 15, Color.LIGHT_GRAY);
        int subtextY = titleY + 20;
        for(String line : subtext.split("\n")){
            g2.drawString(line, titleX, subtextY);
            subtextY+=15;
        }
    }
}
