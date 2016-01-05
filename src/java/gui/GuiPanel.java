package gui;

import gui.mainScreenComponents.ClassSelectionComboBox;
import gui.mainScreenComponents.GuiTestResultsTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Destion on 4-1-2016.
 */
public class GuiPanel extends JPanel {

    public GuiPanel(){
        super();
        setLayout(new GridBagLayout());

        GridBagConstraints button1Constraints = new GridBagConstraints();
        button1Constraints.gridx = 0;
        button1Constraints.gridy = 0;
        button1Constraints.gridwidth = 1;
        button1Constraints.gridheight = 1;
        button1Constraints.weightx = 0.5;
        this.add(new JButton("Gerben is een koekje"), button1Constraints);

        GridBagConstraints button2Constraints = new GridBagConstraints();
        button2Constraints.gridx = 1;
        button2Constraints.gridy = 0;
        button2Constraints.gridwidth = 1;
        button2Constraints.gridheight = 1;
        button2Constraints.weightx = 0.5;

        JButton button2 = new JButton("Mick is een malloot");
        this.add(button2, button2Constraints);

        GridBagConstraints tableConstraints = new GridBagConstraints();
        tableConstraints.gridx = 0;
        tableConstraints.gridy = 1;
        tableConstraints.gridwidth = 3;
        tableConstraints.gridheight = 1;
        tableConstraints.weighty = 0.5;
        tableConstraints.fill = GridBagConstraints.BOTH;
        this.add(new GuiTestResultsTable(), tableConstraints);

        ClassSelectionComboBox cb = new ClassSelectionComboBox();

        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 2;
        textFieldConstraints.gridwidth = 3;
        textFieldConstraints.gridheight = 1;
        textFieldConstraints.fill = GridBagConstraints.BOTH;

        this.add(new JTextField(), textFieldConstraints);

        GridBagConstraints comboBoxConstraints = new GridBagConstraints();
        comboBoxConstraints.gridx = 2;
        comboBoxConstraints.gridy = 0;
        comboBoxConstraints.gridwidth = 1;
        comboBoxConstraints.gridheight = 1;
        this.add(cb, comboBoxConstraints);





    }




}
