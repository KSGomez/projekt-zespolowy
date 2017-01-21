/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy.sqlConnectors;

/**
 *
 * @author Konrad
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import projektzespolowy.Models.Buyer;
import projektzespolowy.Models.Header;
import projektzespolowy.Models.Invoice;
import projektzespolowy.Models.InvoiceItem;
import projektzespolowy.Models.Seller;

public class SqliteConnector {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:testDB.db";

    private Connection conn;
    //pozwala on na wykonywanie zapytań na podstawie zdefiniowanych Stringów
    private Statement stat;

    public SqliteConnector() {
        try {
            //zaladowanie sterownika do systemu
            Class.forName(SqliteConnector.DRIVER);
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
    }

    public boolean createTables() {
        String createBuyer = "CREATE TABLE IF NOT EXISTS buyers (id INTEGER PRIMARY KEY AUTOINCREMENT, Name varchar(255), Street varchar(255), City varchar(255), PostalCode varchar(255), NIP varchar(255))";
        String createSeller = "CREATE TABLE IF NOT EXISTS sellers (id INTEGER PRIMARY KEY AUTOINCREMENT, Name varchar(255), Street varchar(255), City varchar(255), PostalCode varchar(255), NIP varchar(255))";
        String createHeader = "CREATE TABLE IF NOT EXISTS headers (id INTEGER PRIMARY KEY AUTOINCREMENT, InvoiceNumber varchar(255), InvoiceBruttoPrice DOUBLE, InvoiceNettoPrice DOUBLE)";
        String createInvoice = "CREATE TABLE IF NOT EXISTS invoices (id INTEGER PRIMARY KEY AUTOINCREMENT, buyerID INTEGER REFERENCES buyers(id) ,sealerID INTEGER REFERENCES sellers(id),headerID INTEGER REFERENCES heads(id))";
        String createIncoiceItem = "CREATE TABLE IF NOT EXISTS invoiceItems (id INTEGER PRIMARY KEY AUTOINCREMENT, Name varchar(255), Price DOUBLE, Ammount DOUBLE, InvokeID INTEGER REFERENCES invoices(id))";
        try {
            stat.execute(createBuyer);
            stat.execute(createSeller);
            stat.execute(createHeader);
            stat.execute(createInvoice);
            stat.execute(createIncoiceItem);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean insertBuyer(String Name, String Street, String City, String PostalCode,String NIP) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into buyers values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, Name);
            prepStmt.setString(2, Street);
            prepStmt.setString(3, City);
            prepStmt.setString(4, PostalCode);
            prepStmt.setString(5, NIP);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean insertSeller(String Name, String Street, String City, String PostalCode,String NIP) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into sellers values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, Name);
            prepStmt.setString(2, Street);
            prepStmt.setString(3, City);
            prepStmt.setString(4, PostalCode);
            prepStmt.setString(5, NIP);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean insertHeader(String InvoiceNumber, double InvoiceBruttoPrice, double InvoiceNettoPrice) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into headers values (NULL, ?, ?, ?);");
            prepStmt.setString(1, InvoiceNumber);
            prepStmt.setDouble(2, InvoiceBruttoPrice);
            prepStmt.setDouble(3, InvoiceNettoPrice);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean insertInvoice(int buyerID, int headerID, int sealerID) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into invoices values (NULL, ?, ?, ?);");
            prepStmt.setInt(1, buyerID);
            prepStmt.setInt(2, headerID);
            prepStmt.setInt(3, sealerID);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean insertInvoiceItem(int InvokeID, String Name, double Price, double Ammount) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into invoices values (NULL, ?, ?, ?, ?);");
            prepStmt.setInt(1, InvokeID);
            prepStmt.setString(2, Name);
            prepStmt.setDouble(3, Price);
            prepStmt.setDouble(4, Ammount);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public List<Invoice> selectFaktury() {
        List<Invoice> faktury = new LinkedList<Invoice>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM invoices");
            int id;
            int buyerID, headerID, sealerID;
            while(result.next()) {
                id = result.getInt("id");
                buyerID = result.getInt("buyerID");
                headerID = result.getInt("headerID");
                sealerID = result.getInt("sealerID");
                faktury.add(new Invoice(id, buyerID, headerID, sealerID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return faktury;
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
