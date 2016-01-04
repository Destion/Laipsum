package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Destion on 4-1-2016.
 */
public class GuiPanel extends JPanel {
    private BufferedImage img;
    private static final String IMG_PATH = "src/java/gui/knutselen-met-herfstbladeren.jpg";

    public GuiPanel(){
        super();
        try {
            img = ImageIO.read(new File(IMG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        this.repaint();
        super.paintComponent(g);
        g.drawImage(img, 0,0, null);
    }

}
