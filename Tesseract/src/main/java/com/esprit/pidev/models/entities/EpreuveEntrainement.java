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
public class EpreuveEntrainement extends Epreuve{

    protected int nombreTentative;

    public EpreuveEntrainement(int nombreTentative, int id, String codeEpreuve, String difficulte) {
        super(id, codeEpreuve, difficulte);
        this.nombreTentative = nombreTentative;
    }

    public EpreuveEntrainement() {
    }

    public int getNombreTentative() {
        return nombreTentative;
    }

    public void setNombreTentative(int nombreTentative) {
        this.nombreTentative = nombreTentative;
    }

    @Override
    public String toString() {
        return "EpreuveEntrainement{" + super.toString() + "nombreTentative=" + nombreTentative + '}';
    }
    
    
    
    
    
    
}

