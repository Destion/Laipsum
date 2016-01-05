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
public class LoadNewClassifier extends JMenuItem implements ActionListener {

    public LoadNewClassifier() {
        super("Load new classifier");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        File file = Util.promptFile();
        if (file != null) {
                NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();
            try {
                classifier.trainFromFile(file);
                ModelContainer.getInstance().setClassifier(classifier);
                ModelContainer.getInstance().updateTable();
            } catch (IOException e1) {
                Util.showInfoBox("Failed to load classifier from "+ file + "\n Error: \n" + e1.getLocalizedMessage(), "Loading failed");
                e1.printStackTrace();
            }



        }
    }

}
