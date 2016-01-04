package gui.menus.classifierFileMenu;

import javax.swing.*;

/**
 * Created by gerben on 4-1-16.
 */
public class ClassifierFileMenu extends JMenu {


    public ClassifierFileMenu() {
        super("Classifier");
        this.add(new LoadNewClassifier());
        this.add(new LoadToClassifier());
        this.add(new SaveClassifier());

    }
}
