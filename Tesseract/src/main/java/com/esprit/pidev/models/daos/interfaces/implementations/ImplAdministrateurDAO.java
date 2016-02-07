package com.esprit.pidev.models.daos.interfaces.implementations;


import com.esprit.pidev.models.daos.interfaces.IAdministrateurDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Administrateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImplAdministrateurDAO implements IAdministrateurDAO {

    private Connection connection;
    private static final String ROLE = "Administrateur";

    @Override
    public boolean createAdministrateur(Administrateur administrateur) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "insert into users (nom,prenom,age,email,identifiant,photo,login,password,adresse,NumTel,post) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ************SetString to our request************
         */
        preparedStatement.setString(1, administrateur.getNomUtilistaur());
        preparedStatement.setString(2, administrateur.getPrenomUtilisteur());
        preparedStatement.setInt(3, administrateur.getAgeUtilisateur());
        preparedStatement.setString(4, administrateur.getEmailUtilisateur());
        preparedStatement.setString(5, administrateur.getIdentifiantUtilisateur());
        preparedStatement.setString(6, administrateur.getPhotoUtilisateur());
        preparedStatement.setString(7, administrateur.getLoginUtilisateur());
        preparedStatement.setString(8, administrateur.getPasswordUtilisateur());
        preparedStatement.setString(9, administrateur.getAddresseAdmin());
        preparedStatement.setInt(10, administrateur.getNumTelephoneAdmin());
        preparedStatement.setString(11, ROLE);
        /**
         * ********************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public boolean supprimerAdministrateur(Administrateur administrateur) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ? and login like ? and post like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ***************************
         */
        preparedStatement.setString(1, administrateur.getIdentifiantUtilisateur());
        preparedStatement.setString(2, administrateur.getLoginUtilisateur());
        preparedStatement.setString(3, ROLE);
        /**
         * ************************
         */

        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public boolean supprimerAdministrateurByIdentifiant(String Identifiant) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ?";
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
    public boolean modifierAdministrateurByIdentifiant(String Identifiant, Administrateur newAdministrateur) throws SQLException {
        connection = DataSource.getInstance().getConnection();

        final String requete = "update users set nom=?,prenom=?,age=?,email=?,photo=?,login=?,password=?,NumTel=?,adresse=? where identifiant like ? and post like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * *****************************************
         */
        preparedStatement.setString(1, newAdministrateur.getNomUtilistaur());
        preparedStatement.setString(2, newAdministrateur.getPrenomUtilisteur());
        preparedStatement.setInt(3, newAdministrateur.getAgeUtilisateur());
        preparedStatement.setString(4, newAdministrateur.getEmailUtilisateur());
        preparedStatement.setString(5, newAdministrateur.getPhotoUtilisateur());
        preparedStatement.setString(6, newAdministrateur.getLoginUtilisateur());
        preparedStatement.setString(7, newAdministrateur.getPasswordUtilisateur());
        preparedStatement.setInt(8, newAdministrateur.getNumTelephoneAdmin());
        preparedStatement.setString(9, newAdministrateur.getAddresseAdmin());
        preparedStatement.setString(10, Identifiant);
        preparedStatement.setString(11, ROLE);

        /**
         * ***************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public List<Administrateur> afficherAdministrateurs() throws SQLException {
        List<Administrateur> listAdmini = new ArrayList<>();
        Administrateur administrateur = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from users where post like 'Administrateur'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
        while (resultSet.next()) {
            administrateur = new Administrateur();
            /**
             * ****************************************
             */
            administrateur.setNomUtilistaur(resultSet.getString("nom"));
            administrateur.setPrenomUtilisteur(resultSet.getString("prenom"));
            administrateur.setAgeUtilisateur(resultSet.getInt("age"));
            administrateur.setEmailUtilisateur(resultSet.getString("email"));
            administrateur.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            administrateur.setPhotoUtilisateur(resultSet.getString("photo"));
            administrateur.setLoginUtilisateur(resultSet.getString("login"));
            administrateur.setPasswordUtilisateur(resultSet.getString("password"));
            administrateur.setNumTelephoneAdmin(resultSet.getInt("NumTel"));
            administrateur.setAddresseAdmin(resultSet.getString("adresse"));

            /**
             * ******************************************
             */
            listAdmini.add(administrateur);
        }
        if (Objects.nonNull(listAdmini)) {
            return listAdmini;
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public Administrateur getAdministrateurByIdentifiant(String identifiant) throws SQLException {
        Administrateur administrateur = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from users where identifiant like ? and post like 'Administrateur'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, identifiant);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            administrateur = new Administrateur();
            /**
             * ****************************************
             */
            administrateur.setNomUtilistaur(resultSet.getString("nom"));
            administrateur.setPrenomUtilisteur(resultSet.getString("prenom"));
            administrateur.setAgeUtilisateur(resultSet.getInt("age"));
            administrateur.setEmailUtilisateur(resultSet.getString("email"));
            administrateur.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            administrateur.setPhotoUtilisateur(resultSet.getString("photo"));
            administrateur.setLoginUtilisateur(resultSet.getString("login"));
            administrateur.setPasswordUtilisateur(resultSet.getString("password"));
            administrateur.setNumTelephoneAdmin(resultSet.getInt("NumTel"));
            administrateur.setAddresseAdmin(resultSet.getString("adresse"));

            /**
             * ******************************************
             */
        }
        if (Objects.nonNull(administrateur)) {
            return administrateur;
        }

        throw new UnsupportedOperationException();

    }

}
