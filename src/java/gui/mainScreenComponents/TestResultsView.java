package gui.mainScreenComponents;

import gui.ModelContainer;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by gerben on 6-1-16.
 */
public class TestResultsView extends JLabel implements PropertyChangeListener {

    public TestResultsView() {
        super("No test results available yet");
        ModelContainer.getInstance().addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("active") && ! (boolean) evt.getNewValue()) {
            int total = 0;
            int right = 0;
            for (String className: ModelContainer.getInstance().getTestDataMap().keySet()) {
                for(String classGuessed : ModelContainer.getInstance().getTestDataMap().get(className).keySet()) {
                    total += ModelContainer.getInstance().getTestResult(className, classGuessed);
                    if (classGuessed.equals(className)) {
                        right += ModelContainer.getInstance().getTestResult(className, classGuessed);
                    }
                }
            }
            setText(String.format("Right: %d, total: %d", right, total));
        }
    }
}
