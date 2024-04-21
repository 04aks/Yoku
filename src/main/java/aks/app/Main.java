package aks.app;

import aks.app.mainframe.MainFrame;
import aks.app.opening.StartFrame;

public class Main {

    public Utils utils = new Utils();
    public UI ui = new UI(this);
    public StartFrame startFrame;
    public MainFrame mainFrame;
    
    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        startFrame = new StartFrame(this);
    }
}