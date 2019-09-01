package jdijkstraswing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import static jdijkstraswing.Const.BLOCK;
import static jdijkstraswing.Const.VISITED;

public class MapaRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String valor = (String) value;
        
        if(value == null) return l;
        switch (valor) {
            case VISITED:
                l.setBackground(Color.BLUE);
                l.setForeground(Color.BLUE);
                break;
            case BLOCK:
                l.setBackground(Color.BLACK);
                l.setForeground(Color.BLACK);
                break;
            default:
                l.setBackground(Color.WHITE);
                l.setForeground(Color.WHITE);
                break;
        }
        
        return l;
    }
}