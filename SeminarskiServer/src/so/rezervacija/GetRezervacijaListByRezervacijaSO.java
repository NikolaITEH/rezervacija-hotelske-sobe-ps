/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import domain.Rezervacija;
import java.sql.Date;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetRezervacijaListByRezervacijaSO extends AbstractSO {

    private List<Rezervacija> rezervacije;

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Rezervacija)) {
            throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {

        Rezervacija r = (Rezervacija) param;
        StringBuilder query = new StringBuilder();
        boolean first = true;

        if (r.getDatum() != null) {
            query.append(" WHERE ");
            query.append("rez.datum='").append(new Date(r.getDatum().getTime())).append("'");
            first = false;
        }

        if (r.getUkupanIznos() > 0.0) {
            query.append(first ? " WHERE " : " AND ");
            query.append("rez.ukupanIznos=").append(r.getUkupanIznos());
            first = false;
        }

        if (r.getNacinPlacanja() != null && !r.getNacinPlacanja().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("rez.nacinPlacanja='").append(r.getNacinPlacanja().trim()).append("'");
            first = false;
        }

        if (r.getNacinRezervisanja() != null && !r.getNacinRezervisanja().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("rez.nacinRezervisanja='").append(r.getNacinRezervisanja().trim()).append("'");
            first = false;
        }

        if (r.getRecepcioner() != null) {
            query.append(first ? " WHERE " : " AND ");
            query.append("rez.idRecepcioner=").append(String.valueOf(r.getRecepcioner().getId()));
            first = false;
        }

        if (r.getGost() != null) {
            query.append(first ? " WHERE " : " AND ");
            query.append("rez.idGost=").append(String.valueOf(r.getGost().getId()));
            first = false;
        }
        
        rezervacije=repository.getList(new Rezervacija(), query.toString());
        
        System.out.println(query.toString());
        for (Rezervacija rezervacija : rezervacije) {
            System.out.println(rezervacija);
        }
        
    }

    public List<Rezervacija> getRezervacije(){
        return rezervacije;
    }
    
}
