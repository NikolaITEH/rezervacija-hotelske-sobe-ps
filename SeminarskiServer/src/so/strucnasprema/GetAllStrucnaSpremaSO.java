/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.strucnasprema;

import domain.StrucnaSprema;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetAllStrucnaSpremaSO extends AbstractSO {

    private List<StrucnaSprema> strucneSpreme;

    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        strucneSpreme = repository.getAll(new StrucnaSprema());
    }

    public List<StrucnaSprema> getStrucneSpreme() {
        return strucneSpreme;
    }

}
