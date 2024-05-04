package aks.app.mainframe;

import java.awt.Dimension;
import javax.swing.JFrame;
import aks.app.Main;
import aks.app.Strings;

public class MainFrame {
    Main main;
    public JFrame frame;
    public MainPanel mainPanel;
    static int FRAME_X, FRAME_Y;
    public MainFrame(Main main){
        this.main = main;
        frame = new JFrame(Strings.APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(MainPanel.WIDTH, MainPanel.HEIGHT));
        frame.setUndecorated(false);

        mainPanel = new MainPanel(main);

        frame.add(mainPanel);
        frame.pack();
        // frame.setIconImage(Strings.ICON.getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
