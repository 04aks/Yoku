package aks.app.mainframe.left;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SubLeftPanel extends JPanel implements MouseListener{
    Main main;
    public SubLeftPanel(Main main){
        this.main = main;
        addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(0,0,0,195));
        g2.fillRect(0, 0, getWidth(), getHeight());

        String title = "Search for Specific Transactions";
        int titleX = 20;
        int titleY = 60;
        main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 27, Color.LIGHT_GRAY);
        g2.drawString(title, titleX, titleY);
        String subtext = "Filter transactions based on: \n• The amount sent/recieved. \n• The account the transaction was sent to, or recieved from. \n• The date the transaction was made.";
        main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 15, Color.LIGHT_GRAY);
        int subtextY = titleY + 20;
        for(String line : subtext.split("\n")){
            g2.drawString(line, titleX, subtextY);
            subtextY+=17;
        }

        
        int width = 300;
        int height = 40;
        int rectsX = (getWidth() - width)/2;
        drawTextFields(g2, rectsX, subtextY+50, width,height);


        
        
        int radioBoxY = subtextY + 20;
        int radioWidth = 15;
        int sentButX = rectsX;
        int recievedButX = sentButX + 90;
        int hitboxWidth = 80;
        int arc = 10;
        //SENT RADIO OPTION 
        if(main.mainFrame.mainPanel.leftPanel.filterOption == main.mainFrame.mainPanel.leftPanel.sentOption){
            g2.setColor(Color.GREEN);
            g2.fillRoundRect(rectsX, radioBoxY, radioWidth, radioWidth, arc, arc);
        }   
        if(main.mainFrame.mainPanel.leftPanel.filterOption == main.mainFrame.mainPanel.leftPanel.recievedOption){
            g2.setColor(Color.GREEN);
            g2.fillRoundRect(recievedButX, radioBoxY, radioWidth, radioWidth, arc, arc);
        } 
        main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 15, Color.LIGHT_GRAY);
        g2.drawRoundRect(rectsX, radioBoxY, radioWidth, radioWidth,arc,arc);
        g2.drawString("Sent", rectsX + radioWidth + 6, radioBoxY+14);
        main.mainFrame.mainPanel.leftPanel.sentBut.setBounds(rectsX, radioBoxY, hitboxWidth, radioWidth);
        //RECIEVED RADIO BUTTON
        g2.drawRoundRect(recievedButX, radioBoxY, radioWidth, radioWidth,arc,arc);
        g2.drawString("Recieved", recievedButX + radioWidth + 6, radioBoxY+14);
        main.mainFrame.mainPanel.leftPanel.recievedBut.setBounds(recievedButX, radioBoxY, hitboxWidth, radioWidth);


        // g2.setColor(Color.red);
        // g2.draw(main.mainFrame.mainPanel.leftPanel.sentBut);
        // g2.draw(main.mainFrame.mainPanel.leftPanel.recievedBut);
        
    }
    public void drawTextFields(Graphics2D g2, int x, int y, int width, int height){

        g2.setStroke(new BasicStroke(2));
        main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 13, Color.LIGHT_GRAY);
        for(int i = 0; i < main.mainFrame.mainPanel.leftPanel.totalInputFields; i++){
            
            if(main.mainFrame.mainPanel.leftPanel.inputNeededBool[i]){
                g2.setColor(Color.LIGHT_GRAY);
            }else{
                g2.setColor(Strings.CUSTOM_LIGHTGRAY);
            }
            g2.drawRoundRect(x, y, width, height, 20, 20);
            g2.drawString(main.mainFrame.mainPanel.leftPanel.inputHint[i], x, y+height+13);
            y+=height+20;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(main.mainFrame.mainPanel.leftPanel.sentBut.contains(e.getX(), e.getY())){
            if(main.mainFrame.mainPanel.leftPanel.filterOption == main.mainFrame.mainPanel.leftPanel.recievedOption){
                main.mainFrame.mainPanel.leftPanel.filterOption = main.mainFrame.mainPanel.leftPanel.sentOption;
                System.out.println("fk");
            }
        }

        if(main.mainFrame.mainPanel.leftPanel.recievedBut.contains(e.getX(), e.getY())){
            if(main.mainFrame.mainPanel.leftPanel.filterOption == main.mainFrame.mainPanel.leftPanel.sentOption){
                main.mainFrame.mainPanel.leftPanel.filterOption = main.mainFrame.mainPanel.leftPanel.recievedOption;
                System.out.println("unfuck");
            }
        }

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
