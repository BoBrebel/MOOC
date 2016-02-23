/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.models.entities;

import javafx.beans.property.*;

/**
 *
 * @author Bacem
 */
public class Question {
    
    private final IntegerProperty id;
    private final StringProperty question;
    private final IntegerProperty idEpreuve;

    public Question(){
        this(-1,null,-1);
    }
    
    /**
     * Constructor with initial data.
     * 
     * @param id
     * @param question 
     * @param idEpreuve  
     */
    public Question(int id, String question, int idEpreuve) {
        this.id = new SimpleIntegerProperty(id);
        this.question = new SimpleStringProperty(question);
        this.idEpreuve = new SimpleIntegerProperty(idEpreuve);
    }

    public int getIdEpreuve() {
        return idEpreuve.get();
    }

    public void setIdEpreuve(int idEpreuve) {
        this.idEpreuve.set(idEpreuve);
    }
    
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getQuestion() {
        return question.get();
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty questionProperty() {
        return question;
    }

    public IntegerProperty idEpreuveProperty() {
        return idEpreuve;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id.intValue();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + question + '}';
    }
    
    
}
