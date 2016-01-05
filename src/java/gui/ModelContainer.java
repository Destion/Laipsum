package gui;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;
import gui.mainScreenComponents.GuiTestResultsTable;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by gerben on 4-1-16.
 */
public class ModelContainer {

    private NaiveBayesClassifier classifier;
    PropertyChangeListener propertyChangeListener;
    private Map<String, Map<String, Integer>> testData = new HashMap<>();

    private Map<String, String> testCases = new HashMap<>();

    private List<TestDataListener> listeners = new ArrayList<>();

    private static ModelContainer ourInstance = new ModelContainer();
    public static ModelContainer getInstance() {
        return ourInstance;
    }

    private ModelContainer() {
        classifier = new NaiveBayesClassifierImplementation();
    }

    public NaiveBayesClassifier getClassifier() {
        return classifier;
    }

    public void trainFromFiles(File[] inputFiles, String fileClass) throws IOException {
        trainOrTestFromFiles(inputFiles, fileClass, true);
    }

    public void testFromFiles(File[] inputFiles, String fileClass) throws IOException {
        trainOrTestFromFiles(inputFiles, fileClass, false);
    }

    public void setPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeListener = listener;
    }
    public void runAutomatedTest() {
        if (propertyChangeListener != null) {
            TestTask testTask = new TestTask();
            testTask.addPropertyChangeListener(propertyChangeListener);
            testTask.execute();
        }
    }

    public void trainOrTestFromFiles(File[] inputFiles, String fileClass, boolean train) throws IOException {
        for (File file: inputFiles) {
            if (file.isDirectory()) {
                trainOrTestFromFiles(file.listFiles(), fileClass, train);
            } else {
                Scanner scanner = new Scanner(new FileInputStream(file));
                while (scanner.hasNextLine()) {
                    if (train) {
                        classifier.train(scanner.nextLine(), fileClass);
                    } else {
                        testCases.put(scanner.nextLine(), fileClass);
                    }
                }
                scanner.close();
            }
        }
    }

    public void addListener(TestDataListener listener) {
        listeners.add(listener);
    }

    public void updateTable(){
        for (TestDataListener listener: listeners) {
            listener.onTestDataUpdate();
        }
    }

    public void addTestResult(String className, String classifiedAs) {
        if (!testData.containsKey(className)) {
            Map<String, Integer> newMap =  new HashMap<>();
            testData.put(className, newMap);
            newMap.put(classifiedAs, 1);
        } else if(!testData.get(className).containsKey(classifiedAs)) {
            testData.get(className).put(classifiedAs, 1);
        } else {
            testData.get(className).put(classifiedAs,
                    testData.get(className).get(classifiedAs) + 1
                    );
        }
    }


    public int getTestResult(String className, String classifiedAs) {
        if (testData.containsKey(className) && testData.get(className).containsKey(classifiedAs)) {
            return testData.get(className).get(classifiedAs);
        } else {
            return 0;
        }
    }

    public Object[][] getTestData() {
        String[] classNames = classifier.getClassNames();
        Object[][] out = new Object[classNames.length][];
        for (int i = 0; i < out.length; i++) {
            out[i] = new Object[classNames.length + 1];
        }
        for (int i = 0; i < classNames.length; i++) {
            String className = classNames[i];
            out[i][0] = className;
            for (int i1 = 0; i1 < classNames.length; i1++) {
                String classifiedAs = classNames[i1];
                out[i][i1 + 1] = getTestResult(className, classifiedAs);
            }
        }
        return out;
    }

    public void resetTestData(){
        testData = new HashMap<>();
    }

    public void setClassifier(NaiveBayesClassifier classifier) {
        this.classifier = classifier;
    }

    public Map<String, String> getTestCases() {
        return testCases;
    }
}
