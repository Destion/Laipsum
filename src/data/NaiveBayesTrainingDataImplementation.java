package data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesTrainingDataImplementation implements NaiveBayesTrainingData{

    private Map<String, NaiveBayesWordData> data;

    //This is the total amount of words trained, not the amount of unique words!!!
    private int totalWords = 0;

    private int totalJokes = 0;

    public NaiveBayesTrainingDataImplementation() {
        data = new HashMap<String, NaiveBayesWordData>();
    }

    public void addFromFile(File inputFile) throws IOException {
        //TODO: implement file loading
        throw new IOException("Not yet implemented!");
    }

    public void saveToFile(File outputFile) throws IOException {
        //TODO: implement file saving
        throw new IOException("Not yet implemented!");
    }

    public double getInJokeChance(String word) throws UnknownWordException {
        //Get the word from our data
        NaiveBayesWordData wordData = data.get(word);

        if (wordData == null) {
            //If the word is not known, throw an Exception.
            throw new UnknownWordException();
        }
        return ((double) wordData.getnJokes()/(double) wordData.getnOccurrences());
    }

    public void train(String word, boolean isInJoke) {
        //increment the total amount of words counted.
        totalWords ++;

        //Increment the total number of jokes if it is a joke.
        if (isInJoke) {
            totalJokes ++;
        }

        //Check if we already know this word.
        if (data.containsKey(word)) {

            //If we already know the word, get its data.
            NaiveBayesWordData wordData = data.get(word);

            //Increment it's number of occurrences.
            wordData.incrementnOccurrences();

            //Check if the word is part of a joke.
            if (isInJoke) {

                //If so, increment it's amount of occurrences in a joke.
                wordData.incrementnJokes();

            }
        } else {

            //Add the word to our data and set it's variables.
            data.put(word, new NaiveBayesWordDataImplementation(word, isInJoke?1:0, 1));
        }
    }

    public NaiveBayesWordData getWord(String word) throws UnknownWordException {

        //Get the word from our data
        NaiveBayesWordData wordData = data.get(word);

        if (wordData == null) {
            //If the word is not known, throw an Exception.
            throw new UnknownWordException();
        }
        return wordData;
    }

    public int getnOccurences() {
        return 0;
    }

    public int getnJokeOccurrences() {
        return 0;
    }
}
