/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplObjectifDAO;
import com.esprit.pidev.models.entities.Objectif;
import com.esprit.pidev.tesseract.MainApp;
import java.io.IOException;
import java.net.URL;
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
public class DisplayObjectifController implements Initializable {
    private Stage dialogStage;
    @FXML
    private TableView<Objectif> objectifDisplayObjectifTable;
    @FXML
    private TableColumn<Objectif, String> nomDisplayObjectifColumn;
    @FXML
    private TableColumn<Objectif, String> numeroDisplayObjectifColumn;
    @FXML
    private Label nomDisplayObjectifLabel;
    @FXML
    private Label numeroDisplayObjectifLabel;
    @FXML
    private Label descriptionDisplayObjectifLabel;
    @FXML
    private Label difficulteDisplayObjectifLabel;
    
    private int idChapitre;
    private ImplObjectifDAO objectifDAO;
    private Window primaryStage;

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
    
    public void setObjectif(int id){
        this.idChapitre=id;
        objectifDAO=new ImplObjectifDAO();
        objectifDisplayObjectifTable.setItems(objectifDAO.displayObjectifs(id));
        nomDisplayObjectifColumn.setCellValueFactory(cellData -> cellData.getValue().NomProperty());
        numeroDisplayObjectifColumn.setCellValueFactory(cellData -> cellData.getValue().NumeroProperty().asString());
        showObjectifDetails(null);
        objectifDisplayObjectifTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showObjectifDetails(newValue));
    }
    
    private void showObjectifDetails(Objectif objectif) {
        if (objectif != null) {
            // Fill the labels with info from the chapitre object.
            nomDisplayObjectifLabel.setText(objectif.getNom());
            numeroDisplayObjectifLabel.setText(Integer.toString(objectif.getNumero()));
            descriptionDisplayObjectifLabel.setText(objectif.getDescription());
            difficulteDisplayObjectifLabel.setText(objectif.getDifficulte().toString());

        } else {
            // Cours is null, remove all the text.
            nomDisplayObjectifLabel.setText("-");
            numeroDisplayObjectifLabel.setText("-");
            descriptionDisplayObjectifLabel.setText("-");
            difficulteDisplayObjectifLabel.setText("-");
        }
    }
    
    @FXML
    private void handleDeleteObjectif(){
        int selectedIndex = objectifDisplayObjectifTable.getSelectionModel().getSelectedIndex();
        Objectif objectif = new Objectif();
        objectif=objectifDisplayObjectifTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Suppression !!!");
            alert.setHeaderText("Etes-vous sur de bien vouloir supprimer '"+objectif.getNom()+"'");
            //alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                objectifDisplayObjectifTable.getItems().remove(selectedIndex);
                objectifDAO=new ImplObjectifDAO();
                objectifDAO.deleteObjectif(objectif.getId());
            }
        }
    }
    @FXML
    private void handleAddObjectif(){
        Objectif temp = new Objectif();
        ImplObjectifDAO iObjectif = new ImplObjectifDAO();
        boolean ajouterClicked = showObjectifAddDialog(temp, idChapitre);
        if(ajouterClicked){
            objectifDAO = new ImplObjectifDAO();
            objectifDisplayObjectifTable.setItems(objectifDAO.displayObjectifs(idChapitre));
            nomDisplayObjectifColumn.setCellValueFactory(cellData -> cellData.getValue().NomProperty());
            numeroDisplayObjectifColumn.setCellValueFactory(cellData -> cellData.getValue().NumeroProperty().asString());
            showObjectifDetails(null);
            objectifDisplayObjectifTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showObjectifDetails(newValue));
        }
        
    }

    private boolean showObjectifAddDialog(Objectif objectif, int id) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/addObjectif.fxml"));
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
            AddObjectifController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setObjectif(objectif, id);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
