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
public class Drzava implements GenericEntity{
    
    private Long idDrzava;
    private String naziv;
    private String skraceniNaziv;
    private String kontinent;
    private String pozivniBroj;

    public Drzava() {
    }

    public Drzava(Long idDrzava, String naziv, String skraceniNaziv, String kontinent, String pozivniBroj) {
        this.idDrzava = idDrzava;
        this.naziv = naziv;
        this.skraceniNaziv = skraceniNaziv;
        this.kontinent = kontinent;
        this.pozivniBroj = pozivniBroj;
    }

    public Long getIdDrzava() {
        return idDrzava;
    }

    public void setIdDrzava(Long idDrzava) {
        this.idDrzava = idDrzava;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkraceniNaziv() {
        return skraceniNaziv;
    }

    public void setSkraceniNaziv(String skraceniNaziv) {
        this.skraceniNaziv = skraceniNaziv;
    }

    public String getKontinent() {
        return kontinent;
    }

    public void setKontinent(String kontinent) {
        this.kontinent = kontinent;
    }

    public String getPozivniBroj() {
        return pozivniBroj;
    }

    public void setPozivniBroj(String pozivniBroj) {
        this.pozivniBroj = pozivniBroj;
    }

    @Override
    public String toString() {
        return naziv + " / " + skraceniNaziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idDrzava);
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
        final Drzava other = (Drzava) obj;
        return Objects.equals(this.idDrzava, other.idDrzava);
    }

    @Override
    public Long getId() {
        return idDrzava;
    }

    @Override
    public void setId(Long id) {
        this.idDrzava=id;
    }

    @Override
    public String getTableName() {
        return "drzava";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "naziv, skraceniNaziv, kontinent, pozivniBroj";
    }

    @Override
    public String getInsertValues() {
        return "'" + naziv + "','" + skraceniNaziv + "','" + kontinent + "','" + pozivniBroj + "'";
    }

    @Override
    public String getAttributeValues() {
                return "naziv='" + naziv + "'," + "skraceniNaziv='" + skraceniNaziv + "'," + "kontinent='" + kontinent + "'," + "pozivniBroj='" + pozivniBroj + "'";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT idDrzava, naziv, skraceniNaziv, kontinent, pozivniBroj FROM drzava ORDER BY idDrzava";
    }

    @Override
    public String getIdCondition() {
        return "idDrzava=" + getId();
    }

    @Override
    public GenericEntity fromResultSet(ResultSet rs) throws SQLException {
        Drzava d=new Drzava();
        d.setId(rs.getLong("idDrzava"));
        d.setNaziv(rs.getString("naziv"));
        d.setSkraceniNaziv(rs.getString("skraceniNaziv"));
        d.setKontinent(rs.getString("kontinent"));
        d.setPozivniBroj(rs.getString("pozivniBroj"));
        return d;
    }
    
    
}
