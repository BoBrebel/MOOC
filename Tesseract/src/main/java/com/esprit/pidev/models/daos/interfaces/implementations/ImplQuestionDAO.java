/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.daos.interfaces.implementations;

import com.esprit.pidev.models.daos.interfaces.IQuestionDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.entities.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdk.nashorn.internal.ir.Statement;

/**
 *
 * @author Bacem
 */
public class ImplQuestionDAO implements IQuestionDAO{

    Connection connection;
    PreparedStatement pst;
    ResultSet rS;

    public ImplQuestionDAO(){
    connection =(DataSource.getInstance()).getConnection();
}
    @Override
    public int createQuestion(Question question) {
        try {
            String request="insert into question(question, id_epreuve) values (?,?)";
            pst = connection.prepareStatement(request,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, question.getQuestion());
            pst.setInt(2, question.getIdEpreuve());
            
            int result = pst.executeUpdate();
            rS=pst.getGeneratedKeys();
            rS.first();
            
            return rS.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ImplQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean deleteQuestion(int id) {
        try {
            String request = "delete from question where id="+id;
            int result= pst.executeUpdate(request);
            pst.close();
            return (result==1);
        } catch (SQLException ex) {
            Logger.getLogger(ImplQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateQuestion(Question question, int id) {
        try {
            String request="update question set question=?, id_epreuve=? where id=?";
            pst = connection.prepareStatement(request);
            pst.setString(1, question.getQuestion());
            pst.setInt(2, question.getIdEpreuve());
            pst.setInt(3, id);
            
            int result = pst.executeUpdate();
            pst.close();
            return result==1;
        } catch (SQLException ex) {
            Logger.getLogger(ImplQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Question searchQuestion(int id) {
        Question question = new Question();
        try {
            String request ="select * from question where id=?";
            rS = pst.executeQuery(request);
            rS.next();
            question.setId(rS.getInt("id"));
            question.setIdEpreuve(rS.getInt("id_epreuve"));
            question.setQuestion(rS.getString("question"));
        } catch (SQLException ex) {
            Logger.getLogger(ImplQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return question;
    }

    @Override
    public ObservableList<Question> displayQuestion(int id) {
        ObservableList<Question> questions = FXCollections.observableArrayList();
        try {
            String request="select * from question where id_epreuve="+id;
            pst = connection.prepareStatement(request);
            rS=pst.executeQuery();
            while(rS.next()){
                Question q= new Question(rS.getInt(1), rS.getString("question"), rS.getInt(2));
                questions.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
    
}
