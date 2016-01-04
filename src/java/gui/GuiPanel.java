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
    private static final String IMG_PATH = "src/java/gui/knutselen-met-herfstbladeren.jpg";

    public GuiPanel(){
        super();
        try {
            BufferedImage img = ImageIO.read(new File(IMG_PATH));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        this.repaint();
        super.paintComponent(g);
    }

}
