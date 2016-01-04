package gui;

import gui.menus.classifierFileMenu.ClassifierFileMenu;
import gui.menus.dataFileMenu.DataFileMenu;

import javax.swing.*;

/**
 * Created by gerben on 4-1-16.
 */
public class GuiMenuBar extends JMenuBar {

    public GuiMenuBar() {
        super();
        add(new ClassifierFileMenu());
        add(new DataFileMenu());

    }

}
