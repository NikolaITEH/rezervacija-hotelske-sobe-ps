/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nikola
 */
public class ReSS implements GenericEntity{
    
    private Date datumSticanja;
    private Recepcioner recepcioner;
    private StrucnaSprema strucnaSprema;

    public ReSS() {
    }

    public ReSS(Date datumSticanja, Recepcioner recepcioner, StrucnaSprema strucnaSprema) {
        this.datumSticanja = datumSticanja;
        this.recepcioner = recepcioner;
        this.strucnaSprema = strucnaSprema;
    }

    public Date getDatumSticanja() {
        return datumSticanja;
    }

    public void setDatumSticanja(Date datumSticanja) {
        this.datumSticanja = datumSticanja;
    }

    public Recepcioner getRecepcioner() {
        return recepcioner;
    }

    public void setRecepcioner(Recepcioner recepcioner) {
        this.recepcioner = recepcioner;
    }

    public StrucnaSprema getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    @Override
    public String toString() {
        return "ReSS{" + "datumSticanja=" + datumSticanja + ", recepcioner=" + recepcioner + ", strucnaSprema=" + strucnaSprema + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.recepcioner);
        hash = 29 * hash + Objects.hashCode(this.strucnaSprema);
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
        final ReSS other = (ReSS) obj;
        if (!Objects.equals(this.recepcioner, other.recepcioner)) {
            return false;
        }
        return Objects.equals(this.strucnaSprema, other.strucnaSprema);
    }

    @Override
    public Long getId() {
        return 0L; //samo da se zadovolji metoda iz GenericEntity-ja
    }

    @Override
    public void setId(Long id) {
        
    }

    @Override
    public String getTableName() {
        return "ress";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "idRecepcioner,idStrucnaSprema,datumSticanja";
    }

    @Override
    public String getInsertValues() {
        return recepcioner.getId() + "," + strucnaSprema.getId() + ",'" + new java.sql.Date(datumSticanja.getTime()) + "'";
    }

    @Override
    public String getAttributeValues() {
        return "datumSticanja='" + new java.sql.Date(datumSticanja.getTime()) + "'";
    }
    
    @Override
    public String getSelectAllQuery() {
        return "SELECT r.idRecepcioner, r.ime, r.prezime, r.broj, r.email, r.korisnickoIme, r.sifra, s.idStrucnaSprema, s.naziv, s.stepen, s.institucija, rs.datumSticanja "
                + "FROM ress rs JOIN recepcioner r ON rs.idRecepcioner=r.idRecepcioner JOIN strucnasprema s ON rs.idStrucnaSprema=s.idStrucnaSprema";
    }

    @Override
    public String getIdCondition() {
        return "idRecepcioner=" + recepcioner.getId() + " AND idStrucnaSprema=" + strucnaSprema.getId();
    }

    @Override
    public GenericEntity fromResultSet(ResultSet rs) throws SQLException {
        Recepcioner r=new Recepcioner();
        r.setId(rs.getLong("idRecepcioner"));
        r.setIme(rs.getString("ime"));
        r.setPrezime(rs.getString("prezime"));
        r.setBroj(rs.getString("broj"));
        r.setEmail(rs.getString("email"));
        r.setKorisnickoIme(rs.getString("korisnickoIme"));
        r.setSifra(rs.getString("sifra"));
        
        StrucnaSprema s=new StrucnaSprema();
        s.setId(rs.getLong("idStrucnaSprema"));
        s.setNaziv(rs.getString("naziv"));
        s.setStepen(rs.getString("stepen"));
        s.setInstitucija(rs.getString("institucija"));
   
        return new ReSS(rs.getDate("datumSticanja"), r, s);
    }

}
