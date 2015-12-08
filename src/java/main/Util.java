package main;

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
}
