package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Chapitre;
import java.sql.SQLException;
import java.util.List;


public interface IChapitreDAO {
    
    
    boolean createChapitre(Chapitre chapitre) throws SQLException;

    boolean removeChapitre(Chapitre chapitre) throws SQLException;

    boolean removeChapitreByName(String nomChapitre ) throws SQLException;

    boolean updateChapitre(String nomChapitre, Chapitre chapitre) throws SQLException;

    List<Chapitre> displayChapitres() throws SQLException;

    Chapitre getChapitreByName(String nomChapitre ) throws SQLException;
}
