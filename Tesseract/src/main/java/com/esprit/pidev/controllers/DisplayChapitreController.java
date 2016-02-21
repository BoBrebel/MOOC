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
    }
    
}
