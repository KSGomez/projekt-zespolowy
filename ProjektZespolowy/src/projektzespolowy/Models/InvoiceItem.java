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
public class InvoiceItem {
    public int id;
    public int InvokeID;
    public String Name; 
    public double Price;
    public double Ammount; 

    public int getInvokeID() {
        return InvokeID;
    }

    public void setInvokeID(int InvokeID) {
        this.InvokeID = InvokeID;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getAmmount() {
        return Ammount;
    }

    public void setAmmount(double Ammount) {
        this.Ammount = Ammount;
    }

    public InvoiceItem() {
    }

    public InvoiceItem(int id, String Name, double Price, double Ammount,int InvokeID) {
        this.id = id;
        this.InvokeID = InvokeID;
        this.Name = Name;
        this.Price = Price;
        this.Ammount = Ammount;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" + "id=" + id + ", InvokeID=" + InvokeID + ", Name=" + Name + ", Price=" + Price + ", Ammount=" + Ammount + '}';
    }
    
}
