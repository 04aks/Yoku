package aks.app.mainframe.left;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_LeftPanel extends JPanel{
    Main main;
    int totalInputFields = 3;
    static int AMOUNT = 0, ACCOUNT = 1, DATE = 2;
    String[] inputHint = new String[totalInputFields];
    boolean[] inputSelectBool = new boolean[totalInputFields];
    boolean[] inputNeededBool = new boolean[totalInputFields];
    Rectangle[] inputRectangles = new Rectangle[totalInputFields];

    Rectangle sentBut = new Rectangle(), recievedBut = new Rectangle();
    int filterOption = 0;
    final int sentOption = 0;
    final int recievedOption = 1;

    SubLeftPanel subLeftPanel;

    public SUB_LeftPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(450,100));
        setBackground(Strings.HERO_COLOR);
        setLayout(new BorderLayout());
        interations();
        subLeftPanel = new SubLeftPanel(main);
        add(subLeftPanel, BorderLayout.CENTER);
    }
    public void interations(){
        for(int i = 0; i < totalInputFields; i++){
            inputSelectBool[i] = false;
            inputNeededBool[i] = true;
            inputRectangles[i] = new Rectangle();
        }
        inputHint[AMOUNT] = "Amout sent or recieved";
        inputHint[ACCOUNT] = "ccp";
        inputHint[DATE] = "transaction date (optional)";
    }
    // @Override
    // protected void paintComponent(Graphics g) {
    //     Graphics2D g2 = (Graphics2D)g;
    //     super.paintComponent(g2);
        

    //     // g2.setColor(Color.red);
    //     // g2.draw(recievedBut);
        
    // }
    
    
}
