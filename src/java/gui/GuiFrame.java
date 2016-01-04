package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gerben on 4-1-16.
 */
public class GuiFrame extends JFrame {

    private JPanel guiPanel;

    public GuiFrame() {
        super();

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        guiPanel = new GuiPanel();

        this.add(guiPanel, BorderLayout.CENTER);

        this.add(new JButton("Gerben is een koekje"), BorderLayout.EAST);
        this.add(new JButton("Gerben is een malloot"), BorderLayout.SOUTH);

        String[] strings = {"Gerben", "Pizza", "Koekjes", "Macfags"};

        JComboBox cb = new JComboBox(strings);
        cb.setSelectedIndex(3);

        this.add(cb, BorderLayout.WEST);

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
