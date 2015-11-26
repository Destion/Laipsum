package project;

import classifiers.NaiveBayesClassifier;
import classifiers.NaiveBayesClassifierImplementation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by gerben on 24-11-15.
 */
public class LoadFromSQL {
    public static void main(String[] args) {
        NaiveBayesClassifier classifier = new NaiveBayesClassifierImplementation();
        try {
            classifier.train(
                    LoadFromSQL.loadFromSQL(
                            new File("./data/funny_jokes.sql")
                    )
            );
            classifier.saveKnowledgeToFile(new File("./jokes.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Boolean> loadFromSQL(File sqlFile) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(sqlFile));
        Map<String, Boolean> out = new HashMap<String, Boolean>();

        while (in.hasNext()){
            String line = in.nextLine();
            if (line.matches(".* VALUES \\([0-9]*, '[^']*', '[^']*'\\);")){
                line = line.replaceAll(".* VALUES \\([0-9]*, '[^']*', '", "");
                line = line.replaceAll("\\\\r\\\\n", " ");
                out.put(line, true);
            }

        }
        in.close();
        return out;
    }
}
