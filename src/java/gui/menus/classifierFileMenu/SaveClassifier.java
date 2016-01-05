package gui.menus.classifierFileMenu;

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
public class SaveClassifier extends JMenuItem implements ActionListener {

    public SaveClassifier() {
        super("Save classifier to file");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        File file = Util.promptFile(true);
        if (file != null) {
            try {
                ModelContainer.getInstance().getClassifier().saveKnowledgeToFile(file);
                Util.showInfoBox("Successfully saved classifier to "+ file, "Saving successful");
            } catch (IOException e1) {
                Util.showInfoBox("Failed to save classifier to "+ file + "\n Error: \n" + e1.getLocalizedMessage(), "Saving failed");
                e1.printStackTrace();
            }
        }
    }

}
