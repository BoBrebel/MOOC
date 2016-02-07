package com.esprit.pidev.models.entities;

public class Administrateur extends Utilisateur {

    private int numTelephoneAdmin;
    private String addresseAdmin;

    public Administrateur(int numTelephoneAdmin, String addresseAdmin, String nomUtilistaur, String prenomUtilisteur, int ageUtilisateur, String loginUtilisateur, String emailUtilisateur, String passwordUtilisateur, String photoUtilisateur, String identifiantUtilisateur) {
        super(nomUtilistaur, prenomUtilisteur, ageUtilisateur, loginUtilisateur, emailUtilisateur, passwordUtilisateur, photoUtilisateur, identifiantUtilisateur);
        this.numTelephoneAdmin = numTelephoneAdmin;
        this.addresseAdmin = addresseAdmin;
    }

    public Administrateur() {
    }

    public int getNumTelephoneAdmin() {
        return numTelephoneAdmin;
    }

    public void setNumTelephoneAdmin(int numTelephoneAdmin) {
        this.numTelephoneAdmin = numTelephoneAdmin;
    }

    public String getAddresseAdmin() {
        return addresseAdmin;
    }

    public void setAddresseAdmin(String addresseAdmin) {
        this.addresseAdmin = addresseAdmin;
    }

    @Override
    public String toString() {
        return "Administrateur{ " + super.toString() + "numTelephoneAdmin=" + numTelephoneAdmin + ", addresseAdmin=" + addresseAdmin + '}';
    }

}
