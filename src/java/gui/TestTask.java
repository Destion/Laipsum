package gui;


import javafx.concurrent.Task;

import javax.swing.*;

/**
 * Created by gerben on 5-1-16.
 */
public class TestTask extends SwingWorker<Void, Double>{
    @Override
    protected Void doInBackground() throws Exception {
        for (String sentence: ModelContainer.getInstance().getTestCases().keySet()) {
            ModelContainer.getInstance().addTestResult(ModelContainer.getInstance().getTestCases().get(sentence)
                    , ModelContainer.getInstance().getClassifier().getClass(sentence));
        }
        return null;
    }

}
