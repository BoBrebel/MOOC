
package com.esprit.pidev.models.entities;

public class Apprenant extends Utilisateur{
    private int levelApprenant ;
    private int nombreBadge ;

    public Apprenant(int levelApprenant, int nombreBadge, String nomUtilistaur, String prenomUtilisteur, int ageUtilisateur, String loginUtilisateur, String emailUtilisateur, String passwordUtilisateur, String photoUtilisateur, String identifiantUtilisateur) {
        super(nomUtilistaur, prenomUtilisteur, ageUtilisateur, loginUtilisateur, emailUtilisateur, passwordUtilisateur, photoUtilisateur, identifiantUtilisateur);
        this.levelApprenant = levelApprenant;
        this.nombreBadge = nombreBadge;
    }

    public Apprenant() {
    }
    

    public int getLevelApprenant() {
        return levelApprenant;
    }

    public void setLevelApprenant(int levelApprenant) {
        this.levelApprenant = levelApprenant;
    }

    public int getNombreBadge() {
        return nombreBadge;
    }

    public void setNombreBadge(int nombreBadge) {
        this.nombreBadge = nombreBadge;
    }

    @Override
    public String toString() {
        return "Apprenant{"+super.toString() + "levelApprenant=" + levelApprenant + ", nombreBadge=" + nombreBadge + '}';
    }
     
    
}
