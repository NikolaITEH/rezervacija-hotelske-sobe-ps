/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class Rezervacija implements GenericEntity{
    
    private Long idRezervacija;
    private Date datum;
    private double ukupanIznos;
    private String nacinPlacanja;
    private String nacinRezervisanja;
    private Gost gost;
    private Recepcioner recepcioner;
    private List<StavkaRezervacije> stavke = new ArrayList<>();

    public Rezervacija() {
    }

    public Rezervacija(Date datum, double ukupanIznos, String nacinPlacanja, String nacinRezervisanja, Gost gost, Recepcioner recepcioner) {
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.nacinPlacanja = nacinPlacanja;
        this.nacinRezervisanja = nacinRezervisanja;
        this.gost = gost;
        this.recepcioner = recepcioner;
    }

    public Long getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(Long idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public String getNacinRezervisanja() {
        return nacinRezervisanja;
    }

    public void setNacinRezervisanja(String nacinRezervisanja) {
        this.nacinRezervisanja = nacinRezervisanja;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public Recepcioner getRecepcioner() {
        return recepcioner;
    }

    public void setRecepcioner(Recepcioner recepcioner) {
        this.recepcioner = recepcioner;
    }

    public List<StavkaRezervacije> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRezervacije> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "idRezervacija=" + idRezervacija + ", datum=" + datum + ", ukupanIznos=" + ukupanIznos + ", nacinPlacanja=" + nacinPlacanja + ", nacinRezervisanja=" + nacinRezervisanja + ", gost=" + gost + ", recepcioner=" + recepcioner + ", stavke=" + stavke + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idRezervacija);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rezervacija other = (Rezervacija) obj;
        return Objects.equals(this.idRezervacija, other.idRezervacija);
    }

    @Override
    public Long getId() {
        return idRezervacija;
    }

    @Override
    public void setId(Long id) {
        this.idRezervacija=id;
    }

    @Override
    public String getTableName() {
        return "rezervacija";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "datum,ukupanIznos,nacinPlacanja,nacinRezervisanja,idGost,idRecepcioner";
    }

    @Override
    public String getInsertValues() {
        return "'" + new java.sql.Date(datum.getTime()) + "'," + ukupanIznos + ",'" + nacinPlacanja + "','" + nacinRezervisanja + "'," + gost.getId() + "," + recepcioner.getId();

    }

    @Override
    public String getAttributeValues() {
        return "datum='" + new java.sql.Date(datum.getTime()) + "',ukupanIznos=" + ukupanIznos + ",nacinPlacanja='" + nacinPlacanja + "',nacinRezervisanja='" 
                + nacinRezervisanja + "',idGost=" + gost.getId() + ",idRecepcioner=" + recepcioner.getId() ;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT rez.idRezervacija, rez.datum, rez.ukupanIznos, rez.nacinPlacanja, rez.nacinRezervisanja, r.idRecepcioner, r.ime AS recIme, r.prezime AS recPrezime, r.broj AS recBroj, "
                + "r.email AS recEmail, r.korisnickoIme, r.sifra, g.idGost, g.ime AS gostIme, g.prezime AS gostPrezime, g.broj AS gostBroj, g.email AS gostEmail, "
                + "d.idDrzava, d.naziv, d.skraceniNaziv, d.kontinent, d.pozivniBroj FROM rezervacija rez INNER JOIN recepcioner r ON rez.idRecepcioner = r.idRecepcioner "
                + "INNER JOIN gost g ON rez.idGost = g.idGost INNER JOIN drzava d ON g.idDrzava = d.idDrzava";
    }

    @Override
    public String getIdCondition() {
        return "idRezervacija=" + getId();
    }

    @Override
    public GenericEntity fromResultSet(ResultSet rs) throws SQLException {
        Drzava d = new Drzava();
        d.setId(rs.getLong("idDrzava"));
        d.setNaziv(rs.getString("naziv"));
        d.setSkraceniNaziv(rs.getString("skraceniNaziv"));
        d.setKontinent(rs.getString("kontinent"));
        d.setPozivniBroj(rs.getString("pozivniBroj"));

        Gost g = new Gost();
        g.setId(rs.getLong("idGost"));
        g.setIme(rs.getString("gostIme"));
        g.setPrezime(rs.getString("gostPrezime"));
        g.setBroj(rs.getString("gostBroj"));
        g.setEmail(rs.getString("gostEmail"));
        g.setDrzava(d);

        Recepcioner r = new Recepcioner();
        r.setId(rs.getLong("idRecepcioner"));
        r.setIme(rs.getString("recIme"));
        r.setPrezime(rs.getString("recPrezime"));
        r.setBroj(rs.getString("recBroj"));
        r.setEmail(rs.getString("recEmail"));
        r.setKorisnickoIme(rs.getString("korisnickoIme"));
        r.setSifra(rs.getString("sifra"));

        Rezervacija rez = new Rezervacija();
        rez.setId(rs.getLong("idRezervacija"));
        rez.setDatum(rs.getDate("datum"));
        rez.setUkupanIznos(rs.getDouble("ukupanIznos"));
        rez.setNacinPlacanja(rs.getString("nacinPlacanja"));
        rez.setNacinRezervisanja(rs.getString("nacinRezervisanja"));
        rez.setRecepcioner(r);
        rez.setGost(g);
        return rez;
    }
    
}



    
    
    
    
    
    
    

