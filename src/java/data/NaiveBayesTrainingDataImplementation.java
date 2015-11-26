package data;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        Scanner in = new Scanner(new FileInputStream(inputFile));
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] args = line.split(",");
            if (args.length == 3) {
                totalJokes += Integer.decode(args[1]);
                totalWords += Integer.decode(args[2]);
                if (data.containsKey(args[0])){
                    NaiveBayesWordData word = data.get(args[0]);
                    NaiveBayesWordData newWord = new NaiveBayesWordDataImplementation(
                            args[0],
                            Integer.decode(args[1]) + word.getnJokes(),
                            Integer.decode(args[2]) + word.getnOccurrences()
                            );
                    data.put(args[0], newWord);

                } else {
                    data.put(args[0],
                            new NaiveBayesWordDataImplementation(
                                    args[0],
                                    Integer.decode(args[1]),
                                    Integer.decode(args[2]
                                    )
                            )
                    );
                }

            }
        }
        in.close();
    }

    public void saveToFile(File outputFile) throws IOException {
        Writer out = new FileWriter(outputFile);
        for (NaiveBayesWordData word: data.values()) {
            out.write(String.format("%s,%d,%d\n",
                    word.getWord(),
                    word.getnJokes(),
                    word.getnOccurrences()
                    ));
        }
        out.close();
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

    public int getnOccurrences() {
        return totalWords;
    }

    public int getnJokeOccurrences() {
        return totalJokes;
    }
}
