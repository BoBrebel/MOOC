package com.esprit.pidev.tesseract;

import com.esprit.pidev.models.database.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
     //   Connection cnx =DataSource.getInstance().getConnection();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        Connection cnx =DataSource.getInstance().getConnection();
//        Statement s = cnx.createStatement();
//        ResultSet resultSet =  s.executeQuery("select * from utilisateur");
//        while (resultSet.next()) {            
//            System.out.println(resultSet.getString(2));
//        }
    }

}
