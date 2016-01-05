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
public class RunAutomatedTest extends JMenuItem implements ActionListener {

    public RunAutomatedTest() {
        super("Run test");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        ModelContainer.getInstance().runAutomatedTest();
        ModelContainer.getInstance().updateTable();


    }

}
