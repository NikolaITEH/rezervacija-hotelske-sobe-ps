/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.gost;

import domain.Drzava;
import domain.Gost;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class AddGostSO extends AbstractSO {

    private Gost gost;
    
    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Gost)) {
            throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Gost g=(Gost) param;
        
        if(g.getBroj()==null && g.getDrzava()==null && g.getEmail()==null && g.getIme()==null && g.getPrezime()==null){
            g.setBroj("");
            g.setIme("");
            g.setPrezime("");
            g.setEmail("");
            
            List<Drzava> drzave=repository.getAll(new Drzava());
            Drzava prva=drzave.get(0);
            g.setDrzava(prva);
        }
        
        gost=(Gost) repository.add(g);
        
    }

    public Gost getGost(){
        return gost;
    }
    
}
