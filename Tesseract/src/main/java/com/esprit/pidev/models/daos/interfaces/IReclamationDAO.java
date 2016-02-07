package com.esprit.pidev.models.daos.interfaces;


import com.esprit.pidev.models.entities.Reclamation;
import java.sql.SQLException;
import java.util.List;

public interface IReclamationDAO {

    boolean createReclamation(Reclamation reclamation) throws SQLException;

    List<Reclamation> afficherReclamations() throws SQLException;
    
    Reclamation getReclamationByIdentifiant(String Identifiant) throws SQLException ;

}
