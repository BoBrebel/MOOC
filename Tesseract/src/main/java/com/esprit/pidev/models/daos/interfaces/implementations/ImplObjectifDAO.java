package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IObjectifDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Chapitre;
import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.entities.Objectif;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplObjectifDAO implements IObjectifDAO {

    @Override
    public boolean createObjectif(Objectif objectif) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        String req = "insert into objectif values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, objectif.getIdObjectif());
        ps.setInt(2, objectif.getIdChapitre());
        ps.setString(3, objectif.getNom());
        ps.setString(4, objectif.getDescription());
        ps.setString(5, objectif.getDifficule());

        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;
    }

    @Override
    public boolean removeObjectif(Objectif objectif) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        String req = "delete from objectif where id_objectif = " + objectif.getIdObjectif();
        Statement ps = connection.createStatement();
        int res = ps.executeUpdate(req);
        ps.close();
        return res == 1;

    }

    @Override
    public boolean removeObjectifByname(String nomObjectif) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        String req = "delete from objectif where nom like ? ";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, nomObjectif);
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;
    }

    @Override
    public boolean updateObjectif(String nomObjectif, Objectif objectif) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        String req = "update objectif set id_chapitre=?,  nom=?,description=?, difficule =? where nom like ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, objectif.getIdChapitre());
        ps.setString(2, objectif.getNom());
        ps.setString(3, objectif.getDescription());
        ps.setString(4, objectif.getDifficule());
        ps.setString(5, nomObjectif);
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;

    }

    @Override
    public List<Objectif> displayObjectifs() throws SQLException {

        List<Objectif> listObjectifs = new ArrayList<Objectif>();
        Connection connection = DataSource.getInstance().getConnection();
        String req = "select * from objectif";
        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(req);
        Objectif objectif = new Objectif();
        while (rs.next()) {
            objectif.setIdObjectif(rs.getInt(1));
            objectif.setIdChapitre(rs.getInt(2));
            objectif.setNom(rs.getString(3));
            objectif.setDescription(rs.getString(4));
            objectif.setDifficule(rs.getString(5));
            listObjectifs.add(objectif);
        }
        ps.close();
        return listObjectifs;
    }

    @Override
    public List<Objectif> getObjectifByChapitre(Chapitre chapitre) throws SQLException {
    
    List<Objectif> listObjectifs = new ArrayList<Objectif>();
        Connection connection = DataSource.getInstance().getConnection();
        String req = "select * from objectif where id_chapitre = "+chapitre.getIdChapitre();
        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(req);
        Objectif objectif = new Objectif();
        while (rs.next()) {
            objectif.setIdObjectif(rs.getInt(1));
            objectif.setIdChapitre(rs.getInt(2));
            objectif.setNom(rs.getString(3));
            objectif.setDescription(rs.getString(4));
            objectif.setDifficule(rs.getString(5));
            listObjectifs.add(objectif);
        }
        ps.close();
        return listObjectifs;
    
    
    }

 
}
