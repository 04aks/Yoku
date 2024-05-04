package aks.app.mainframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_BottomPanel extends JPanel{
    Main main;
    public SUB_BottomPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(100,26));
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.setColor(new Color(0,0,0,195));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Strings.BORDER_COLOR);
        g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 13, Color.LIGHT_GRAY);
        String text = Strings.COPYRIGHT;
        int x = main.ui.getXForCenteredText(g2, text, getWidth());
        g2.drawString(text, x, 18);
        

    }
}
