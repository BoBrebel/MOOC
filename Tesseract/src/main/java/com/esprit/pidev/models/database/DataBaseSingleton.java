package com.esprit.pidev.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseSingleton {

    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final long PORT = 3306;
    private static DataBaseSingleton dbS = null;
    private Connection connection;

    private DataBaseSingleton() {
    }

    public static synchronized DataBaseSingleton getInstance() {
        if (Objects.isNull(dbS)) {
            dbS = new DataBaseSingleton();
        }
        return dbS;
    }

    public Connection getConnection() {
        return connection;

    }

    public void connect() throws SQLException {
        if (Objects.nonNull(connection)) {
            return;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = String.format("jdbc:mysql://localhost:%d/tesseract", PORT);
        connection = DriverManager.getConnection(url, LOGIN, PASSWORD);
    }

    public void disconnect() throws SQLException {
        if (Objects.nonNull(connection)) {
            connection.close();
        }
        connection = null;
    }
}
