/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import domain.Recepcioner;
import domain.Rezervacija;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class GetRezervacijaListByRecepcionerSO extends AbstractSO {

    private List<Rezervacija> rezervacije;

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Recepcioner)) {
            throw new Exception("Pogresan parametar");
        }
        Recepcioner r = (Recepcioner) param;
        if (r.getBroj() != null && !(r.getBroj().trim().isEmpty()) && (r.getBroj().trim().length() < 8 || r.getBroj().trim().length() > 14)) {
            throw new Exception("Broj telefona mora imati izmedju 8 i 14 karaktera");
        }
        if (r.getEmail() != null && !(r.getEmail().trim().isEmpty()) && !r.getEmail().contains("@")) {
            throw new Exception("Email nije ispravnog formata");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Recepcioner r = (Recepcioner) param;
        StringBuilder query = new StringBuilder();
        boolean first = true;

        if (r.getIme() != null && !r.getIme().trim().isEmpty()) {
            query.append(" WHERE ");
            query.append("r.ime='").append(r.getIme().trim()).append("'");
            first = false;
        }

        if (r.getPrezime() != null && !r.getPrezime().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("r.prezime='").append(r.getPrezime().trim()).append("'");
            first = false;
        }

        if (r.getBroj() != null && !r.getBroj().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("r.broj='").append(r.getBroj().trim()).append("'");
            first = false;
        }

        if (r.getEmail() != null && !r.getEmail().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("r.email='").append(r.getEmail().trim()).append("'");
            first = false;
        }

        if (r.getKorisnickoIme() != null && !r.getKorisnickoIme().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("r.korisnickoIme='").append(r.getKorisnickoIme().trim()).append("'");
            first = false;
        }
        
        rezervacije=repository.getList(new Rezervacija(), query.toString());
        
    }
    
    public List<Rezervacija> getRezervacije(){
        return rezervacije;
    }

}
