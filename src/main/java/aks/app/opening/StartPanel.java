package aks.app.opening;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import aks.app.Main;

public class StartPanel extends JPanel{
    Main main;

    public static int WIDTH = 720, HEIGHT = 500;
    public Rectangle titleBar = new Rectangle(0,0,WIDTH-1,50), addButton = new Rectangle(0,0,0,0),
                    exitButton = new Rectangle(0,0,0,0);
    public boolean moveFrame, buttonHovered = false;
    OpeningMouse om;
    
    
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
    public int chooseFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        if (fileChooser.getSelectedFile()!= null) {
            return 1;
        }
        return 0;
    }

    
}
