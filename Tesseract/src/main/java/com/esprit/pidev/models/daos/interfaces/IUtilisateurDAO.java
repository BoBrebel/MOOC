package com.esprit.pidev.models.daos.interfaces;
import com.esprit.pidev.models.entities.Utilisateur;
import java.sql.SQLException;
import java.util.List;


public interface IUtilisateurDAO {
    public boolean addUtilisateur(Utilisateur user) throws SQLException;
    
    public boolean deleteUtilisateur(int idUser) throws SQLException;
    
    public boolean updateUtilisateur(Utilisateur User)throws SQLException;
        
    public List<Utilisateur> displayUtilisateur()throws SQLException;
    
    public Utilisateur getUtilisateurByID(int id)throws SQLException;
}
