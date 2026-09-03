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
public class GetGostListByGostSO extends AbstractSO {

    private List<Gost> gosti;

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Gost)) {
            throw new Exception("Pogresan parametar");
        }
        Gost g=(Gost) param;
        if (g.getBroj() != null && !(g.getBroj().trim().isEmpty()) && (g.getBroj().trim().length() < 8 || g.getBroj().trim().length() > 14)) {
            throw new Exception("Broj telefona mora imati izmedju 8 i 14 karaktera");
        }
        if (g.getEmail() != null && !(g.getEmail().trim().isEmpty()) && !g.getEmail().contains("@")) {
            throw new Exception("Email nije ispravnog formata");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Gost g = (Gost) param;
        StringBuilder query = new StringBuilder();
        boolean first = true;

        if (g.getIme() != null && !g.getIme().trim().isEmpty()) {
            query.append(" WHERE ");
            query.append("g.ime='").append(g.getIme().trim()).append("'");
            first = false;
        }

        if (g.getPrezime() != null && !g.getPrezime().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("g.prezime='").append(g.getPrezime().trim()).append("'");
            first = false;
        }

        if (g.getBroj() != null && !g.getBroj().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("g.broj='").append(g.getBroj().trim()).append("'");
            first = false;
        }

        if (g.getEmail() != null && !g.getEmail().trim().isEmpty()) {
            query.append(first ? " WHERE " : " AND ");
            query.append("g.email='").append(g.getEmail().trim()).append("'");
            first = false;
        }

        if (g.getDrzava() != null) {
            query.append(first ? " WHERE " : " AND ");
            query.append("d.idDrzava=").append(String.valueOf(g.getDrzava().getId()));
            first = false;
        }

        gosti = repository.getList(g, query.toString());

    }

    public List<Gost> getGosti() {
        return gosti;
    }

}
