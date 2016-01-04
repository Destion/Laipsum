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

    public GuiPanel(){
        super();
//
        this.add(new JButton("Gerben is een koekje"), BorderLayout.EAST);
        this.add(new JButton("Gerben is een malloot"), BorderLayout.SOUTH);

        String[] strings = {"Gerben", "Pizza", "Koekjes", "Macfags"};

        JComboBox cb = new JComboBox(strings);
        cb.setSelectedIndex(3);

        this.add(cb, BorderLayout.WEST);

    }


}
