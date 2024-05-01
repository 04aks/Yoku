package aks.app.opening;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import aks.app.Main;

public class StartPanel extends JPanel{
    Main main;

    public static int WIDTH = 720, HEIGHT = 350;
    public static int GITHUB = 0, TWITTER = 1, CODE = 2;
    public Rectangle titleBar = new Rectangle(0,0,WIDTH-1,50), addButton = new Rectangle(0,0,0,0),
                    exitButton = new Rectangle(0,0,0,0);
    public boolean moveFrame, buttonHovered = false;
    public OpeningMouse om;
    
    
    public StartPanel(Main main){
        this.main = main;
        om = new OpeningMouse(main);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.DARK_GRAY);
        addMouseListener(om);
        addMouseMotionListener(om);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        main.ui.drawOpeningPanel(g2);
    }
    

    
}
