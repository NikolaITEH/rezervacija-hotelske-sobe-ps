/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.gost;

import domain.Gost;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetGostSO extends AbstractSO {

    
    private Gost gost;
    
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Gost)) {
            throw new Exception("Pogresan parametar");
        }
        Gost g = (Gost) param;
        if (g.getId() == null) {
            throw new Exception("Gost mora imati id");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        gost=(Gost) param;
        gost=(Gost) repository.get(gost, " WHERE g.idGost=" + gost.getId());
        if(gost==null){
            throw new Exception("Gost ne postoji");
        }
    }

    public Gost getGost(){
        return gost;
    }
    
}
