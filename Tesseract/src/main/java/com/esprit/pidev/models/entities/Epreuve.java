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
public class Epreuve {
    
    private int id;
    private String codeEpreuve;
    private String difficulte;

    public Epreuve(int id, String codeEpreuve, String difficulte) {
        this.id = id;
        this.codeEpreuve = codeEpreuve;
        this.difficulte = difficulte;
    }

    public Epreuve() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeEpreuve() {
        return codeEpreuve;
    }

    public void setCodeEpreuve(String codeEpreuve) {
        this.codeEpreuve = codeEpreuve;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Epreuve other = (Epreuve) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Epreuve{" + "codeEpreuve=" + codeEpreuve + ", difficulte=" + difficulte + '}';
    }
    
    
}
