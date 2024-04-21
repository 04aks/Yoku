package aks.app;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Utils {
    public Font createFont(String path){
        Font font = null;
        InputStream is = getClass().getResourceAsStream(path);
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            is.close();
        }catch(Exception e){    
            System.out.println("Error trying to read font data");
        }
        return font;
    }
    public BufferedImage importImage(String path){
        BufferedImage image = null;
        InputStream is = getClass().getResourceAsStream(path);
        try{
            image = ImageIO.read(is);
            is.close();
        }catch(Exception e){
            System.out.println("Error trying to read image");
        }
        return image;
    }
}
