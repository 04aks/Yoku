package aks.app;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Strings {
    public static String ICON_PATH = "/aks/res/images/icon.png";
    public static String ICON_PATH_SMALL = "/aks/res/images/iconsmall.png";
    public static String APP_NAME = "Yoku";
    public static String APP_DESC = "Application that allows you to monitor and sort payements \nsent/recieved from/to your CCP account. also works without \nan Internet connection, once you have downloaded the excel \nfile from the ECCP website you are good to go offline. \na more user-friendly interface than Microsoft Excel.";
    public static ImageIcon ICON = new ImageIcon(Strings.class.getResource(ICON_PATH));
    public static String COPYRIGHT = "Copyright © Yoku - GitHub.com/04aks";
    public static Color HERO_COLOR = new Color(0,0,0,25);
}
