package gui.listeners;

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

    public AdditionListener(JTextField tf, ClassSelectionComboBox cb) {
        super();
        this.tf = tf;
        this.cb = cb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NaiveBayesClassifier nbc = ModelContainer.getInstance().getClassifier();
        boolean valid = true;

        if (tf.getText().equals("") || cb.getSelectedItem() == null) {
            valid = false;
        }

        if (valid){
            nbc.train(tf.getText(), (String) cb.getSelectedItem());
            tf.setText("");
        }
    }
}
