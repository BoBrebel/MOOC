/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IFormateurDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Apprenant;
import com.esprit.pidev.models.entities.Formateur;
import com.esprit.pidev.models.enums.Etat;
import com.esprit.pidev.models.enums.Role;
import java.sql.Connection;
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
public class ImplFormateurDAO implements IFormateurDAO {

    @Override
    public boolean ajouterFormateur(Formateur formateur, Integer idOrganisme) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();

        String requete = "insert into utilisateur (id_organisation,pseudo,mdp,nom,prenom,date_naissance,telephone,adresse,mail,photo,role,cv,etat) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(requete);
        ps.setInt(1, idOrganisme);
        ps.setString(2, formateur.getNomUtilisateur());
        ps.setString(3, formateur.getMotDePass());
        ps.setString(4, formateur.getNom());
        ps.setString(5, formateur.getPrenom());
        ps.setDate(6, formateur.getDateNaissance());
        ps.setInt(7, formateur.getTel());
        ps.setString(8, formateur.getAdresse());

        ps.setString(9, formateur.getMail());
        ps.setString(10, formateur.getPhoto());
        ps.setString(11, String.valueOf(Role.FOR));

        ps.setString(12, formateur.getCv());
        ps.setString(13, String.valueOf(Etat.ATT));
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;
    }

    @Override
    public Formateur getFormateurByLogin(String login) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        String requete = "select * from utilisateur where pseudo like ?";
        PreparedStatement ps = connection.prepareCall(requete);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        Formateur formateur = new Formateur();
        while (rs.next()) {

            formateur.setIdUtilisateur(rs.getInt(1));
            formateur.setNomUtilisateur(rs.getString(3));
            formateur.setMotDePass(rs.getString(4));
            formateur.setNom(rs.getString(5));
            formateur.setPrenom(rs.getString(6));
            formateur.setDateNaissance(rs.getDate(7));
            formateur.setTel(rs.getInt(8));
            formateur.setAdresse(rs.getString(9));
            formateur.setMail(rs.getString(10));
            formateur.setPhoto(rs.getString(11));
            formateur.setCv(rs.getString(14));
            formateur.setEtat(Etat.valueOf(rs.getString(15)));

        }
        ps.close();
        return formateur;
    }

    @Override
    public boolean supprimerFormateurByLogin(String login) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        String requete = "delete from utilisateur where pseudo like ?";
        PreparedStatement ps = connection.prepareCall(requete);
        ps.setString(1, login);
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;
    }

    @Override
    public List<Formateur> getAllFormateurs() throws SQLException {

        List<Formateur> list = new ArrayList<>();
        Connection connection = DataSource.getInstance().getConnection();
        String requete = "select * from utilisateur";
        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(requete);
        Formateur formateur = new Formateur();
        while (rs.next()) {

            formateur.setIdUtilisateur(rs.getInt(1));
            formateur.setNomUtilisateur(rs.getString(3));
            formateur.setMotDePass(rs.getString(4));
            formateur.setNom(rs.getString(5));
            formateur.setPrenom(rs.getString(6));
            formateur.setDateNaissance(rs.getDate(7));
            formateur.setTel(rs.getInt(8));
            formateur.setAdresse(rs.getString(9));
            formateur.setMail(rs.getString(10));
            formateur.setPhoto(rs.getString(11));
            formateur.setCv(rs.getString(14));
            formateur.setEtat(Etat.valueOf(rs.getString(15)));
            list.add(formateur);
        }
        ps.close();
        return list;
    }

    @Override
    public boolean modifierFormateur(String login, Formateur newFormateur) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();

        String requete = "update utilisateur set pseudo=?,mdp=?,nom=?,prenom=?,date_naissance=?,telephone=?,adresse=?,mail=?,photo=?,role=?,cv=?,etat=? where pseudo like ?";
        PreparedStatement ps = connection.prepareStatement(requete);
        ps.setString(1, newFormateur.getNomUtilisateur());
        ps.setString(2, newFormateur.getMotDePass());
        ps.setString(3, newFormateur.getNom());
        ps.setString(4, newFormateur.getPrenom());
        ps.setDate(5, newFormateur.getDateNaissance());
        ps.setInt(6, newFormateur.getTel());
        ps.setString(7, newFormateur.getAdresse());
        ps.setString(8, String.valueOf(Role.FOR));
        ps.setString(9, newFormateur.getMail());
        ps.setString(10, newFormateur.getPhoto());
        ps.setString(11, newFormateur.getCv());
        ps.setString(12, newFormateur.getEtat().name());
        ps.setString(13, login);
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;
    }

}
