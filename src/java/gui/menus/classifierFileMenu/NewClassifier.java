package gui.menus.classifierFileMenu;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;
import gui.ModelContainer;
import main.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by gerben on 4-1-16.
 */
public class NewClassifier extends JMenuItem implements ActionListener {

    public NewClassifier() {
        super("New classifier");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();
        ModelContainer.getInstance().setClassifier(classifier);
        ModelContainer.getInstance().updateTable();

    }

}
