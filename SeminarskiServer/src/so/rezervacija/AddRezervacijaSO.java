/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import domain.Gost;
import domain.Rezervacija;
import java.util.Date;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class AddRezervacijaSO extends AbstractSO {

    private Rezervacija rezervacija;
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Rezervacija)) {
            throw new Exception("Pogresan parametar");
        }
        Rezervacija r = (Rezervacija) param;
        if (r.getRecepcioner() == null || r.getRecepcioner().getId() == null) {
            throw new Exception("Rezervaciju mora kreirati prijavljeni recepcioner");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Rezervacija r = (Rezervacija) param;
        
        if (r.getDatum() == null && r.getUkupanIznos() == 0.0 && r.getNacinPlacanja() == null && r.getNacinRezervisanja() == null && r.getGost() == null) {

            List<Gost> gosti = repository.getAll(new Gost());
            if (gosti.isEmpty()) {
                throw new Exception("Ne postoji nijedan gost u bazi, rezervacija se ne moze kreirati");
            }
            r.setGost(gosti.get(0));
            r.setDatum(new Date());
            r.setNacinPlacanja("");
            r.setNacinRezervisanja("");
            
            rezervacija=(Rezervacija) repository.add(r);
        }
    }
    
    public Rezervacija getRezervacija(){
        return rezervacija;
    }

}
