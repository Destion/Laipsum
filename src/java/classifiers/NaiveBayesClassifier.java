package classifiers;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public interface NaiveBayesClassifier {

    /**
     * This method will decide whether an input String is of the Class or not.
     *
     * @param text the text to be classified.
     * @return Returns the class of our document.
     */
    String getClass(String text);

    /**
     * Train the algorithm with a new text
     *
     * @param text The text that is either of our Class or not
     * @param c    The class of the object
     */
    void train(String text, String c);

    /**
     * Train the algorithm using multiple documents.
     *
     * @param data A Map with a String that represents the text
     *             and a String indicating the class.
     */
    void train(Map<String, String> data);

    /**
     * Trains the NB algorithm from a file.
     *
     * @param inputFile The file to read.
     */
    void trainFromFile(File inputFile) throws IOException;

    /**
     * Save the training data to a file.
     *
     * @param outputFile The file to write to.
     */
    void saveKnowledgeToFile(File outputFile) throws IOException;


    String[] getClassNames();
}
