
package com.esprit.pidev.models.entities;

import java.sql.Date;


public class SujetForum {
    private int idSujet;
    private int idUtilisateur;
    private String titre;
    private String description;
    private Date dateSujet;

    public SujetForum() {
    }

    public SujetForum(int idSujet, int idUtilisateur, String titre, String description, Date dateSujet) {
        this.idSujet = idSujet;
        this.idUtilisateur = idUtilisateur;
        this.titre = titre;
        this.description = description;
        this.dateSujet = dateSujet;
    }

    public int getIdSujet() {
        return idSujet;
    }

    public void setIdSujet(int idSujet) {
        this.idSujet = idSujet;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateSujet() {
        return dateSujet;
    }

    public void setDateSujet(Date dateSujet) {
        this.dateSujet = dateSujet;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final SujetForum other = (SujetForum) obj;
        if (this.idSujet != other.idSujet) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SujetForum{" + "idSujet=" + idSujet + ", idUtilisateur=" + idUtilisateur + ", titre=" + titre + ", description=" + description + ", dateSujet=" + dateSujet + '}';
    }
    
    
}
