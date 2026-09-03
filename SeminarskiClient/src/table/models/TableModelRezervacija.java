/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.models;

import domain.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelRezervacija extends AbstractTableModel {

    private List<Rezervacija> rezervacije;
    private final String[] columnNames = {"Datum", "Ukupan iznos(RSD)", "Nacin placanja", "Nacin rezervisanja", "Recepcioner", "Gost"};

    public TableModelRezervacija(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public int getRowCount() {
        return rezervacije == null ? 0 : rezervacije.size();
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
        Rezervacija r = rezervacije.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return new SimpleDateFormat("dd.MM.yyyy").format(r.getDatum());
            case 1:
                return String.format("%.2f", r.getUkupanIznos());
            case 2:
                return r.getNacinPlacanja();
            case 3:
                return r.getNacinRezervisanja();
            case 4:
                return r.getRecepcioner();
            case 5:
                return r.getGost();
            default:
                return null;
        }
    }

    public Rezervacija getRezervacijaAt(int row) {
        return rezervacije.get(row);
    }

}
