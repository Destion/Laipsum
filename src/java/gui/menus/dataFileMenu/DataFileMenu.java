package gui.menus.dataFileMenu;

import gui.menus.classifierFileMenu.LoadNewClassifier;
import gui.menus.classifierFileMenu.LoadToClassifier;
import gui.menus.classifierFileMenu.SaveClassifier;

import javax.swing.*;

/**
 * Created by gerben on 4-1-16.
 */
public class DataFileMenu extends JMenu {


    public DataFileMenu() {
        super("Data");
        this.add(new TrainFromData());

    }
}
