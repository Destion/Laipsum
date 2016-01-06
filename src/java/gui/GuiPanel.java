package gui;

import gui.listeners.AdditionListener;
import gui.listeners.RunListener;
import gui.mainScreenComponents.AddClassButton;
import gui.mainScreenComponents.ClassSelectionComboBox;
import gui.mainScreenComponents.GuiTestResultsTable;
import gui.mainScreenComponents.TestProgressBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Destion on 4-1-2016.
 */
public class GuiPanel extends JPanel {

    public GuiPanel() {
        super();
        setLayout(new GridBagLayout());

        GridBagConstraints button1Constraints = new GridBagConstraints();
        button1Constraints.gridx = 0;
        button1Constraints.gridy = 0;
        button1Constraints.gridwidth = 1;
        button1Constraints.gridheight = 1;
        button1Constraints.weightx = 0.5;
        JButton button1 = new JButton("Run testqueueueueueueue");
        button1.addActionListener(new RunListener(button1));
        this.add(button1, button1Constraints);

        GridBagConstraints button2Constraints = new GridBagConstraints();
        button2Constraints.gridx = 3;
        button2Constraints.gridy = 0;
        button2Constraints.gridwidth = 1;
        button2Constraints.gridheight = 1;
        button2Constraints.weightx = 0.5;

        AddClassButton button2 = new AddClassButton();
        this.add(button2, button2Constraints);

        GridBagConstraints tableConstraints = new GridBagConstraints();
        tableConstraints.gridx = 0;
        tableConstraints.gridy = 1;
        tableConstraints.gridwidth = 6;
        tableConstraints.gridheight = 1;
        tableConstraints.weighty = 0.5;
        tableConstraints.fill = GridBagConstraints.BOTH;
        this.add(new GuiTestResultsTable(), tableConstraints);

        ClassSelectionComboBox cb = new ClassSelectionComboBox();

        GridBagConstraints comboBoxConstraints = new GridBagConstraints();
        comboBoxConstraints.gridx = 5;
        comboBoxConstraints.gridy = 0;
        comboBoxConstraints.gridwidth = 1;
        comboBoxConstraints.gridheight = 1;
        this.add(cb, comboBoxConstraints);


        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 2;
        textFieldConstraints.gridwidth = 3;
        textFieldConstraints.gridheight = 1;
        textFieldConstraints.fill = GridBagConstraints.BOTH;
        JTextField tf = new JTextField();
        tf.setToolTipText("Please enter the string you want to add to the " +
                "classifier.");
        this.add(tf, textFieldConstraints);

        GridBagConstraints cbconstraints = new GridBagConstraints();
        cbconstraints.gridx = 3;
        cbconstraints.gridy = 2;
        cbconstraints.gridwidth = 1;
        cbconstraints.gridheight = 1;
        cbconstraints.fill = GridBagConstraints.BOTH;
        cbconstraints.weightx = 0.5;
        ClassSelectionComboBox combo = new ClassSelectionComboBox();

        this.add(combo, cbconstraints);

        GridBagConstraints button3Constraints = new GridBagConstraints();
        button3Constraints.gridx = 5;
        button3Constraints.gridy = 2;
        button3Constraints.gridwidth = 1;
        button3Constraints.gridheight = 1;
        button3Constraints.weightx = 0.5;
        button3Constraints.fill = GridBagConstraints.BOTH;

        JButton button3 = new JButton("Add");

        button3.addActionListener(new AdditionListener(tf, cb));
        this.add(button3, button3Constraints);

        GridBagConstraints progressBarConstraints = new GridBagConstraints();
        progressBarConstraints.gridx = 0;
        progressBarConstraints.gridy = 3;
        progressBarConstraints.gridwidth = 10;
        progressBarConstraints.gridheight = 1;
        progressBarConstraints.weightx = 0.5;
        progressBarConstraints.fill = GridBagConstraints.BOTH;

        TestProgressBar progressBar = new TestProgressBar();
        ModelContainer.getInstance().setPropertyChangeListener(progressBar);
        add(progressBar, progressBarConstraints);

    }


}
