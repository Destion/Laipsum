package test;


import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;

import java.io.File;

/**
 * Created by gerben on 8-12-15.
 */
public class TestMultipleClasses {
    public static void main(String[] args) {
        NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();

        classifier.train("Deze zin bevat meerdere instanties van het 'a' teken, " +
                "de 'a' dient als test om te zien of de classifier dit correct classificeert.", "a");
        classifier.train("Deze zin bevat meerdere 'b' tekens, " +
                "hierdoor zou de classifier in theorie zinnen met een 'b' er in moeten zien als onderdeel van deze klasse.", "b");
        classifier.train("Als laatste konden we bij deze zin de 'c' niet achterlaten, na ab komt natuurlijk een c.", "c");

        //Save the classifier data, to test this part of the implementation.

        File file = new File("./GerbenIsEenPizza.gov");
        classifier.saveKnowledgeToFile(file);
        NaiveBayesClassifier classifier2 = classifier;
        classifier = new NaiveBayesClassifierImplementation();
        classifier.trainFromFile(file);


        //Test if it's working.

        testClassifier(classifier, "De zin bevat een c, en zowaar nog een c. " +
                "Helaas is deze code niet geschreven in C, anders zou het lekker onleesbaar zijn ;)", "c");
        testClassifier(classifier, "Deze zinnen zijn een b -tje kinderachtig vind ik...", "b");
        testClassifier(classifier, "Wie b zegt, moet ook a zeggen. Heel vaak zelfs, a a a a a a!", "a");


    }

    public static void testClassifier(NaiveBayesClassifier classifier, String input, String correctClass) {
        if (classifier.getClass(input).equals(correctClass)){
            System.out.printf("The test \"%s\" was correctly classified as %s.\n", input, correctClass);
        } else {
            System.err.printf("The test \"%s\" was incorrectly classified as %s, it should have been %s.\n", input, classifier.getClass(input), correctClass);

        }
    }
}
