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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
     //   Connection cnx =DataSource.getInstance().getConnection();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginFXML.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
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
       launch(args);
    }
}