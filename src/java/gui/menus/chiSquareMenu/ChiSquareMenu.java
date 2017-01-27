package gui.menus.chiSquareMenu;

import classifiers.NaiveBayesClassifierImplementation;

import javax.swing.*;

/**
 * Created by root on 27-1-17.
 */
public class ChiSquareMenu extends JMenu {

    public ChiSquareMenu(){
        super("ChiSquareTesting");
        this.add(new ExecuteChiSquare());
        this.add(new GetMostDistinguishing());
    }
}
