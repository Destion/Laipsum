package gui;


import javax.swing.*;
import java.awt.*;

/**
 * Created by gerben on 5-1-16.
 */
public class GuiTestResultsTable extends JPanel {

    private String[] columnHeaders = new String[0];
    private Object[][] data = new Object[0][];
    JTable table;
    JScrollPane scrollPane;

    public GuiTestResultsTable() {
        super();
        updateTable();
        setLayout(new GridBagLayout());
        ModelContainer.getInstance().setListener(this);

    }

    public void updateTable() {
        if (table != null) {
            remove(table.getTableHeader());
            scrollPane.remove(table);
            remove(scrollPane);
        }
        data = ModelContainer.getInstance().getTestData();
        columnHeaders = new String[ModelContainer.getInstance().getClassifier().getClassNames().length + 1];
        columnHeaders[0] = "ClassName ->";
        System.arraycopy(ModelContainer.getInstance().getClassifier().getClassNames()
                , 0, columnHeaders, 1
                , columnHeaders.length - 1
        );
        table = new JTable(data, columnHeaders);
        table.setFillsViewportHeight(true);

        GridBagConstraints tableHeaderConstraints = new GridBagConstraints();
        tableHeaderConstraints.gridx = 0;
        tableHeaderConstraints.gridy = 0;
        tableHeaderConstraints.gridwidth = 1;
        tableHeaderConstraints.gridheight = 1;
        tableHeaderConstraints.weighty = 0;
        add(table.getTableHeader(), tableHeaderConstraints);
        scrollPane = new JScrollPane(table);

        GridBagConstraints tableConstraints = new GridBagConstraints();
        tableConstraints.gridx = 0;
        tableConstraints.gridy = 1;
        tableConstraints.gridwidth = 1;
        tableConstraints.gridheight = 1;
        tableConstraints.weighty = 0.5;
        add(scrollPane, tableConstraints);
        setVisible(false);
        setVisible(true);
    }

}
