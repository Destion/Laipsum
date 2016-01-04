package gui;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;

import java.io.File;
import java.io.IOException;

/**
 * Created by gerben on 4-1-16.
 */
public class ModelContainer {

    private NaiveBayesClassifier classifier;

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

    public void trainFromFiles(File[] inputFiles) throws IOException {
        for (File file: inputFiles) {
            classifier.trainFromFile(file);
        }
    }

    public void setClassifier(NaiveBayesClassifier classifier) {
        this.classifier = classifier;
    }
}
