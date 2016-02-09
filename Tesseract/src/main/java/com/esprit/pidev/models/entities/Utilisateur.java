package com.esprit.pidev.models.entities;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public abstract class Utilisateur {

    protected int idUtilisateur;

    protected String nomUtilisateur;
    protected String motDePass;
    protected String nom;
    protected String prenom;
    protected Date dateNaissance;
    protected int tel;
    protected String adresse;
    protected String mail;
    protected String photo;
    protected List<Notification> listNotification = new ArrayList<>();
    protected List<Log> listLog = new ArrayList<>();
    protected List<Reclamation> listReclamation = new ArrayList<>();
    protected List<SujetForum> listSujet = new ArrayList<>();

    public Utilisateur(int idUtilisateur, String nomUtilisateur, String motDePass, String nom, String prenom, Date dateNaissance, int tel, String adresse, String mail, String photo) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePass = motDePass;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.tel = tel;
        this.adresse = adresse;
        this.mail = mail;
        this.photo = photo;
    }

    public Utilisateur() {
    }

    public Utilisateur(String nomUtilisateur, String motDePass, String nom, String prenom, Date dateNaissance, int tel, String adresse, String mail, String photo) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePass = motDePass;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.tel = tel;
        this.adresse = adresse;
        this.mail = mail;
        this.photo = photo;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idUtilisateur;
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
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return true;
    }

    public List<Notification> getListNotification() {
        return listNotification;
    }

    public void setListNotification(List<Notification> listNotification) {
        this.listNotification = listNotification;
    }

    public List<Log> getListLog() {
        return listLog;
    }

    public void setListLog(List<Log> listLog) {
        this.listLog = listLog;
    }

    public List<Reclamation> getListReclamation() {
        return listReclamation;
    }

    public void setListReclamation(List<Reclamation> listReclamation) {
        this.listReclamation = listReclamation;
    }

    public List<SujetForum> getListSujet() {
        return listSujet;
    }

    public void setListSujet(List<SujetForum> listSujet) {
        this.listSujet = listSujet;
    }
    

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur + ", motDePass=" + motDePass + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", tel=" + tel + ", adresse=" + adresse + ", mail=" + mail + ", photo=" + photo + '}';
    }

}
