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
public class EditGostSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Gost)) {
            throw new Exception("Pogresan parametar");
        }
        Gost g = (Gost) param;
        if (g.getId() == null) {
            throw new Exception("Gost mora prethodno biti kreiran");
        }
        if (g.getIme() == null || g.getIme().trim().isEmpty()) {
            throw new Exception("Ime je obavezno");
        }
        if (g.getPrezime() == null || g.getPrezime().trim().isEmpty()) {
            throw new Exception("Prezime je obavezno");
        }
        if (g.getBroj() == null || g.getBroj().trim().length() <= 7 || g.getBroj().trim().length() >= 15) {
            throw new Exception("Broj telefona mora imati izmedju 8 i 14 karaktera");
        }
        if (g.getEmail() == null || !g.getEmail().trim().contains("@")) {
            throw new Exception("Email nije ispravnog formata");
        }
        if (g.getDrzava() == null) {
            throw new Exception("Drzava je obavezna");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Gost g=(Gost) param;
        repository.edit(g);
    }

}
