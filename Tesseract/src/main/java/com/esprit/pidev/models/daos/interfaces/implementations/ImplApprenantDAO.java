package com.esprit.pidev.models.daos.interfaces.implementations;


import com.esprit.pidev.models.daos.interfaces.IApprenantDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Apprenant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplApprenantDAO implements IApprenantDAO {

    private Connection connection;
    
    private static final String ATTRIBUT_PARTAGE = "nom,prenom,age,email,identifiant,photo,login,password";
     private static final String ROLE="Apprenant";

  

    @Override
    public boolean createApprenant(Apprenant apprenant) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "insert into users (nom,prenom,age,email,identifiant,photo,login,password,level,NbBadge,post) values(?,?,?,?,?,?,?,?,?,?,'Apprenant')";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ************SetString to our request************
         */
        preparedStatement.setString(1, apprenant.getNomUtilistaur());
        preparedStatement.setString(2, apprenant.getPrenomUtilisteur());
        preparedStatement.setInt(3, apprenant.getAgeUtilisateur());
        preparedStatement.setString(4, apprenant.getEmailUtilisateur());
        preparedStatement.setString(5, apprenant.getIdentifiantUtilisateur());
        preparedStatement.setString(6, apprenant.getPhotoUtilisateur());
        preparedStatement.setString(7, apprenant.getLoginUtilisateur());
        preparedStatement.setString(8, apprenant.getPasswordUtilisateur());
        preparedStatement.setInt(9, apprenant.getLevelApprenant());
        preparedStatement.setInt(10, apprenant.getNombreBadge());
        /**
         * ********************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);

    }

    @Override
    public boolean supprimerApprenant(Apprenant apprenant) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ? and login like ? and post like 'Apprenant'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ***************************
         */
        preparedStatement.setString(1, apprenant.getIdentifiantUtilisateur());
        preparedStatement.setString(2, apprenant.getLoginUtilisateur());
        /**
         * ************************
         */

        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);

    }

    @Override
    public boolean supprimerApprenantByIdentifiant(String Identifiant) throws SQLException {
         connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ? and post like 'Apprenant'";
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
    public boolean modifierApprenantByIdentifiant(String Identifiant, Apprenant newApprenant) throws SQLException {
        connection = DataSource.getInstance().getConnection();

        final String requete = "update users set nom=?,prenom=?,age=?,email=?,photo=?,login=?,password=? where identifiant like ? and post like 'Apprenant'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * *****************************************
         */
        preparedStatement.setString(1, newApprenant.getNomUtilistaur());
        preparedStatement.setString(2, newApprenant.getPrenomUtilisteur());
        preparedStatement.setInt(3, newApprenant.getAgeUtilisateur());
        preparedStatement.setString(4, newApprenant.getEmailUtilisateur());
        preparedStatement.setString(5, newApprenant.getPhotoUtilisateur());
        preparedStatement.setString(6, newApprenant.getLoginUtilisateur());
        preparedStatement.setString(7, newApprenant.getPasswordUtilisateur());
        preparedStatement.setString(8, Identifiant);

        /**
         * ***************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);

    }

    @Override
    public List<Apprenant> afficherApprenants() throws SQLException {
        List<Apprenant> listApprenant = new ArrayList<>();
        Apprenant apprenant = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from users where post like 'Apprenant'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
        while (resultSet.next()) {
            apprenant = new Apprenant();
            /**
             * ****************************************
             */
            apprenant.setNomUtilistaur(resultSet.getString("nom"));
            apprenant.setPrenomUtilisteur(resultSet.getString("prenom"));
            apprenant.setAgeUtilisateur(resultSet.getInt("age"));
            apprenant.setEmailUtilisateur(resultSet.getString("email"));
            apprenant.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            apprenant.setPhotoUtilisateur(resultSet.getString("photo"));
            apprenant.setLoginUtilisateur(resultSet.getString("login"));
            apprenant.setPasswordUtilisateur(resultSet.getString("password"));
            apprenant.setLevelApprenant(resultSet.getInt("level"));
            apprenant.setNombreBadge(resultSet.getInt("NbBadge"));

            /**
             * ******************************************
             */
            listApprenant.add(apprenant);
        }
        if (Objects.nonNull(listApprenant)) {
            return listApprenant;
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public Apprenant getApprenantByIdentifiant(String identifiant) throws SQLException {

        Apprenant apprenant = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from users where identifiant like ? and post like 'Apprenant'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, identifiant);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            apprenant = new Apprenant();
            /**
             * ****************************************
             */
            apprenant.setNomUtilistaur(resultSet.getString("nom"));
            apprenant.setPrenomUtilisteur(resultSet.getString("prenom"));
            apprenant.setAgeUtilisateur(resultSet.getInt("age"));
            apprenant.setEmailUtilisateur(resultSet.getString("email"));
            apprenant.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            apprenant.setPhotoUtilisateur(resultSet.getString("photo"));
            apprenant.setLoginUtilisateur(resultSet.getString("login"));
            apprenant.setPasswordUtilisateur(resultSet.getString("password"));
            apprenant.setLevelApprenant(resultSet.getInt("level"));
            apprenant.setNombreBadge(resultSet.getInt("NbBadge"));

            /**
             * ******************************************
             */
        }
        if (Objects.nonNull(apprenant)) {
            return apprenant;
        }

        throw new UnsupportedOperationException();

    }

}
