package test;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;
import project.LoadFromSQL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class SimpleTest {
    public static void main(String[] args) {
        //TODO: Add instantiation of a implementation of the NaiveBayesClassifier
        NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();

        Map <String, Boolean> trainingMap = new HashMap<String, Boolean>();
        trainingMap.put("Joke Joke Joke", true);
        trainingMap.put("Joke Joke", true);
        trainingMap.put("Not a joke, not a joke, not a joke", false);
        trainingMap.put("Not a joke, no joke", false);
        trainingMap.put("Not not a joke, so a joke", true);

        classifier.train(trainingMap);
        classifier.trainFromFile(new File("./jokes.csv"));
        assertEqual("Joke tested as joke", classifier.isJoke(
                "What is uglier than an aardvark? Two aardvarks!")
                , true);

        assertEqual("Non joke is not classified as joke.", classifier.isJoke(
                "The moon does not have a fixed distance to the earth")
                , false);



    }

    public static void assertEqual(String testSummary, boolean answer, boolean targetAnswer) {
        if (answer != targetAnswer) {
            //System.out.printf("Test resulted in wrong result: \"%s\"\nExpected value:\tActual value:\n%s\t%s\n", testSummary, targetAnswer, answer);
            System.out.printf("Test resulted in wrong result: \"%s\"\n Expected value: \t\t %s \n Actual value: \t\t\t %s\n", testSummary, targetAnswer, answer);
        }
    }
}
