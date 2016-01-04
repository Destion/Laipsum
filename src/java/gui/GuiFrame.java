package gui;

import javax.swing.*;

/**
 * Created by gerben on 4-1-16.
 */
public class GuiFrame extends JFrame {

    public GuiFrame() {
        super();
        setTitle("Naive Bayes Classifier");
        setJMenuBar(new GuiMenuBar());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(500,500);
        setVisible(true);


    }

    public static void main(String[] args) {
        GuiFrame frame = new GuiFrame();
    }
}
