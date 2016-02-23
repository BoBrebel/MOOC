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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class EditObjectifController implements Initializable {
    
    @FXML
    private ComboBox <Difficulte> difficulteEditObjectifComboBox;
    @FXML
    private TextField nomEditObjectifTextField;
    @FXML
    private TextField numeroEditObjectifTextField;
    @FXML
    private TextArea descriptionEditObjectifTextArea;
    private Stage dialogStage;
    private boolean modifierClicked;
    private Objectif objectif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    void setObjectif(Objectif objectif, int idChapitre) {
        this.objectif=objectif;
        this.objectif.setIdChapitre(idChapitre);
        if(objectif.getNom()!=null){
            nomEditObjectifTextField.setText(objectif.getNom());
            numeroEditObjectifTextField.setText(Integer.toString(objectif.getNumero()));
            difficulteEditObjectifComboBox.setItems( FXCollections.observableArrayList( Difficulte.values()));
            difficulteEditObjectifComboBox.setValue(objectif.getDifficulte());
            descriptionEditObjectifTextArea.setText(objectif.getDescription());
        }
    }

    boolean isOkClicked() {
        return modifierClicked;
    }
    @FXML
    private void handleModifier(){
        if (isInputValid()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Modification !!!");
            alert.setContentText("Etes vous sur de bien vouloir modifier le cours '"+nomEditObjectifTextField.getText()+"'");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                objectif.setDifficulte(difficulteEditObjectifComboBox.getValue());
                objectif.setNom(nomEditObjectifTextField.getText());
                objectif.setDescription(descriptionEditObjectifTextArea.getText());
                objectif.setNumero(Integer.parseInt(numeroEditObjectifTextField.getText()));
                
                ImplObjectifDAO objectifDAO = new ImplObjectifDAO();
                objectifDAO.updateObjectif(objectif);
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

        if (nomEditObjectifTextField.getText() == null || nomEditObjectifTextField.getText().length() == 0) {
            errorMessage += "Nom Invalide!\n"; 
        }
        if (!isNumeric(numeroEditObjectifTextField.getText()) || numeroEditObjectifTextField.getText().length()==0 || Integer.parseInt(numeroEditObjectifTextField.getText())==0) {
            errorMessage += "Numéro invalide!\n"; 
        }
        if (isNumeric(numeroEditObjectifTextField.getText())){
            if (chapitreDAO.isNumberThere(Integer.parseInt(numeroEditObjectifTextField.getText()),objectif.getIdChapitre())){
                errorMessage += "Numéro existant!\n";
            }
        }
        if (descriptionEditObjectifTextArea.getText() == null || descriptionEditObjectifTextArea.getText().length()==0) {
            errorMessage += "Description invalide!\n"; 
        }
        if (difficulteEditObjectifComboBox.getValue() == null) {
            errorMessage += "Difficulté invalide!\n"; 
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
