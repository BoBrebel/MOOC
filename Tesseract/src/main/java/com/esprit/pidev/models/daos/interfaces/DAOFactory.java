package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplAdministrateurDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplApprenantDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplFormateurDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplMembreComitPedagDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplReclamationDAO;


public abstract class DAOFactory {

    private final static int ADMINISTRATEUR = 1;
    private final static int APPRENANT = 2;
    private final static int FORMATEUR = 3;
    private final static int MEMBRECP = 4;
    private final static int RECLAMATIO = 5;

//     IAdministrateurDAO administrateurDAO ;
//     IApprenantDAO apprenantDAO;
//     IFormateurDAO formateurDAO;
//     IMembreComitPedagDAO iMembreComitPedagDAO;
//     IReclamationDAO iReclamationDAO ;
 
    public static IAdministrateurDAO getAdministrateurDAO() {
        return new ImplAdministrateurDAO();
    }

    public static IApprenantDAO getApprenantDAO() {
        return new ImplApprenantDAO();
    }

    public static IFormateurDAO getFormateurDAO() {
        return new ImplFormateurDAO();
    }

    public static IMembreComitPedagDAO getiMembreComitPedagDAO() {
        return new ImplMembreComitPedagDAO();
    }

    public static IReclamationDAO getiReclamationDAO() {
        return new ImplReclamationDAO();
    }
     
}
