package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Apprenant;
import java.sql.SQLException;
import java.util.List;

public interface IApprenantDAO {

    boolean createApprenant(Apprenant apprenant) throws SQLException;

    boolean supprimerApprenant(Apprenant apprenant) throws SQLException;

    boolean supprimerApprenantByIdentifiant(String Identifiant) throws SQLException;

    boolean modifierApprenantByIdentifiant(String Identifiant, Apprenant newApprenant) throws SQLException;

    List<Apprenant> afficherApprenants() throws SQLException;

    Apprenant getApprenantByIdentifiant(String identifiant) throws SQLException;

}
