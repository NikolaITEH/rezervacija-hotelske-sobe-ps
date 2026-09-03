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
public class DeleteRezervacijaSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        if(!(param instanceof Rezervacija)){
            throw new Exception("Pogresan parametar");
        }
        Rezervacija r=(Rezervacija) param;
        if(r.getId()==null){
            throw new Exception("Rezervacija mora biti prethodno pronadjena");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Rezervacija r=(Rezervacija) param;        
        List<StavkaRezervacije> dbStavke = repository.getList(new StavkaRezervacije(), " WHERE sr.idRezervacija=" + r.getId());
        
        for (StavkaRezervacije stavkaRezervacije : dbStavke) {
            repository.delete(stavkaRezervacije);
        }
        
        repository.delete(r);
        
    }
    
    
}
