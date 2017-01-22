/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy.sqlConnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import projektzespolowy.Models.Invoice;
import projektzespolowy.Models.InvoiceItem;

/**
 *
 * @author Adrian
 */
public class OracleDatabaseConnector extends SqlConnector {
      public static final String DRIVER = "org.ojdbc6.JDBC";
    public static final String DB_URL = "jdbc:ojdbc6:testDB.db";

    private Connection conn;
    //pozwala on na wykonywanie zapytań na podstawie zdefiniowanych Stringów
    private Statement stat;

    public OracleDatabaseConnector(String databaseType, Invoice object) {
            super(databaseType, object);
        try {
            //zaladowanie sterownika do systemu
            Class.forName(OracleDatabaseConnector.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTables();
        insertBuyer();
        insertSeller();
        insertHeader();
        for(int i = 0; i < operationObject.invoiceItems.size(); i++)
        {
            insertInvoiceItem(i); 
        }
    }

    public boolean createTables() {
        return StaticMethods.createTablesSQLLite(stat);
    }
    
    public boolean insertBuyer() {
        return StaticMethods.insertBuyer(operationObject.nabywca, conn); 
    }
    
    public boolean insertSeller() {
            return StaticMethods.insertSeller(operationObject.sprzedawca, conn); 
    }
    
    public boolean insertHeader() {
            return StaticMethods.insertHeader(operationObject.naglowek, conn);
    }
    
    public boolean insertInvoice() {
            return StaticMethods.insertInvoice(operationObject, conn);
    }
    
    public boolean insertInvoiceItem(int i) {
            return StaticMethods.insertInvoiceItem(operationObject.invoiceItems.get(i), conn);
    }
    
    public List<Invoice> selectFaktury() {
            return StaticMethods.selectFaktury(stat);
    }
    
    public Invoice getFaktura()
    {
        InvoiceItem nowy = new InvoiceItem(0,DRIVER, 0, 1, 0);
        operationObject.invoiceItems.add(nowy);
        return operationObject;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
