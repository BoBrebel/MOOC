/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.ISessionEpreuveDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.SessionEpreuve;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BoB
 */
public class ImplSessionEpreuveDAO implements ISessionEpreuveDAO{
    
    private Connection connection;

    public ImplSessionEpreuveDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public boolean ajouterSessionEpreuve(SessionEpreuve sessionEpreuve) {
        String query = "Insert into session_epreuve(`id_utilisateur`, `id_epreuve`,`note`,`nbr_tentative`,`date_session`) "
                + "values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement pSt = connection.prepareStatement(query);
            pSt.setInt(1, sessionEpreuve.getId_utilisateur());
            pSt.setInt(2, sessionEpreuve.getId_epreuve());
            pSt.setFloat(3, sessionEpreuve.getNote());
            pSt.setInt(4, sessionEpreuve.getNbr_tentative());
            pSt.setDate(5, (Date) sessionEpreuve.getDate_Session());
            pSt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("SessionEpreuve non ajouté");
            return false;
        }
    }

    @Override
    public boolean modifierSessionEpreuve(SessionEpreuve sessionEpreuve) {
        String requete = "update session_epreuve set note=?, nbr_tentative=?, date_session=? where id_utilisateur=? and id_epreuve=?,";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setFloat(1, sessionEpreuve.getNote());
            ps.setInt(2, sessionEpreuve.getNbr_tentative());
            ps.setDate(3, (Date) sessionEpreuve.getDate_Session());
            ps.setInt(4, sessionEpreuve.getId_utilisateur());
            ps.setInt(5, sessionEpreuve.getId_epreuve());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            //System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<SessionEpreuve> getSessionEpreuvebyUserid(int idUser) {
         ArrayList<SessionEpreuve> listeSessionEpreuve = new ArrayList<SessionEpreuve>();
        String query = "select * from session_epreuve where id_utilisateur=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idUser);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                SessionEpreuve sessionEpreuve = new SessionEpreuve();
                sessionEpreuve.setId_utilisateur(resultat.getInt(1));
                sessionEpreuve.setId_epreuve(resultat.getInt(2));
                sessionEpreuve.setNote(resultat.getFloat(3));
                sessionEpreuve.setNbr_tentative(resultat.getInt(4));
                sessionEpreuve.setDate_Session(resultat.getDate(5));
                listeSessionEpreuve.add(sessionEpreuve);
            }
            return listeSessionEpreuve;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du log " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<SessionEpreuve> getSessionEpreuvebyidEpreuve(int idEpreuve) {
        ArrayList<SessionEpreuve> listeSessionEpreuve = new ArrayList<SessionEpreuve>();
        String query = "select * from session_cours where id_epreuve=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idEpreuve);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                SessionEpreuve sessionEpreuve = new SessionEpreuve();
                sessionEpreuve.setId_utilisateur(resultat.getInt(1));
                sessionEpreuve.setId_epreuve(resultat.getInt(2));
                sessionEpreuve.setNote(resultat.getFloat(3));
                sessionEpreuve.setNbr_tentative(resultat.getInt(4));
                sessionEpreuve.setDate_Session(resultat.getDate(5));
                listeSessionEpreuve.add(sessionEpreuve);
            }
            return listeSessionEpreuve;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du log " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<SessionEpreuve> getSessoEpreuvebynote(float note) {
        ArrayList<SessionEpreuve> listeSessionEpreuve = new ArrayList<SessionEpreuve>();
        String query = "select * from session_cours where note>?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, note);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                SessionEpreuve sessionEpreuve = new SessionEpreuve();
                sessionEpreuve.setId_utilisateur(resultat.getInt(1));
                sessionEpreuve.setId_epreuve(resultat.getInt(2));
                sessionEpreuve.setNote(resultat.getFloat(3));
                sessionEpreuve.setNbr_tentative(resultat.getInt(4));
                sessionEpreuve.setDate_Session(resultat.getDate(5));
                listeSessionEpreuve.add(sessionEpreuve);
            }
            return listeSessionEpreuve;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du log " + ex.getMessage());
            return null;
        }
    }
    
}
