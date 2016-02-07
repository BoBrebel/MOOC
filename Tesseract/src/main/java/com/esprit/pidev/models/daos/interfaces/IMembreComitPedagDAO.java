package com.esprit.pidev.models.daos.interfaces;


import com.esprit.pidev.models.entities.MembreComitePedago;
import java.sql.SQLException;
import java.util.List;

public interface IMembreComitPedagDAO {

    boolean createMembreComitePedago(MembreComitePedago membreComitePedago) throws SQLException;

    boolean supprimerMembreComitePedago(MembreComitePedago membreComitePedago)throws SQLException;

    boolean supprimerMembreComitePedagoByIdentifiant(String Identifiant) throws SQLException;

    boolean modifierAdministrateurByIdentifiant(String Identifiant, MembreComitePedago newMembreComitePedago)throws SQLException;

    List<MembreComitePedago> afficherMembreComitePedagos()throws SQLException;

    MembreComitePedago getMembreComitePedagoByIdentifiant(String identifiant)throws SQLException;

}
