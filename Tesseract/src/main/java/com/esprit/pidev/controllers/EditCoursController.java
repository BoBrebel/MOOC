/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplCoursDAO;
import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.enums.Difficulte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class EditCoursController implements Initializable {

    @FXML
    private Label idEditCourLabel;
    @FXML
    private TextField nomEditCourTextField;
    @FXML
    private ComboBox <Difficulte> difficulteEditCourComboBox;
    @FXML
    private ImageView badgeEditCourImageView;
    @FXML
    private Label badgeEditCoursLabel;
    @FXML
    private ImageView afficheEditCourImageView;
    @FXML
    private Label afficheEditCoursLabel;
    @FXML
    private TextArea descriptionEditCoursTextArea;
    @FXML
    private Button badgeEditCourButton;
    @FXML
    private Button afficheEditCourButton;
    @FXML
    private Label nomEditCoursLabel;
    
    private Image imageBadge;
    private Image imageAffiche;
    
    private Stage dialogStage;
    private Cours cours;
    private boolean modifierClicked = false;
    
    private static final String CHAR_LIST =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
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
        if (cours.getNomCours()!=null){
            nomEditCoursLabel.setText("Modification '"+cours.getNomCours()+"'");
            imageBadge = new Image("/images/"+cours.getBadge());
            imageAffiche = new Image("/images/"+cours.getAffiche());
            idEditCourLabel.setText(Integer.toString(cours.getIdCours()));
            nomEditCourTextField.setText(cours.getNomCours());
            difficulteEditCourComboBox.setItems( FXCollections.observableArrayList( Difficulte.values()));
            difficulteEditCourComboBox.setValue(cours.getDifficulte());
            badgeEditCourImageView.setImage(imageBadge);
            badgeEditCoursLabel.setText(cours.getBadge());
            afficheEditCourImageView.setImage(imageAffiche);
            afficheEditCoursLabel.setText(cours.getAffiche());
            descriptionEditCoursTextArea.setText(cours.getDescriptionCours());
        }else{
            nomEditCoursLabel.setText("Ajout nouveau cour");
            imageBadge = new Image("/images/no_image.png");
            imageAffiche = new Image("/images/no_image.png");
            badgeEditCourImageView.setImage(imageBadge);
            badgeEditCoursLabel.setText("no_image.png");
            afficheEditCourImageView.setImage(imageAffiche);
            afficheEditCoursLabel.setText("no_image.png");
            difficulteEditCourComboBox.setItems( FXCollections.observableArrayList( Difficulte.values()));
        }
        
        
    }
    public boolean isOkClicked() {
        return modifierClicked;
    }
    
    @FXML
    private void handleModifier() throws SQLException, InterruptedException {
        if (isInputValid()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Modification !!!");
            alert.setContentText("Etes vous sur de bien vouloir modifier le cours '"+nomEditCourTextField.getText()+"'");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                cours.setIdCours(Integer.parseInt(idEditCourLabel.getText()));
                cours.setNomCours(nomEditCourTextField.getText());
                cours.setDifficulte(difficulteEditCourComboBox.getValue());
                cours.setBadge(badgeEditCoursLabel.getText());
                cours.setAffiche(afficheEditCoursLabel.getText());
                cours.setDescriptionCours(descriptionEditCoursTextArea.getText());
                ImplCoursDAO coursDAO = new ImplCoursDAO();
                coursDAO.updateCours(cours, cours.getIdCours());
                modifierClicked = true;
                
                dialogStage.close();
            }
        }
    }
     @FXML
    private void handleAnnuler() {
        dialogStage.close();
    }
    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    @FXML
    private void handleBadgeAdd() throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez une image pour le badge");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        
        File selectedFile = fileChooser.showOpenDialog(null);
        
        badgeEditCoursLabel.setText(selectedFile.getName());
        Image image = new Image(selectedFile.toURI().toString());
        badgeEditCourImageView.setImage(image);
        if(selectedFile!=null){
            String path = selectedFile.getAbsolutePath();
            String ext = path.substring(path.lastIndexOf("."));
            ext=ext.toLowerCase();
            FileChannel in = null;
            FileChannel out = null;
                StringBuffer str = new StringBuffer();
                for(int i=0; i<10; i++){
                    int number = getRandomNumber();
                    char ch = CHAR_LIST.charAt(number);
                    str.append(ch);
                }
            try {
                    // Init
                in = new FileInputStream(selectedFile).getChannel();
                out = new FileOutputStream("src/main/resources/images/"+str+ext).getChannel();

                // Copie depuis le in vers le out
                in.transferTo(0, in.size(), out);
                badgeEditCoursLabel.setText(str+ext);
            } catch (Exception e) {
                e.printStackTrace(); 
            } finally {
                if(in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {}
                }
                if(out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {}
                }
            }
        }

    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (nomEditCourTextField.getText() == null || nomEditCourTextField.getText().length() == 0) {
            errorMessage += "Cours Invalide!\n"; 
        }
        if (difficulteEditCourComboBox.getValue() == null) {
            errorMessage += "Difficulté invalide!\n"; 
        }
        if (badgeEditCoursLabel.getText() == null || badgeEditCoursLabel.getText().length() == 0) {
            errorMessage += "Badge invalide!\n"; 
        }
        if (afficheEditCoursLabel.getText() == null || afficheEditCoursLabel.getText().length() == 0) {
            errorMessage += "Affiche invalide!\n"; 
        }
        if (descriptionEditCoursTextArea.getText() == null || descriptionEditCoursTextArea.getText().length() == 0) {
            errorMessage += "Description invalide!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs Invalide");
            alert.setHeaderText("Veuillez verifier les champs ci dessous");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
}
