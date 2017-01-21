/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy.sqlConnectors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import projektzespolowy.Models.*;

/**
 *
 * @author Kisacz
 */
public class StaticMethods {
    
    private StaticMethods(){}
    
    
        public static boolean createTablesSQLLite(Statement stat)
        {           
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
        
        public static boolean createTablesMySQL(Statement stat)
        {           
        String createBuyer = "CREATE TABLE IF NOT EXISTS buyers (id Int PRIMARY KEY AUTO_INCREMENT, Name varchar(255), Street varchar(255), City varchar(255), PostalCode varchar(255), NIP varchar(255))";
        String createSeller = "CREATE TABLE IF NOT EXISTS sellers (id INTEGER PRIMARY KEY AUTO_INCREMENT, Name varchar(255), Street varchar(255), City varchar(255), PostalCode varchar(255), NIP varchar(255))";
        String createHeader = "CREATE TABLE IF NOT EXISTS headers (id INTEGER PRIMARY KEY AUTO_INCREMENT, InvoiceNumber varchar(255), InvoiceBruttoPrice DOUBLE, InvoiceNettoPrice DOUBLE)";
        String createInvoice = "CREATE TABLE IF NOT EXISTS invoices (id INTEGER PRIMARY KEY AUTO_INCREMENT, buyerID INTEGER REFERENCES buyers(id) ,sealerID INTEGER REFERENCES sellers(id),headerID INTEGER REFERENCES heads(id))";
        String createIncoiceItem = "CREATE TABLE IF NOT EXISTS invoiceItems (id INTEGER PRIMARY KEY AUTO_INCREMENT, Name varchar(255), Price DOUBLE, Ammount DOUBLE, InvokeID INTEGER REFERENCES invoices(id))";
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
        
        public static boolean createTablesPostgreSql(Statement stat)
        {           
        String createBuyer = "CREATE TABLE IF NOT EXISTS buyers (id SERIAL PRIMARY KEY , Name varchar(255), Street varchar(255), City varchar(255), PostalCode varchar(255), NIP varchar(255))";
        String createSeller = "CREATE TABLE IF NOT EXISTS sellers (id SERIAL PRIMARY KEY, Name varchar(255), Street varchar(255), City varchar(255), PostalCode varchar(255), NIP varchar(255))";
        String createHeader = "CREATE TABLE IF NOT EXISTS headers (id SERIAL PRIMARY KEY, InvoiceNumber varchar(255), InvoiceBruttoPrice REAL, InvoiceNettoPrice REAL)";
        String createInvoice = "CREATE TABLE IF NOT EXISTS invoices (id SERIAL PRIMARY KEY, buyerID INTEGER REFERENCES buyers(id) ,sealerID INTEGER REFERENCES sellers(id),headerID INTEGER REFERENCES headers(id))";
        String createIncoiceItem = "CREATE TABLE IF NOT EXISTS invoiceItems (id SERIAL PRIMARY KEY, Name varchar(255), Price REAL, Ammount REAL, InvokeID INTEGER REFERENCES invoices(id))";
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
        
        public static boolean insertBuyer(Buyer buyer, Connection conn) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "INSERT INTO buyers (Name, Street, City, PostalCode, NIP) VALUES (?, ?, ?, ?, ?);");
            prepStmt.setString(1, buyer.Name);
            prepStmt.setString(2, buyer.Street);
            prepStmt.setString(3, buyer.City);
            prepStmt.setString(4, buyer.PostalCode);
            prepStmt.setString(5, buyer.NIP);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
        
            public static boolean insertSeller(Seller seller, Connection conn) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into sellers values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, seller.Name);
            prepStmt.setString(2, seller.Street);
            prepStmt.setString(3, seller.City);
            prepStmt.setString(4, seller.PostalCode);
            prepStmt.setString(5, seller.NIP);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
            
                public static boolean insertHeader(Header header, Connection conn) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into headers values (NULL, ?, ?, ?);");
            prepStmt.setString(1, header.InvoiceNumber);
            prepStmt.setDouble(2, header.InvoiceBruttoPrice);
            prepStmt.setDouble(3, header.InvoiceNettoPrice);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean insertInvoice(Invoice invoice, Connection conn) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into invoices values (NULL, ?, ?, ?);");
            prepStmt.setInt(1, invoice.buyerID);
            prepStmt.setInt(2, invoice.headerID);
            prepStmt.setInt(3, invoice.SellerID);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean insertInvoiceItem(InvoiceItem item, Connection conn) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into invoiceItems values (NULL, ?, ?, ?, ?);");
            prepStmt.setInt(1, item.InvokeID);
            prepStmt.setString(2, item.Name);
            prepStmt.setDouble(3, item.Price);
            prepStmt.setDouble(4, item.Ammount);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static List<Invoice> selectFaktury(Statement stat) {
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
}
