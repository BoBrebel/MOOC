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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        Image image;
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
            image = new Image("/images/"+cours.getBadge());
            badgeDisplayCourImageView.setImage(image);
            descriptionDisplayCourLabel.setText(cours.getDescriptionCours());

        } else {
            // Cours is null, remove all the text.
            image = new Image("/images/no_image.png");
            idDisplayCourLabel.setText("-");
            nomDisplayCourLabel.setText("-");
            matiereDisplayCourLabel.setText("-");
            difficulteDisplayCourLabel.setText("-");
            badgeDisplayCourImageView.setImage(image);
            descriptionDisplayCourLabel.setText("-");
        }
    }
    @FXML
    private void handleDeleteCours() throws SQLException {
        int selectedIndex = coursDisplayCourTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            coursDisplayCourTable.getItems().remove(selectedIndex);
            Cours cours = new Cours();
            cours=coursDisplayCourTable.getSelectionModel().getSelectedItem();
            coursDAO=new ImplCoursDAO();
            coursDAO.deleteCoursById(cours.getIdCours());
            
        }
    }

    
}
