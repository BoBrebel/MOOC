/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplUserDAO;
import com.esprit.pidev.models.database.DataSource;
import com.esprit.pidev.models.enums.Role;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author BoB
 */
public class LoginFXMLController implements Initializable {
    
    ImplUserDAO UserDAO;
    
    
    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Label lbllogin;
    @FXML
    private Label lblcnx;
    @FXML
    private void btnLogin(ActionEvent event){
        String auth=UserDAO.authenticateUser(txtusername.getText(),txtpassword.getText());
        if(auth.equals("ADM")){
        lbllogin.setText("HELLO");
        }
        else{
        lbllogin.setText("connection error");
        }
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Connection cnx =DataSource.getInstance().getConnection();
        try {
            if(cnx.isClosed()){
                lblcnx.setText("no connection");
            }
            else{
                lblcnx.setText("connection successful");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
