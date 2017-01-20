/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy.sqlConnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projektzespolowy.Models.Invoice;

/**
 *
 * @author Kisacz
 */
public class MySqlConnector extends SqlConnector{

        String userName = "username";
        String password = "password";
        String url = "jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=MYDB";
    
    public MySqlConnector(String databaseType, Invoice object) {
        super(databaseType, object);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(url, userName, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
}
