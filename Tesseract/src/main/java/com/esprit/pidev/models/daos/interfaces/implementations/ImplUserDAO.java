/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IUserDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.enums.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BoB
 */
public class ImplUserDAO implements IUserDAO {
     private Connection connection;
     private String role;

    public ImplUserDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public String authenticateUser(String userName, String Pwd) {
        String query = "select role from utilisateur where pseudo='"+ userName +"' and mdp='"+ Pwd +"'";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
            role=resultat.getString(1);
            
            
        }
         return role;   
        } 
        catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }
    }
    
}
