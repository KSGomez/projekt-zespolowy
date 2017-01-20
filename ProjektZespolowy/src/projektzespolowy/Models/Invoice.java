/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy.Models;

import java.util.ArrayList;

/**
 *
 * @author Kisacz
 */
public class Invoice {
    public Buyer nabywca; 
    public Seller sprzedawca; 
    public Header naglowek; 
    public ArrayList<Invoice> invoiceItems = new ArrayList<>();   
}
