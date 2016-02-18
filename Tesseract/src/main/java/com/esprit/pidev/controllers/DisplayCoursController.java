/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplCoursDAO;
import com.esprit.pidev.models.entities.Cours;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Cours, String> matiereDisplayCourColumn;

    @FXML
    private Label idDisplayCourLabel;
    @FXML
    private Label nomDisplayCourLabel;
    @FXML
    private Label matiereDisplayCourLabel;
    @FXML
    private Label difficulteDisplayCourLabel;
    @FXML
    private Label badgeDisplayCourLabel;
    @FXML
    private Label descriptionDisplayCourLabel;
    
    private ImplCoursDAO mainApp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomDisplayCourColumn.setCellValueFactory(cellData -> cellData.getValue().nomCoursProperty());
        matiereDisplayCourColumn.setCellValueFactory(new PropertyValueFactory("idMatiere"));
    }
    public void setImplCoursDAO(ImplCoursDAO mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        coursDisplayCourTable.setItems(mainApp.findAll());
    }
    
}
