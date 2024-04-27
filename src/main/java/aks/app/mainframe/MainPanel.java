package aks.app.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.mainframe.left.SUB_LeftPanel;
import aks.app.mainframe.right.SUB_RightPanel;

public class MainPanel extends JPanel{
    Main main;
    public static int WIDTH = 900, HEIGHT = 600;
    SUB_BottomPanel buttomPanel;
    SUB_TopPanel topPanel;
    SUB_LeftPanel leftPanel;
    public SUB_RightPanel rightPanel;
    public MainPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout(2,2));

        buttomPanel = new SUB_BottomPanel(main);
        topPanel = new SUB_TopPanel(main);
        leftPanel = new SUB_LeftPanel(main);
        rightPanel = new SUB_RightPanel(main);
        add(buttomPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
    }
}
