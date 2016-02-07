package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Formateur;
import java.sql.SQLException;
import java.util.List;

public interface IFormateurDAO {

    boolean createFormateur(Formateur formateur) throws SQLException;

    boolean supprimerFormateur(Formateur formateur) throws SQLException;

    boolean supprimerFormateurByIdentifiant(String Identifiant) throws SQLException;

    boolean modifierFormateurByIdentifiant(String Identifiant, Formateur newFormateur) throws SQLException;

    List<Formateur> afficherFormateurs() throws SQLException;

    Formateur getFormateurByIdentifiant(String identifiant) throws SQLException;
}
