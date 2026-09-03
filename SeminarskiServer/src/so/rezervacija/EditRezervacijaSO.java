/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import domain.Rezervacija;
import domain.StavkaRezervacije;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class EditRezervacijaSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Rezervacija)) {
            throw new Exception("Pogresan parametar");
        }
        Rezervacija r = (Rezervacija) param;
        if (r.getId() == null) {
            throw new Exception("Rezervacija mora prethodno biti kreirana");
        }
        if (r.getGost() == null || r.getGost().getId() == null) {
            throw new Exception("Morate izabrati gosta");
        }
        if (r.getNacinPlacanja() == null || r.getNacinPlacanja().trim().isEmpty()) {
            throw new Exception("Nacin placanja je obavezan");
        }
        if (r.getNacinRezervisanja() == null || r.getNacinRezervisanja().trim().isEmpty()) {
            throw new Exception("Nacin rezervisanja je obavezan");
        }
        if (r.getStavke() == null || r.getStavke().isEmpty()) {
            throw new Exception("Rezervacija mora imati bar jednu stavku");
        }

        for (StavkaRezervacije sr : r.getStavke()) {
            if (sr.getSoba() == null || sr.getSoba().getId() == null) {
                throw new Exception("Svaka stavka mora imati izabranu sobu");
            }
            if (sr.getBrojDana() <= 0) {
                throw new Exception("Broj dana mora biti veci od 0");
            }
            if (sr.getDatumPocetka() == null) {
                throw new Exception("Datum pocetka je obavezan");
            }
            if (sr.getIznos() <= 0.0) {
                throw new Exception("Iznos mora biti veci od 0");
            }
            if (sr.getDatumIsteka() == null) {
                throw new Exception("Datum isteka je obavezan");
            }
            if (sr.getIznosPoGostu() <= 0.0) {
                throw new Exception("Iznos po gostu mora biti veci od 0");
            }
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Rezervacija r = (Rezervacija) param;

        repository.edit(r);

        List<StavkaRezervacije> dbStavke = repository.getList(new StavkaRezervacije(), " WHERE sr.idRezervacija=" + r.getId() + " ORDER BY sr.rb ASC");
        for (StavkaRezervacije stavkaRezervacije : dbStavke) {
            System.out.println("Iz baze: " + stavkaRezervacije);
        }

        List<StavkaRezervacije> rStavke = r.getStavke();
        for (StavkaRezervacije stavkaRezervacije : rStavke) {
            System.out.println("Iz klijenta " + stavkaRezervacije);
        }

        int rbStavke;
        if (dbStavke.isEmpty()) {
            rbStavke = 1;
        } else {
            rbStavke = dbStavke.get(dbStavke.size() - 1).getRb() + 1;
        }

        List<StavkaRezervacije> toEdit = new ArrayList<>();
        List<StavkaRezervacije> toDelete = new ArrayList<>(dbStavke);
        List<StavkaRezervacije> toAdd = new ArrayList<>(rStavke);

        for (StavkaRezervacije dbStavka : dbStavke) {
            for (StavkaRezervacije rStavka : rStavke) {
                if (dbStavka.equals(rStavka)) {
                    toEdit.add(rStavka);
                    toDelete.remove(dbStavka);
                    toAdd.remove(rStavka);
                    break;
                }
            }
        }

        for (StavkaRezervacije sEdit : toEdit) {
            System.out.println("To edit: " + sEdit);
            repository.edit(sEdit);
        }

        for (StavkaRezervacije sDelete : toDelete) {
            System.out.println("To delete: " + sDelete);
            repository.delete(sDelete);
        }

        for (StavkaRezervacije sAdd : toAdd) {
            sAdd.setRb(rbStavke++);
            System.out.println("To add: " + sAdd);
            repository.add(sAdd);
        }

        /*

        //     if (!dbStavke.isEmpty()) {
        for (StavkaRezervacije dbStavka : dbStavke) {
            System.out.println("For db: " + dbStavka);
            for (StavkaRezervacije rStavka : rStavke) {
                System.out.println("For r: " + rStavka);
                if (dbStavka.equals(rStavka)) {
                    rbStavke++;
                    repository.edit(rStavka);
                    rStavke.remove(rStavka);
                    dbStavke.remove(dbStavka);
                }
            }
            repository.delete(dbStavka);
            dbStavke.remove(dbStavka);
        }
        //  }

        for (StavkaRezervacije stavkaRezervacije : rStavke) {
            stavkaRezervacije.setRb(rbStavke);
            rbStavke++;
            repository.add(stavkaRezervacije);
        }

    
         */
    }
}
