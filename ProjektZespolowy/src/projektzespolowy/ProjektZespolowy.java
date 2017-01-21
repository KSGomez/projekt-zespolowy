/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy;

import java.util.List;
import projektzespolowy.Models.Buyer;
import projektzespolowy.Models.Header;
import projektzespolowy.sqlConnectors.*;

import projektzespolowy.Models.Invoice;
import projektzespolowy.Models.InvoiceItem;
import projektzespolowy.Models.Seller;

/**
 *
 * @author Kisacz
 */
public class ProjektZespolowy {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Invoice newInvoice = new Invoice(0, 0, 0, 0, null, null, null);
        newInvoice.nabywca = new Buyer(0,"Janusz", "Januszowa", "Januszow", "05-111", "2190877120"); 
        newInvoice.sprzedawca =new Seller(0,"Wiaczeslaw", "Momotowa", "Momotow", "05-112", "2190877121"); 
        newInvoice.naglowek = new Header(0, "FV/111/11", 1000, 1200);
        newInvoice.invoiceItems.add(new InvoiceItem(0, 0, "Testowy produkt", 1000, 10));
               
        /*
        //SQLLITE
        SqliteConnector sLiteCon = new SqliteConnector("SqlLite", newInvoice);        
        newInvoice = sLiteCon.getFaktura();  
        System.out.println(newInvoice);        
        sLiteCon.closeConnection();
        
        //MySQL
        MySqlConnector sMysqlConn = new MySqlConnector("MySql", newInvoice);        
        newInvoice = sMysqlConn.getFaktura();  
        System.out.println(newInvoice);        
        sLiteCon.closeConnection();
*/
        //PostgreSQL
        PostgreSqlConnector sPostgreSQL = new PostgreSqlConnector("PostgreSql", newInvoice);        
        newInvoice = sPostgreSQL.getFaktura();  
        System.out.println(newInvoice);        
        sPostgreSQL.closeConnection();
        
        
    }
    
}
