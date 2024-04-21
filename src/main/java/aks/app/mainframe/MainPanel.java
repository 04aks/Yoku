package aks.app.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import aks.app.Main;

public class MainPanel extends JPanel{
    Main main;
    public static int WIDTH = 900, HEIGHT = 600;
    public SUB_BottomPanel buttomPanel;
    public SUB_TopPanel topPanel;
    public MainPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());

        buttomPanel = new SUB_BottomPanel(main);
        topPanel = new SUB_TopPanel(main);
        add(buttomPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
    }
}
