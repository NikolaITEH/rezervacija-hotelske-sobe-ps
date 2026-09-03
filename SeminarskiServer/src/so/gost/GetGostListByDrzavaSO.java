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
public class GetGostListByDrzavaSO extends AbstractSO {

    private List<Gost> gosti;

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Drzava)) {
            throw new Exception("Pogresan parametar");
        }
        Drzava d = (Drzava) param;
        if (d.getNaziv() != null && !(d.getNaziv().trim().isEmpty()) && d.getNaziv().trim().length() <= 1) {
            throw new Exception("Naziv drzave mora imati vise od 2 karaktera");
        }
        if (d.getSkraceniNaziv() != null && !(d.getSkraceniNaziv().trim().isEmpty()) && (d.getSkraceniNaziv().trim().length() < 2 || d.getSkraceniNaziv().trim().length() > 3)) {
            throw new Exception("Skraceni naziv mora imati izmedju 2 i 3 karaktera");
        }
        if (d.getPozivniBroj() != null && !(d.getPozivniBroj().trim().isEmpty()) && !d.getPozivniBroj().startsWith("+")) {
            throw new Exception("Pozivni broj mora poceti sa '+'");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Drzava d = (Drzava) param;
        StringBuilder query = new StringBuilder();
        boolean first = true;

        if (d.getNaziv() != null && !d.getNaziv().trim().isEmpty()) {
            query.append(" WHERE d.naziv='").append(d.getNaziv().trim()).append("'");
            first = false;
        }
        if (d.getSkraceniNaziv() != null && !d.getSkraceniNaziv().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ").append("d.skraceniNaziv='").append(d.getSkraceniNaziv().trim()).append("'");
            first = false;
        }
        if (d.getKontinent() != null && !d.getKontinent().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ").append("d.kontinent='").append(d.getKontinent().trim()).append("'");
            first = false;
        }
        if (d.getPozivniBroj() != null && !d.getPozivniBroj().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ").append("d.pozivniBroj='").append(d.getPozivniBroj().trim()).append("'");
        }
        
        gosti=repository.getList(new Gost(), query.toString());
    }
    
    public List<Gost> getGosti(){
        return gosti;
    }

}
