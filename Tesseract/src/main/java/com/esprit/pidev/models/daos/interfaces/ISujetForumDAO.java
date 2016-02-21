package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.SujetForum;
import com.esprit.pidev.models.entities.Utilisateur;
import java.sql.SQLException;
import java.util.List;


public interface ISujetForumDAO {
    public boolean addSujetForum(SujetForum sujetf) throws SQLException;
    
    public boolean deleteSujetForum(int idSujet) throws SQLException;
    
    public boolean updateSujetForum(SujetForum sujetf)throws SQLException;
        
    public List<SujetForum> displaySujetForum()throws SQLException;
    
    public List<SujetForum> displayByUtilisateur(Utilisateur utilisateur)throws SQLException;
    
    public List<SujetForum> searchSujetForum(String rch)throws SQLException;
}
