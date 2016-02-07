
package com.esprit.pidev.models.entities;


public class MembreComitePedago extends Utilisateur{
    private int numeroCoursAccepter ;
    private String addresse ;

    public MembreComitePedago(int numeroCoursAccepter, String addresse, String nomUtilistaur, String prenomUtilisteur, int ageUtilisateur, String loginUtilisateur, String emailUtilisateur, String passwordUtilisateur, String photoUtilisateur, String identifiantUtilisateur) {
        super(nomUtilistaur, prenomUtilisteur, ageUtilisateur, loginUtilisateur, emailUtilisateur, passwordUtilisateur, photoUtilisateur, identifiantUtilisateur);
        this.numeroCoursAccepter = numeroCoursAccepter;
        this.addresse = addresse;
    }

    public MembreComitePedago() {
    }

    public int getNumeroCoursAccepter() {
        return numeroCoursAccepter;
    }

    public void setNumeroCoursAccepter(int numeroCoursAccepter) {
        this.numeroCoursAccepter = numeroCoursAccepter;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "MembreComitePedago{"+super.toString() + "numeroCoursAccepter=" + numeroCoursAccepter + ", addresse=" + addresse + '}';
    }

    
    
}
