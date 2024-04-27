package aks.app.mainframe.right;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SubRightPanel extends JPanel implements MouseListener, MouseMotionListener{
    Main main;
    RightPanelScroll rPanelScroll;
    public int y, scroll;
    public SubRightPanel(Main main){
        this.main = main;
        rPanelScroll = new RightPanelScroll(main);
        addMouseWheelListener(rPanelScroll);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(0,0,0,195));
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
            
            if(main.cellsManager.cellsList.get(i).hovered){
                g2.setColor(selectedColor);
            }else{
                g2.setColor(plainColor);
            }
            g2.fillRoundRect(x, y, width, height, 20, 20);
            main.cellsManager.cellsList.get(i).rectangle.setBounds(x,y,width,height);


            //DRAW TRANSACTIONS' DETAILS

            //RECIEVED OR SEN
            main.ui.setFontAtt(g2, main.ui.fontRegular, Font.PLAIN, 15, Color.LIGHT_GRAY);
            int arrowX = 20;
            int arrowY = (height - main.ui.greenArrow.getHeight())/2 + y;
            int recieved = (int)main.cellsManager.cellsList.get(i).getRecieved();
            int currencyY = arrowY + 20;
            int currencyX = arrowX + main.ui.greenArrow.getWidth() + 10;
            if(recieved > 0){
                g2.drawImage(main.ui.greenArrow, arrowX, arrowY, null);
                g2.drawString(Integer.toString(recieved), currencyX, currencyY);
            }else{
                g2.drawImage(main.ui.redArrow, arrowX, arrowY, null);
                int sent = (int)(main.cellsManager.cellsList.get(i).getSent()*(-1));
                g2.drawString(Integer.toString(sent), currencyX, currencyY);
            }


            //DATE
            main.ui.setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 15, Color.LIGHT_GRAY);
            String date = main.cellsManager.cellsList.get(i).getTransactionDate();
            int dateX = main.ui.alignTextToRight(g2, date, (x+width)-arrowX);
            g2.drawString(date, dateX, currencyY);


    


            y+=55;
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for(int i = 0; i < main.cellsManager.cellsList.size(); i++){
            if(main.cellsManager.cellsList.get(i).rectangle.contains(e.getX(),e.getY())){
                System.out.println(i);
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
        for(int i = 0; i < main.cellsManager.cellsList.size(); i++){
            if(main.cellsManager.cellsList.get(i).rectangle.contains(e.getX(), e.getY())){
                main.cellsManager.cellsList.get(i).hovered = true;
            }else{
                main.cellsManager.cellsList.get(i).hovered = false;
            }
        }
        repaint();
    }
}
