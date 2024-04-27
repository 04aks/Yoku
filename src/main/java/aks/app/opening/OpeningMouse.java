package aks.app.opening;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import aks.app.Main;
import aks.app.mainframe.MainFrame;
import aks.app.threads.PrepareExcelThread;

public class OpeningMouse implements MouseListener, MouseMotionListener{
    Main main;
    public OpeningMouse(Main main){
        this.main = main;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(main.startFrame.sp.titleBar.contains(e.getX(),e.getY())){
            main.startFrame.sp.moveFrame = true;
            StartFrame.frameX = e.getX();
            StartFrame.frameY = e.getY();
        }
        if(main.startFrame.sp.addButton.contains(e.getX(),e.getY())){

            int fileNum = main.excelEx.chooseFile();
            if(fileNum == 1){
                main.startFrame.frame.dispose();
                main.mainFrame = new MainFrame(main);

                PrepareExcelThread peThread = new PrepareExcelThread(main);
                peThread.execute();
                
            }else{
                System.out.println("Selected fuck all");
            }
            
            main.startFrame.sp.buttonHovered = false;
            main.startFrame.sp.repaint();
        }
        if(main.startFrame.sp.exitButton.contains(e.getX(),e.getY())){
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        main.startFrame.sp.moveFrame = false;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(main.startFrame.sp.moveFrame){
            main.startFrame.frame.setLocation(e.getXOnScreen() - StartFrame.frameX, e.getYOnScreen() - StartFrame.frameY);
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        if(main.startFrame.sp.addButton.contains(e.getX(),e.getY())){
            main.startFrame.sp.buttonHovered = true;
        }else{
            main.startFrame.sp.buttonHovered = false;
        }
        main.startFrame.sp.repaint();
    }
    
}
