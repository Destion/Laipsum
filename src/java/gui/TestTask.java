package gui;


import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.concurrent.Task;

import javax.swing.*;

/**
 * Created by gerben on 5-1-16.
 */
public class TestTask extends SwingWorker<Void, Double>{
    @Override
    protected Void doInBackground() throws Exception {
        this.firePropertyChange("active", false, true);
        double length = ModelContainer.getInstance().getTestCases().keySet().size();
        double pos = 0.0;
        for (String sentence: ModelContainer.getInstance().getTestCases().keySet()) {
            pos += 1;
            ModelContainer.getInstance().addTestResult(ModelContainer.getInstance().getTestCases().get(sentence)
                    , ModelContainer.getInstance().getClassifier().getClass(sentence));
            this.firePropertyChange("progress", (pos-1)/length, pos/length);
        }
        ModelContainer.getInstance().updateTable();
        this.firePropertyChange("active", true, false);
        return null;
    }

}
