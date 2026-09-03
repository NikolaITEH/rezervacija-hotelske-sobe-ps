/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.models;

import domain.StrucnaSprema;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelStrucnaSprema extends AbstractTableModel {

    private List<StrucnaSprema> strucneSpreme;
    private final String[] columnNames = {"Naziv", "Stepen", "Institucija"};

    public TableModelStrucnaSprema(List<StrucnaSprema> strucneSpreme){
        this.strucneSpreme=strucneSpreme;
    }
    
    @Override
    public int getRowCount() {
        return strucneSpreme == null ? 0 : strucneSpreme.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StrucnaSprema s = strucneSpreme.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getNaziv();
            case 1:
                return s.getStepen();
            case 2:
                return s.getInstitucija();
            default:
                return null;
        }
    }
    
    public void addStrucnaSprema(StrucnaSprema s){
        strucneSpreme.add(s);
        fireTableRowsInserted(strucneSpreme.size() -1, strucneSpreme.size() -1);
    }

}
