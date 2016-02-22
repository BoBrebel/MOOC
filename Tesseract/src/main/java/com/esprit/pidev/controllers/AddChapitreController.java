/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplChapitreDAO;
import com.esprit.pidev.models.entities.Chapitre;
import com.sun.xml.internal.ws.util.StringUtils;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class AddChapitreController implements Initializable {
    @FXML
    private Label idCoursAddChapitreLabel;
    @FXML
    private TextField nomAddChapitreTextField;
    @FXML
    private TextField numeroAddChapitreTextField;
    @FXML
    private TextArea descriptionAddChapitreTextArea;
    @FXML
    private TextArea resumeAddChapitreTextArea;
    
    private Stage dialogStage;
    private Chapitre chapitre;
    private boolean ajouterClicked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setChapitre(Chapitre chapitre,int id){
        this.chapitre=chapitre;
        System.out.println(id);
        chapitre.setIdCours(id);
        System.out.println(chapitre.getIdCours());
    }
    public boolean isOkClicked() {
        return ajouterClicked;
    }
    @FXML
    private void handleAjouter(){
        if (isInputValid()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ajout !!!");
            alert.setContentText("Etes vous sur de bien vouloir ajouter le cours '"+nomAddChapitreTextField.getText()+"'");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                chapitre.setNom(nomAddChapitreTextField.getText());
                chapitre.setNumero(Integer.parseInt(numeroAddChapitreTextField.getText()));
                chapitre.setDescription(descriptionAddChapitreTextArea.getText());
                chapitre.setResume(resumeAddChapitreTextArea.getText());
                ImplChapitreDAO chapitreDAO = new ImplChapitreDAO();
                chapitreDAO.addChapitre(chapitre);
                ajouterClicked = true;
                dialogStage.close();
            }
        }
    }
    @FXML
    private void handleAnnuler() {
        dialogStage.close();
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    private boolean isInputValid() {
        String errorMessage = "";
        ImplChapitreDAO chapitreDAO = new ImplChapitreDAO();

        if (nomAddChapitreTextField.getText() == null || nomAddChapitreTextField.getText().length() == 0) {
            errorMessage += "Nom Invalide!\n"; 
        }
        if (!isNumeric(numeroAddChapitreTextField.getText()) || numeroAddChapitreTextField.getText().length()==0 || Integer.parseInt(numeroAddChapitreTextField.getText())==0) {
            errorMessage += "Numéro invalide!\n"; 
        }
        if (chapitreDAO.isNumberThere(Integer.parseInt(numeroAddChapitreTextField.getText()),chapitre.getIdCours())){
            errorMessage += "Numéro existant!\n";
        }
        if (descriptionAddChapitreTextArea.getText() == null || descriptionAddChapitreTextArea.getText().length()==0) {
            errorMessage += "Description invalide!\n"; 
        }
        if (resumeAddChapitreTextArea.getText() == null || resumeAddChapitreTextArea.getText().length()==0) {
            errorMessage += "Resume invalide!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs Invalide");
            alert.setHeaderText("Veuillez verifier les champs ci dessous");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
    
}
