/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplChapitreDAO;
import com.esprit.pidev.models.entities.Chapitre;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class EditChapitreController implements Initializable {
    private Stage dialogStage;
    private boolean modifierClicked = false;
    private Chapitre chapitre;
    @FXML
    private TextField nomEditChapitreTextField;
    @FXML
    private TextField numeroEditChapitreTextField;
    @FXML
    private TextArea resumeEditChapitreTextArea;
    @FXML
    private TextArea descriptionEditChapitreTextArea;

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
    public boolean isOkClicked() {
        return modifierClicked;
    }
    void setChapitre(Chapitre chapitre, int id) {
        this.chapitre=chapitre;
        this.chapitre.setIdCours(id);
        if (chapitre.getNom()!=null){
            nomEditChapitreTextField.setText(chapitre.getNom());
            numeroEditChapitreTextField.setText(Integer.toString(chapitre.getNumero()));
            resumeEditChapitreTextArea.setText(chapitre.getResume());
            descriptionEditChapitreTextArea.setText(chapitre.getDescription());
        }
    }
    
    @FXML
    private void handleModifier() throws SQLException, InterruptedException {
        if (isInputValid()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Modification !!!");
            alert.setContentText("Etes vous sur de bien vouloir modifier le chapitre '"+nomEditChapitreTextField.getText()+"'");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                chapitre.setNom(nomEditChapitreTextField.getText());
                chapitre.setNumero(Integer.parseInt(numeroEditChapitreTextField.getText()));
                chapitre.setDescription(descriptionEditChapitreTextArea.getText());
                chapitre.setResume(resumeEditChapitreTextArea.getText());
                ImplChapitreDAO chapitreDAO = new ImplChapitreDAO();
                chapitreDAO.updateChapitre(chapitre);
                modifierClicked = true;
                
                dialogStage.close();
            }
        }
    }
    @FXML
    private void handleAnnuler() {
        dialogStage.close();
    }
    
    public static boolean isNumeric(String str){
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    private boolean isInputValid() {
        String errorMessage = "";
        ImplChapitreDAO chapitreDAO = new ImplChapitreDAO();

        if (nomEditChapitreTextField.getText() == null || nomEditChapitreTextField.getText().length() == 0) {
            errorMessage += "Nom Invalide!\n"; 
        }
        if (!isNumeric(numeroEditChapitreTextField.getText()) || numeroEditChapitreTextField.getText().length()==0 || Integer.parseInt(numeroEditChapitreTextField.getText())==0) {
            errorMessage += "Numéro invalide!\n"; 
        }
        if (chapitreDAO.isNumberThere(Integer.parseInt(numeroEditChapitreTextField.getText()),chapitre.getIdCours())){
            errorMessage += "Numéro existant!\n";
        }
        if (descriptionEditChapitreTextArea.getText() == null || descriptionEditChapitreTextArea.getText().length()==0) {
            errorMessage += "Description invalide!\n"; 
        }
        if (resumeEditChapitreTextArea.getText() == null || resumeEditChapitreTextArea.getText().length()==0) {
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
