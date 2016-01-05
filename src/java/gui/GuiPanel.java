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
        setLayout(new GridBagLayout());
//
        GridBagConstraints button1Constraints = new GridBagConstraints();
        button1Constraints.gridx = 0;
        button1Constraints.gridy = 0;
        button1Constraints.gridwidth = 1;
        button1Constraints.gridheight = 1;
        this.add(new JButton("Gerben is een koekje"), button1Constraints);

        GridBagConstraints button2Constraints = new GridBagConstraints();
        button2Constraints.gridx = 1;
        button2Constraints.gridy = 0;
        button2Constraints.gridwidth = 1;
        button2Constraints.gridheight = 1;
        this.add(new JButton("Gerben is een malloot"), button2Constraints);

        String[] strings = {"Gerben", "Pizza", "Koekjes", "Macfags"};


        JComboBox cb = new JComboBox(strings);
        cb.setSelectedIndex(3);

        GridBagConstraints comboBoxConstraints = new GridBagConstraints();
        comboBoxConstraints.gridx = 2;
        comboBoxConstraints.gridy = 0;
        comboBoxConstraints.gridwidth = 1;
        comboBoxConstraints.gridheight = 1;
        this.add(cb, comboBoxConstraints);


        GridBagConstraints tableConstraints = new GridBagConstraints();
        tableConstraints.gridx = 0;
        tableConstraints.gridy = 1;
        tableConstraints.gridwidth = 3;
        tableConstraints.gridheight = 1;
        tableConstraints.weighty = 0.5;
        tableConstraints.fill = GridBagConstraints.BOTH;
        this.add(new GuiTestResultsTable(), tableConstraints);


    }


}
