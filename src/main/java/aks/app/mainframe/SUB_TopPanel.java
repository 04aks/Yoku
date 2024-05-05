package aks.app.mainframe;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_TopPanel extends JPanel implements MouseMotionListener, MouseListener{
    Main main;
    public Rectangle[] headerButtons = new Rectangle[3];

    public SUB_TopPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(100,26));
        // setBackground(Strings.HERO_COLOR);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10,3));
        instantiateIteration();
        setLabels();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void instantiateIteration(){
        for(int i = 0; i < headerButtons.length; i++){
            headerButtons[i] = new Rectangle(0,0,0,0);
        }
    }
    public void setLabels(){
        JLabel gitLabel = null;
        addLabel(gitLabel, Strings.GIT_IMG_PATH, "https://github.com/04aks");

        JLabel codeLabel = null;
        addLabel(codeLabel, Strings.CODE_IMG_PATH, "https://github.com/04aks/Yoku");

        // JLabel minLabel = new JLabel();
        // minLabel.setIcon(new ImageIcon(getClass().getResource(Strings.MIN_IMG_PATH)));
        // minLabel.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //         main.mainFrame.frame.setState(Frame.ICONIFIED);
        //     }
        // });
        // add(minLabel);
        

        // JLabel maxLabel = new JLabel();
        // maxLabel.setIcon(new ImageIcon(getClass().getResource(Strings.MAX_IMG_PATH)));
        // maxLabel.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //         main.mainFrame.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        //     }
        // });
        // add(maxLabel);

        // JLabel exitLabel = new JLabel();
        // exitLabel.setIcon(new ImageIcon(getClass().getResource(Strings.EXIT_IMG_PATH)));
        // exitLabel.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //         System.exit(0);
        //     }
        // });
        // add(exitLabel);
    }
    public void addLabel(JLabel label, String imgPath, String link){

        label = new JLabel();
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                main.utils.browseSource(link);
            }
        });
        label.setIcon(new ImageIcon(getClass().getResource(imgPath)));
        add(label);
    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Strings.PANEL_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Strings.BORDER_COLOR);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        main.mainFrame.frame.setLocation(e.getXOnScreen() - MainFrame.FRAME_X, e.getYOnScreen() - MainFrame.FRAME_Y);
        // revalidate();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        MainFrame.FRAME_X = e.getX();
        MainFrame.FRAME_Y = e.getY();
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
