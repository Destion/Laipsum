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

    public boolean isClass(String text) {
        String[] normalized = normalize(text);
        double totalClass = data.getnClassOccurrences();
        double totalNonClass = data.getnOccurrences() - data.getnClassOccurrences();
        double chanceClassGivenText = Math.log(totalClass) - Math.log(data.getnOccurrences());
        double chanceNotClassGivenText = Math.log(totalNonClass) - Math.log(data.getnOccurrences());
        for (String word: normalized) {
            try {
                NaiveBayesWordData wordData = data.getWord(word);
                if (wordData.getnOccurrences() > 5) {
                    chanceClassGivenText += Math.log(wordData.getnClass()) - Math.log(totalClass);
                    chanceNotClassGivenText += Math.log(wordData.getnOccurrences() - wordData.getnClass()) - Math.log(totalNonClass);
                }


            } catch (UnknownWordException e) {
                chanceClassGivenText *= 1.0;
                chanceNotClassGivenText *= 1.0;
            }
        }


        return chanceClassGivenText>chanceNotClassGivenText;
    }

    public static String[] normalize(String text) {
        //Put text in lowercase
        text = text.toLowerCase();

        //Take out any irrelevant characters
        text = text.replaceAll("\n", " ");
        text = text.replaceAll("[^a-zA-Z ]", "");

        return text.split(" ");
    }

    public void train(String text, boolean isClass) {
        for (String word: normalize(text)) {
            data.train(word, isClass);
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
