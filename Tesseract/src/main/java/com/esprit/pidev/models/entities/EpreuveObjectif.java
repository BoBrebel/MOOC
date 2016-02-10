/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.entities;


/**
 *
 * @author Bacem
 */
public class EpreuveObjectif extends Epreuve{

    public EpreuveObjectif(int id, String codeEpreuve, String difficulte) {
        super(id, codeEpreuve, difficulte);
    }

    public EpreuveObjectif() {
    }

    @Override
    public String toString() {
        return "EpreuveObjectif{" +super.toString() +  '}';
    }
    
    
    
}
