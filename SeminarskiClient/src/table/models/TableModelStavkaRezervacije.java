/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.models;

import domain.StavkaRezervacije;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class TableModelStavkaRezervacije extends AbstractTableModel {

    private List<StavkaRezervacije> stavkeRezervacije;
    private final String[] columnNames = {"Broj dana", "Broj gostiju", "Datum pocetka", "Datum isteka", "Soba", "Iznos po gostu(RSD)", "Iznos(RSD)"};

    public TableModelStavkaRezervacije(List<StavkaRezervacije> stavkeRezervacije) {
        if (stavkeRezervacije != null) {
            this.stavkeRezervacije = stavkeRezervacije;
        } else {
            this.stavkeRezervacije = new ArrayList<>();
        }
    }

    @Override
    public int getRowCount() {
        return stavkeRezervacije == null ? 0 : stavkeRezervacije.size();
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
        StavkaRezervacije sr = stavkeRezervacije.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sr.getBrojDana();
            case 1:
                return sr.getBrojGostiju();
            case 2:
                return new SimpleDateFormat("dd.MM.yyyy").format(sr.getDatumPocetka());
            case 3:
                return new SimpleDateFormat("dd.MM.yyyy").format(sr.getDatumIsteka());
            case 4:
                return sr.getSoba();
            case 5:
                return String.format("%.2f", sr.getIznosPoGostu());
            case 6:
                return String.format("%.2f", sr.getIznos());
            default:
                return null;
        }
    }

    public void addStavkaRezervacije(StavkaRezervacije sr) {
        stavkeRezervacije.add(sr);
        fireTableRowsInserted(stavkeRezervacije.size() - 1, stavkeRezervacije.size() - 1);
    }

    public void removeStavkaRezervacije(int row) {
        stavkeRezervacije.remove(row);
        fireTableDataChanged();
    }

    public Double getUkupanIznos() {
        double ukupanIznos = 0.0;
        for (StavkaRezervacije stavkaRezervacije : stavkeRezervacije) {
            ukupanIznos += stavkaRezervacije.getIznos();
        }
        return ukupanIznos;
    }

    public StavkaRezervacije getStavkaRezervacijeAt(int row) {
        return stavkeRezervacije.get(row);
    }
    

    public List<StavkaRezervacije> getStavkeRezervacije() {
        return stavkeRezervacije;
    }
    
    public void updateStavkaRezervacije(int row, StavkaRezervacije sr){
        stavkeRezervacije.set(row, sr);
        fireTableRowsUpdated(row, row);
    }

}
