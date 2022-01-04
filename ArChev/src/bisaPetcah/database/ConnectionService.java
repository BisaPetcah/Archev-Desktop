/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bisaPetcah.database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import bisaPetcah.database.ConfigDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author winat
 */
public class ConnectionService {

    private static Connection connection;
    private static Statement statement;

    public static Connection open() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        ConfigDatabase.getDbUrl(),
                        ConfigDatabase.getDbUser(),
                        ConfigDatabase.getDbPassword()
                );
                if (connection == null) {
                    throw new Exception("Connection Failure");
                }
            }
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static int query(String query) {
        try {
            open();

            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return 0;
    }

    public static ResultSet get(String query) {
        try {
            open();

            ResultSet data = statement.executeQuery(query);
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public static String set(String query) {
        try {
            open();

            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public static void close() {
        try {
//            connection.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
