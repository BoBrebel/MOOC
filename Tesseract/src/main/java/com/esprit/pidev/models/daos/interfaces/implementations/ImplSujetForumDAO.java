/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.ISujetForumDAO;
import com.esprit.pidev.models.entities.SujetForum;
import com.esprit.pidev.models.entities.Utilisateur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author haikal
 */
public class ImplSujetForumDAO implements ISujetForumDAO{

    @Override
    public boolean addSujetForum(SujetForum sujetf) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSujetForum(int idSujet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateSujetForum(SujetForum sujetf) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SujetForum> displaySujetForum() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SujetForum> displayByUtilisateur(Utilisateur utilisateur) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SujetForum> searchSujetForum(String rch) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
