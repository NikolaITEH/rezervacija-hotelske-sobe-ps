/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Drzava;
import domain.Gost;
import domain.Recepcioner;
import domain.Rezervacija;
import domain.Soba;
import domain.StrucnaSprema;
import java.util.List;
import so.drzava.GetAllDrzavaSO;
import so.gost.AddGostSO;
import so.gost.DeleteGostSO;
import so.gost.EditGostSO;
import so.gost.GetAllGostSO;
import so.gost.GetGostListByDrzavaSO;
import so.gost.GetGostListByGostSO;
import so.gost.GetGostSO;
import so.recepcioner.GetAllRecepcionerSO;
import so.recepcioner.LoginRecepcionerSO;
import so.rezervacija.AddRezervacijaSO;
import so.rezervacija.DeleteRezervacijaSO;
import so.rezervacija.EditRezervacijaSO;
import so.rezervacija.GetRezervacijaListByGostSO;
import so.rezervacija.GetRezervacijaListByRecepcionerSO;
import so.rezervacija.GetRezervacijaListByRezervacijaSO;
import so.rezervacija.GetRezervacijaListBySobaSO;
import so.rezervacija.GetRezervacijaSO;
import so.soba.GetAllSobaSO;
import so.strucnasprema.AddStrucnaSpremaSO;
import so.strucnasprema.EditStrucnaSpremaSO;
import so.strucnasprema.GetAllStrucnaSpremaSO;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Recepcioner login(Recepcioner recepcioner) throws Exception {
        LoginRecepcionerSO so = new LoginRecepcionerSO();
        so.execute(recepcioner);
        return so.getRecepcioner();
    }

    public List<Drzava> getAllDrzava() throws Exception {
        GetAllDrzavaSO so = new GetAllDrzavaSO();
        so.execute(null);
        return so.getDrzave();
    }

    public Gost addGost(Gost gost) throws Exception {
        AddGostSO so = new AddGostSO();
        so.execute(gost);
        return so.getGost();
    }

    public void editGost(Gost gost) throws Exception {
        EditGostSO so = new EditGostSO();
        so.execute(gost);
    }

    public List<Gost> getGostListByGost(Gost gost) throws Exception {
        GetGostListByGostSO so = new GetGostListByGostSO();
        so.execute(gost);
        return so.getGosti();
    }

    public List<Gost> getGostListByDrzava(Drzava drzava) throws Exception {
        GetGostListByDrzavaSO so = new GetGostListByDrzavaSO();
        so.execute(drzava);
        return so.getGosti();
    }

    public Gost getGost(Gost gost) throws Exception {
        GetGostSO so = new GetGostSO();
        so.execute(gost);
        return so.getGost();
    }

    public void deleteGost(Gost gost) throws Exception {
        DeleteGostSO so = new DeleteGostSO();
        so.execute(gost);
    }

    public StrucnaSprema addStrucnaSprema(StrucnaSprema s) throws Exception {
        AddStrucnaSpremaSO so = new AddStrucnaSpremaSO();
        so.execute(s);
        return so.getStrucnaSprema();
    }

    public void editStrucnaSprema(StrucnaSprema s) throws Exception {
        EditStrucnaSpremaSO so = new EditStrucnaSpremaSO();
        so.execute(s);
    }

    public List<StrucnaSprema> getAllStrucnaSprema() throws Exception {
        GetAllStrucnaSpremaSO so = new GetAllStrucnaSpremaSO();
        so.execute(null);
        return so.getStrucneSpreme();
    }

    public List<Recepcioner> getAllRecepcioner() throws Exception {
        GetAllRecepcionerSO so = new GetAllRecepcionerSO();
        so.execute(null);
        return so.getRecepcioneri();
    }

    public List<Gost> getAllGost() throws Exception {
        GetAllGostSO so = new GetAllGostSO();
        so.execute(null);
        return so.getGosti();
    }

    public List<Soba> getAllSoba() throws Exception {
        GetAllSobaSO so = new GetAllSobaSO();
        so.execute(null);
        return so.getSobe();
    }

    public Rezervacija addRezervacija(Rezervacija rezervacija) throws Exception {
        AddRezervacijaSO so = new AddRezervacijaSO();
        so.execute(rezervacija);
        return so.getRezervacija();
    }

    public void editRezervacija(Rezervacija rezervacija) throws Exception {
        EditRezervacijaSO so = new EditRezervacijaSO();
        so.execute(rezervacija);
    }

    public Rezervacija getRezervacija(Rezervacija rezervacija) throws Exception {
        GetRezervacijaSO so = new GetRezervacijaSO();
        so.execute(rezervacija);
        return so.getRezervacija();
    }

    public void deleteRezervacija(Rezervacija rezervacija) throws Exception {
        DeleteRezervacijaSO so = new DeleteRezervacijaSO();
        so.execute(rezervacija);
    }

    public List<Rezervacija> getRezervacijaListByRezervacija(Rezervacija rezervacija) throws Exception {
        GetRezervacijaListByRezervacijaSO so = new GetRezervacijaListByRezervacijaSO();
        so.execute(rezervacija);
        return so.getRezervacije();
    }

    public List<Rezervacija> getRezervacijaListByGost(Gost gost) throws Exception {
        GetRezervacijaListByGostSO so=new GetRezervacijaListByGostSO();
        so.execute(gost);
        return so.getRezervacije();
    }
    
    public List<Rezervacija> getRezervacijaListByRecepcioner(Recepcioner recepcioner) throws Exception{
        GetRezervacijaListByRecepcionerSO so=new GetRezervacijaListByRecepcionerSO();
        so.execute(recepcioner);
        return so.getRezervacije();
    }
    
    public List<Rezervacija> getRezervacijaListBySoba(Soba soba) throws Exception{
        GetRezervacijaListBySobaSO so=new GetRezervacijaListBySobaSO();
        so.execute(soba);
        return so.getRezervacije();
    }

}
