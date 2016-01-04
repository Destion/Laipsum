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
public class LoadToClassifier extends JMenuItem implements ActionListener {

    public LoadToClassifier() {
        super("Train current classifier from file");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        File file = Util.promptFile();
        if (file != null) {
            try {
                ModelContainer.getInstance().getClassifier().trainFromFile(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
