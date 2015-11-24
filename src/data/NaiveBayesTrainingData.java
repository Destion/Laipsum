package data;

import java.io.File;
import java.io.IOException;

/**
 * Created by gerben on 24-11-15.
 */
public interface NaiveBayesTrainingData {

    /**
     * Add data from a File to the data.
     * @param inputFile The File to read from.
     * @throws IOException When the file can not be opened.
     */
    void addFromFile(File inputFile) throws IOException;


    void saveToFile(File outputFile);

    /**
     * Calculates the chance that a word is in a joke, given this data.
     * @param word The word to be tested
     * @return The chance that the word is in a joke, given this data.
     * @throws UnknownWordException when the word is not in the data.
     */
    double getInJokeChance(String word) throws UnknownWordException;

    /**
     * Adds data about a word to the dataSet.
     * @param word The word.
     * @param isInJoke Enter whether this word is in a joke (true) or not (false).
     */
    void train(String word, boolean isInJoke);
}
