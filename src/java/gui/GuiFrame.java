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
        setLayout(new GridBagLayout());
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
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        add(guiPanel, c);


        setTitle("Naive Bayes Classifier");
        setJMenuBar(new GuiMenuBar());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);


    }

    public static void main(String[] args) {
        GuiFrame frame = new GuiFrame();
    }
}
