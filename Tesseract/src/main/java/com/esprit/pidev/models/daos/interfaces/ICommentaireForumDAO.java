package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.CommentaireForum;
import com.esprit.pidev.models.entities.SujetForum;
import com.esprit.pidev.models.entities.Utilisateur;
import java.sql.SQLException;
import java.util.List;


public interface ICommentaireForumDAO {
    public boolean addCommentaireForum(CommentaireForum cmntfrm) throws SQLException;
    
    public boolean deleteCommentaireForum(int idCmnt) throws SQLException;
    
    boolean updateCommentaireForum(CommentaireForum cmntfrm)throws SQLException;
        
    public List<CommentaireForum> displayCommentaireForum()throws SQLException;
    
    public List<CommentaireForum> getCommentaireForumBySujet(SujetForum sujetf)throws SQLException;
    
    public List<CommentaireForum> getCommentaireForumByUtilisateur(Utilisateur user)throws SQLException;
}
