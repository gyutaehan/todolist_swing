package ict.badass.todolist.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(!isSelected) {
			if(row % 2 ==0) {
				c.setBackground(new Color(255, 234, 234));
			} else {
				c.setBackground(Color.white);
			}
		}
		return c;
	}
}
