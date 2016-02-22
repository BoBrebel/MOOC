/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplChapitreDAO;
import com.esprit.pidev.models.entities.Chapitre;
import com.esprit.pidev.tesseract.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
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
public class DisplayChapitreController implements Initializable {
    private Stage dialogStage;
    @FXML
    private TableView<Chapitre> chapitreDisplayChapitreTable;
    @FXML
    private TableColumn<Chapitre, String> nomDisplayChapitreColumn;
    @FXML
    private TableColumn<Chapitre, String> numeroDisplayChapitreColumn;

    @FXML
    private Label idDisplayChapitreLabel;
    @FXML
    private Label nomDisplayChapitreLabel;
    @FXML
    private Label numeroDisplayChapitreLabel;
    @FXML
    private Label resumeDisplayChapitreLabel;
    @FXML
    private Label descriptionDisplayChapitreLabel;

    private ImplChapitreDAO chapitreDAO;
    private Window primaryStage;
    private int idCours;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setChapitres(int id){
        this.idCours=id;
        chapitreDAO=new ImplChapitreDAO();
        chapitreDisplayChapitreTable.setItems(chapitreDAO.displayChapitre(id));
        nomDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NomProperty());
        numeroDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NumeroProperty().asString());
        showChapitreDetails(null);
        chapitreDisplayChapitreTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showChapitreDetails(newValue));
    }
    private void showChapitreDetails(Chapitre chapitre) {
        if (chapitre != null) {
            // Fill the labels with info from the chapitre object.
            idDisplayChapitreLabel.setText(Integer.toString(chapitre.getId()));
            nomDisplayChapitreLabel.setText(chapitre.getNom());
            numeroDisplayChapitreLabel.setText(Integer.toString(chapitre.getNumero()));
            descriptionDisplayChapitreLabel.setText(chapitre.getDescription());
            resumeDisplayChapitreLabel.setText(chapitre.getResume());

        } else {
            // Cours is null, remove all the text.
            idDisplayChapitreLabel.setText("-");
            nomDisplayChapitreLabel.setText("-");
            numeroDisplayChapitreLabel.setText("-");
            descriptionDisplayChapitreLabel.setText("-");
            resumeDisplayChapitreLabel.setText("-");
        }
    }
    public boolean showChapitreAddDialog(Chapitre chapitre, int id) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/addChapitre.fxml"));
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
            AddChapitreController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setChapitre(chapitre, id);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @FXML
    private void handleDeleteChapitre() throws SQLException {
        int selectedIndex = chapitreDisplayChapitreTable.getSelectionModel().getSelectedIndex();
        Chapitre chapitre = new Chapitre();
        chapitre=chapitreDisplayChapitreTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Suppression !!!");
            alert.setHeaderText("Etes-vous sur de bien vouloir supprimer '"+chapitre.getNom()+"'");
            //alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                chapitreDisplayChapitreTable.getItems().remove(selectedIndex);
                chapitreDAO=new ImplChapitreDAO();
                chapitreDAO.deleteChapitre(chapitre.getId());
            }
        }
    }
    @FXML
    private void handleAddChapitre() throws SQLException {
        Chapitre temp = new Chapitre();
        ImplChapitreDAO iChapitre= new ImplChapitreDAO();
        boolean ajouterClicked = showChapitreAddDialog(temp,idCours);
        if (ajouterClicked) {
            chapitreDAO=new ImplChapitreDAO();
            chapitreDisplayChapitreTable.setItems(chapitreDAO.displayChapitre(temp.getIdCours()));
            nomDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NomProperty());
            numeroDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NumeroProperty().asString());
            showChapitreDetails(null);
            chapitreDisplayChapitreTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showChapitreDetails(newValue));
        }
    }
    @FXML
    private void handleEditChapitre(){
        Chapitre selectedChapitre = chapitreDisplayChapitreTable.getSelectionModel().getSelectedItem();
        if (selectedChapitre != null) {
            boolean modifierClicked = showChapitreEditDialog(selectedChapitre);
            if (modifierClicked) {
                showChapitreDetails(selectedChapitre);
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

    private boolean showChapitreEditDialog(Chapitre chapitre) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/editChapitre.fxml"));
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
            EditChapitreController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setChapitre(chapitre, idCours);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
