/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import communication.Operations;
import communication.Request;
import communication.Response;
import domain.Drzava;
import domain.Gost;
import domain.Recepcioner;
import domain.Rezervacija;
import domain.Soba;
import domain.StrucnaSprema;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;

    private Recepcioner ulogovanRecepcioner;

    private Controller() { //posto se koristi instanca, nema potrebe da se iz bilo koje klase moze pristupiti konstruktoru
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Recepcioner getUlogovanRecepcioner() {
        return ulogovanRecepcioner;
    }

    public void setUlogovanRecepcioner(Recepcioner ulogovanRecepcioner) {
        this.ulogovanRecepcioner = ulogovanRecepcioner;
    }

    public Recepcioner prijaviRecepcioner(String korisnickoIme, String sifra) throws Exception {
        Recepcioner r = new Recepcioner();
        r.setKorisnickoIme(korisnickoIme);
        r.setSifra(sifra);

        Request request = new Request(r, Operations.LOGIN);
        Response response = Communication.getInstance().sendRequest(request);

        if (response.getException() != null) {
            throw response.getException();
        }

        return (Recepcioner) response.getResult();

    }

    public List<Drzava> vratiListuSvihDrzava() throws Exception {
        Request request = new Request(null, Operations.GET_ALL_DRZAVA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Drzava>) response.getResult();
    }

    public Gost kreirajGost(Gost gost) throws Exception {
        Request request = new Request(gost, Operations.ADD_GOST);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Gost) response.getResult();
    }

    public void promeniGost(Gost gost) throws Exception {
        Request request = new Request(gost, Operations.EDIT_GOST);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Gost> vratiListuGost(Gost gost) throws Exception {
        Request request = new Request(gost, Operations.GET_GOST_LIST_BY_GOST);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Gost>) response.getResult();
    }

    public List<Gost> vratiListuGost(Drzava drzava) throws Exception {
        Request request = new Request(drzava, Operations.GET_GOST_LIST_BY_DRZAVA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Gost>) response.getResult();
    }

    public Gost pretraziGost(Gost gost) throws Exception {
        Request request = new Request(gost, Operations.GET_GOST);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Gost) response.getResult();
    }

    public void obrisiGost(Gost gost) throws Exception {
        Request request = new Request(gost, Operations.DELETE_GOST);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public StrucnaSprema ubaciStrucnaSprema(StrucnaSprema s) throws Exception {
        Request request = new Request(s, Operations.ADD_STRUCNA_SPREMA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (StrucnaSprema) response.getResult();
    }

    public void promeniStrucnaSprema(StrucnaSprema s) throws Exception {
        Request request = new Request(s, Operations.EDIT_STRUCNA_SPREMA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<StrucnaSprema> vratiListuSvihStrucnihSprema() throws Exception {
        Request request = new Request(null, Operations.GET_ALL_STRUCNA_SPREMA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<StrucnaSprema>) response.getResult();
    }

    public List<Recepcioner> vratiListuSvihRecepcionera() throws Exception {
        Request request = new Request(null, Operations.GET_ALL_RECEPCIONER);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Recepcioner>) response.getResult();
    }

    public List<Gost> vratiListuSvihGostiju() throws Exception {
        Request request = new Request(null, Operations.GET_ALL_GOST);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Gost>) response.getResult();
    }

    public List<Soba> vratiListuSvihSoba() throws Exception {
        Request request = new Request(null, Operations.GET_ALL_SOBA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Soba>) response.getResult();
    }

    public Rezervacija kreirajRezervacija(Rezervacija rezervacija) throws Exception {
        Request request = new Request(rezervacija, Operations.ADD_REZERVACIJA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Rezervacija) response.getResult();
    }

    public void promeniRezervacija(Rezervacija rezervacija) throws Exception {
        Request request = new Request(rezervacija, Operations.EDIT_REZERVACIJA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public Rezervacija vratiRezervaciju(Rezervacija rezervacija) throws Exception {
        Request request = new Request(rezervacija, Operations.GET_REZERVACIJA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Rezervacija) response.getResult();
    }

    public void obrisiRezervacija(Rezervacija rezervacija) throws Exception {
        Request request = new Request(rezervacija, Operations.DELETE_REZERVACIJA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Rezervacija> vratiListuRezervacija(Rezervacija rezervacija) throws Exception {
        Request request = new Request(rezervacija, Operations.GET_REZERVACIJA_LIST_BY_REZERVACIJA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Rezervacija>) response.getResult();
    }

    public List<Rezervacija> vratiListuRezervacija(Gost gost) throws Exception {
        Request request = new Request(gost, Operations.GET_REZERVACIJA_LIST_BY_GOST);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Rezervacija>) response.getResult();
    }

    public List<Rezervacija> vratiListuRezervacija(Recepcioner recepcioner) throws Exception {
        Request request = new Request(recepcioner, Operations.GET_REZERVACIJA_LIST_BY_RECEPCIONER);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Rezervacija>) response.getResult();
    }

    public List<Rezervacija> vratiListuRezervacija(Soba soba) throws Exception {
        Request request = new Request(soba, Operations.GET_REZERVACIJA_LIST_BY_SOBA);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Rezervacija>) response.getResult();
    }

    public void logout() throws Exception {
        Request request = new Request(ulogovanRecepcioner, Operations.LOGOUT);
        Response response = Communication.getInstance().sendRequest(request);
        if (response.getException() != null) {
            throw response.getException();
        }
        ulogovanRecepcioner = null;
    }

}
