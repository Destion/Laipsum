package gui.listeners;

import gui.ModelContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Destion on 6-1-2016.
 */
public class RunListener implements ActionListener, PropertyChangeListener {

    JButton button;

    public RunListener(JButton button){
        super();
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelContainer.getInstance().runAutomatedTest();
        ModelContainer.getInstance().updateTable();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("active")) {
            if ((boolean) evt.getNewValue()){
                button.setEnabled(false);
            } else {
                button.setEnabled(true);
            }
        }
    }
}
