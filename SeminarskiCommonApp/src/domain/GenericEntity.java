/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Nikola
 */
public interface GenericEntity extends Serializable{
    
    Long getId();
    
    void setId(Long id);
    
    String getTableName();
    
    String getColumnNamesForInsert();
    
    String getInsertValues();
    
    String getAttributeValues();
 
    String getSelectAllQuery();
    
    String getIdCondition();
    
    GenericEntity fromResultSet(ResultSet rs) throws SQLException;
    
}
