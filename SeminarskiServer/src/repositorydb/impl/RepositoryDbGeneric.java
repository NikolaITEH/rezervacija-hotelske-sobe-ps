/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorydb.impl;

import domain.GenericEntity;
import java.util.List;
import repositorydb.DbRepository;
import java.sql.*;
import java.util.ArrayList;
import repositorydb.DbConnectionFactory;

/**
 *
 * @author Nikola
 */
public class RepositoryDbGeneric implements DbRepository<GenericEntity>{

    @Override
    public GenericEntity add(GenericEntity t) throws Exception {
        Connection connection=DbConnectionFactory.getInstance().getConnection();
        String query="INSERT INTO " + t.getTableName() + " (" + t.getColumnNamesForInsert() + ")" + " VALUES (" + t.getInsertValues() + ")";
        Statement statement=connection.createStatement();
        statement.executeUpdate(query, statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys=statement.getGeneratedKeys();
        if(generatedKeys.next()){
            t.setId(generatedKeys.getLong(1));
        }
        generatedKeys.close();
        statement.close();
        return t;
    }

    @Override
    public void edit(GenericEntity t) throws Exception {
        Connection connection=DbConnectionFactory.getInstance().getConnection();
        String query="UPDATE " + t.getTableName() + " SET " + t.getAttributeValues() + " WHERE " + t.getIdCondition();
        Statement statement=connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    @Override
    public void delete(GenericEntity t) throws Exception {
        Connection connection=DbConnectionFactory.getInstance().getConnection();
        String query="DELETE FROM " + t.getTableName() + " WHERE " + t.getIdCondition();
        Statement statement=connection.createStatement();
        statement.executeUpdate(query);
        statement.close();        
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity t) throws Exception {
        Connection connection=DbConnectionFactory.getInstance().getConnection();
        List<GenericEntity> result=new ArrayList<>();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(t.getSelectAllQuery());
        while(rs.next()){
            result.add(t.fromResultSet(rs));
        }
        rs.close();
        statement.close();
        return result;
    }

    @Override
    public List<GenericEntity> getList(GenericEntity t, String query) throws Exception {
        List<GenericEntity> list=new ArrayList<>();
        Connection connection=DbConnectionFactory.getInstance().getConnection();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(t.getSelectAllQuery() + query);
        while(rs.next()){
            list.add(t.fromResultSet(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public GenericEntity get(GenericEntity t, String query) throws Exception {
         Connection connection=DbConnectionFactory.getInstance().getConnection();
         Statement statement=connection.createStatement();
         ResultSet rs=statement.executeQuery(t.getSelectAllQuery() + query);
         GenericEntity entity=null;
         if(rs.next()){
             entity=t.fromResultSet(rs);
         }
         rs.close();
         statement.close();
         return entity;
    }
    
}
