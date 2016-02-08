/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.tesseract.models.beans.Objectif;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Noor
 */
public interface IObjectifDAO {

    boolean createObjectif(Objectif objectif) throws SQLException;

    boolean removeObjectif(Objectif objectif) throws SQLException;

    boolean removeObjectifByname(String nomObjectif) throws SQLException;

    boolean updateObjectif(String nomObjectif, Objectif objectif) throws SQLException;

    List<Objectif> displayObjectifs() throws SQLException;

    Objectif getObjectifByName(String nomObjectif) throws SQLException;

}
