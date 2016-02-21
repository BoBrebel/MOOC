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
import com.esprit.pidev.tesseract.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class DisplayCoursController implements Initializable {

    @FXML
    private TableView<Cours> coursDisplayCourTable;
    @FXML
    private TableColumn<Cours, String> nomDisplayCourColumn;
    @FXML
    private TableColumn<Cours, String> difficulteDisplayCourColumn;

    @FXML
    private Label idDisplayCourLabel;
    @FXML
    private Label nomDisplayCourLabel;
    @FXML
    private Label matiereDisplayCourLabel;
    @FXML
    private Label difficulteDisplayCourLabel;
    @FXML
    private ImageView badgeDisplayCourImageView = new ImageView();
    @FXML
    private Label descriptionDisplayCourLabel;
    
    private ImplCoursDAO coursDAO;
    private Window primaryStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coursDAO=new ImplCoursDAO();
        coursDisplayCourTable.setItems(coursDAO.findAll());
        nomDisplayCourColumn.setCellValueFactory(cellData -> cellData.getValue().nomCoursProperty());
        difficulteDisplayCourColumn.setCellValueFactory(cellData -> cellData.getValue().difficulteProperty().asString());
        showCoursDetails(null);
        coursDisplayCourTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showCoursDetails(newValue));
    }
    private void showCoursDetails(Cours cours) {
        Image imageBadge;
        if (cours != null) {
            ImplMatiereDAO matiereDAO = new ImplMatiereDAO();
            Matiere matiere = new Matiere();
            try {
                matiere=matiereDAO.findMatiereById(cours.getIdMatiere());
            } catch (SQLException ex) {
                Logger.getLogger(DisplayCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Fill the labels with info from the cours object.
            idDisplayCourLabel.setText(Integer.toString(cours.getIdCours()));
            nomDisplayCourLabel.setText(cours.getNomCours());
            matiereDisplayCourLabel.setText(matiere.getNomMatiere());
            difficulteDisplayCourLabel.setText(cours.getDifficulte().toString());
            imageBadge = new Image("/images/"+cours.getBadge());
            badgeDisplayCourImageView.setImage(imageBadge);
            descriptionDisplayCourLabel.setText(cours.getDescriptionCours());

        } else {
            // Cours is null, remove all the text.
            imageBadge = new Image("/images/no_image.png");
            idDisplayCourLabel.setText("-");
            nomDisplayCourLabel.setText("-");
            matiereDisplayCourLabel.setText("-");
            difficulteDisplayCourLabel.setText("-");
            badgeDisplayCourImageView.setImage(imageBadge);
            descriptionDisplayCourLabel.setText("-");
        }
    }
    public boolean showCoursEditDialog(Cours cours) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/editCours.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Cours");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the cours into the controller.
            EditCoursController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCours(cours);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showCoursAddDialog(Cours cours) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/addCours.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter un Cours");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the cours into the controller.
            AddCoursController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCours(cours);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleAddCours() throws SQLException {
        Cours tempCours = new Cours();
        ImplCoursDAO iCours= new ImplCoursDAO();
        boolean ajouterClicked = showCoursAddDialog(tempCours);
        if (ajouterClicked) {
            coursDAO=new ImplCoursDAO();
            coursDisplayCourTable.setItems(coursDAO.findAll());
            nomDisplayCourColumn.setCellValueFactory(cellData -> cellData.getValue().nomCoursProperty());
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected cours.
     */
    @FXML
    private void handleEditCours(){
        Cours selectedCours = coursDisplayCourTable.getSelectionModel().getSelectedItem();
        if (selectedCours != null) {
            boolean modifierClicked = showCoursEditDialog(selectedCours);
            if (modifierClicked) {
                showCoursDetails(selectedCours);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Cours Selected");
            alert.setContentText("Please select a cours in the table.");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleDeleteCours() throws SQLException {
        int selectedIndex = coursDisplayCourTable.getSelectionModel().getSelectedIndex();
        Cours cours = new Cours();
        cours=coursDisplayCourTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Suppression !!!");
            alert.setHeaderText("Etes-vous sur de bien vouloir supprimer '"+cours.getNomCours()+"'");
            //alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                coursDisplayCourTable.getItems().remove(selectedIndex);
                coursDAO=new ImplCoursDAO();
                coursDAO.deleteCoursById(cours.getIdCours());
            }
            
        }
    }
    
    @FXML
    private void handleAfficherChapitre(){
        Cours selectedCours = coursDisplayCourTable.getSelectionModel().getSelectedItem();
        if (selectedCours != null) {
            showChapitreDialog(Integer.parseInt(idDisplayCourLabel.getText()));
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Chapitre Selected");
            alert.setContentText("Please select a cours in the table.");

            alert.showAndWait();
        }
        
    }

    private void showChapitreDialog(int id) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            System.out.println("hello");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/displayChapitre.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Chapitres");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the cours into the controller.
            DisplayChapitreController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setChapitres(id);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
