package com.esprit.pidev.models.daos.interfaces.implementations;


import com.esprit.pidev.models.daos.interfaces.IReclamationDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.EtatDemande;
import com.esprit.pidev.models.entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImplReclamationDAO implements IReclamationDAO {

    private Connection connection;

    @Override
    public boolean createReclamation(Reclamation reclamation) throws SQLException {
        connection = DataSource.getInstance().getConnection();
        final String requete = "insert into reclamations (description,etat) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        /**
         * ************SetString to our request************
         */
        preparedStatement.setString(1, reclamation.getDescriptionReclamation());
        preparedStatement.setString(2, String.valueOf(reclamation.getEtatDemandeReclamation()));

        /**
         * ********************************************
         */
        int update = preparedStatement.executeUpdate();
        preparedStatement.close();
        return (update == 1);
    }

    @Override
    public List<Reclamation> afficherReclamations() throws SQLException {
        List<Reclamation> listReclamation = new ArrayList<>();
        Reclamation reclamation = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from reclamations";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
        while (resultSet.next()) {
            reclamation = new Reclamation();
            /**
             * ****************************************
             */

            reclamation.setDescriptionReclamation(resultSet.getString("description"));
            reclamation.setEtatDemandeReclamation(EtatDemande.valueOf(resultSet.getString("etat")));
            reclamation.setIdentifiantReclamation(resultSet.getString("identifiant"));

            /**
             * ******************************************
             */
            listReclamation.add(reclamation);
        }
        if (Objects.nonNull(listReclamation)) {
            return listReclamation;
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public Reclamation getReclamationByIdentifiant(String Identifiant) throws SQLException {
        Reclamation reclamation = null;
        connection = DataSource.getInstance().getConnection();
        final String requete = "select * from reclamations where identifiant like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, Identifiant);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            reclamation = new Reclamation();
            /**
             * ****************************************
             */
            reclamation.setDescriptionReclamation(resultSet.getString("description"));
            reclamation.setEtatDemandeReclamation(EtatDemande.valueOf(resultSet.getString("etat")));
            reclamation.setIdentifiantReclamation(resultSet.getString("identifiant"));

            /**
             * ******************************************
             */
        }
        if (Objects.nonNull(reclamation)) {
            return reclamation;
        }

        throw new UnsupportedOperationException();
    }

}
