/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Log;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Choukou_Tracker
 */
public interface ILogDAO {
    
    public boolean ajouterLog(Log Log);
    
    public boolean supprimerLog(int id);
        
    public ObservableList<Log> getallLog() throws SQLException;
    
    public Log getLogbyid(int id);
    
    public List<Log> getLogbyuser(int idUser);
    
    public List<Log> getLogbytache(String Tache);
    
}
