package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesWordDataImplementation implements NaiveBayesWordData{
    private String word;
    private final Map<String, Integer> occurrences = new HashMap<String, Integer>();
    private int nOccurrences;
    private double mutualInformation;
    private boolean miValid = false;

    public NaiveBayesWordDataImplementation(String word, int nOccurrences) {
        this.word = word;
        this.nOccurrences = nOccurrences;
    }

    public String getWord() {
        return word;
    }

    public int getnClass(String c) {
        Integer occ = occurrences.get(c);
        return occ==null?0:occ;
    }

    public int getnOccurrences() {
        return nOccurrences;
    }

    public void incrementnClass(String c) {
        incrementnClass(c, 1);
    }

    public void incrementnClass(String c, int amount) {
        miValid = false;
        if (occurrences.containsKey(c)) {
            occurrences.put(c, occurrences.get(c) + amount);
        } else {
            occurrences.put(c, amount);
        }
    }

    public void incrementnOccurrences() {
        miValid = false;
        nOccurrences+=1;
    }

    public void setMutualInformation(double maxMutualInfo) {
        mutualInformation = maxMutualInfo;
        miValid = true;
    }

    public double getMutualInformation() throws MutualInformationInvalidException {
        if (!miValid) {
            throw new MutualInformationInvalidException();
        }
        return mutualInformation;
    }

}
