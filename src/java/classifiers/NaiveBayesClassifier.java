package classifiers;

import java.io.File;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public interface NaiveBayesClassifier {

    /**
     * This method will decide whether an input String is a joke or not.
     * @param text the text to be classified.
     * @return Returns true if the String is a joke, false if not.
     */
    boolean isJoke(String text);

    /**
     * Train the algorithm with a new text
     * @param text The text that is either a joke or not
     * @param isJoke A boolean indicating whether the text is a joke or not
     */
    void train(String text, boolean isJoke);

    /**
     * Train the algorithm using multiple sentences.
     * @param data A Map with a String that represents the text
     *             and a Boolean to indicate whether the text is a joke or not.
     */
    void train(Map<String, Boolean> data);

    /**
     * Trains the NB algorithm from a file.
     * @param inputFile The file to read.
     */
    void trainFromFile(File inputFile);

    /**
     * Save the training data to a file.
     * @param outputFile The file to write to.
     */
    void saveKnowledgeToFile(File outputFile);



}
