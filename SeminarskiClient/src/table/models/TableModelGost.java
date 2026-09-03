/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.models;

import domain.Gost;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelGost extends AbstractTableModel {

    private List<Gost> gosti;
    private final String[] columnNames = {"Ime", "Prezime", "Broj telefona", "Email", "Drzava"};

    public TableModelGost(List<Gost> gosti) {
        this.gosti = gosti;
    }

    @Override
    public int getRowCount() {
        return gosti == null ? 0 : gosti.size();
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
        Gost g=gosti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return g.getIme();
            case 1:
                return g.getPrezime();
            case 2:
                return g.getBroj();
            case 3:
                return g.getEmail();
            case 4:
                return g.getDrzava();
            default:
                return null;
        }
    }
    
    public Gost getGostAt(int row){
        return gosti.get(row);
    }

}
