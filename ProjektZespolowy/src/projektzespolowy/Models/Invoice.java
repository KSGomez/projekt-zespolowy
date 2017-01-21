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
    public int id;
    public int buyerID;
    public int headerID;
    public int SellerID;
    public Buyer nabywca; 
    public Seller sprzedawca; 
    public Header naglowek; 
    public ArrayList<InvoiceItem> invoiceItems = new ArrayList<>();   

    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public int getHeaderID() {
        return headerID;
    }

    public void setHeaderID(int headerID) {
        this.headerID = headerID;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int SellerID) {
        this.SellerID = SellerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buyer getNabywca() {
        return nabywca;
    }

    public void setNabywca(Buyer nabywca) {
        this.nabywca = nabywca;
    }

    public Seller getSprzedawca() {
        return sprzedawca;
    }

    public void setSprzedawca(Seller sprzedawca) {
        this.sprzedawca = sprzedawca;
    }

    public Header getNaglowek() {
        return naglowek;
    }

    public void setNaglowek(Header naglowek) {
        this.naglowek = naglowek;
    }

    public ArrayList<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(ArrayList<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Invoice() {
    }

    public Invoice(int id, int buyerID, int headerID, int SellerID) {
        this.id = id;
        this.buyerID = buyerID;
        this.headerID = headerID;
        this.SellerID = SellerID;
    }

    public Invoice(int id, int buyerID, int headerID, int SellerID, Buyer nabywca, Seller sprzedawca, Header naglowek) {
        this.id = id;
        this.buyerID = buyerID;
        this.headerID = headerID;
        this.SellerID = SellerID;
        this.nabywca = nabywca;
        this.sprzedawca = sprzedawca;
        this.naglowek = naglowek;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", buyerID=" + buyerID + ", headerID=" + headerID + ", SellerID=" + SellerID + ", nabywca=" + nabywca + ", sprzedawca=" + sprzedawca + ", naglowek=" + naglowek + ", invoiceItems=" + invoiceItems + '}';
    }
    
}
