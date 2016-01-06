package classifiers;

import data.NaiveBayesTrainingData;
import data.NaiveBayesTrainingDataImplementation;
import data.NaiveBayesWordData;
import data.UnknownWordException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesClassifierImplementation implements NaiveBayesClassifier {
    NaiveBayesTrainingData data = new NaiveBayesTrainingDataImplementation();
    ArrayList<Double> MiList = new ArrayList<Double>();


    public String getClass(String text) {
        String[] normalized = normalize(text);
        String[] classes = data.getClasses();
        double[] logPropabilities = new double[classes.length];
        for (int i = 0; i < classes.length; i++) {
            String c = classes[i];
            double totalClass = data.getnClassOccurrences(c);
            double chanceClassGivenText = Math.log(totalClass) - Math.log(data.getnOccurrences());
            for (String word : normalized) {
                try {
                    NaiveBayesWordData wordData = data.getWord(word);
                    double mi = data.getMutualInformation(wordData);
                    MiList.add(mi);
                } catch (UnknownWordException e) {
                    chanceClassGivenText *= 1.0;
                }
            }
            double miAver = 0.0;
            for (double MI : MiList) {
                miAver += MI;
            }
            miAver = miAver / MiList.size();
            for (String word2 : normalized) {
                try {
                    NaiveBayesWordData wordData2 = data.getWord(word2);
                    double mi2 = data.getMutualInformation(wordData2);
                    if (mi2 >= miAver) {
                        chanceClassGivenText += Math.log(wordData2.getnClass(c) + 1) - Math.log(totalClass + classes.length);
                    }
                } catch (UnknownWordException e) {
                    chanceClassGivenText *= 1.0;
                }
            }
            logPropabilities[i] = chanceClassGivenText;

        }

        int highestI = 0;
        double highestValue = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < classes.length; i++) {

            if (logPropabilities[i] > highestValue) {
                highestI = i;
                highestValue = logPropabilities[i];
            }
        }

        return classes[highestI];
    }

    public static String[] normalize(String text) {
        //Put text in lowercase
        text = text.toLowerCase();

        //Take out any irrelevant characters
        text = text.replaceAll("\n", " ");
        text = text.replaceAll("[^a-zA-Z ]", "");

        return text.split(" ");
    }

    public void train(String text, String c) {
        for (String word : normalize(text)) {
            data.train(word, c);
        }

    }

    public void train(Map<String, String> data) {
        for (String text : data.keySet()) {
            train(text, data.get(text));
        }

    }

    public void trainFromFile(File inputFile) throws IOException {
        data.addFromFile(inputFile);

    }

    public void saveKnowledgeToFile(File outputFile) throws IOException {

        data.saveToFile(outputFile);

    }

    @Override
    public String[] getClassNames() {
        return data.getClasses();
    }
}
