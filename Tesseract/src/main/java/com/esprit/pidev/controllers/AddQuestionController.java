/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplEpreuveObjectifDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplQuestionDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplReponseDAO;
import com.esprit.pidev.models.entities.EpreuveObjectif;
import com.esprit.pidev.models.entities.Question;
import com.esprit.pidev.models.entities.Reponse;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class AddQuestionController implements Initializable {

    @FXML
    private TextField questionAddQuizTextField;
    @FXML
    private TextField choix1AddQuizTextField;
    @FXML
    private TextField choix2AddQuizTextField;
    @FXML
    private TextField choix3AddQuizTextField;
    @FXML
    private TextField choix4AddQuizTextField;
    @FXML
    private TextArea justification1AddQuizTextArea;
    @FXML
    private TextArea justification2AddQuizTextArea;
    @FXML
    private TextArea justification3AddQuizTextArea;
    @FXML
    private TextArea justification4AddQuizTextArea;
    @FXML
    private CheckBox choix1CheckBox;
    @FXML
    private CheckBox choix2CheckBox;
    @FXML
    private CheckBox choix3CheckBox;
    @FXML
    private CheckBox choix4CheckBox;

    private Stage dialogStage;
    private boolean ajouterClicked;
    private Question question;
    private int idEpreuve;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    void setQuestion(Question temp, int idQuiz) {
        this.question = temp;
        question.setIdEpreuve(idQuiz);
        idEpreuve=idQuiz;
        System.out.println(idQuiz+"!!!!!!!!!!!!!!!!!!!!!"+temp.getIdEpreuve());
    }

    boolean isOkClicked() {
        return ajouterClicked;
    }

    @FXML
    private void handleAjouter() {
        if (isInputValid()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ajout !!!");
            alert.setContentText("Etes vous sur de bien vouloir ajouter la question '" + questionAddQuizTextField.getText() + "'");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                
                
                question.setIdEpreuve(idEpreuve);
                question.setQuestion(questionAddQuizTextField.getText());
                ImplQuestionDAO questionDAO = new ImplQuestionDAO();
                int idQuestion = questionDAO.createQuestion(question);
                System.out.println(idQuestion+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                ImplReponseDAO reponseDAO = new ImplReponseDAO();
                boolean ch1 = choix1CheckBox.isSelected();
                boolean ch2 = choix2CheckBox.isSelected();
                boolean ch3 = choix3CheckBox.isSelected();
                boolean ch4 = choix4CheckBox.isSelected();

                for (int i = 0; i < 4; i++) {
                    Reponse r = new Reponse();
                    r.setIdQuestion(idQuestion);
                    switch (i) {
                        case 0:
                            r.setReponse(choix1AddQuizTextField.getText());
                            r.setJustification(justification1AddQuizTextArea.getText());
                            if (ch1) {
                                r.setEtat("vrai");
                            }
                            break;
                        case 1:
                            r.setReponse(choix2AddQuizTextField.getText());
                            r.setJustification(justification2AddQuizTextArea.getText());
                            if (ch2) {
                                r.setEtat("vrai");
                            }
                            break;
                        case 2:
                            r.setReponse(choix3AddQuizTextField.getText());
                            r.setJustification(justification3AddQuizTextArea.getText());
                            if (ch3) {
                                r.setEtat("vrai");
                            }
                            break;
                        case 3:
                            r.setReponse(choix4AddQuizTextField.getText());
                            r.setJustification(justification4AddQuizTextArea.getText());
                            if (ch4) {
                                r.setEtat("vrai");
                            }
                            break;
                    }
                    reponseDAO.createReponse(r);

                }
                ajouterClicked = true;
                dialogStage.close();
            }
        }
    }

    @FXML
    private void handleAnnuler() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (questionAddQuizTextField.getText() == null || questionAddQuizTextField.getText().length() == 0) {
            errorMessage += "Question Invalide!\n";
        }
        if (choix1AddQuizTextField.getText() == null || choix1AddQuizTextField.getText().length() == 0) {
            errorMessage += "Choix 1 invalide!\n";
        }
        if (choix2AddQuizTextField.getText() == null || choix2AddQuizTextField.getText().length() == 0) {
            errorMessage += "Choix 2 invalide!\n";
        }
        if (choix3AddQuizTextField.getText() == null || choix3AddQuizTextField.getText().length() == 0) {
            errorMessage += "Choix 3 invalide!\n";
        }
        if (choix4AddQuizTextField.getText() == null || choix4AddQuizTextField.getText().length() == 0) {
            errorMessage += "Choix 4 invalide!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs Invalide");
            alert.setHeaderText("Veuillez verifier les champs ci dessous");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
