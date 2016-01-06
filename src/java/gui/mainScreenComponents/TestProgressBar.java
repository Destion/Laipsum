package gui.mainScreenComponents;

import gui.TestTask;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by gerben on 5-1-16.
 */
public class TestProgressBar extends JProgressBar implements PropertyChangeListener {

    public TestProgressBar(){
        super();
        setVisible(false);
        setStringPainted(true);
        setString("Running tests");

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("progress")) {
            double progress = (double) evt.getNewValue();
            setValue((int) (progress * 100));
        } else if(evt.getPropertyName().equals("active")) {
            setVisible((Boolean) evt.getNewValue());
        }
    }
}
