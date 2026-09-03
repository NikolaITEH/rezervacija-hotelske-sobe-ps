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
public class AddStrucnaSpremaSO extends AbstractSO {

    private StrucnaSprema strucnaSprema;
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof StrucnaSprema)) {
            throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        StrucnaSprema s = (StrucnaSprema) param;
        if (s.getNaziv() == null && s.getStepen() == null && s.getInstitucija() == null) {
            s.setNaziv("");
            s.setStepen("");
            s.setInstitucija("");
        }
        strucnaSprema = (StrucnaSprema) repository.add(s);
    }
    
    public StrucnaSprema getStrucnaSprema(){
        return strucnaSprema;
    }
    
}
