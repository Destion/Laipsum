package gui;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

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

    public void trainFromFiles(File[] inputFiles, String fileClass) throws IOException {
        for (File file: inputFiles) {
            Scanner scanner = new Scanner(new FileInputStream(file));
            while (scanner.hasNextLine()) {
                classifier.train(scanner.nextLine(), fileClass);
            }
            scanner.close();
        }
    }

    public void setClassifier(NaiveBayesClassifier classifier) {
        this.classifier = classifier;
    }
}
