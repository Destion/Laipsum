package gui.mainScreenComponents;

import gui.ModelContainer;
import gui.listeners.TestDataListener;

import javax.swing.*;

/**
 * Created by gerben on 5-1-16.
 */
public class ClassSelectionComboBox extends JComboBox<String> implements TestDataListener {

    public ClassSelectionComboBox() {
        super();
        ModelContainer.getInstance().addListener(this);
    }

    @Override
    public void onTestDataUpdate() {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(
                ModelContainer.getInstance().getClassifier().getClassNames());
        setModel(cbm);
    }
}
