package com.esprit.pidev.models.entities;

public class Formateur extends Utilisateur {

    private String curriculumVitaeFormateur;
    private int StageFormateur;
    private int ScoreFormateur;

    public Formateur(String curriculumVitaeFormateur, int StageFormateur, int ScoreFormateur, String nomUtilistaur, String prenomUtilisteur, int ageUtilisateur, String loginUtilisateur, String emailUtilisateur, String passwordUtilisateur, String photoUtilisateur, String identifiantUtilisateur) {
        super(nomUtilistaur, prenomUtilisteur, ageUtilisateur, loginUtilisateur, emailUtilisateur, passwordUtilisateur, photoUtilisateur, identifiantUtilisateur);
        this.curriculumVitaeFormateur = curriculumVitaeFormateur;
        this.StageFormateur = StageFormateur;
        this.ScoreFormateur = ScoreFormateur;
    }

    public Formateur() {
    }

    public String getCurriculumVitaeFormateur() {
        return curriculumVitaeFormateur;
    }

    public void setCurriculumVitaeFormateur(String curriculumVitaeFormateur) {
        this.curriculumVitaeFormateur = curriculumVitaeFormateur;
    }

    public int getStageFormateur() {
        return StageFormateur;
    }

    public void setStageFormateur(int StageFormateur) {
        this.StageFormateur = StageFormateur;
    }

    public int getScoreFormateur() {
        return ScoreFormateur;
    }

    public void setScoreFormateur(int ScoreFormateur) {
        this.ScoreFormateur = ScoreFormateur;
    }

    @Override
    public String toString() {
        return "Formateur{" + super.toString() + "curriculumVitaeFormateur=" + curriculumVitaeFormateur + ", StageFormateur=" + StageFormateur + ", ScoreFormateur=" + ScoreFormateur + '}';
    }

}
