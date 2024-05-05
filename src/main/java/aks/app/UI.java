package aks.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import aks.app.opening.StartPanel;
import aks.excel.ExcelCells;

public class UI {
    Main main;
    public BufferedImage greenArrow, redArrow, exitButton;
    public Font fontRegular, fontBlack;
    public UI(Main main){
        this.main = main;
        fontRegular = main.utils.createFont("/aks/res/fonts/Roboto-Regular.ttf");
        fontBlack = main.utils.createFont("/aks/res/fonts/Roboto-Black.ttf");
        importImages();
    }

    public void importImages(){
        greenArrow = main.utils.importImage(Strings.GREEN_ARROW_PATH);
        redArrow = main.utils.importImage(Strings.RED_ARROW_PATH);
        exitButton = main.utils.importImage(Strings.EXIT_IMG_PATH);
    }
    public void drawOpeningPanel(Graphics2D g2){

        setFontAtt(g2, main.ui.fontBlack, Font.BOLD, 20, Color.LIGHT_GRAY);
        int hitboxX = StartPanel.WIDTH - 30;
        int exitY = 10;
        main.startFrame.sp.exitButton.setBounds(hitboxX, exitY, 20, 20);
        g2.drawImage(exitButton, hitboxX, exitY, null);

        
        String title = Strings.APP_NAME;
        String description = Strings.APP_DESC;
        int marginLeft = 50;
        int marginTop = 100;
        //TITLE SHADOW
        setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 50, Strings.SHADOWS_COLOR);
        g2.drawString(title, marginLeft-3, marginTop+3);
        //TITLE
        setFontAtt(g2, main.ui.fontBlack, Font.PLAIN, 50, Color.WHITE);
        g2.drawString(title, marginLeft, marginTop);


        setFontAtt(g2, fontRegular, Font.PLAIN, 15, Color.LIGHT_GRAY);
        for(String line : description.split("\n")){
            g2.drawString(line, marginLeft, marginTop+40);
            marginTop+=20;
        }


        int width = 200;
        int height = 40;
        int x = (StartPanel.WIDTH - width)/2;
        int y = StartPanel.HEIGHT - 70;
        main.startFrame.sp.addButton.setBounds(x,y,width,height);
        
        g2.setColor(Strings.CUSTOM_DARKGRAY);
        // g2.fillRoundRect(x, y, width, height, 10, 10);
        setFontAtt(g2, fontBlack, Font.PLAIN, 15, Color.LIGHT_GRAY);
        String butText = "OPEN EXCEL FILE";
        int butDesX = getXForCenteredText(g2, butText, StartPanel.WIDTH);
        g2.drawString(butText, butDesX, y+25);
        if(main.startFrame.sp.buttonHovered){   
            // g2.setStroke(new BasicStroke(2));
            //BUTTON TEXT SHADOW
            g2.setColor(Strings.SHADOWS_COLOR);
            g2.drawString(butText, butDesX+3, y+25+3);
            //BUTTON TEXT
            g2.setColor(Color.white);
            g2.drawString(butText, butDesX, y+25);
            // g2.drawRoundRect(x, y, width-1, height-1, 10, 10);
        }
    }
    public void drawRedGreenArrow(Graphics2D g2, int recieved, int arrowX, int arrowY, int currencyX, int currencyY, int i, ExcelCells excelCell){
        if(recieved > 0){
            g2.drawImage(main.ui.greenArrow, arrowX, arrowY, null);
            g2.drawString(Integer.toString(recieved), currencyX, currencyY);
        }else{
            g2.drawImage(main.ui.redArrow, arrowX, arrowY, null);
            int sent = (int)(excelCell.getSent()*(-1));
            g2.drawString(Integer.toString(sent), currencyX, currencyY);
        }
    }
    public int getXForCenteredText(Graphics2D graphics, String text, int panel){
        int length = (int)(graphics.getFontMetrics().getStringBounds(text, graphics).getWidth());
        return (panel - length)/2;
    }
    public void setFontAtt(Graphics2D graphics, Font font, int style ,int size, Color color){
        graphics.setColor(color);
        graphics.setFont(font);
        graphics.setFont(graphics.getFont().deriveFont(style,size));
    }
    public int alignTextToRight(Graphics2D g2, String text, int tail){

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return tail - length;
    }
    
}
