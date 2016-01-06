package gui.listeners;

import gui.ModelContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Destion on 6-1-2016.
 */
public class RunListener implements ActionListener {

    public RunListener(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelContainer.getInstance().runAutomatedTest();
        ModelContainer.getInstance().updateTable();
    }
}
