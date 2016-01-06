package test;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;
import data.DocumentLoader;

import java.io.File;
import java.io.IOException;

/**
 * Created by gerben on 8-12-15.
 */
public class TestMails {

    public static void main(String[] args) {

        NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();

        //Train our classifier to recognize whether our blogger is female.
        File[] folders = (new File("./corpus")).listFiles();
        for (int i = 0; i < folders.length - 1; i++) {

            File[] files = folders[i].listFiles();
            for (int j = 0; j < files.length; j++) {
                try {
                    classifier.train(DocumentLoader.loadFromFile(files[j]), files[j].getName().contains("spm") ? "spm" : "msg");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


        File[] files = folders[folders.length - 1].listFiles();
        int rightSpam = 0;
        int wrongSpam = 0;
        int rightMessage = 0;
        int wrongMessage = 0;
        for (int j = 0; j < files.length; j++) {
            try {
                String classifiedAs = classifier.getClass(DocumentLoader.loadFromFile(files[j]));
                if (files[j].getName().contains("spm")) {
                    if (classifiedAs.equals("spm")) {
                        rightSpam += 1;
                    } else {
                        wrongSpam += 1;
                    }
                } else {
                    if (classifiedAs.equals("spm")) {
                        wrongMessage += 1;
                    } else {
                        rightMessage += 1;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Spam correctly classified: %d\n", rightSpam);
        System.out.printf("Messages correctly classified: %d\n", rightMessage);
        System.out.printf("Spam not classified as such: %d\n", wrongSpam);
        System.out.printf("Messages not classified as such: %d\n", wrongMessage);


    }
}
