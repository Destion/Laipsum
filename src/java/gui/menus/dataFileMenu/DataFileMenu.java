package gui.menus.dataFileMenu;

import javax.swing.*;

/**
 * Created by gerben on 4-1-16.
 */
public class DataFileMenu extends JMenu {


    public DataFileMenu() {
        super("Data");
        this.add(new TrainFromData());
        this.add(new AddTestData());
        //this.add(new RunAutomatedTest());
    }
}
