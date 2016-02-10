/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.EpreuveFinal;
import java.util.List;

/**
 *
 * @author Bacem
 */
public interface IEpreuveFinalDAO {
    boolean createEpreuveFinal(EpreuveFinal epreuveFinal);
    boolean deleteEpreuveFinal(int id);
    boolean updateEpreuveFinal(EpreuveFinal epreuveFinal, int id);
    EpreuveFinal searchEpreuveFinal(int id);
    List<EpreuveFinal> displayEpreuveFinal();
    
}
