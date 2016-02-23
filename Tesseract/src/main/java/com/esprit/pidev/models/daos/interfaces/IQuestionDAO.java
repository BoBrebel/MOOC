/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces;
import com.esprit.pidev.models.entities.Question;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Bacem
 */
public interface IQuestionDAO {
    
    int createQuestion(Question question);
    boolean deleteQuestion(int id);
    boolean updateQuestion(Question question, int id);
    Question searchQuestion(int id);
    ObservableList<Question> displayQuestion(int id);
    
}
