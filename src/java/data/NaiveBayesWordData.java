package data;

/**
 * Created by gerben on 24-11-15.
 */
public interface NaiveBayesWordData {

    /**
     * Gets the word.
     * @return The actual String representing the word.
     */
    String getWord();

    /**
     * Gets the total number of occurrences of this word in the Class according to this data.
     * @return The number of occurrences of this word in this Class according to this data.
     */
    int getnClass();

    /**
     * Gets the total number of occurrences of this word in the data.
     * @return The total number of occurrences in this data.
     */
    int getnOccurrences();

    /**
     * Increments the total amount of times this word was found as part of this Class.
     */
    void incrementnClass();

    /**
     * Increments the total amount of times this word was found.
     */
    void incrementnOccurrences();

}
