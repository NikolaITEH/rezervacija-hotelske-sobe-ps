/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class Gost implements GenericEntity{
    
    private Long idGost;
    private String ime;
    private String prezime;
    private String broj;
    private String email;
    private Drzava drzava;

    public Gost() {
    }

    public Gost(String ime, String prezime, String broj, String email, Drzava drzava) {
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
        this.email = email;
        this.drzava = drzava;
    }
    
    public Long getIdGost() {
        return idGost;
    }

    public void setIdGost(Long idGost) {
        this.idGost = idGost;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + broj + " " + email + " " + drzava;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idGost);
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
        final Gost other = (Gost) obj;
        return Objects.equals(this.idGost, other.idGost);
    }

    @Override
    public Long getId() {
        return idGost;
    }

    @Override
    public void setId(Long id) {
        this.idGost=id;
    }

    @Override
    public String getTableName() {
        return "gost";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime,prezime,broj,email,idDrzava";
    }

    @Override
    public String getInsertValues() {
        return "'" + ime + "','" + prezime + "','" + broj + "','" + email + "'," + drzava.getId();
    }

    @Override
    public String getAttributeValues() {
        return "ime='" + ime + "'," + "prezime='" + prezime + "'," + "broj='" + broj + "'," + "email='" + email + "'," + "idDrzava=" + drzava.getId();
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT g.idGost, g.ime, g.prezime, g.broj, g.email, d.idDrzava, d.naziv, d.skraceniNaziv, d.kontinent, d.pozivniBroj FROM gost g INNER JOIN drzava d ON g.idDrzava=d.idDrzava";
    }

    @Override
    public String getIdCondition() {
        return "idGost=" + getId();
    }

    @Override
    public GenericEntity fromResultSet(ResultSet rs) throws SQLException {
        Drzava d=new Drzava();
        d.setId(rs.getLong("idDrzava"));
        d.setNaziv(rs.getString("naziv"));
        d.setSkraceniNaziv(rs.getString("skraceniNaziv"));
        d.setKontinent(rs.getString("kontinent"));
        d.setPozivniBroj(rs.getString("pozivniBroj"));
        
        Gost g=new Gost();
        g.setId(rs.getLong("idGost"));
        g.setIme(rs.getString("ime"));
        g.setPrezime(rs.getString("prezime"));
        g.setBroj(rs.getString("broj"));
        g.setEmail(rs.getString("email"));
        g.setDrzava(d);
        
        return g;
    }
 
}
