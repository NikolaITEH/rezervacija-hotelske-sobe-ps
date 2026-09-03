/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import domain.Rezervacija;
import domain.Soba;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetRezervacijaListBySobaSO extends AbstractSO {

    private List<Rezervacija> rezervacije;

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Soba)) {
            throw new Exception("Pogresan parametar");
        }
        Soba s = (Soba) param;
        if (s.getBroj() != null && !(s.getBroj().trim().isEmpty()) && s.getBroj().trim().length() <= 0) {
            throw new Exception("Broj sobe mora imati 1 ili vise karaktera");
        }
        if (s.getBrojKreveta() != 0 && (s.getBrojKreveta() < 1 || s.getBrojKreveta() > 9)) {
            throw new Exception("Broj kreveta mora biti izmedju 1 i 9");
        }
        /*if (s.getSprat() < 0) {
            throw new Exception("Broj sprata mora biti veci ili jednak 0");
        }*/
        if (s.getCenaPoDanu() < 0.0) {
            throw new Exception("Cena mora biti veca od 0");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Soba s = (Soba) param;
        StringBuilder query = new StringBuilder();
        boolean first = true;

        query.append("SELECT sr.idRezervacija FROM stavkarezervacije sr INNER JOIN soba sob ON sr.idSoba=sob.idSoba");

        if (s.getBroj() != null && !s.getBroj().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ").append("sob.broj='").append(s.getBroj().trim()).append("'");
            first = false;
        }
        if (s.getBrojKreveta() > 0) {
            query.append(first ? " WHERE " : " AND ").append("sob.brojKreveta=").append(s.getBrojKreveta());
            first = false;
        }
        if (s.getCenaPoDanu() > 0.0) {
            query.append(first ? " WHERE " : " AND ").append("sob.cenaPoDanu=").append(s.getCenaPoDanu());
            first = false;
        }
        if (s.getSprat() >= 0) {
            query.append(first ? " WHERE " : " AND ").append("sob.sprat=").append(s.getSprat());
            first = false;
        }
        
        query.append(first ? " WHERE " : " AND " ).append("sob.balkon=").append(s.isBalkon() ? 1 : 0);
        
        rezervacije=repository.getList(new Rezervacija(), " WHERE rez.idRezervacija IN (" + query.toString()+ ")");

        System.out.println(query.toString());
        
    }

    public List<Rezervacija> getRezervacije(){
        return rezervacije;
    }
    
}
