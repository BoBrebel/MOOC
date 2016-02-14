
package com.esprit.pidev.models.daos.interfaces;


import com.esprit.pidev.models.entities.Chapitre;
import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.entities.Objectif;
import java.sql.SQLException;
import java.util.List;


public interface IObjectifDAO {

    boolean createObjectif(Objectif objectif) throws SQLException;

    boolean removeObjectif(Objectif objectif) throws SQLException;

    boolean removeObjectifByname(String nomObjectif) throws SQLException;

    boolean updateObjectif(String nomObjectif, Objectif objectif) throws SQLException;

    List<Objectif> displayObjectifs() throws SQLException;

    List<Objectif> getObjectifByChapitre(Chapitre chapitre) throws SQLException;

}
