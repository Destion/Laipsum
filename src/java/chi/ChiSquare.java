package chi;

import java.util.HashMap;

public class ChiSquare {

    //TODO replace int types from classifier, find out real classifier type

    private int classifier;

//    public ChiSquare(int classifier){
//        this.classifier = classifier;
//
//
//        this.executeTest();
//    }

    //temp constructor

    public ChiSquare(){
        executeTest();
    }




    //TODO get classifier in here, get classes from classifier into arraylist, get length of classes, test word occurenses in the class.

    private float executeTest(){
        //C1 t/m Cn in example
        HashMap<String, Float> lengthsPerClass = new HashMap<>();

        //Temp code for testing
        lengthsPerClass.put("c1", 60f);
        lengthsPerClass.put("c2", 60f);


        //120 in exampletable (N)
        int totalTexts = 0;

        for(float texts : lengthsPerClass.values()){
            totalTexts += texts;
        }

        //W1 t/m Wn in example, can be used to calculate notW1 t/m notWn
        HashMap<String, Float> occurencesPerClass = new HashMap<>();

        //Temp code for testing
        occurencesPerClass.put("c1", 10f);
        occurencesPerClass.put("c2", 1f);

        //W1 in example
        int totalOccurences = 0;
        //W2 in example
        int totalNonOccurences = 0;

        for(float occurences : occurencesPerClass.values()){
            totalOccurences += occurences;
        }

        totalNonOccurences = totalTexts - totalOccurences;

        //Expected values for w and not w per class
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
        return 0;
    }
}
