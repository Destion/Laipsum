package gui;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;

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

    public void setClassifier(NaiveBayesClassifier classifier) {
        this.classifier = classifier;
    }
}
