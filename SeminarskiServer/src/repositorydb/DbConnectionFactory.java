/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorydb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikola
 */
public class DbConnectionFactory {
    
    private Connection connection;
    private static DbConnectionFactory instance;

    public DbConnectionFactory() {
    }

    public static DbConnectionFactory getInstance() {
        if(instance==null){
            instance=new DbConnectionFactory();
        }
        return instance;
    }
    
    
    public Connection getConnection() throws Exception{
        if(connection==null || connection.isClosed()){
            try {
                Properties properties=new Properties();
                properties.load(new FileInputStream("config/dbconfig.properties"));
                String url=properties.getProperty("url");
                String username=properties.getProperty("username");
                String password=properties.getProperty("password");
                connection=DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
                System.out.println("Konekcija uspesno uspostavljena!");
            } catch (Exception ex) {
                System.out.println("Neuspesno uspostavljanje konekcije! " + ex.getMessage());
                throw ex;
            }
            
        }
        
        return connection;
    }
    
    
    
}
