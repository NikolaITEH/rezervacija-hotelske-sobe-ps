/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class StavkaRezervacije implements GenericEntity{
    
    private int rb;
    private int brojDana;
    private double iznos;
    private int brojGostiju;
    private Date datumPocetka;
    private Date datumIsteka;
    private double iznosPoGostu;
    private Soba soba;
    private Rezervacija rezervacija;

    public StavkaRezervacije() {
    }

    public StavkaRezervacije(int rb, int brojDana, double iznos, int brojGostiju, Date datumPocetka, Date datumIsteka, double iznosPoGostu, Soba soba, Rezervacija rezervacija) {
        this.rb = rb;
        this.brojDana = brojDana;
        this.iznos = iznos;
        this.brojGostiju = brojGostiju;
        this.datumPocetka = datumPocetka;
        this.datumIsteka = datumIsteka;
        this.iznosPoGostu = iznosPoGostu;
        this.soba = soba;
        this.rezervacija = rezervacija;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public int getBrojGostiju() {
        return brojGostiju;
    }

    public void setBrojGostiju(int brojGostiju) {
        this.brojGostiju = brojGostiju;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public double getIznosPoGostu() {
        return iznosPoGostu;
    }

    public void setIznosPoGostu(double iznosPoGostu) {
        this.iznosPoGostu = iznosPoGostu;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    public String toString() {
        return "StavkaRezervacije{" + "rb=" + rb + ", brojDana=" + brojDana + ", iznos=" + iznos + ", brojGostiju=" + brojGostiju + ", datumPocetka=" + datumPocetka + ", datumIsteka=" + datumIsteka + ", iznosPoGostu=" + iznosPoGostu + ", soba=" + soba + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.rb);
        hash = 79 * hash + Objects.hashCode(rezervacija.getId());
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
        final StavkaRezervacije other = (StavkaRezervacije) obj;
        if (!Objects.equals(this.rb, other.rb)) {
            return false;
        }
        return Objects.equals(this.rezervacija, other.rezervacija);
    }


    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public void setId(Long id) {
        
    }

    @Override
    public String getTableName() {
        return "stavkarezervacije";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "rb,brojDana,iznos,brojGostiju,datumPocetka,datumIsteka,iznosPoGostu,idSoba,idRezervacija";
    }

    @Override
    public String getInsertValues() {
        return rb + "," + brojDana + "," + iznos + "," + brojGostiju + ",'" + new java.sql.Date(datumPocetka.getTime()) + "','" 
                + new java.sql.Date(datumIsteka.getTime()) + "'," + iznosPoGostu + "," + soba.getId() + "," +rezervacija.getId();
    }

    @Override
    public String getAttributeValues() {
        return "brojDana=" + brojDana + ",iznos=" + iznos + ",brojGostiju=" + brojGostiju + ",datumPocetka='" + new java.sql.Date(datumPocetka.getTime()) 
                + "',datumIsteka='" + new java.sql.Date(datumIsteka.getTime()) + "',iznosPoGostu=" + iznosPoGostu + ",idSoba=" + soba.getId();
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT sr.idRezervacija, sr.rb, sr.brojDana, sr.iznos, sr.brojGostiju, sr.datumPocetka, sr.datumIsteka, sr.iznosPoGostu, "
                + "s.idSoba, s.broj, s.brojKreveta, s.sprat, s.balkon, s.cenaPoDanu "
                + "FROM stavkarezervacije sr INNER JOIN soba s ON sr.idSoba = s.idSoba";
    }

    @Override
    public String getIdCondition() {
        return "idRezervacija=" + rezervacija.getId() + " AND rb=" + rb;
    }

    @Override
    public GenericEntity fromResultSet(ResultSet rs) throws SQLException {
        Soba s = new Soba();
        s.setId(rs.getLong("idSoba"));
        s.setBroj(rs.getString("broj"));
        s.setBrojKreveta(rs.getInt("brojKreveta"));
        s.setSprat(rs.getInt("sprat"));
        s.setBalkon(rs.getBoolean("balkon"));
        s.setCenaPoDanu(rs.getDouble("cenaPoDanu"));

        Rezervacija r = new Rezervacija();
        r.setId(rs.getLong("idRezervacija"));

        StavkaRezervacije sr = new StavkaRezervacije();
        sr.setRb(rs.getInt("rb"));
        sr.setBrojDana(rs.getInt("brojDana"));
        sr.setIznos(rs.getDouble("iznos"));
        sr.setBrojGostiju(rs.getInt("brojGostiju"));
        sr.setDatumPocetka(rs.getDate("datumPocetka"));
        sr.setDatumIsteka(rs.getDate("datumIsteka"));
        sr.setIznosPoGostu(rs.getDouble("iznosPoGostu"));
        sr.setSoba(s);
        sr.setRezervacija(r);
                
        return sr;
    }
 
}
