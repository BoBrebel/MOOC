package com.esprit.pidev.models.entities;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public abstract class Utilisateur {

    private List<Reclamation> listReclamation;

    private String nomUtilistaur;
    private String prenomUtilisteur;
    private int ageUtilisateur;
    private String loginUtilisateur;
    private String emailUtilisateur;
    private String passwordUtilisateur;
    private String photoUtilisateur;
    private String identifiantUtilisateur;

    public Utilisateur(String nomUtilistaur, String prenomUtilisteur, int ageUtilisateur, String loginUtilisateur, String emailUtilisateur, String passwordUtilisateur, String photoUtilisateur, String identifiantUtilisateur) {
        this.nomUtilistaur = nomUtilistaur;
        this.prenomUtilisteur = prenomUtilisteur;
        this.ageUtilisateur = ageUtilisateur;
        this.loginUtilisateur = loginUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passwordUtilisateur = passwordUtilisateur;
        this.photoUtilisateur = photoUtilisateur;
        this.identifiantUtilisateur = identifiantUtilisateur;
    }

    public Utilisateur() {
    }

    public String getNomUtilistaur() {
        return nomUtilistaur;
    }

    public void setNomUtilistaur(String nomUtilistaur) {
        this.nomUtilistaur = nomUtilistaur;
    }

    public String getPrenomUtilisteur() {
        return prenomUtilisteur;
    }

    public void setPrenomUtilisteur(String prenomUtilisteur) {
        this.prenomUtilisteur = prenomUtilisteur;
    }

    public int getAgeUtilisateur() {
        return ageUtilisateur;
    }

    public void setAgeUtilisateur(int ageUtilisateur) {
        this.ageUtilisateur = ageUtilisateur;
    }

    public String getLoginUtilisateur() {
        return loginUtilisateur;
    }

    public void setLoginUtilisateur(String loginUtilisateur) {
        this.loginUtilisateur = loginUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getPasswordUtilisateur() {
        return passwordUtilisateur;
    }

    public void setPasswordUtilisateur(String passwordUtilisateur) {
        this.passwordUtilisateur = passwordUtilisateur;
    }

    public String getPhotoUtilisateur() {
        return photoUtilisateur;
    }

    public void setPhotoUtilisateur(String photoUtilisateur) {
        this.photoUtilisateur = photoUtilisateur;
    }

    public String getIdentifiantUtilisateur() {
        return identifiantUtilisateur;
    }

    public void setIdentifiantUtilisateur(String identifiantUtilisateur) {
        this.identifiantUtilisateur = identifiantUtilisateur;
    }

    public List<Reclamation> getListReclamation() {
        return listReclamation;
    }

    public void setListReclamation(List<Reclamation> listReclamation) {
        this.listReclamation = listReclamation;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.identifiantUtilisateur);
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
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.identifiantUtilisateur, other.identifiantUtilisateur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "nomUtilistaur=" + nomUtilistaur + ", prenomUtilisteur=" + prenomUtilisteur + ", ageUtilisateur=" + ageUtilisateur + ", loginUtilisateur=" + loginUtilisateur + ", emailUtilisateur=" + emailUtilisateur + ", passwordUtilisateur=" + passwordUtilisateur + ", photoUtilisateur=" + photoUtilisateur + ", identifiantUtilisateur=" + identifiantUtilisateur + '}';
    }

}
