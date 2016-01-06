package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by gerben on 8-12-15.
 */
public class DocumentLoader {
    public static String loadFromFile(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = null;
        String out = "";

        while ((line = in.readLine()) != null) {
            out += line + "\n";
        }
        in.close();
        return out;
    }

    public static String loadFromFile(String path) throws IOException {
        File file = new File(path);
        return loadFromFile(file);

    }
}
