/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy.Models;

/**
 *
 * @author Kisacz
 */
public class Header {
    public int id;
    public String InvoiceNumber;
    public double InvoiceBruttoPrice;
    public double InvoiceNettoPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public double getInvoiceBruttoPrice() {
        return InvoiceBruttoPrice;
    }

    public void setInvoiceBruttoPrice(double InvoiceBruttoPrice) {
        this.InvoiceBruttoPrice = InvoiceBruttoPrice;
    }

    public double getInvoiceNettoPrice() {
        return InvoiceNettoPrice;
    }

    public void setInvoiceNettoPrice(double InvoiceNettoPrice) {
        this.InvoiceNettoPrice = InvoiceNettoPrice;
    }

    public Header() {
    }

    public Header(int id, String InvoiceNumber, double InvoiceBruttoPrice, double InvoiceNettoPrice) {
        this.id = id;
        this.InvoiceNumber = InvoiceNumber;
        this.InvoiceBruttoPrice = InvoiceBruttoPrice;
        this.InvoiceNettoPrice = InvoiceNettoPrice;
    }

    @Override
    public String toString() {
        return "Header{" + "id=" + id + ", InvoiceNumber=" + InvoiceNumber + ", InvoiceBruttoPrice=" + InvoiceBruttoPrice + ", InvoiceNettoPrice=" + InvoiceNettoPrice + '}';
    }
    
}
