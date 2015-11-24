package classifiers;

import data.*;

import java.io.File;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesClassifierImplementation implements NaiveBayesClassifier {
    NaiveBayesTrainingData data = new NaiveBayesTrainingDataImplementation();

    public boolean isJoke(String text) {
        return false;
    }

    private double getJokeChance(String word, int sentenceLength) {
        //TODO: Broken logic.

        //Apply bayes rule

        //P(word is part of joke | data) should be P( this word occurs | this is a joke)
        double pjd;
        try {
            pjd = data.getInJokeChance(word);
        } catch (UnknownWordException e) {
            pjd = 1/sentenceLength;
        }

        //TODO: Find out if this P(data) can really just be a constant.
        double pd = 1.0;
        double pj = (double) data.getnJokeOccurrences()/ (double) data.getnOccurences();

        //Bayes rule:
        double pdj = (pjd * pj)/pd;
        return pdj;
    }

    public void train(String text, boolean isJoke) {

    }

    public void train(Map<String, Boolean> data) {

    }

    public void trainFromFile(File inputFile) {

    }

    public void saveKnowledgeToFile(File outputFile) {

    }
}
