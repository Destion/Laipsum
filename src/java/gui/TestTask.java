package gui;


import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by gerben on 5-1-16.
 */
public class TestTask extends SwingWorker<Void, Double> {
    @Override
    protected Void doInBackground() throws Exception {
        this.firePropertyChange("active", false, true);
        double length = ModelContainer.getInstance().getTestCases().keySet().size();
        double pos = 0.0;
        ArrayList<String> doneTests = new ArrayList<>();
        for (String sentence : ModelContainer.getInstance().getTestCases().keySet()) {
            pos += 1;
            ModelContainer.getInstance().addTestResult(ModelContainer.getInstance().getTestCases().get(sentence)
                    , ModelContainer.getInstance().getClassifier().getClass(sentence));
            this.firePropertyChange("progress", (pos - 1) / length, pos / length);
            doneTests.add(sentence);
        }
        for (String sentence: doneTests) {
            ModelContainer.getInstance().getTestCases().remove(sentence);
        }
        ModelContainer.getInstance().updateTable();
        this.firePropertyChange("active", true, false);
        return null;
    }

}
