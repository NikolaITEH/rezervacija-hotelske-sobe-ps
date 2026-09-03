/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recepcioner;

import domain.Recepcioner;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetAllRecepcionerSO extends AbstractSO {

    private List<Recepcioner> recepcioneri;

    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        recepcioneri = repository.getAll(new Recepcioner());
    }

    public List<Recepcioner> getRecepcioneri() {
        return recepcioneri;
    }
}
