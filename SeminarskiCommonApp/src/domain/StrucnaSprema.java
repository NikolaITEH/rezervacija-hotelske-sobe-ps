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
public class StrucnaSprema implements GenericEntity{
    
    private Long idStrucnaSprema;
    private String naziv;
    private String stepen;
    private String institucija;

    public StrucnaSprema() {
    }

    public StrucnaSprema(Long idStrucnaSprema, String naziv, String stepen, String institucija) {
        this.idStrucnaSprema = idStrucnaSprema;
        this.naziv = naziv;
        this.stepen = stepen;
        this.institucija = institucija;
    }

   
    public Long getIdStrucnaSprema() {
        return idStrucnaSprema;
    }

    public void setIdStrucnaSprema(Long idStrucnaSprema) {
        this.idStrucnaSprema = idStrucnaSprema;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getStepen() {
        return stepen;
    }

    public void setStepen(String stepen) {
        this.stepen = stepen;
    }

    public String getInstitucija() {
        return institucija;
    }

    public void setInstitucija(String institucija) {
        this.institucija = institucija;
    }

    @Override
    public String toString() {
        return "StrucnaSprema{" + "idStrucnaSprema=" + idStrucnaSprema + ", naziv=" + naziv + ", stepen=" + stepen + ", institucija=" + institucija + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.idStrucnaSprema);
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
        final StrucnaSprema other = (StrucnaSprema) obj;
        return Objects.equals(this.idStrucnaSprema, other.idStrucnaSprema);
    }

    @Override
    public Long getId() {
        return idStrucnaSprema;
    }

    @Override
    public void setId(Long id) {
        this.idStrucnaSprema=id;
    }

    @Override
    public String getTableName() {
        return "strucnasprema";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "naziv,stepen,institucija";
    }

    @Override
    public String getInsertValues() {
        return "'" + naziv + "','" + stepen + "','" + institucija + "'";
    }

    @Override
    public String getAttributeValues() {
        return "naziv='" + naziv + "',stepen='" + stepen + "',institucija='" + institucija + "'";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT idStrucnaSprema, naziv, stepen, institucija FROM strucnasprema";
    }

    @Override
    public String getIdCondition() {
        return "idStrucnaSprema=" + getId();
    }

    @Override
    public GenericEntity fromResultSet(ResultSet rs) throws SQLException {
        StrucnaSprema s = new StrucnaSprema();
        s.setId(rs.getLong("idStrucnaSprema"));
        s.setNaziv(rs.getString("naziv"));
        s.setStepen(rs.getString("stepen"));
        s.setInstitucija(rs.getString("institucija"));
        return s;
    }
    
}
