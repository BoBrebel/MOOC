/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Utilisateur;
import com.esprit.pidev.models.enums.Role;

/**
 *
 * @author BoB
 */
public interface IUserDAO {
    
    public void authenticateUser(String userName,String Pwd);
}
