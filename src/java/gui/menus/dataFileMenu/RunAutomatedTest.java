package gui.menus.dataFileMenu;

import gui.ModelContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gerben on 4-1-16.
 */
@Deprecated
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
