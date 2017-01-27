package gui.menus.chiSquareMenu;

import chi.ChiSquare;
import classifiers.NaiveBayesClassifierImplementation;
import data.NaiveBayesTrainingDataImplementation;
import gui.ModelContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by root on 27-1-17.
 */
public class GetMostDistinguishing extends JMenuItem implements ActionListener {

    public GetMostDistinguishing(){
        super("Get most distinguishing words");
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent actionEvent) {
        int amount = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Please input amount:"));
        NaiveBayesClassifierImplementation classifier = (NaiveBayesClassifierImplementation) ModelContainer.getInstance().getClassifier();
        HashMap<String, Float> results = new ChiSquare(classifier, "").mostDistinguishing(amount);
        String s = "";
        for(String name : results.keySet()){
            s = s + name + " : " + results.get(name) + "\n";
        }
        JOptionPane.showMessageDialog(new JFrame(), s);
    }
}
