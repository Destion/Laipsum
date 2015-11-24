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
     * Gets the total number of occurrences of this word in jokes according to this data.
     * @return The number of occurrences of this word in jokes according to this data.
     */
    int getnJokes();

    /**
     * Gets the total number of occurrences of this word in the data.
     * @return The total number of occurrences in this data.
     */
    int getnOccurrences();

    /**
     * Increments the total amount of times this word was found in a joke.
     */
    void incrementnJokes();

    /**
     * Increments the total amount of times this word was found.
     */
    void incrementnOccurrences();

}
