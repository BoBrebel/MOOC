/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bacem
 */
public class DataSource {
    
    private Connection connection;
    private String url;
    private String login;
    private String password;
    private Properties properties;
    private static DataSource instance;

    private DataSource() {
        properties = new Properties();
        try {
            //properties.load(new FileInputStream(new File("config.properties")));
            url ="jdbc:mysql://localhost:3306/tesseract"; //properties.getProperty("url");
            login ="root"; //properties.getProperty("login");
            password = "";//properties.getProperty("password");
            connection = DriverManager.getConnection(url,login,password);
//        } catch (IOException ex) {
//            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DataSource getInstance(){
        if (instance==null){
            instance=new DataSource();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    
}
