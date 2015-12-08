package classifiers;

import java.io.File;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public interface NaiveBayesClassifier {

    /**
     * This method will decide whether an input String is of the Class or not.
     * @param text the text to be classified.
     * @return Returns true if the String is of our Class, false if not.
     */
    boolean isClass(String text);

    /**
     * Train the algorithm with a new text
     * @param text The text that is either of our Class or not
     * @param isClass A boolean indicating whether the text is of our Class or not
     */
    void train(String text, boolean isClass);

    /**
     * Train the algorithm using multiple documents.
     * @param data A Map with a String that represents the text
     *             and a Boolean to indicate whether the text is of our Class or not.
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
