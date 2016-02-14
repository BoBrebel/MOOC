package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.ISujetForumDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.SujetForum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplSujetForumDAO implements ISujetForumDAO {

    @Override
    public boolean createSujetForum(SujetForum sujetForum, int idUtilisateur) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        String req = "insert into sujet_forum values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(2, idUtilisateur);
        ps.setInt(1, sujetForum.getIdSujet());
        ps.setString(3, sujetForum.getTitre());
        ps.setString(4, sujetForum.getDescription());
        ps.setDate(5, sujetForum.getDateSujet());
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;
    }

    @Override
    public List<SujetForum> getSujetForumByUserId(int idUtilisateur) throws SQLException {
        List<SujetForum> list = new ArrayList<SujetForum>();
        Connection connection = DataSource.getInstance().getConnection();
        String requete = "select * from sujet_forum where id_utilisateur = ?";
        PreparedStatement ps = connection.prepareStatement(requete);
        ps.setInt(1, idUtilisateur);
        ResultSet rs = ps.executeQuery();
        SujetForum sujetForum = new SujetForum();
        while (rs.next()) {
            sujetForum.setIdSujet(rs.getInt(1));
            sujetForum.setIdUtilisateur(rs.getInt(2));
            sujetForum.setTitre(rs.getString(3));
            sujetForum.setDescription(rs.getString(4));
            sujetForum.setDateSujet(rs.getDate(5));
            list.add(sujetForum);
        }
        ps.close();
        return list;

    }

    @Override
    public boolean updateSujetForum(int idSujet, SujetForum sujetForum) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        String req = "update sujet_forum set id_utilisateur=?,  titre=?,description=?, date_sujet =? where id_sujet = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, sujetForum.getIdUtilisateur());
        ps.setString(2, sujetForum.getTitre());
        ps.setString(3, sujetForum.getDescription());
        ps.setDate(4, sujetForum.getDateSujet());
        ps.setInt(5, idSujet);
        int resultat = ps.executeUpdate();
        ps.close();
        return resultat == 1;
    }

}
