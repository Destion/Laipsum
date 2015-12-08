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

    private int totalClasss = 0;

    public NaiveBayesTrainingDataImplementation() {
        data = new HashMap<String, NaiveBayesWordData>();
    }

    public void addFromFile(File inputFile) throws IOException {
        Scanner in = new Scanner(new FileInputStream(inputFile));
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] args = line.split(",");
            if (args.length == 3) {
                totalClasss += Integer.decode(args[1]);
                totalWords += Integer.decode(args[2]);
                if (data.containsKey(args[0])){
                    NaiveBayesWordData word = data.get(args[0]);
                    NaiveBayesWordData newWord = new NaiveBayesWordDataImplementation(
                            args[0],
                            Integer.decode(args[1]) + word.getnClass(),
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
                    word.getnClass(),
                    word.getnOccurrences()
                    ));
        }
        out.close();
    }


    public void train(String word, boolean isInClass) {
        //increment the total amount of words counted.
        totalWords ++;

        //Increment the total number of jokes if it is a joke.
        if (isInClass) {
            totalClasss ++;
        }

        //Check if we already know this word.
        if (data.containsKey(word)) {

            //If we already know the word, get its data.
            NaiveBayesWordData wordData = data.get(word);

            //Increment it's number of occurrences.
            wordData.incrementnOccurrences();

            //Check if the word is part of a joke.
            if (isInClass) {

                //If so, increment it's amount of occurrences in a joke.
                wordData.incrementnClass();

            }
        } else {

            //Add the word to our data and set it's variables. Always add 1 to both classes because our classifier will not work otherwise.
            data.put(word, new NaiveBayesWordDataImplementation(word, isInClass?2:1, 3));
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

    public int getnClassOccurrences() {
        return totalClasss;
    }
}
