package gui.menus.fileMenu;

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

    }

    public void actionPerformed(ActionEvent e) {
        File file = Util.promptFile();
        if (file != null) {
                NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();
            try {
                classifier.trainFromFile(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            ModelContainer.getInstance().setClassifier(classifier);

        }
    }

}
