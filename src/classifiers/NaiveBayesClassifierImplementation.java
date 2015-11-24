package classifiers;

import data.NaiveBayesWordData;

import java.io.File;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesClassifierImplementation implements NaiveBayesClassifier {
    NaiveBayesWordData data;

    public boolean isJoke(String text) {
        return false;
    }

    public void train(String text, boolean isJoke) {

    }

    public void train(Map<String, Boolean> data) {

    }

    public void trainFromFile(File inputFile) {

    }

    public void saveKnowledgeToFile(File outputFile) {

    }
}
