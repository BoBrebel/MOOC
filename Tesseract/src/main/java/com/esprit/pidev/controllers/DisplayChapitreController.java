/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplChapitreDAO;
import com.esprit.pidev.models.entities.Chapitre;
import java.net.URL;
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
    public void setChapitres(int id){
        chapitreDAO=new ImplChapitreDAO();
        chapitreDisplayChapitreTable.setItems(chapitreDAO.displayChapitre(id));
        nomDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NomProperty());
        numeroDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NumeroProperty().asString());
        showChapitreDetails(null);
        chapitreDisplayChapitreTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showChapitreDetails(newValue));
    }
    private void showChapitreDetails(Chapitre chapitre) {
        if (chapitre != null) {
            // Fill the labels with info from the cours object.
            idDisplayChapitreLabel.setText(Integer.toString(chapitre.getId()));
            nomDisplayChapitreLabel.setText(chapitre.getNom());
            descriptionDisplayChapitreLabel.setText(chapitre.getDescription());
            resumeDisplayChapitreLabel.setText(chapitre.getResume());

        } else {
            // Cours is null, remove all the text.
            idDisplayChapitreLabel.setText("-");
            nomDisplayChapitreLabel.setText("-");
            descriptionDisplayChapitreLabel.setText("-");
            resumeDisplayChapitreLabel.setText("-");
        }
    }
    
}
