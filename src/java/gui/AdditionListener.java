package gui;

import classifiers.NaiveBayesClassifier;
import gui.mainScreenComponents.ClassSelectionComboBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Destion on 5-1-2016.
 */
public class AdditionListener implements ActionListener {

    JTextField tf;
    ClassSelectionComboBox cb;
    NaiveBayesClassifier nbc;

    public AdditionListener(JTextField tf, ClassSelectionComboBox cb, NaiveBayesClassifier nbc) {
        super();
        this.tf = tf;
        this.cb = cb;
        this.nbc = nbc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean valid = true;

        if (tf.getText().equals("") || cb.getSelectedItem() == null) {
            valid = false;
        }

        if (valid) {
            System.out.println(tf.getText());
            System.out.println((String) cb.getSelectedItem());
            nbc.train(tf.getText(), (String) cb.getSelectedItem());
            tf.setText("");
        }
    }
}
