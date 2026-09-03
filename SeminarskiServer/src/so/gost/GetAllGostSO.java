/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.gost;

import domain.Gost;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetAllGostSO extends AbstractSO{

    private List<Gost> gosti;

    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        gosti = repository.getAll(new Gost());
    }

    public List<Gost> getGosti() {
        return gosti;
    }

}
