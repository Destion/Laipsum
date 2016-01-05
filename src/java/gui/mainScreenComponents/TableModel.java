package gui.mainScreenComponents;

import javax.swing.table.DefaultTableModel;

/**
 * Created by Destion on 5-1-2016.
 */
public class TableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
    }
}
