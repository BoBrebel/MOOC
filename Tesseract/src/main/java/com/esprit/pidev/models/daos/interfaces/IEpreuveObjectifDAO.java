/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.EpreuveObjectif;
import java.util.List;

/**
 *
 * @author Bacem
 */
public interface IEpreuveObjectifDAO {
    int createEpreuveObjectif(EpreuveObjectif epreuveObjectif);
    boolean deleteEpreuveObjectif(int id);
    boolean updateEpreuveObjectif(EpreuveObjectif epreuveObjectif, int id);
    EpreuveObjectif searchEpreuveObjectif(int id);
    List<EpreuveObjectif> displayEpreuveObjectif();
    
}
