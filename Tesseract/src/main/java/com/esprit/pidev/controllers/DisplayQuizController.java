/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplEpreuveEntrainementDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplEpreuveObjectifDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplQuestionDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplReponseDAO;
import com.esprit.pidev.models.entities.EpreuveEntrainement;
import com.esprit.pidev.models.entities.EpreuveObjectif;
import com.esprit.pidev.models.entities.Question;
import com.esprit.pidev.models.entities.Reponse;
import com.esprit.pidev.tesseract.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.Window;
/**
 * FXML Controller class
 *
 * @author Bacem
 */
public class DisplayQuizController implements Initializable {

    @FXML
    private TableView <Question> quizDisplayQuizTable;
    @FXML
    private TableColumn<Question, String> questionDisplayQuestionColumn;
    @FXML
    private Label textDisplayQuizLabel;
    @FXML
    private Label choix1DisplayQuizLabel;
    @FXML
    private Label choix2DisplayQuizLabel;
    @FXML
    private Label choix3DisplayQuizLabel;
    @FXML
    private Label choix4DisplayQuizLabel;
    
    @FXML
    private Label justification1DisplayQuizLabel;
    
    @FXML
    private Label justification2DisplayQuizLabel;
    
    @FXML
    private Label justification3DisplayQuizLabel;
    
    @FXML
    private Label justification4DisplayQuizLabel;
    
    @FXML
    private ImageView choix1DisplayQuizImageView;
    @FXML
    private ImageView choix2DisplayQuizImageView;
    @FXML
    private ImageView choix3DisplayQuizImageView;
    @FXML
    private ImageView choix4DisplayQuizImageView;
    
    private Stage dialogStage;
    private int idObjectif;
    private ImplEpreuveObjectifDAO quizDAO;
    private ImplQuestionDAO questionDAO;
    private int idQuiz;
    private Window primaryStage;
    
    private Image tick = new Image("/images/tick.png");
    
    
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
    void setQuiz(int id) {
        this.idObjectif=id;
        quizDAO = new ImplEpreuveObjectifDAO();
        EpreuveObjectif quiz = new EpreuveObjectif();
        quiz = quizDAO.searchEpreuveObjectif(id);
        idQuiz = quiz.getId();
        
        questionDAO = new ImplQuestionDAO();
        quizDisplayQuizTable.setItems(questionDAO.displayQuestion(idQuiz));
        questionDisplayQuestionColumn.setCellValueFactory(cellData -> cellData.getValue().questionProperty());
        showQuestionDetail(null);
        quizDisplayQuizTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showQuestionDetail(newValue));
        
    }
    private void showQuestionDetail(Question question) {
        if (question !=null){
            textDisplayQuizLabel.setText(question.getQuestion());
            ImplReponseDAO reponseDAO = new ImplReponseDAO();
            List<Reponse> reponses = new ArrayList();
            reponses = reponseDAO.displayReponse(question.getId());
            System.out.println(reponses);
            int i =0;
            for (i=0; i<4; i++) {
                if (i==0){
                    choix1DisplayQuizLabel.setText(reponses.get(i).getReponse());
                    justification1DisplayQuizLabel.setText(reponses.get(i).getJustification());
                    if(reponses.get(i).getEtat()=="vrai"){
                        choix1DisplayQuizImageView.setImage(tick);
                    }
                }
                else if (i==1){
                    choix2DisplayQuizLabel.setText(reponses.get(i).getReponse());
                    justification2DisplayQuizLabel.setText(reponses.get(i).getJustification());
                    if(reponses.get(i).getEtat()=="vrai"){
                        choix2DisplayQuizImageView.setImage(tick);
                    }
                }
                else if (i==2){
                    choix3DisplayQuizLabel.setText(reponses.get(i).getReponse());
                    justification3DisplayQuizLabel.setText(reponses.get(i).getJustification());
                    if(reponses.get(i).getEtat()=="vrai"){
                        choix3DisplayQuizImageView.setImage(tick);
                    }
                }
                else if (i==3){
                    choix4DisplayQuizLabel.setText(reponses.get(i).getReponse());
                    justification4DisplayQuizLabel.setText(reponses.get(i).getJustification());
                    if(reponses.get(i).getEtat()=="vrai"){
                        choix4DisplayQuizImageView.setImage(tick);
                    }
                }
            } 
        }else{
            textDisplayQuizLabel.setText("-");
            choix1DisplayQuizLabel.setText("-");
            choix2DisplayQuizLabel.setText("-");
            choix3DisplayQuizLabel.setText("-");
            choix4DisplayQuizLabel.setText("-");
        }
    }
    
    @FXML
    private void handleDeleteQuestion(){
        int selectedIndex = quizDisplayQuizTable.getSelectionModel().getSelectedIndex();
        Question question = new Question();
        question=quizDisplayQuizTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Suppression !!!");
            alert.setHeaderText("Etes-vous sur de bien vouloir supprimer '"+question.getQuestion()+"'");
            //alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                quizDisplayQuizTable.getItems().remove(selectedIndex);
                questionDAO=new ImplQuestionDAO();
                questionDAO.deleteQuestion(question.getId());
            }
        }
    }
    
    @FXML
    private void handleAddQuestion(){
        Question temp = new Question();
        ImplQuestionDAO iQuestion = new ImplQuestionDAO();
        EpreuveObjectif epreuve = new EpreuveObjectif();
        ImplEpreuveObjectifDAO epreuveDAO = new ImplEpreuveObjectifDAO();
        int idEpreuve=epreuveDAO.createEpreuveObjectif(epreuve);
        idQuiz = idEpreuve;
        temp.setIdEpreuve(idQuiz);
        boolean ajouterClicked = showQuestionAddDialog(temp);
        if(ajouterClicked){
            quizDisplayQuizTable.setItems(iQuestion.displayQuestion(idQuiz));
            questionDisplayQuestionColumn.setCellValueFactory(cellData -> cellData.getValue().questionProperty());
        }
    }

    private boolean showQuestionAddDialog(Question temp) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/addQuestion.fxml"));
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
            AddQuestionController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setQuestion(temp, idQuiz);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
