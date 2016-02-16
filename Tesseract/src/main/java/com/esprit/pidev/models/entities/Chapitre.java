
package com.esprit.pidev.models.entities;

import java.util.List;


public class Chapitre {
   private int idChapitre ; 
   private int idCours ;
   private String nom ;
   private int numero ; 
   private String description ;
   private String resume ;
   private List<Objectif>  listObjectif ;
   

    public Chapitre(int idChapitre, int idCours, String nom, int numero, String description, String resume) {
        this.idChapitre = idChapitre;
        this.idCours = idCours;
        this.nom = nom;
        this.numero = numero;
        this.description = description;
        this.resume = resume;
    }

    public Chapitre(int idChapitre, int idCours, String nom, int numero, String description, String resume, List<Objectif> listObjectif) {
        this.idChapitre = idChapitre;
        this.idCours = idCours;
        this.nom = nom;
        this.numero = numero;
        this.description = description;
        this.resume = resume;
        this.listObjectif = listObjectif;
    }
     

    public Chapitre(String nom, int numero, String description, String resume) {
        this.nom = nom;
        this.numero = numero;
        this.description = description;
        this.resume = resume;
    }

    public Chapitre() {
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idChapitre;
        return hash;
    }

    public List<Objectif> getListObjectif() {
        return listObjectif;
    }

    public void setListObjectif(List<Objectif> listObjectif) {
        this.listObjectif = listObjectif;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chapitre other = (Chapitre) obj;
        if (this.idChapitre != other.idChapitre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chapitre{" + "idChapitre=" + idChapitre + ", idCours=" + idCours + ", nom=" + nom + ", numero=" + numero + ", description=" + description + ", resume=" + resume + ", listObjectif=" + listObjectif + '}';
    }

   
   
   
}
