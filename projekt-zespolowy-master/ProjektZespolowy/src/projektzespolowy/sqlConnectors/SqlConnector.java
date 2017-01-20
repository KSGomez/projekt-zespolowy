/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektzespolowy.sqlConnectors;

import projektzespolowy.Models.*;
/**
 *
 * @author Kisacz
 */
public abstract class SqlConnector {
    
    //Zminna przechowująca rodzaj bazy danych (Oracle, MSsql, MySql itp.) potrzebne do logowania zmian
    private String databaseType; 
    private Invoice operationObject; 
    
    public SqlConnector(String databaseType, Invoice object)
    {
        this.databaseType = databaseType; 
        this.operationObject = object; 
    }
    
}
