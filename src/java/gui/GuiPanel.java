package gui;

import gui.listeners.AdditionListener;
import gui.listeners.ExpectationListener;
import gui.listeners.RunListener;
import gui.mainScreenComponents.*;

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
        JButton button1 = new JButton("Run testqueue");
        RunListener runL = new RunListener(button1);
        ModelContainer.getInstance().addPropertyChangeListener(runL);
        button1.addActionListener(runL);

        this.add(button1, button1Constraints);

        GridBagConstraints button2Constraints = new GridBagConstraints();
        button2Constraints.gridx = 1;
        button2Constraints.gridy = 0;
        button2Constraints.gridwidth = 1;
        button2Constraints.gridheight = 1;
        button2Constraints.weightx = 0.5;

        AddClassButton button2 = new AddClassButton();
        this.add(button2, button2Constraints);

        GridBagConstraints button31Constraints = new GridBagConstraints();
        button31Constraints.gridx = 2;
        button31Constraints.gridy = 0;
        button31Constraints.gridwidth = 1;
        button31Constraints.gridheight = 1;
        button31Constraints.weightx = 0.5;

        FillInFromTestDataButton button31 = new FillInFromTestDataButton();
        this.add(button31, button31Constraints);

        GridBagConstraints tableConstraints = new GridBagConstraints();
        tableConstraints.gridx = 0;
        tableConstraints.gridy = 1;
        tableConstraints.gridwidth = 6;
        tableConstraints.gridheight = 1;
        tableConstraints.weighty = 0.5;
        tableConstraints.fill = GridBagConstraints.BOTH;
        this.add(new GuiTestResultsTable(), tableConstraints);

        TestResultsView resultsView = new TestResultsView();

        GridBagConstraints comboBoxConstraints = new GridBagConstraints();
        comboBoxConstraints.gridx = 3;
        comboBoxConstraints.gridy = 0;
        comboBoxConstraints.gridwidth = 2;
        comboBoxConstraints.gridheight = 1;
        this.add(resultsView, comboBoxConstraints);


        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 2;
        textFieldConstraints.gridwidth = 3;
        textFieldConstraints.gridheight = 1;
        textFieldConstraints.fill = GridBagConstraints.BOTH;
        JTextField tf = new GuiTextField();
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
        button3Constraints.gridx = 4;
        button3Constraints.gridy = 2;
        button3Constraints.gridwidth = 1;
        button3Constraints.gridheight = 1;
        button3Constraints.weightx = 0.5;
        button3Constraints.fill = GridBagConstraints.BOTH;

        JButton button3 = new JButton("Add");

        button3.addActionListener(new AdditionListener(tf, combo));
        this.add(button3, button3Constraints);

        GridBagConstraints progressBarConstraints = new GridBagConstraints();
        progressBarConstraints.gridx = 0;
        progressBarConstraints.gridy = 3;
        progressBarConstraints.gridwidth = 10;
        progressBarConstraints.gridheight = 1;
        progressBarConstraints.weightx = 0.5;
        progressBarConstraints.fill = GridBagConstraints.BOTH;

        TestProgressBar progressBar = new TestProgressBar();
        ModelContainer.getInstance().addPropertyChangeListener(progressBar);
        add(progressBar, progressBarConstraints);

        GridBagConstraints button4Constraints = new GridBagConstraints();
        button4Constraints.gridx = 5;
        button4Constraints.gridy = 2;
        button4Constraints.gridwidth = 1;
        button4Constraints.gridheight = 1;
        button4Constraints.fill = GridBagConstraints.BOTH;

        JButton button4 = new JButton("Check expected class");
        button4.addActionListener(new ExpectationListener(tf));
        this.add(button4, button4Constraints);

    }


}
