/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.ICommentaireForumDAO;
import com.esprit.pidev.models.entities.CommentaireForum;
import com.esprit.pidev.models.entities.SujetForum;
import com.esprit.pidev.models.entities.Utilisateur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 
 */
public class ImplCommentaireForumDAO implements ICommentaireForumDAO{

    @Override
    public boolean addCommentaireForum(CommentaireForum cmntfrm) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCommentaireForum(int idCmnt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCommentaireForum(CommentaireForum cmntfrm) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentaireForum> displayCommentaireForum() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentaireForum> getCommentaireForumBySujet(SujetForum sujetf) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentaireForum> getCommentaireForumByUtilisateur(Utilisateur user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
