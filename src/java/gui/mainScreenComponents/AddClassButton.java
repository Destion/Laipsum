package gui.mainScreenComponents;

import gui.ModelContainer;
import main.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gerben on 6-1-16.
 */
public class AddClassButton extends JButton implements ActionListener{

    public AddClassButton() {
        setText("Add new class");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelContainer.getInstance().getClassifier().addClass(
                Util.promptString("Class name: ", "Add class")
        );
        ModelContainer.getInstance().updateTable();
    }
}
