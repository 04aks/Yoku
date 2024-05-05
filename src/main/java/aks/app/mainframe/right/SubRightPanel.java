package aks.app.mainframe.right;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SubRightPanel extends JPanel implements MouseListener, MouseMotionListener{
    Main main;
    RightPanelScroll rPanelScroll;
    public int y, scroll;
    public boolean drawFiltered = false;
    Rectangle exitFilter = new Rectangle();
    public SubRightPanel(Main main){
        this.main = main;
        rPanelScroll = new RightPanelScroll(main, this);
        addMouseWheelListener(rPanelScroll);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Strings.PANEL_COLOR);
        g2.fillRect(0, 0, getWidth(), getHeight());
        y = 60 + scroll;

        if(main.excelEx.tableTitle != null){
            String title = main.excelEx.subTitle;
            main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 20, Color.LIGHT_GRAY);
            int x = main.ui.getXForCenteredText(g2, title, getWidth());
            g2.drawString(title, x, y);


            String subTitle = main.excelEx.tableTitle;
            main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 15, Color.LIGHT_GRAY);
            int xS = main.ui.getXForCenteredText(g2, subTitle, getWidth());
            g2.drawString(subTitle, xS, y+20);
        }
        

        Color selectedColor = new Color(0x686868);
        Color plainColor = new Color(0x525252);
        
        y += 30;
        int x = 5;
        int width = getWidth()-10;
        int height = 50;
        for(int i = 0; i<main.cellsManager.cellsList.size(); i++){
            
            //RECT SHADOW
            g2.setColor(Strings.SHADOWS_COLOR);
            g2.fillRoundRect(x+3, y+3, width, height, 20, 20);
            //RECT FILL
            if(main.cellsManager.cellsList.get(i).hovered){
                g2.setColor(selectedColor);
            }else{
                g2.setColor(plainColor);
            }
            g2.fillRoundRect(x, y, width, height, 20, 20);
            main.cellsManager.cellsList.get(i).rectangle.setBounds(x,y,width,height);
            //RECT BORDER
            g2.setColor(Strings.BORDER_COLOR);
            g2.drawRoundRect(x, y, width, height, 20, 20);   


            //DRAW TRANSACTIONS' DETAILS

            //RECIEVED OR SENT
            main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 15, Color.LIGHT_GRAY);
            int arrowX = 20;
            int arrowY = (height - main.ui.greenArrow.getHeight())/2 + y;
            int recieved = (int)main.cellsManager.cellsList.get(i).getRecieved();
            int currencyY = arrowY + 20;
            int currencyX = arrowX + main.ui.greenArrow.getWidth() + 10;
            main.ui.drawRedGreenArrow(g2, recieved, arrowX, arrowY, currencyX, currencyY, i);

            //DATE
            main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 15, Color.LIGHT_GRAY);
            String date = main.cellsManager.cellsList.get(i).getTransactionDate();
            int dateX = main.ui.alignTextToRight(g2, date, (x+width)-arrowX);
            g2.drawString(date, dateX, currencyY);


            y+=55;
        }


        if(drawFiltered){
            int filteredPanelWidth = getWidth() - 50;
            int filteredPanelHeight = getHeight() - 50;
            int filteredPanelX = (getWidth() - filteredPanelWidth)/2;
            int filteredPanelY = (getHeight() - filteredPanelHeight)/2;
            int filteredPanelArc = 20;

            //UNFOCUS ?
            g2.setColor(new Color(0,0,0,120));
            g2.fillRect(0, 0, getWidth(), getHeight());
            //PANEL SHADOW
            g2.setColor(Strings.SHADOWS_COLOR);
            g2.fillRoundRect(filteredPanelX+5, filteredPanelY+5, filteredPanelWidth, filteredPanelHeight, filteredPanelArc, filteredPanelArc);
            //PANEL
            g2.setColor(Strings.CUSTOM_DARKGRAY);
            g2.fillRoundRect(filteredPanelX, filteredPanelY, filteredPanelWidth, filteredPanelHeight, filteredPanelArc, filteredPanelArc);
            //PANEL BORDER
            g2.setColor(Strings.BORDER_COLOR);
            g2.drawRoundRect(filteredPanelX, filteredPanelY, filteredPanelWidth, filteredPanelHeight, filteredPanelArc ,filteredPanelArc);
            //PANEL X BUTTON
            g2.drawImage(main.ui.exitButton, filteredPanelWidth-10, filteredPanelY+10, null);
            exitFilter.setBounds(filteredPanelWidth-10, filteredPanelY+10, 20, 20);
            //PANEL TITLE
            main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 15, Color.lightGray);
            String title = "Filtering Results";
            int titleX = filteredPanelX + 20;//main.ui.getXForCenteredText(g2, title, filteredPanelWidth) + filteredPanelX;
            g2.drawString(title, titleX, filteredPanelY + 25);
            //DRAW FILTERED ITEMS
            int rectWidth = filteredPanelWidth - 40;
            int rectHeight = 40;
            int rectX = (filteredPanelWidth - rectWidth)/2 + filteredPanelX;
            int rectY = filteredPanelY + 60;
            int rectArc = 20;
            for(int i = 0; i < main.searchRow.filtered.size(); i++){
                //RECTANGLE SHADOW
                g2.setColor(Strings.SHADOWS_COLOR);
                g2.fillRoundRect(rectX+3, rectY+3, rectWidth, rectHeight, rectArc, rectArc);
                //RECTANGLE FILL
                g2.setColor(Strings.CUSTOM_LIGHTGRAY);
                g2.fillRoundRect(rectX, rectY, rectWidth, rectHeight, rectArc, rectArc);
                //RECTANGLE BORDER
                g2.setColor(Strings.BORDER_COLOR);
                g2.drawRoundRect(rectX, rectY, rectWidth, rectHeight, rectArc, rectArc);
                //FILTERED ITEMS DETAILS
                int amount = (int)main.searchRow.filtered.get(i).getRecieved();
                main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 15, Color.LIGHT_GRAY);
                main.ui.drawRedGreenArrow(g2, amount, rectX+10, rectY+5, rectX+50, rectY+25, i);
                int f = rectX + 50;
                int remainingWidth = filteredPanelWidth - f;
                int half = remainingWidth/2;
                String code = main.searchRow.filtered.get(i).getTransactionCode();
                g2.drawString(code, main.ui.alignTextToRight(g2, code, half+f), rectY +25);
                String secondParty = main.searchRow.filtered.get(i).getOtherParty();
                g2.drawString(secondParty, main.ui.alignTextToRight(g2, secondParty, (half*2)+f), rectY +25);

                rectY += rectHeight + 5;
            }
        }



        g2.setColor(Strings.BORDER_COLOR);
        g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(!drawFiltered){
            for(int i = 0; i < main.cellsManager.cellsList.size(); i++){
                if(main.cellsManager.cellsList.get(i).rectangle.contains(e.getX(),e.getY())){
                    System.out.println(i);
                }
            }
        }else{
            if(exitFilter.contains(e.getX(), e.getY())){
                drawFiltered = false;
            }
        }
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
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        if(!drawFiltered){
            for(int i = 0; i < main.cellsManager.cellsList.size(); i++){
                if(main.cellsManager.cellsList.get(i).rectangle.contains(e.getX(), e.getY())){
                    main.cellsManager.cellsList.get(i).hovered = true;
                }else{
                    main.cellsManager.cellsList.get(i).hovered = false;
                }
            }  
        }

        repaint();
    }
}
