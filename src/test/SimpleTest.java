package test;

import classifiers.NaiveBayesClassifier;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class SimpleTest {
    public void main(String[] args) {
        //TODO: Add instantiation of a implementation of the NaiveBayesClassifier
        NaiveBayesClassifier classifier = null;

        Map <String, Boolean> trainingMap = new HashMap<String, Boolean>();
        trainingMap.put("My friend thinks he is smart. He told me an onion is the only food that makes you cry, so I threw a coconut at his face.", true);
        trainingMap.put("Q: Is Google male or female? \n" +
                "A: Female, because it doesn't let you finish a sentence before making a suggestion.", true);
        trainingMap.put("The Moon (in Greek: σελήνη Selene, in Latin: Luna) is Earth's only natural satellite.", false);
        trainingMap.put("A river is a natural flowing watercourse, usually freshwater, flowing towards an ocean, sea, lake or another river.", false);
        trainingMap.put("Yo momma is so fat when she got on the scale it said, \"I need your weight not your phone number.\"", true);

        classifier.train(trainingMap);
        assertEqual("Joke is classified as joke.", classifier.isJoke(
                "What happens to a frog's car when it breaks down?\n" +
                "It gets toad away.")
                , true);

        assertEqual("Non joke is not classified as joke.", classifier.isJoke(
                "The Sun is a G-type main-sequence star (G2V) based on spectral class and it is informally referred to as a yellow dwarf.")
                , false);



    }

    public static void assertEqual(String testSummary, boolean answer, boolean targetAnswer) {
        if (answer != targetAnswer) {
            System.out.printf("Test resulted in wrong result: \"%s\"\nExpected value:\tActual value:\n%s\t%s\n", testSummary, targetAnswer, answer);
        }
    }
}
