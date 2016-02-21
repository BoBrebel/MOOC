/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IUserDAO;
import com.esprit.pidev.models.database.DataSource;
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

    public ImplUserDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public boolean authenticateUser(String userName, String Pwd) {
        String query = "select * from utilisateur where pseudo='"+ userName +"' and mdp='"+ Pwd +"'";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultat = ps.executeQuery(); 
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du log " + ex.getMessage());
            return false;
        }
    }
    
}
