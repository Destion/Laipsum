package gui.menus.chiSquareMenu;

import chi.ChiSquare;
import classifiers.NaiveBayesClassifierImplementation;
import gui.ModelContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by root on 27-1-17.
 */
public class ExecuteChiSquare extends JMenuItem implements ActionListener{


    public ExecuteChiSquare(){
        super("Execute Chi Square Test");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String word = JOptionPane.showInputDialog(new JFrame(), "Please input the word to be tested:");
        NaiveBayesClassifierImplementation classifier = (NaiveBayesClassifierImplementation) ModelContainer.getInstance().getClassifier();
        JOptionPane.showMessageDialog(new JFrame(), new ChiSquare(classifier, word).executeRealTest());
    }
}
