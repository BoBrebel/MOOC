package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IChapitreDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Chapitre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplChapitreDAO implements IChapitreDAO {

    @Override
    public boolean createChapitre(Chapitre chapitre) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        String req = "insert into chapitre values (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, chapitre.getIdChapitre());
        ps.setInt(2, chapitre.getIdCours());
        ps.setString(3, chapitre.getNom());
        ps.setInt(4, chapitre.getNumero());
        ps.setString(5, chapitre.getDescription());
        ps.setString(6, chapitre.getResume());

        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;

    }

    @Override
    public boolean removeChapitre(Chapitre chapitre) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        String req = "delete from chapitre where id_chapitre like " + chapitre.getIdChapitre();
        Statement ps = connection.createStatement();
        int res = ps.executeUpdate(req);
        ps.close();
        return res == 1;

    }

    @Override
    public boolean removeChapitreByName(String nomChapitre) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        String req = "delete from chapitre where nom like ? ";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, nomChapitre);
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;

    }

    @Override
    public boolean updateChapitre(String nomChapitre, Chapitre chapitre) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        String req = "update chapitre set id_cours=?,  numero=?,description=?,resume=? where nom like ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, chapitre.getIdCours());
        ps.setInt(2, chapitre.getNumero());
        ps.setString(3, chapitre.getDescription());
        ps.setString(4, chapitre.getResume());
        ps.setString(5, nomChapitre);
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;

    }

    @Override
    public List<Chapitre> displayChapitres() throws SQLException {
        List<Chapitre> listChapitres = new ArrayList<Chapitre>();
        Connection connection = DataSource.getInstance().getConnection();
        String req = "select * from chapitre";
        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(req);
        Chapitre chapitre = new Chapitre();
        while (rs.next()) {

            chapitre.setIdChapitre(rs.getInt(1));
            chapitre.setIdCours(rs.getInt(2));
            chapitre.setNom(rs.getString(3));
            chapitre.setNumero(rs.getInt(4));
            chapitre.setDescription(rs.getString(5));
            chapitre.setResume(rs.getString(6));
            listChapitres.add(chapitre);
        }
        ps.close();
        return listChapitres;
    }

    @Override
    public Chapitre getChapitreByName(String nomChapitre) throws SQLException {
       
        Connection connection = DataSource.getInstance().getConnection();
        String req = "select * from chapitre where nom like ?";
        PreparedStatement ps = connection.prepareCall(req);
        ps.setString(1, nomChapitre);

        ResultSet rs = ps.executeQuery();
        Chapitre chapitre = new Chapitre();
        while (rs.next()) {

            chapitre.setIdChapitre(rs.getInt(1));
            chapitre.setIdCours(rs.getInt(2));
            chapitre.setNom(rs.getString(3));
            chapitre.setNumero(rs.getInt(4));
            chapitre.setDescription(rs.getString(5));
            chapitre.setResume(rs.getString(6));
           
        }
        ps.close();
        return chapitre;

    }

}
