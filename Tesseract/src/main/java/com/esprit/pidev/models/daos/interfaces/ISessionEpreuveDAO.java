/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.SessionEpreuve;
import java.util.List;

/**
 *
 * @author BoB
 */
public interface ISessionEpreuveDAO {
    
    public boolean ajouterSessionEpreuve(SessionEpreuve sessionEpreuve);
    
    public boolean modifierSessionEpreuve(SessionEpreuve sessionEpreuve);
    
    public List<SessionEpreuve> getSessionEpreuvebyUserid(int idUser);
    
    public List<SessionEpreuve> getSessionEpreuvebyidEpreuve(int idEpreuve);
    
    public List<SessionEpreuve> getSessoEpreuvebynote(float note);
    
    
}
