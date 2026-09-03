/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.soba;

import domain.Gost;
import domain.Soba;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetAllSobaSO extends AbstractSO{

    private List<Soba> sobe;

    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        sobe = repository.getAll(new Soba());
    }

    public List<Soba> getSobe() {
        return sobe;
    }
    
    
}
