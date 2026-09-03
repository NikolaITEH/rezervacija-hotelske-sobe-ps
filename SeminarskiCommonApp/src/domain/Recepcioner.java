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
public class Recepcioner implements GenericEntity{
    
    private Long idRecepcioner;
    private String ime;
    private String prezime;
    private String broj;
    private String email;
    private String korisnickoIme;
    private String sifra;

    public Recepcioner() {
    }

    public Recepcioner(Long idRecepcioner, String ime, String prezime, String broj, String email, String korisnickoIme, String sifra) {
        this.idRecepcioner = idRecepcioner;
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    
    public Long getIdRecepcioner() {
        return idRecepcioner;
    }

    public void setIdRecepcioner(Long idRecepcioner) {
        this.idRecepcioner = idRecepcioner;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idRecepcioner);
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
        final Recepcioner other = (Recepcioner) obj;
        return Objects.equals(this.idRecepcioner, other.idRecepcioner);
    }

    @Override
    public Long getId() {
        return idRecepcioner;
    }

    @Override
    public void setId(Long id) {
        this.idRecepcioner=id;
    }

    @Override
    public String getTableName() {
        return "recepcioner";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime,prezime,broj,email,korisnickoIme,sifra";
    }

    @Override
    public String getInsertValues() {
        return "'" + ime + "','" + prezime + "','" + broj + "','" + email + "','" + korisnickoIme + "','" + sifra + "'";
    }

    @Override
    public String getAttributeValues() {
        return "ime='" + ime + "',prezime='" + prezime + "',broj='" + broj + "',email='" + email + "',korisnickoIme='" + korisnickoIme + "',sifra='" + sifra + "'";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT idRecepcioner, ime, prezime, broj, email, korisnickoIme, sifra FROM recepcioner";
    }

    @Override
    public String getIdCondition() {
        return "idRecepcioner=" + getId();
    }

    @Override
    public GenericEntity fromResultSet(ResultSet rs) throws SQLException {
        Recepcioner r = new Recepcioner();
        r.setId(rs.getLong("idRecepcioner"));
        r.setIme(rs.getString("ime"));
        r.setPrezime(rs.getString("prezime"));
        r.setBroj(rs.getString("broj"));
        r.setEmail(rs.getString("email"));
        r.setKorisnickoIme(rs.getString("korisnickoIme"));
        r.setSifra(rs.getString("sifra"));
        return r;
    }
    
}
