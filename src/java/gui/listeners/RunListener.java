package gui.listeners;

import gui.ModelContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Destion on 6-1-2016.
 */
public class RunListener implements ActionListener {

    private JButton button;

    public RunListener(JButton button){
        super();
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelContainer.getInstance().runAutomatedTest();
        ModelContainer.getInstance().updateTable();
    }
}
