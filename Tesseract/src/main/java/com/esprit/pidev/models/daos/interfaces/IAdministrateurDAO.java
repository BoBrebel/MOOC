
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Administrateur;
import com.esprit.pidev.models.entities.Apprenant;
import java.sql.SQLException;
import java.util.List;


public interface IAdministrateurDAO {
       
   public boolean ajouterAdministrateur(Administrateur apprenant) throws SQLException ;
   
   public Administrateur getAdministrateurByLogin(String login)throws SQLException;
   
   public boolean supprimerAdministrateurByLogin(String login)throws SQLException;
   
   public List<Administrateur> getAllAdministrateurs()throws SQLException;
   
   public boolean modifierAdministrateur (String login , Administrateur newAdministrateur)throws SQLException;
}
