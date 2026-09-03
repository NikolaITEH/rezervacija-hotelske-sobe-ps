/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.strucnasprema;

import domain.StrucnaSprema;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class EditStrucnaSpremaSO extends AbstractSO {
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof StrucnaSprema)) {
            throw new Exception("Pogresan parametar");
        }
        StrucnaSprema s = (StrucnaSprema) param;
        if (s.getId() == null) {
            throw new Exception("Strucna sprema mora prethodno biti kreirana");
        }
        if (s.getNaziv() == null || s.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv je obavezan");
        }
        if (s.getStepen() == null || s.getStepen().trim().isEmpty() || s.getStepen().trim().length() >= 7) {
            throw new Exception("Stepen mora imati manje od 7 karaktera");
        }
        if (s.getInstitucija() == null || s.getInstitucija().trim().isEmpty()) {
            throw new Exception("Institucija je obavezna");
        }
    }
    
    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit(param);
    }
    
}
