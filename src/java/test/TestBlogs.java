package test;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;
import data.DocumentLoader;

import java.io.File;
import java.io.IOException;

/**
 * Created by gerben on 8-12-15.
 */
public class TestBlogs {
    public static void main(String[] args) {
        NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();

        //Train our classifier to recognize whether our blogger is female.
        for (String gender: new String[] {"M", "F"}) {
            File[] files = (new File("./blogs/TrainingSet/"+gender)).listFiles();
            for (int i = 0; i < files.length; i++) {
                try {
                    classifier.train(DocumentLoader.loadFromFile(files[i]), gender.equals("F"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //Test the implementation
        //These variables should be read as: Classified as M while it should be M.
        int mm = 0;
        int mf = 0;
        int fm = 0;
        int ff = 0;
        for (String gender: new String[] {"M", "F"}) {
            File[] files = (new File("./blogs/TestSet/"+gender)).listFiles();
            for (int i = 0; i < files.length; i++) {
                try {
                    boolean isFemale = classifier.isClass(DocumentLoader.loadFromFile(files[i]));
                    if (gender.equals("F")) {
                        if (isFemale) {
                            ff += 1;
                        } else {
                            mf += 1;
                        }
                    } else {
                        if (isFemale) {
                            fm += 1;
                        } else {
                            mm += 1;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String out = "--Results--\n";
        out += String.format("Correct: %d\n", mm + ff);
        out += String.format("Incorrect: %d\n", mf + fm);
        out += String.format("Female\t correct: %d\t incorrect: %d\n", ff, mf);
        out += String.format("Male\t correct: %d\t incorrect: %d\n", mm, fm);
        System.out.println(out);

    }
}
