/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy;

import java.util.List;
import projektzespolowy.sqlConnectors.SqliteConnector;

import projektzespolowy.Models.Invoice;

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
        SqliteConnector sLiteCon = new SqliteConnector();
        
        sLiteCon.insertBuyer("Janusz", "Januszowa", "Januszow", "05-111", "2190877120");
        sLiteCon.insertSeller("Wiaczeslaw", "Momotowa", "Momotow", "05-112", "2190877121");
        sLiteCon.insertHeader("FV/111/11", 1000, 1200);
        sLiteCon.insertInvoice(1, 1, 1);
        
        List<Invoice> faktury = sLiteCon.selectFaktury();
        
        System.out.println("Lista faktur: ");
        for(Invoice c: faktury)
            System.out.println(c);
        
        sLiteCon.closeConnection();
    }
    
}
