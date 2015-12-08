package data;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesWordDataImplementation implements NaiveBayesWordData{
    String word;
    int nClasss;
    int nOccurrences;

    public NaiveBayesWordDataImplementation(String word, int nClasss, int nOccurrences) {
        this.word = word;
        this.nClasss = nClasss;
        this.nOccurrences = nOccurrences;
    }

    public String getWord() {
        return word;
    }

    public int getnClass() {
        return nClasss;
    }

    public int getnOccurrences() {
        return nOccurrences;
    }

    public void incrementnClass() {
        nClasss+=1;
    }

    public void incrementnOccurrences() {
        nOccurrences+=1;
    }
}
