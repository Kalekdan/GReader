import javax.swing.*;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.Component;

public class GamesTable extends JTable {
    private static Class[] types = {Integer.class, String.class, Integer.class};

    public GamesTable(Object[][] data, String[] collumns) {
        super(new DefaultTableModel(data, collumns) {
            @Override
            public Class getColumnClass(int column) {
                return types[column];
            }
        });
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);
        comp.setBackground(row % 2 == 0 ? Color.white : new Color(221, 221, 221));
        return comp;
    }

    @Override
    public void setTableHeader(JTableHeader tableheader) {
        super.setTableHeader(tableheader);
        tableheader.setBackground(Color.LIGHT_GRAY);
    }
}
