package gui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by gerben on 5-1-16.
 */
public class GuiTestResultsTable extends JScrollPane {

    private String[] columnHeaders = new String[1];
    private Object[][] data = new Object[1][];
    JTable table;
    DefaultTableModel model;

    public GuiTestResultsTable() {
        super();
        table = new JTable();
        model = (DefaultTableModel) table.getModel();
        model.setDataVector(data, columnHeaders);
        updateTable();
        ModelContainer.getInstance().setListener(this);
        setViewportView(table);

    }

    public void updateTable() {

        data = ModelContainer.getInstance().getTestData();
        columnHeaders = new String[ModelContainer.getInstance().getClassifier().getClassNames().length + 1];
        columnHeaders[0] = "ClassName ->";
        System.arraycopy(ModelContainer.getInstance().getClassifier().getClassNames()
                , 0, columnHeaders, 1
                , columnHeaders.length - 1
        );
        model.setDataVector(data, columnHeaders);
        model.fireTableDataChanged();

    }

}
