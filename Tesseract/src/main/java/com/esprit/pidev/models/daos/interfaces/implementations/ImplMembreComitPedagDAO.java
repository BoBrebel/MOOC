package com.esprit.pidev.models.daos.interfaces.implementations;


import com.esprit.pidev.models.daos.interfaces.IMembreComitPedagDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.MembreComitePedago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImplMembreComitPedagDAO implements IMembreComitPedagDAO {

    private Connection connection;
    private static final String ROLE = "MembreCP";

    @Override
    public boolean createMembreComitePedago(MembreComitePedago membreComitePedago) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "insert into users (nom,prenom,age,email,identifiant,photo,login,password,nbCoursAcc,adresse,post) values(?,?,?,?,?,?,?,?,?,?,'MembreCP')";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ************SetString to our request************
         */
        preparedStatement.setString(1, membreComitePedago.getNomUtilistaur());
        preparedStatement.setString(2, membreComitePedago.getPrenomUtilisteur());
        preparedStatement.setInt(3, membreComitePedago.getAgeUtilisateur());
        preparedStatement.setString(4, membreComitePedago.getEmailUtilisateur());
        preparedStatement.setString(5, membreComitePedago.getIdentifiantUtilisateur());
        preparedStatement.setString(6, membreComitePedago.getPhotoUtilisateur());
        preparedStatement.setString(7, membreComitePedago.getLoginUtilisateur());
        preparedStatement.setString(8, membreComitePedago.getPasswordUtilisateur());
        preparedStatement.setInt(9, membreComitePedago.getNumeroCoursAccepter());
        preparedStatement.setString(10, membreComitePedago.getAddresse());
        /**
         * ********************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public boolean supprimerMembreComitePedago(MembreComitePedago membreComitePedago) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ? and login like ? and post like MembreCP";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ***************************
         */
        preparedStatement.setString(1, membreComitePedago.getIdentifiantUtilisateur());
        preparedStatement.setString(2, membreComitePedago.getLoginUtilisateur());
        /**
         * ************************
         */

        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public boolean supprimerMembreComitePedagoByIdentifiant(String Identifiant) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "delete from users where identifiant like ? and post like 'MembreCP'";
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
    public boolean modifierAdministrateurByIdentifiant(String Identifiant, MembreComitePedago newMembreComitePedago) throws SQLException {
        connection = DataSource.getInstance().getConnection();

        final String requete = "update users set nom=?,prenom=?,age=?,email=?,photo=?,login=?,password=?,nbCoursAcc=?,adresse=? where identifiant like ? and post like 'MembreCP'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * *****************************************
         */
        preparedStatement.setString(1, newMembreComitePedago.getNomUtilistaur());
        preparedStatement.setString(2, newMembreComitePedago.getPrenomUtilisteur());
        preparedStatement.setInt(3, newMembreComitePedago.getAgeUtilisateur());
        preparedStatement.setString(4, newMembreComitePedago.getEmailUtilisateur());
        preparedStatement.setString(5, newMembreComitePedago.getPhotoUtilisateur());
        preparedStatement.setString(6, newMembreComitePedago.getLoginUtilisateur());
        preparedStatement.setString(7, newMembreComitePedago.getPasswordUtilisateur());
        preparedStatement.setInt(8, newMembreComitePedago.getNumeroCoursAccepter());
        preparedStatement.setString(9, newMembreComitePedago.getAddresse());
        preparedStatement.setString(10, Identifiant);

        /**
         * ***************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public List<MembreComitePedago> afficherMembreComitePedagos() throws SQLException {
        List<MembreComitePedago> listMembre = new ArrayList<>();
        MembreComitePedago membreComitePedago = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from users where post like 'MembreCP'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
        while (resultSet.next()) {
            membreComitePedago = new MembreComitePedago();
            /**
             * ****************************************
             */
            membreComitePedago.setNomUtilistaur(resultSet.getString("nom"));
            membreComitePedago.setPrenomUtilisteur(resultSet.getString("prenom"));
            membreComitePedago.setAgeUtilisateur(resultSet.getInt("age"));
            membreComitePedago.setEmailUtilisateur(resultSet.getString("email"));
            membreComitePedago.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            membreComitePedago.setPhotoUtilisateur(resultSet.getString("photo"));
            membreComitePedago.setLoginUtilisateur(resultSet.getString("login"));
            membreComitePedago.setPasswordUtilisateur(resultSet.getString("password"));
            membreComitePedago.setNumeroCoursAccepter(resultSet.getInt("nbCoursAcc"));
            membreComitePedago.setAddresse(resultSet.getString("adresse"));

            /**
             * ******************************************
             */
            listMembre.add(membreComitePedago);
        }
        if (Objects.nonNull(listMembre)) {
            return listMembre;
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public MembreComitePedago getMembreComitePedagoByIdentifiant(String identifiant) throws SQLException {
        MembreComitePedago membreComitePedago = null;
        connection = DataSource.getInstance().getConnection();DataSource.getInstance().getConnection();
        final String requete = "select * from users where identifiant like ? and post like 'MembreCP'";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, identifiant);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            membreComitePedago = new MembreComitePedago();
            /**
             * ****************************************
             */
            membreComitePedago.setNomUtilistaur(resultSet.getString("nom"));
            membreComitePedago.setPrenomUtilisteur(resultSet.getString("prenom"));
            membreComitePedago.setAgeUtilisateur(resultSet.getInt("age"));
            membreComitePedago.setEmailUtilisateur(resultSet.getString("email"));
            membreComitePedago.setIdentifiantUtilisateur(resultSet.getString("identifiant"));
            membreComitePedago.setPhotoUtilisateur(resultSet.getString("photo"));
            membreComitePedago.setLoginUtilisateur(resultSet.getString("login"));
            membreComitePedago.setPasswordUtilisateur(resultSet.getString("password"));
            membreComitePedago.setNumeroCoursAccepter(resultSet.getInt("nbCoursAcc"));
            membreComitePedago.setAddresse(resultSet.getString("adresse"));

            /**
             * ******************************************
             */
        }
        if (Objects.nonNull(membreComitePedago)) {
            return membreComitePedago;
        }

        throw new UnsupportedOperationException();
    }

}
