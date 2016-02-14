package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.SujetForum;
import java.sql.SQLException;
import java.util.List;


public interface ISujetForumDAO {
    public boolean createSujetForum (SujetForum sujetForum, int idUtilisateur)throws SQLException;

    public List<SujetForum> getSujetForumByUserId(int idUtilisateur)throws SQLException;

    public boolean updateSujetForum(int idSujet, SujetForum sujetForum)throws SQLException;
}
