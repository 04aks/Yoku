package aks.app.mainframe.left;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SubLeftPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
    Main main;
    SUB_LeftPanel slp;
    public SubLeftPanel(Main main, SUB_LeftPanel slp){
        this.main = main;
        this.slp = slp;
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
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
        g2.setColor(Strings.GREEN_SELECTION);
        if(slp.filterOption == slp.sentOption){
            g2.fillRoundRect(rectsX, radioBoxY, radioWidth, radioWidth, arc, arc);
        }   
        if(slp.filterOption == slp.recievedOption){
            g2.fillRoundRect(recievedButX, radioBoxY, radioWidth, radioWidth, arc, arc);
        } 
        main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 15, Color.LIGHT_GRAY);
        g2.drawRoundRect(rectsX, radioBoxY, radioWidth, radioWidth,arc,arc);
        g2.drawString("Sent", rectsX + radioWidth + 6, radioBoxY+14);
        slp.sentBut.setBounds(rectsX, radioBoxY, hitboxWidth, radioWidth);
        //RECIEVED RADIO BUTTON
        g2.drawRoundRect(recievedButX, radioBoxY, radioWidth, radioWidth,arc,arc);
        g2.drawString("Recieved", recievedButX + radioWidth + 6, radioBoxY+14);
        slp.recievedBut.setBounds(recievedButX, radioBoxY, hitboxWidth, radioWidth);


        
        if(slp.searchButtonHovered){
            g2.setColor(Strings.CUSTOM_DARKGRAY);
        }else{
            g2.setColor(Strings.CUSTOM_LIGHTGRAY);
        }
        int buttonWidth = 200;
        int buttonHeight = 40;
        int buttonX = (getWidth() - buttonWidth) / 2;
        int buttonY = getHeight() - 50;
        g2.fillRoundRect(buttonX, buttonY, buttonWidth, buttonHeight, 20, 20);
        slp.searchButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        String butText = "SEARCH";
        int butTextX = main.ui.getXForCenteredText(g2, butText, getWidth());
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawString(butText, butTextX, buttonY+25);


        g2.setStroke(new BasicStroke(1));
        g2.setColor(Strings.BORDER_COLOR);
        g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
        
    }
    public void drawTextFields(Graphics2D g2, int x, int y, int width, int height){

        g2.setStroke(new BasicStroke(2));
        
        for(int i = 0; i < slp.totalInputFields; i++){
            
            if(slp.inputNeededBool[i]){
                g2.setColor(Color.LIGHT_GRAY);
            }else{
                g2.setColor(Strings.CUSTOM_LIGHTGRAY);
            }

            
            main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 16, Color.LIGHT_GRAY);
            if(slp.inputSelectBool[i]){
                g2.setColor(Strings.GREEN_SELECTION);
            }

            //INPUT TEXT
            if(slp.inputContent[i] != null){
                g2.drawString(slp.inputContent[i], x+10, y+26);
            }

            //FIELDS AND HINTS
            g2.drawRoundRect(x, y, width, height, 20, 20);
            main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 13, Color.LIGHT_GRAY);
            g2.drawString(slp.inputHint[i], x, y+height+13);
            slp.inputRectangles[i].setBounds(x, y, width, height);
            y+=height+20;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(slp.sentBut.contains(e.getX(), e.getY())){
            if(slp.filterOption == slp.recievedOption){
                slp.filterOption = slp.sentOption;
            }
        }

        if(slp.recievedBut.contains(e.getX(), e.getY())){
            if(slp.filterOption == slp.sentOption){
                slp.filterOption = slp.recievedOption;
            }
        }

        for(int i = 0; i < slp.totalInputFields; i++){
            if(slp.inputRectangles[i].contains(e.getX(),e.getY())){
                slp.inputSelectBool[i] = true;
            }else{
                slp.inputSelectBool[i] = false;
            }
        }

        if(slp.searchButton.contains(e.getX(),e.getY())){
            main.searchRow.searchPayements(slp.inputContent[SUB_LeftPanel.AMOUNT], slp.inputContent[SUB_LeftPanel.ACCOUNT], slp.inputContent[SUB_LeftPanel.DATE]);
        }
        repaint();
    }
    //MOUUUUUSE
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    //KEYYYYS
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        char character = e.getKeyChar();
        

        //DELETE
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            deleteInput();
        }
        //INPUT
        if(code != KeyEvent.VK_CAPS_LOCK && code != 155 && code != 36 && code != 33 && code != 127 && code != 35 && code != 34 && code != 10 && code != 8 && code != 17 && code != 18 && code != 16 && code != 38 && code != 40 && code != 37 && code != 39){
            input(character);
        }

        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    public void input(char character){
        if(slp.inputSelectBool[SUB_LeftPanel.AMOUNT]){
            if(slp.amountIndex < slp.amountString.length){
                slp.amountString[slp.amountIndex] = character;
                slp.amountIndex++;
                slp.inputContent[SUB_LeftPanel.AMOUNT] = new String(slp.amountString).trim();
            }
        }

        else if(slp.inputSelectBool[SUB_LeftPanel.ACCOUNT]){
            if(slp.ccpIndex < slp.ccpString.length){
                slp.ccpString[slp.ccpIndex] = character;
                slp.ccpIndex++;
                slp.inputContent[SUB_LeftPanel.ACCOUNT] = new String(slp.ccpString).trim();
            }
        }

        else if(slp.inputSelectBool[SUB_LeftPanel.DATE]){
            if(slp.dateIndex < slp.dateString.length){
                slp.dateString[slp.dateIndex] = character;
                slp.dateIndex++;
                slp.inputContent[SUB_LeftPanel.DATE] = new String(slp.dateString).trim();
            }
        }
        
    }
    public void deleteInput(){
        if(slp.inputSelectBool[SUB_LeftPanel.AMOUNT]){
            if(slp.amountIndex > 0){
                slp.amountString[slp.amountIndex - 1] = ' ';
                slp.amountIndex--;
                slp.inputContent[SUB_LeftPanel.AMOUNT] = new String(slp.amountString).trim();
            }
        }

        else if(slp.inputSelectBool[SUB_LeftPanel.ACCOUNT]){
            if(slp.ccpIndex > 0){
                slp.ccpString[slp.ccpIndex - 1] = ' ';
                slp.ccpIndex--;
                slp.inputContent[SUB_LeftPanel.ACCOUNT] = new String(slp.ccpString).trim();
            }
        }

        else if(slp.inputSelectBool[SUB_LeftPanel.DATE]){
            if(slp.dateIndex > 0){
                slp.dateString[slp.dateIndex - 1] = ' ';
                slp.dateIndex--;
                slp.inputContent[SUB_LeftPanel.DATE] = new String(slp.dateString).trim();
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        if(slp.searchButton.contains(e.getX(),e.getY())){
            slp.searchButtonHovered = true;
        }else{
            slp.searchButtonHovered = false;
        }
        repaint();
    }
}
