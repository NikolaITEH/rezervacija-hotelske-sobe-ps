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
public class DeleteGostSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        if(!(param instanceof Gost)){
            throw new Exception("Pogresan parametar");
        }
        Gost g=(Gost) param;
        if(g.getId()==null){
            throw new Exception("Gost mora biti prethodno pronadjen");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete(param);
    }
    
}
