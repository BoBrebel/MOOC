/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplCoursDAO;
import com.esprit.pidev.models.entities.Cours;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    private ImplCoursDAO coursDAO;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coursDAO=new ImplCoursDAO();
        coursDisplayCourTable.setItems(coursDAO.findAll());
        nomDisplayCourColumn.setCellValueFactory(cellData -> cellData.getValue().nomCoursProperty());
        matiereDisplayCourColumn.setCellValueFactory(new PropertyValueFactory("idMatiere"));
    }
        // Add observable list data to the table
        
    
    
}
