package com.esprit.pidev.models.entities;

import com.esprit.pidev.models.enums.Difficulte;

public class Cours {

    private int idCours;
    private String badge;
    private String nomCours;
    private Difficulte difficulte;
    private int nbChapitre;
    private String descriptionCours;
    private int idMatiere;
    private String affiche;
    private int idFormateur;

    public Cours() {

    }

    public Cours(String nomCours, String descriptionCours, int idCours, int nbChapitre, int idMatiere, String affiche, String badge) {
        this.descriptionCours = descriptionCours;
        this.nomCours = nomCours;
        this.idCours = idCours;
        this.nbChapitre = nbChapitre;
        this.idMatiere = idMatiere;
        this.affiche = affiche;
        this.badge = badge;

    }

    public Cours(String badge, String nomCours, Difficulte difficulte, int nbChapitre, String descriptionCours, String affiche) {

        this.badge = badge;
        this.nomCours = nomCours;
        this.difficulte = difficulte;
        this.nbChapitre = nbChapitre;
        this.descriptionCours = descriptionCours;

        this.affiche = affiche;

    }

    public Cours(String badge, String nomCours, Difficulte difficulte, int nbChapitre, String descriptionCours, int idMatiere, String affiche, int idFormateur) {
     
        this.badge = badge;
        this.nomCours = nomCours;
        this.difficulte = difficulte;
        this.nbChapitre = nbChapitre;
        this.descriptionCours = descriptionCours;
        this.idMatiere = idMatiere;
        this.affiche = affiche;
        this.idFormateur = idFormateur;
    }
    

    public Cours(String nomCours, String descriptionCours, int nbChapitre, int idMatiere, String affiche, String badge) {
        this.descriptionCours = descriptionCours;
        this.nomCours = nomCours;
        this.nbChapitre = nbChapitre;
        this.idMatiere = idMatiere;
        this.affiche = affiche;
        this.badge = badge;

    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int getIdCours() {
        return idCours;
    }


    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getBadge() {
        return badge;
    }

  
    public void setBadge(String badge) {
        this.badge = badge;
    }

    
    public String getNomCours() {
        return nomCours;
    }

   
    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    /**
     * @return the difficulte
     */
    public Difficulte getDifficulte() {
        return difficulte;
    }

    /**
     * @param difficulte the difficulte to set
     */
    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    /**
     * @return the nbChapitre
     */
    public int getNbChapitre() {
        return nbChapitre;
    }

    /**
     * @param nbChapitre the nbChapitre to set
     */
    public void setNbChapitre(int nbChapitre) {
        this.nbChapitre = nbChapitre;
    }

    /**
     * @return the descriptionCours
     */
    public String getDescriptionCours() {
        return descriptionCours;
    }

    /**
     * @param descriptionCours the descriptionCours to set
     */
    public void setDescriptionCours(String descriptionCours) {
        this.descriptionCours = descriptionCours;
    }

    /**
     * @return the idMatiere
     */
    public int getIdMatiere() {
        return idMatiere;
    }

    /**
     * @param idMatiere the idMatiere to set
     */
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    /**
     * @return the affiche
     */
    public String getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    /**
     * @return the idFormateur
     */
    public int getIdFormateur() {
        return idFormateur;
    }

    /**
     * @param idFormateur the idFormateur to set
     */
    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

}
