/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.drzava;

import domain.Drzava;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetAllDrzavaSO extends AbstractSO{
    
    private List<Drzava> drzave;

    @Override
    protected void precondition(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        drzave=repository.getAll(new Drzava()); 
    }
    
    public List<Drzava> getDrzave(){
        return drzave;
    }
    
}
