package gui.menus.dataFileMenu;

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
        super("Train classifier with data");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        File[] files = Util.promptFiles();
        if (files != null) {
            String className = Util.promptString("The name of the class", "Load Data");
            try {
                ModelContainer.getInstance().trainFromFiles(files, className);
                ModelContainer.getInstance().updateTable();
            } catch (IOException e1) {
                Util.showInfoBox("Failed to load classifier from selected files \n Error: \n" + e1.getLocalizedMessage(), "Loading failed");
                e1.printStackTrace();
            }

        }

    }

}
