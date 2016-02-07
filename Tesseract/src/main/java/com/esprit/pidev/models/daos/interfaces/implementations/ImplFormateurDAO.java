package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IFormateurDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Formateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImplFormateurDAO implements IFormateurDAO {

    private Connection connection;

    private static final String ATTRIBUT_PARTAGE = "nom,prenom,age,email,identifiant,photo,login,password";
    private static final String ROLE = "Formateur";

    @Override
    public boolean createFormateur(Formateur formateur) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "insert into users (nom,prenom,age,email,identifiant,photo,login,password,score,stage,cv,post) values(?,?,?,?,?,?,?,?,?,?,?,'Formateur')";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ************SetString to our request************
         */
        preparedStatement.setString(1, formateur.getNomUtilistaur());
        preparedStatement.setString(2, formateur.getPrenomUtilisteur());
        preparedStatement.setInt(3, formateur.getAgeUtilisateur());
        preparedStatement.setString(4, formateur.getEmailUtilisateur());
        preparedStatement.setString(5, formateur.getIdentifiantUtilisateur());
        preparedStatement.setString(6, formateur.getPhotoUtilisateur());
        preparedStatement.setString(7, formateur.getLoginUtilisateur());
        preparedStatement.setString(8, formateur.getPasswordUtilisateur());
        preparedStatement.setInt(9, formateur.getScoreFormateur());
        preparedStatement.setInt(10, formateur.getStageFormateur());
        preparedStatement.setString(11, formateur.getCurriculumVitaeFormateur());
        /**
         * ********************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);

    }

    @Override
    public boolean supprimerFormateur(Formateur formateur) throws SQLException {

        connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ? and login like ? and post like 'Formateur'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ***************************
         */
        preparedStatement.setString(1, formateur.getIdentifiantUtilisateur());
        preparedStatement.setString(2, formateur.getLoginUtilisateur());
        /**
         * ************************
         */

        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public boolean supprimerFormateurByIdentifiant(String Identifiant) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ? and post like 'Formateur'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ***************************
         */
        preparedStatement.setString(1, Identifiant);

        /**
         * ************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public boolean modifierFormateurByIdentifiant(String Identifiant, Formateur newFormateur) throws SQLException {

        connection = DataSource.getInstance().getConnection();

        final String requete = "update users set nom=?,prenom=?,age=?,email=?,photo=?,login=?,password=?,stage=?,score=?, cv=? where identifiant like ? and post like 'Formateur'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * *****************************************
         */
        preparedStatement.setString(1, newFormateur.getNomUtilistaur());
        preparedStatement.setString(2, newFormateur.getPrenomUtilisteur());
        preparedStatement.setInt(3, newFormateur.getAgeUtilisateur());
        preparedStatement.setString(4, newFormateur.getEmailUtilisateur());
        preparedStatement.setString(5, newFormateur.getPhotoUtilisateur());
        preparedStatement.setString(6, newFormateur.getLoginUtilisateur());
        preparedStatement.setString(7, newFormateur.getPasswordUtilisateur());
        preparedStatement.setInt(8, newFormateur.getStageFormateur());
        preparedStatement.setInt(9, newFormateur.getScoreFormateur());
        preparedStatement.setString(10, newFormateur.getCurriculumVitaeFormateur());
        preparedStatement.setString(11, Identifiant);

        /**
         * ***************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public List<Formateur> afficherFormateurs() throws SQLException {
        List<Formateur> listFormateur = new ArrayList<>();
        Formateur formateur = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from users where post like 'Formateur'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
        while (resultSet.next()) {
            formateur = new Formateur();
            /**
             * ****************************************
             */
            formateur.setNomUtilistaur(resultSet.getString("nom"));
            formateur.setPrenomUtilisteur(resultSet.getString("prenom"));
            formateur.setAgeUtilisateur(resultSet.getInt("age"));
            formateur.setEmailUtilisateur(resultSet.getString("email"));
            formateur.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            formateur.setPhotoUtilisateur(resultSet.getString("photo"));
            formateur.setLoginUtilisateur(resultSet.getString("login"));
            formateur.setPasswordUtilisateur(resultSet.getString("password"));
            formateur.setStageFormateur(resultSet.getInt("stage"));
            formateur.setScoreFormateur(resultSet.getInt("score"));
            formateur.setCurriculumVitaeFormateur(resultSet.getString("cv"));

            /**
             * ******************************************
             */
            listFormateur.add(formateur);
        }
        if (Objects.nonNull(listFormateur)) {
            return listFormateur;
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public Formateur getFormateurByIdentifiant(String identifiant) throws SQLException {
        Formateur formateur = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from users where identifiant like ? and post like 'Formateur'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, identifiant);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            formateur = new Formateur();
            /**
             * ****************************************
             */
            formateur.setNomUtilistaur(resultSet.getString("nom"));
            formateur.setPrenomUtilisteur(resultSet.getString("prenom"));
            formateur.setAgeUtilisateur(resultSet.getInt("age"));
            formateur.setEmailUtilisateur(resultSet.getString("email"));
            formateur.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            formateur.setPhotoUtilisateur(resultSet.getString("photo"));
            formateur.setLoginUtilisateur(resultSet.getString("login"));
            formateur.setPasswordUtilisateur(resultSet.getString("password"));
            formateur.setStageFormateur(resultSet.getInt("stage"));
            formateur.setScoreFormateur(resultSet.getInt("score"));
            formateur.setCurriculumVitaeFormateur(resultSet.getString("cv"));
            /**
             * ******************************************
             */
        }
        if (Objects.nonNull(formateur)) {
            return formateur;
        }

        throw new UnsupportedOperationException();
    }

}
