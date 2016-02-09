/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IChallengeDAO;
import com.esprit.pidev.models.daos.interfaces.IEvenementDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Evenement;
import com.esprit.pidev.models.entities.Organisation;
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
public class ImplEvenementDAO implements IEvenementDAO{
    private Connection connection;

    public ImplEvenementDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    

    @Override
    public boolean addEvenement(Evenement evn) {
        String query = "Insert into evenement(`id_evenement`, `id_organisation`, `nom`, `description` , `nbr_max` , `affiche` , `date_evenement`) "
                + "values (NULL, ?, ?, ?, ? ,? ,?,?);";
        try {
            PreparedStatement pSt = connection.prepareStatement(query);
            pSt.setInt(1, evn.getIdEvenement());
            pSt.setInt(2, evn.getIdOrganisation());
            pSt.setString(3, evn.getNom());
            pSt.setString(4, evn.getDescription());
            pSt.setInt(5, evn.getNbrMax());
            pSt.setString(6, evn.getAffiche());
            pSt.setDate(7, (Date) evn.getDateEvenement());
            pSt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("error to add evenement !!");
            return false;
        }
    }

    @Override
    public boolean deleteEvenement(int idEvn) {
                String query="delete from evenement where id_evenement =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idEvn);
            ps.executeUpdate();
            System.out.println("evenement supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEvenement(Evenement evn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evenement> displayEvenement() {
        ArrayList<Evenement> liste = new ArrayList<Evenement>();
        
        String query = "select * from Organisation";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(query);

            while (resultat.next()) {
                Evenement evn = new Evenement();                
                evn.setIdEvenement(resultat.getInt(1));
                evn.setIdOrganisation(resultat.getInt(2));
                evn.setNom(resultat.getString(3));
                evn.setDescription(resultat.getString(4));
                evn.setNbrMax(resultat.getInt(5));
                evn.setAffiche(resultat.getString(6));
                evn.setDateEvenement(resultat.getDate(7));

                liste.add(evn);
            }
            return liste;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Logs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Evenement> displayChallengeByEvenement(int idEvn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evenement getEvenementByid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evenement getEvenementByNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
