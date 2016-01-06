package gui.mainScreenComponents;

import gui.ModelContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gerben on 6-1-16.
 */
public class FillInFromTestDataButton extends JButton implements ActionListener{

    public FillInFromTestDataButton() {
        super("Get new sentence");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelContainer.getInstance().pushTest();
    }
}
