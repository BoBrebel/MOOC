/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.controllers;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplLogDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.esprit.pidev.models.entities.Log;
import java.util.Date;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author BoB
 */
public class AdminDashBoardFXMLController implements Initializable {
    ImplLogDAO logs = new ImplLogDAO();
    
    @FXML
    private TableView<Log> displaylog;
    @FXML
    private TableColumn<Log,Integer> useridclm;
    @FXML
    private TableColumn<Log,String> taskclm;
    @FXML
    private TableColumn<Log,Date> dateclm;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        useridclm = new TableColumn<>("Userid");
        useridclm.setMinWidth(200);
        useridclm.setCellValueFactory(new PropertyValueFactory<>("idUtilisateur"));
        
        taskclm = new TableColumn<>("task");
        taskclm.setMinWidth(200);
        taskclm.setCellValueFactory(new PropertyValueFactory<>("Tache"));
        
        dateclm = new TableColumn<>("Date");
        dateclm.setMinWidth(200);
        dateclm.setCellValueFactory(new PropertyValueFactory<>("dateTache"));
        
        displaylog = new TableView<>();
        displaylog.setItems(logs.getallLog());
        displaylog.getColumns().addAll(useridclm,taskclm,dateclm);
        
        System.out.println(logs.getallLog());
        
    }    
    
}
