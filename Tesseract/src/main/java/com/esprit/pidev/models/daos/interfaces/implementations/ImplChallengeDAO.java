/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IChallengeDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Challenge;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haikal
 */
public class ImplChallengeDAO implements IChallengeDAO{
    private Connection connection;

    public ImplChallengeDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    

    @Override
    public boolean addChallenge(Challenge chl) {
        String query = "Insert into challenge(`id_challenge`, `id_organisation`, `nom`, `description` , `theme` , `date_challenge`) "
                + "values (NULL, ?, ?, ?, ? ,? , ?);";
        try {
            PreparedStatement pSt = connection.prepareStatement(query);
            pSt.setInt(1, chl.getIdChallenge());
            pSt.setInt(2, chl.getIdOrganisation());
            pSt.setString(3, chl.getNom());
            pSt.setString(4, chl.getDescription());
            pSt.setString(5, chl.getTheme());
            pSt.setDate(6, (Date) chl.getDateChallenge());
            pSt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("error to add a challenge !!");
            return false;
        }
    }

    @Override
    public boolean deleteChallenge(int idChl) {
                String query="delete from challenge where id_challenge =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idChl);
            ps.executeUpdate();
            System.out.println("challenge supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateChallenge(Challenge chl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Challenge> displayChallenge() {
        ArrayList<Challenge> liste = new ArrayList<Challenge>();
        
        String query = "select * from challenge";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(query);

            while (resultat.next()) {
                Challenge ch = new Challenge();                
                ch.setIdChallenge(resultat.getInt(1));
                ch.setIdOrganisation(resultat.getInt(2));
                ch.setNom(resultat.getString(3));
                ch.setDescription(resultat.getString(4));
                ch.setTheme(resultat.getString(5));
                ch.setDateChallenge(resultat.getDate(6));

                liste.add(ch);
            }
            return liste;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Logs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Challenge> displayChallengeByOrganisation(int idChl) {
        ArrayList<Challenge> liste = new ArrayList<Challenge>();
        
        String query = "select * from challenge where id_organisation=?";
        
        try {
            PreparedStatement pSt = connection.prepareStatement(query);
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(query);

            while (resultat.next()) {
                Challenge ch = new Challenge();                
                ch.setIdChallenge(resultat.getInt(1));
                ch.setIdOrganisation(resultat.getInt(2));
                ch.setNom(resultat.getString(3));
                ch.setDescription(resultat.getString(4));
                ch.setTheme(resultat.getString(5));
                ch.setDateChallenge(resultat.getDate(6));

                liste.add(ch);
            }
            return liste;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Logs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Challenge getChallengeByid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Challenge getChallengeByNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
