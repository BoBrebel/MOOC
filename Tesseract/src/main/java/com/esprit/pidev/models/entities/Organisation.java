/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.entities;

import java.util.Objects;

/**
 *
 * @author haikal
 */
public class Organisation {
    private int idOrganisation;
    private String nom;
    private String adresse;
    private String matricule;
    private String photo;
    
    
    public Organisation(){}
    public Organisation(int idOrganisation, String nom, String adresse, String matricule, String photo) {
        this.idOrganisation = idOrganisation;
        this.nom = nom;
        this.adresse = adresse;
        this.matricule = matricule;
        this.photo = photo;
    }

    public int getIdOrganisation() {
        return idOrganisation;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setIdOrganisation(int idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Organisation{" + "idOrganisation=" + idOrganisation + ", nom=" + nom + ", adresse=" + adresse + ", matricule=" + matricule + ", photo=" + photo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idOrganisation;
        hash = 97 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organisation other = (Organisation) obj;
        if (this.idOrganisation != other.idOrganisation) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
    
}
