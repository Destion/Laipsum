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

    /**
     * Saves the data to a File.
     * @param outputFile the File to write.
     */
    void saveToFile(File outputFile) throws IOException;


    /**
     * Adds data about a word to our data.
     * @param word The word.
     * @param c The class of document it is in.
     */
    void train(String word, String c);

    /**
     * Get data about a word
     * @param word The String representing the word.
     * @return An object with data about the word.
     * @throws UnknownWordException This happens when the word does not exist in the data.
     */
    NaiveBayesWordData getWord(String word) throws UnknownWordException;

    int getnOccurrences();

    int getnClassOccurrences(String c);

    String[] getClasses();

}
