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
     * @param c The Class name
     * @return The number of occurrences of this word in this Class according to this data.
     */
    int getnClass(String c);

    /**
     * Gets the total number of occurrences of this word in the data.
     * @return The total number of occurrences in this data.
     */
    int getnOccurrences();

    /**
     * Increments the total amount of times this word was found as part of this Class by a certain amount.
     * @param c The class
     */
    void incrementnClass(String c, int amount);


    /**
     * Increments the total amount of times this word was found as part of this Class.
     * @param c The class
     */
    void incrementnClass(String c);

    /**
     * Increments the total amount of times this word was found.
     */
    void incrementnOccurrences();

}
