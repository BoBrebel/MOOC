
package com.esprit.pidev.models.entities;


public class Objectif {
    private int idObjectif ;
    private int idChapitre;
    private String nom;
    private String description;
    private String difficule ;

    public Objectif() {
    }

    public Objectif(int idObjectif, int idChapitre, String nom, String description, String difficule) {
        this.idObjectif = idObjectif;
        this.idChapitre = idChapitre;
        this.nom = nom;
        this.description = description;
        this.difficule = difficule;
    }

    public int getIdObjectif() {
        return idObjectif;
    }

    public void setIdObjectif(int idObjectif) {
        this.idObjectif = idObjectif;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficule() {
        return difficule;
    }

    public void setDifficule(String difficule) {
        this.difficule = difficule;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Objectif other = (Objectif) obj;
        if (this.idObjectif != other.idObjectif) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objectif{" + "idObjectif=" + idObjectif + ", idChapitre=" + idChapitre + ", nom=" + nom + ", description=" + description + ", difficule=" + difficule + '}';
    }
   
    
    
}
