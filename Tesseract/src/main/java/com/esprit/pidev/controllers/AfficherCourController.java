/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplChapitreDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplCoursDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplMatiereDAO;
import com.esprit.pidev.models.entities.Chapitre;
import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.entities.Matiere;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class AfficherCourController implements Initializable {
    private Stage dialogStage;
    @FXML
    WebView webview = new WebView();
    @FXML
    private Label descriptionAffichageLabel;
    @FXML
    private Label nomCourAfficherLabel;
    @FXML
    private TableView<Chapitre> chapitreDisplayChapitreTable;
    @FXML
    private TableColumn<Chapitre, String> nomDisplayChapitreColumn;
    @FXML
    private TableColumn<Chapitre, String> numeroDisplayChapitreColumn;
    @FXML
    private Label matiereAffichageLabel;
    @FXML
    private ImageView imageV = new ImageView();
    @FXML
    private WebView videoCourAfficherWebView = new WebView();
    private WebEngine we =videoCourAfficherWebView.getEngine();
    Image imageBadge;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setCour(2);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCourController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    private void setCour(int i) throws SQLException {
        ImplCoursDAO courDAO = new ImplCoursDAO();
        Cours cour = new Cours();
        cour = courDAO.findCoursById(i);
        nomCourAfficherLabel.setText(cour.getNomCours());
        ImplChapitreDAO chapitreDAO=new ImplChapitreDAO();
        ImplMatiereDAO matiereDAO = new ImplMatiereDAO();
        Matiere matiere = new Matiere();
        matiere=matiereDAO.findMatiereById(cour.getIdMatiere());
        chapitreDisplayChapitreTable.setItems(chapitreDAO.displayChapitre(cour.getIdCours()));
        nomDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NomProperty());
        numeroDisplayChapitreColumn.setCellValueFactory(cellData -> cellData.getValue().NumeroProperty().asString());
        descriptionAffichageLabel.setText("Description :\n"+cour.getDescriptionCours());
        matiereAffichageLabel.setText(matiere.getNomMatiere());
        webview.getEngine().load(cour.getVideo());
        imageBadge = new Image("/images/"+cour.getBadge());
        imageV.setImage(imageBadge);
    }
    
}
