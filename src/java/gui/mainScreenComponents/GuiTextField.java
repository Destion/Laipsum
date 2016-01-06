package gui.mainScreenComponents;

import gui.ModelContainer;
import gui.listeners.TestCaseListener;

import javax.swing.*;

/**
 * Created by gerben on 6-1-16.
 */
public class GuiTextField extends JTextField implements TestCaseListener{

    public GuiTextField() {
        super();
        ModelContainer.getInstance().setTestCaseListener(this);
    }

    @Override
    public void onTestCasePushed(String sentence, String className) {
        setText(sentence);
        System.out.println(sentence);
    }
}
