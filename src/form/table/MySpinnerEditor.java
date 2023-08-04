/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author YOGA6
 */
public class MySpinnerEditor extends DefaultCellEditor {
    JSpinner sp;
    DefaultEditor defaultEditor;
    JTextField text;
    // Initialize the spinner
    public MySpinnerEditor() {
        super(new JTextField());
        sp = new JSpinner();
        defaultEditor = ((DefaultEditor)sp.getEditor());
        text = defaultEditor.getTextField();
    }
    // Prepare the spinner component and return it
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
    {
        sp.setValue(value);
        return sp;
    }
    // Returns the current value of the spinners
    @Override
    public Object getCellEditorValue() {
        return sp.getValue();
    }
 }