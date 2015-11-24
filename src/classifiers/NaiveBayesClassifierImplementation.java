package classifiers;

import data.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesClassifierImplementation implements NaiveBayesClassifier {
    NaiveBayesTrainingData data = new NaiveBayesTrainingDataImplementation();

    public boolean isJoke(String text) {
        String[] normalized = normalize(text);
        double totalJokes = data.getnJokeOccurrences();
        double totalNonJokes = data.getnOccurrences() - data.getnJokeOccurrences();
        double chanceJokeGivenText = totalJokes/data.getnOccurrences();
        double chanceNotJokeGivenText = totalNonJokes/data.getnOccurrences();
        for (String word: normalized) {
            try {
                NaiveBayesWordData wordData = data.getWord(word);
                chanceJokeGivenText *= wordData.getnJokes()/totalJokes;
                chanceNotJokeGivenText *= (wordData.getnOccurrences() - wordData.getnJokes())/totalNonJokes;


            } catch (UnknownWordException e) {
                chanceJokeGivenText *= 1.0;
                chanceNotJokeGivenText *= 1.0;
            }
        }

        System.out.printf("Joke: %f, not a joke: %f\n", chanceJokeGivenText, chanceNotJokeGivenText);
        return chanceJokeGivenText>chanceNotJokeGivenText;
    }

    public static String[] normalize(String text) {
        //Put text in lowercase
        text = text.toLowerCase();

        //Take out any irrelevant characters
        text = text.replaceAll("\n", " ");
        text = text.replaceAll("[^a-zA-Z ]", "");

        return text.split(" ");
    }

    public void train(String text, boolean isJoke) {
        for (String word: normalize(text)) {
            data.train(word, isJoke);
        }

    }

    public void train(Map<String, Boolean> data) {
        for(String text: data.keySet()) {
            train(text, data.get(text));
        }

    }

    public void trainFromFile(File inputFile) {
        try {
            data.addFromFile(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveKnowledgeToFile(File outputFile) {
        try {
            data.saveToFile(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
