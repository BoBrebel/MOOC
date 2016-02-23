/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplCoursDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplMatiereDAO;
import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.entities.Matiere;
import com.esprit.pidev.models.enums.Difficulte;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class AddCoursController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label idAddCourLabel;
    @FXML
    private TextField nomAddCourTextField;
    @FXML
    private ComboBox matiereAddCourComboBox;
    @FXML
    private ComboBox <Difficulte> difficulteAddCourComboBox;
    @FXML
    private ImageView badgeAddCourImageView;
    @FXML
    private Label badgeAddCoursLabel;
    @FXML
    private ImageView afficheAddCourImageView;
    @FXML
    private Label afficheAddCoursLabel;
    @FXML
    private TextArea descriptionAddCoursTextArea;
    @FXML
    private Button badgeAddCourButton;
    @FXML
    private Button afficheAddCourButton;
    @FXML
    private Label nomAddCoursLabel;
    @FXML
    private TextField videoAddCoursTextField;
    
    private Image imageBadge;
    private Image imageAffiche;
    
    private Stage dialogStage;
    private Cours cours;
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
    
    public void setCours(Cours cours){
        this.cours=cours;
        ImplMatiereDAO iMatiere = new ImplMatiereDAO();
        nomAddCoursLabel.setText("Ajout nouveau cour");
        imageBadge = new Image("/images/no_image.png");
        imageAffiche = new Image("/images/no_image.png");
        badgeAddCourImageView.setImage(imageBadge);
        badgeAddCoursLabel.setText("no_image.png");
        afficheAddCourImageView.setImage(imageAffiche);
        afficheAddCoursLabel.setText("no_image.png");
        difficulteAddCourComboBox.setItems( FXCollections.observableArrayList( Difficulte.values()));
        try {
            matiereAddCourComboBox.setItems(iMatiere.findMatiereName());
        } catch (SQLException ex) {
            Logger.getLogger(AddCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public boolean isOkClicked() {
        return ajouterClicked;
    }
    
    @FXML
    private void handleAjouter() throws SQLException {
        if (isInputValid()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ajout !!!");
            alert.setContentText("Etes vous sur de bien vouloir ajouter le cours '"+nomAddCourTextField.getText()+"'");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                ImplMatiereDAO iMatiere = new ImplMatiereDAO();
                Matiere M = new Matiere();
                M = iMatiere.findMatiereByName(matiereAddCourComboBox.getValue().toString());
                cours.setNomCours(nomAddCourTextField.getText());
                cours.setDifficulte(difficulteAddCourComboBox.getValue());
                cours.setIdMatiere(M.getIdMatiere());
                cours.setBadge(badgeAddCoursLabel.getText());
                cours.setAffiche(afficheAddCoursLabel.getText());
                cours.setDescriptionCours(descriptionAddCoursTextArea.getText());
                cours.setVideo(videoAddCoursTextField.getText());
                ImplCoursDAO coursDAO = new ImplCoursDAO();
                coursDAO.AjouterCours(cours);
                ajouterClicked = true;
                dialogStage.close();
            }
        }
    }
     @FXML
    private void handleAnnuler() {
        dialogStage.close();
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (nomAddCourTextField.getText() == null || nomAddCourTextField.getText().length() == 0) {
            errorMessage += "Cours Invalide!\n"; 
        }
        if (difficulteAddCourComboBox.getValue() == null) {
            errorMessage += "Difficulté invalide!\n"; 
        }
        if (matiereAddCourComboBox.getValue() == null) {
            errorMessage += "Matière invalide!\n"; 
        }
        if (badgeAddCoursLabel.getText() == null || badgeAddCoursLabel.getText().length() == 0) {
            errorMessage += "Badge invalide!\n"; 
        }
        if (afficheAddCoursLabel.getText() == null || afficheAddCoursLabel.getText().length() == 0) {
            errorMessage += "Affiche invalide!\n"; 
        }
        if (descriptionAddCoursTextArea.getText() == null || descriptionAddCoursTextArea.getText().length() == 0) {
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
