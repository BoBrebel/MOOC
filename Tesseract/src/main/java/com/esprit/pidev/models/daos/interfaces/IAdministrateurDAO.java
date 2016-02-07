package com.esprit.pidev.models.daos.interfaces;


import com.esprit.pidev.models.entities.Administrateur;
import java.sql.SQLException;
import java.util.List;

public interface IAdministrateurDAO {

    boolean createAdministrateur(Administrateur administrateur) throws SQLException;

    boolean supprimerAdministrateur(Administrateur administrateur) throws SQLException;

    boolean supprimerAdministrateurByIdentifiant(String Identifiant) throws SQLException;

    boolean modifierAdministrateurByIdentifiant(String Identifiant, Administrateur newAdministrateur) throws SQLException;

    List<Administrateur> afficherAdministrateurs() throws SQLException;

    Administrateur getAdministrateurByIdentifiant(String identifiant) throws SQLException;

}
