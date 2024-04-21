package aks.app.mainframe;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import aks.app.Main;
import aks.app.Strings;

public class SUB_TopPanel extends JPanel{
    Main main;
    public Rectangle[] headerButtons = new Rectangle[3];

    public SUB_TopPanel(Main main){
        this.main = main;
        setPreferredSize(new Dimension(100,26));
        setBackground(Strings.HERO_COLOR);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10,3));
        instantiateIteration();
        setLabels();
    }
    public void instantiateIteration(){
        for(int i = 0; i < headerButtons.length; i++){
            headerButtons[i] = new Rectangle(0,0,0,0);
        }
    }
    public void setLabels(){
        JLabel gitLabel = null;
        addLabel(gitLabel, Strings.GIT_IMG_PATH, "https://github.com/04aks");

        JLabel xLabel = null;
        addLabel(xLabel, Strings.X_IMG_PATH, "https://twitter.com/07kisee");

        JLabel codeLabel = null;
        addLabel(codeLabel, Strings.CODE_IMG_PATH, "https://github.com/04aks/Yoku");
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
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // BufferedImage github = main.utils.importImage(Strings.GIT_IMG_PATH);
        // int width = 30;
        // int x = 10;
        // int y = (getHeight() - github.getHeight())/2;
        // g2.drawImage(github, x, y, null);

    }
}
