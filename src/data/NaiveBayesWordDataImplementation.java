package data;

/**
 * Created by gerben on 24-11-15.
 */
public class NaiveBayesWordDataImplementation implements NaiveBayesWordData{
    String word;
    int nJokes;
    int nOccurrences;

    public NaiveBayesWordDataImplementation(String word, int nJokes, int nOccurrences) {
        this.word = word;
        this.nJokes = nJokes;
        this.nOccurrences = nOccurrences;
    }

    public String getWord() {
        return word;
    }

    public int getnJokes() {
        return nJokes;
    }

    public int getnOccurrences() {
        return nOccurrences;
    }

    public void incrementnJokes() {
        nJokes+=1;
    }

    public void incrementnOccurrences() {
        nOccurrences+=1;
    }
}
