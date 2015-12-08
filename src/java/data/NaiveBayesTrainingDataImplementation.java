package data;

import main.Util;

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

    private final Map<String, Integer> totals = new HashMap<String, Integer>();

    public NaiveBayesTrainingDataImplementation() {
        data = new HashMap<String, NaiveBayesWordData>();
    }

    public void addFromFile(File inputFile) throws IOException {
        Scanner in = new Scanner(new FileInputStream(inputFile));
        String[] classNames = null;
        if(in.hasNextLine()) {
            String line = in.nextLine();
            classNames = line.split(",");

        }
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] args = line.split(",");
            if (args.length == classNames.length + 2) {
                for (int i = 0; i < classNames.length; i++) {
                    int value = Integer.decode(args[i + 1]);
                    if (totals.containsKey(classNames[i])) {
                        totals.put(classNames[i], totals.get(classNames[i]) + value);
                    } else {
                        totals.put(classNames[i], value);

                    }
                }
                totalWords += Integer.decode(args[args.length - 1]);
                if (data.containsKey(args[0])){
                    NaiveBayesWordData word = data.get(args[0]);
                    NaiveBayesWordData newWord = new NaiveBayesWordDataImplementation(
                            args[0],
                            Integer.decode(args[args.length - 1]) + word.getnOccurrences()
                            );
                    data.put(args[0], newWord);

                } else {
                    data.put(args[0],
                            new NaiveBayesWordDataImplementation(
                                    args[0],
                                    Integer.decode(args[args.length - 1]
                                    )
                            )
                    );
                    for (int i = 0; i < classNames.length; i++) {
                        data.get(args[0]).incrementnClass(classNames[i],
                                Integer.decode(args[i+1]));

                    }
                }

            }
        }
        in.close();
    }

    public void saveToFile(File outputFile) throws IOException {
        Writer out = new FileWriter(outputFile);
        String[] classes = Util.toStringArray(totals.keySet().toArray());
        String classString = "";
        for (int i = 0; i < classes.length; i++) {
            classString += classes[i];
            if (i < classes.length-1){
                classString += ",";
            }
        }
        out.write(classString+"\n");
        for (NaiveBayesWordData word: data.values()) {
            String classInfo = "";
            for (String c : classes) {
                classInfo += word.getnClass(c) + ",";
            }

            out.write(String.format("%s,%s%d\n",
                    word.getWord(),
                    classInfo,
                    word.getnOccurrences()
                    ));
        }
        out.close();
    }


    public void train(String word, String c) {
        //increment the total amount of words counted.
        totalWords ++;

        //Increment the total number of jokes if it is a joke.
        if (totals.containsKey(c)) {
            totals.put(c, totals.get(c) + 1);
        } else {
            totals.put(c, 1);
        }

        //Check if we already know this word.
        if (data.containsKey(word)) {

            //If we already know the word, get its data.
            NaiveBayesWordData wordData = data.get(word);

            //Increment it's number of occurrences.
            wordData.incrementnOccurrences();

            //Increment it's amount of occurrences in the class.
            wordData.incrementnClass(c);

        } else {

            //Add the word to our data and set it's variables.
            NaiveBayesWordData newData = new NaiveBayesWordDataImplementation(word, 1);
            data.put(word, newData);
            newData.incrementnClass(c);
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

    public int getnClassOccurrences(String c) {
        Integer occurrences = totals.get(c);

        return occurrences==null?0:occurrences;
    }

    public String[] getClasses() {
        return Util.toStringArray(totals.keySet().toArray());
    }
}
