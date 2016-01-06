package gui.listeners;

import gui.ModelContainer;
import main.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Destion on 6-1-2016.
 */
public class ExpectationListener implements ActionListener {

    JTextField tf;

    public ExpectationListener(JTextField tf){
        super();
        this.tf = tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Util.showInfoBox("Expected class: " +
                ModelContainer.getInstance().getClassifier().getClass(tf.getText()), "Class expectation");
    }
}
