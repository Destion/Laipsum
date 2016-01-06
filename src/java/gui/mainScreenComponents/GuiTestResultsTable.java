package gui.mainScreenComponents;


import gui.ModelContainer;
import gui.listeners.TestDataListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by gerben on 5-1-16.
 */
public class GuiTestResultsTable extends JScrollPane implements TestDataListener {
    private String[] columnHeaders = new String[0];
    private Object[][] data = new Object[0][];
    JTable table;
    DefaultTableModel model;

    public GuiTestResultsTable() {
        super();
        table = new JTable();
        table.setModel(new TableModel());
        model = (DefaultTableModel) table.getModel();
        model.setDataVector(data, columnHeaders);
        ModelContainer.getInstance().addListener(this);
        setViewportView(table);

    }

    public void onTestDataUpdate() {

        data = ModelContainer.getInstance().getTestData();
        columnHeaders = new String[ModelContainer.getInstance().getClassifier().getClassNames().length + 1];
        columnHeaders[0] = "ClassName / Classified as ->";
        System.arraycopy(ModelContainer.getInstance().getClassifier().getClassNames()
                , 0, columnHeaders, 1
                , columnHeaders.length - 1
        );
        model.setDataVector(data, columnHeaders);
        model.fireTableDataChanged();

    }

}
