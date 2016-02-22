/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplObjectifDAO;
import com.esprit.pidev.models.entities.Objectif;
import com.esprit.pidev.models.enums.Difficulte;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class AddObjectifController implements Initializable {
    @FXML
    private Label idCoursAddObjectifLabel;
    @FXML
    private TextField nomAddObjectifTextField;
    @FXML
    private TextField numeroAddObjectifTextField;
    @FXML
    private TextArea descriptionAddObjectifTextArea;
    @FXML
    private ComboBox <Difficulte> difficulteAddObjectifComboBox;
    
    private Stage dialogStage;
    private boolean ajouterClicked = false;
    private Objectif objectif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setDialogStage(Stage dialogStage) {
        this.dialogStage=dialogStage;
    }

    void setObjectif(Objectif objectif, int id) {
        this.objectif=objectif;
        objectif.setIdChapitre(id);
        difficulteAddObjectifComboBox.setItems( FXCollections.observableArrayList( Difficulte.values()));
    }

    boolean isOkClicked() {
        return ajouterClicked;
    }
    
    @FXML
    private void handleAjouter(){
        if (isInputValid()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ajout !!!");
            alert.setContentText("Etes vous sur de bien vouloir ajouter le cours '"+nomAddObjectifTextField.getText()+"'");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                objectif.setNom(nomAddObjectifTextField.getText());
                objectif.setNumero(Integer.parseInt(numeroAddObjectifTextField.getText()));
                objectif.setDescription(descriptionAddObjectifTextArea.getText());
                objectif.setDifficulte(difficulteAddObjectifComboBox.getValue());
                ImplObjectifDAO objectifDAO = new ImplObjectifDAO();
                objectifDAO.addObjectif(objectif);
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
        ImplObjectifDAO chapitreDAO = new ImplObjectifDAO();

        if (nomAddObjectifTextField.getText() == null || nomAddObjectifTextField.getText().length() == 0) {
            errorMessage += "Nom Invalide!\n"; 
        }
        if (!isNumeric(numeroAddObjectifTextField.getText()) || numeroAddObjectifTextField.getText().length()==0 || Integer.parseInt(numeroAddObjectifTextField.getText())==0) {
            errorMessage += "Numéro invalide!\n"; 
        }
        if (chapitreDAO.isNumberThere(Integer.parseInt(numeroAddObjectifTextField.getText()),objectif.getIdChapitre())){
            errorMessage += "Numéro existant!\n";
        }
        if (descriptionAddObjectifTextArea.getText() == null || descriptionAddObjectifTextArea.getText().length()==0) {
            errorMessage += "Description invalide!\n"; 
        }
        if (descriptionAddObjectifTextArea.getText() == null || descriptionAddObjectifTextArea.getText().length() == 0) {
            errorMessage += "Description invalide!\n"; 
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
