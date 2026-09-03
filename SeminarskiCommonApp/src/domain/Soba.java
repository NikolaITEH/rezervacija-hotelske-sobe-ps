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
public class Soba implements GenericEntity{
    
    private Long idSoba;
    private String broj;
    private int brojKreveta;
    private int sprat;
    private boolean balkon;
    private double cenaPoDanu;

    public Soba() {
    }

    public Soba(Long idSoba, String broj, int brojKreveta, int sprat, boolean balkon, double cenaPoDanu) {
        this.idSoba = idSoba;
        this.broj = broj;
        this.brojKreveta = brojKreveta;
        this.sprat = sprat;
        this.balkon = balkon;
        this.cenaPoDanu = cenaPoDanu;
    }

    
    
    public Long getIdSoba() {
        return idSoba;
    }

    public void setIdSoba(Long idSoba) {
        this.idSoba = idSoba;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public boolean isBalkon() {
        return balkon;
    }

    public void setBalkon(boolean balkon) {
        this.balkon = balkon;
    }

    public double getCenaPoDanu() {
        return cenaPoDanu;
    }

    public void setCenaPoDanu(double cenaPoDanu) {
        this.cenaPoDanu = cenaPoDanu;
    }

    @Override
    public String toString() {
        return broj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idSoba);
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
        final Soba other = (Soba) obj;
        return Objects.equals(this.idSoba, other.idSoba);
    }

    @Override
    public Long getId() {
        return idSoba;
    }

    @Override
    public void setId(Long id) {
        this.idSoba=id;
    }

    @Override
    public String getTableName() {
        return "soba";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "broj,brojKreveta,sprat,balkon,cenaPoDanu";
    }

    @Override
    public String getInsertValues() {
        return "'" + broj +"'," + brojKreveta + "," + sprat + "," + (balkon ? 1 : 0) + "," + cenaPoDanu;
    }

    @Override
    public String getAttributeValues() {
        return "broj='" + broj + "',brojKreveta=" + brojKreveta + ",sprat=" + sprat + ",balkon=" + (balkon ? 1 : 0) + ",cenaPoDanu=" + cenaPoDanu;  
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT idSoba, broj, brojKreveta, sprat, balkon, cenaPoDanu FROM soba";
    }

    @Override
    public String getIdCondition() {
        return "idSoba=" + getId();
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
        return s;
    }
    
}
