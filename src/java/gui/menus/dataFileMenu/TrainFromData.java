package gui.menus.dataFileMenu;

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
public class TrainFromData extends JMenuItem implements ActionListener {

    public TrainFromData() {
        super("Load new classifier");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        File[] files = Util.promptFiles();
        if (files != null) {
            try {
                ModelContainer.getInstance().trainFromFiles(files);
            } catch (IOException e1) {
                Util.showInfoBox("Failed to load classifier from selected files \n Error: \n" + e1.getLocalizedMessage(), "Loading failed");
                e1.printStackTrace();
            }

        }
    }

}
