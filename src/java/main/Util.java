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
        return promptFile(false);
    }

    public static File promptFile(boolean save) {
        //Create a file chooser
        final JFileChooser fc = new JFileChooser("./");
        int returnVal;
        if (save) {
            returnVal = fc.showSaveDialog(fc);
        } else {
            returnVal = fc.showOpenDialog(fc);
        }
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        } else {
            return null;
        }

    }

    public static File[] promptFiles() {
        //Create a file chooser
        final JFileChooser fc = new JFileChooser("./");
        fc.setMultiSelectionEnabled(true);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //In response to a button click:
        int returnVal = fc.showOpenDialog(fc);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFiles();
        } else {
            return null;
        }

    }

    public static void showInfoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String promptString(String infoMessage, String titleBar) {
        String s = JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.QUESTION_MESSAGE);
        if (s.equals("")){
            return null;
        }
        return s;
    }
}
