package chi;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;
import data.NaiveBayesTrainingData;
import data.NaiveBayesTrainingDataImplementation;
import data.UnknownWordException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ChiSquare {

    //TODO replace int types from classifier, find out real classifier type

    private NaiveBayesClassifierImplementation classifier;
    private String word;

    public ChiSquare(NaiveBayesClassifierImplementation classifier, String word){
        this.classifier = classifier;
        this.word = word;
    }

//    private float executeTest(){
//        //C1 t/m Cn in example
//        HashMap<String, Float> lengthsPerClass = new HashMap<>();
//
//        //Temp code for testing
//        lengthsPerClass.put("c1", 60f);
//        lengthsPerClass.put("c2", 60f);
//
//
//        //120 in exampletable (N)
//        int totalTexts = 0;
//
//        for(float texts : lengthsPerClass.values()){
//            totalTexts += texts;
//        }
//
//        //W1 t/m Wn in example, can be used to calculate notW1 t/m notWn
//        HashMap<String, Float> occurencesPerClass = new HashMap<>();
//
//        //Temp code for testing
//        occurencesPerClass.put("c1", 10f);
//        occurencesPerClass.put("c2", 1f);
//
//        //W1 in example
//        int totalOccurences = 0;
//        //W2 in example
//        int totalNonOccurences;
//
//        for(float occurences : occurencesPerClass.values()){
//            totalOccurences += occurences;
//        }
//
//        totalNonOccurences = totalTexts - totalOccurences;
//
//        //Expected values for w and not w per class
//        HashMap<String, Float> expectedPos = new HashMap<>();
//        HashMap<String, Float> expectedNeg = new HashMap<>();
//
//        for(String clss : lengthsPerClass.keySet()){
//            float expectedtemp = (totalOccurences * lengthsPerClass.get(clss));
//            float expected = expectedtemp / totalTexts;
//            expectedPos.put(clss, expected);
//
//            float expectedtemp2 = (totalNonOccurences * lengthsPerClass.get(clss));
//            float expected2 = expectedtemp2 / totalTexts;
//            expectedNeg.put(clss, expected2);
//        }
//
//        for (float expec :  expectedPos.values()){
//            System.out.println(expec);
//        }
//        for (float expec :  expectedNeg.values()){
//            System.out.println(expec);
//        }
//
//        //End of Expected value calculations and testing
//
//        float result = 0f;
//
//        for(String c : occurencesPerClass.keySet()){
//            result += (Math.pow(occurencesPerClass.get(c) - expectedPos.get(c), 2)) / expectedPos.get(c);
//            result += (Math.pow((lengthsPerClass.get(c) - occurencesPerClass.get(c)) - expectedNeg.get(c), 2)) / expectedNeg.get(c);
//        }
//
//        System.out.println(result);
//
//        return result;
//    }

    public float executeRealTest(){

        NaiveBayesTrainingData data = this.classifier.getData();

        HashMap<String, Float> lengthsPerClass = new HashMap<>();

        for(String cl : data.getClasses()){
            System.out.println(cl);
            lengthsPerClass.put(cl, (float) data.getnClassOccurrences(cl));
        }

        int totalTexts = 0;

        for(float texts : lengthsPerClass.values()){
            totalTexts += texts;
        }

        System.out.println(totalTexts);

        HashMap<String, Float> occurencesPerClass = new HashMap<>();

        for(String cl2 : data.getClasses()){
            try {
                occurencesPerClass.put(cl2, (float) data.getWord(this.word).getnClass(cl2));
            } catch (UnknownWordException e) {
                e.printStackTrace();
            }
        }

        int totalOccurences = 0;
        int totalNonOccurences;

        for(float occurences : occurencesPerClass.values()){
            totalOccurences += occurences;
        }

        totalNonOccurences = totalTexts - totalOccurences;

        HashMap<String, Float> expectedPos = new HashMap<>();
        HashMap<String, Float> expectedNeg = new HashMap<>();

        for(String clss : lengthsPerClass.keySet()){
            float expectedtemp = (totalOccurences * lengthsPerClass.get(clss));
            float expected = expectedtemp / totalTexts;
            expectedPos.put(clss, expected);

            float expectedtemp2 = (totalNonOccurences * lengthsPerClass.get(clss));
            float expected2 = expectedtemp2 / totalTexts;
            expectedNeg.put(clss, expected2);
        }

        for (float expec :  expectedPos.values()){
            System.out.println(expec);
        }
        for (float expec :  expectedNeg.values()){
            System.out.println(expec);
        }

        float result = 0f;

        for(String c : occurencesPerClass.keySet()){
            result += (Math.pow(occurencesPerClass.get(c) - expectedPos.get(c), 2)) / expectedPos.get(c);
            result += (Math.pow((lengthsPerClass.get(c) - occurencesPerClass.get(c)) - expectedNeg.get(c), 2)) / expectedNeg.get(c);
        }

        System.out.println(result);

        return result;
    }

    public HashMap<String, Float> mostDistinguishing(int amount){

        NaiveBayesTrainingDataImplementation data = (NaiveBayesTrainingDataImplementation) this.classifier.getData();
        HashMap<String, Float> result = new HashMap<>();

        float lowest = Float.MAX_VALUE;
        String lowestname = "";

        for (String lowname : result.keySet()){
            if (result.get(lowname) < lowest){
                lowest = result.get(lowname);
                lowestname = lowname;
            }
        }

        for(String word : data.getWords()){
            this.word = word;
            float temp = executeRealTest();
            if (result.size() + 1 > amount){
                if (temp > lowest){
                    result.remove(lowestname);
                    result.put(word, temp);
                    for (String lowname : result.keySet()){
                        if (result.get(lowname) < lowest){
                            lowest = result.get(lowname);
                            lowestname = lowname;
                        }
                    }
                }
            } else {
                result.put(word, temp);
                for (String lowname : result.keySet()){
                    if (result.get(lowname) < lowest){
                        lowest = result.get(lowname);
                        lowestname = lowname;
                    }
                }
            }
        }

        return result;
    }
}
