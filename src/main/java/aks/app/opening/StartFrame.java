package aks.app.opening;

import javax.swing.JFrame;
import aks.app.Main;
import aks.app.Strings;

public class StartFrame{
    Main main;
    public StartPanel sp;
    public JFrame frame;
    public static int frameX, frameY;

    public StartFrame(Main main){
        this.main = main;
        frame = new JFrame(Strings.APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        sp = new StartPanel(main);

        frame.add(sp);
        frame.pack();
        frame.setIconImage(Strings.ICON.getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
