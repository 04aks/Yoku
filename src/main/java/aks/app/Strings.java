package aks.app;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Strings {
    public static String WRONG_FILE_TYPE = "Please select a .xlsx file";
    public static String ICON_PATH = "/aks/res/images/icon.png";
    public static String ICON_PATH_SMALL = "/aks/res/images/iconsmall.png";
    public static String APP_NAME = "Yoku";
    public static String APP_DESC = "Application that allows you to monitor and sort payements \nsent/recieved from/to your CCP account. also works without \nan Internet connection, once you have downloaded the excel \nfile from the ECCP website you are good to go offline. \na more user-friendly interface than Microsoft Excel.";
    public static ImageIcon ICON = new ImageIcon(Strings.class.getResource(ICON_PATH));
    public static String COPYRIGHT = "Copyright © Yoku - GitHub.com/04aks";
    public static Color HERO_COLOR = new Color(0,0,0,25);
    public static String GIT_IMG_PATH = "/aks/res/images/github.png";
    public static String X_IMG_PATH = "/aks/res/images/x.png";
    public static String CODE_IMG_PATH = "/aks/res/images/code.png";
    public static String GREEN_ARROW_PATH = "/aks/res/images/green.png";
    public static String RED_ARROW_PATH = "/aks/res/images/red.png";
    public static Color CUSTOM_DARKGRAY = new Color(0x525252);
    public static Color CUSTOM_LIGHTGRAY = new Color(0x686868);
    public static Color GREEN_SELECTION = new Color(0x268016);
    public static Color BORDER_COLOR = new Color(0,0,0,100);
    public static String EXIT_IMG_PATH = "/aks/res/images/exit.png";
    public static String MAX_IMG_PATH = "/aks/res/images/max.png";
    public static String MIN_IMG_PATH = "/aks/res/images/min.png";
}
