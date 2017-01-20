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
public class Buyer {
    public int id;
    public String Name; 
    public String Street;
    public String City;
    public String PostalCode;
    public String NIP; 

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

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
    
    public Buyer() {
    }

    public Buyer(int id, String Name, String Street, String City, String PostalCode, String NIP) {
        this.id = id;
        this.Name = Name;
        this.Street = Street;
        this.City = City;
        this.PostalCode = PostalCode;
        this.NIP = NIP;
    }

    @Override
    public String toString() {
        return "Buyer{" + "id=" + id + ", Name=" + Name + ", Street=" + Street + ", City=" + City + ", PostalCode=" + PostalCode + ", NIP=" + NIP + '}';
    }
    
}
