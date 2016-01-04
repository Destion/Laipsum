package main;

import javax.swing.*;
import java.io.File;

/**
 * Created by gerben on 8-12-15.
 */
public class Util {

    public static String[] toStringArray(Object[] array) {
        String[] stringArray = new String[array.length];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = (String) array[i];
        }
        return stringArray;
    }

    public static File promptFile() {
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();

        //In response to a button click:
        int returnVal = fc.showOpenDialog(fc);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("Opened "+ fc.getSelectedFile());
            return fc.getSelectedFile();
        } else {
            System.out.println("Something went wrong!");
            return null;
        }

    }
}
