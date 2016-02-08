/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.entities;

public class BanForum {

    private int idBan;
    private int idUtilisateur;
    private String dateBan;
    private int duree;
    private Utilisateur utilisateur ;

    public BanForum() {
    }

    public BanForum(String dateBan, int duree, Utilisateur utilisateur) {
        this.dateBan = dateBan;
        this.duree = duree;
        this.utilisateur = utilisateur;
    }

    public BanForum(int idBan, int idUtilisateur, String dateBan, int duree, Utilisateur utilisateur) {
        this.idBan = idBan;
        this.idUtilisateur = idUtilisateur;
        this.dateBan = dateBan;
        this.duree = duree;
        this.utilisateur = utilisateur;
    }
    

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getDateBan() {
        return dateBan;
    }

    public void setDateBan(String dateBan) {
        this.dateBan = dateBan;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idBan;
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
        final BanForum other = (BanForum) obj;
        if (this.idBan != other.idBan) {
            return false;
        }
        return true;
    }
  
    @Override
    public String toString() {
        return "BanForum{" + "idBan=" + idBan + ", idUtilisateur=" + idUtilisateur + ", dateBan=" + dateBan + ", duree=" + duree + ", utilisateur=" + utilisateur + '}';
    }
    
    

}
