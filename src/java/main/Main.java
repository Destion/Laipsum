package main;

/**
 * Created by destion on 17-11-15.
 */

import weka.classifiers.bayes.NaiveBayes;
import weka.core.*;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.NumericToNominal;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Main {

    public static void main(String[] args) {

        System.out.println("Gerben is kut en Aede is fries.");
        FastVector attributesEven = new FastVector(11);
        attributesEven.addElement(new Attribute("E"));
        FastVector attributesOdd = new FastVector(11);
        attributesOdd.addElement(new Attribute("O"));
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0) {
                attributesEven.addElement(new Attribute("koek"+i));
            } else {
                attributesOdd.addElement(new Attribute("pizza"+i));
            }


        }
        Instances instancesEven = new Instances("even", attributesEven, 11);
        Instances instancesOdd = new Instances("odd", attributesOdd, 11);



        NaiveBayes naiveBayes = new NaiveBayes();
        try {
            instancesEven.setClassIndex(0);
            System.out.println(instancesEven);
            naiveBayes.buildClassifier(instancesEven);
            instancesOdd.setClassIndex(0);
            naiveBayes.buildClassifier(instancesOdd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
