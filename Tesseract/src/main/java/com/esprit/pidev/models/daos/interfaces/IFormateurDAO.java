
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Administrateur;
import com.esprit.pidev.models.entities.Apprenant;
import com.esprit.pidev.models.entities.Formateur;
import java.sql.SQLException;
import java.util.List;


public interface IFormateurDAO {
    
     public boolean ajouterFormateur(Formateur apprenant,Integer idOrganisme) throws SQLException ;
   
   public Formateur getFormateurByLogin(String login)throws SQLException;
   
   public boolean supprimerFormateurByLogin(String login)throws SQLException;
   
   public List<Formateur> getAllFormateurs()throws SQLException;
   
   public boolean modifierFormateur (String login , Formateur newFormateur)throws SQLException;
    
}
