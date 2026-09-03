/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import domain.Rezervacija;
import domain.StavkaRezervacije;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetRezervacijaSO extends AbstractSO {

    private Rezervacija rezervacija;

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Rezervacija)) {
            throw new Exception("Pogresan parametar");
        }
        Rezervacija r = (Rezervacija) param;
        if (r.getId() == null) {
            throw new Exception("Rezervacija mora imati id");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        rezervacija = (Rezervacija) param;
        List<StavkaRezervacije> stavkeRezervacije = repository.getList(new StavkaRezervacije(), " WHERE sr.idRezervacija=" + rezervacija.getId() + " ORDER BY sr.rb ASC");
        rezervacija=(Rezervacija) repository.get(rezervacija, " WHERE rez.idRezervacija=" + rezervacija.getId());
        if(rezervacija==null){
            throw new Exception("Rezervacija ne postoji");
        }
        rezervacija.setStavke(stavkeRezervacije);
    }
    
    public Rezervacija getRezervacija(){
        return rezervacija;
    }

}
