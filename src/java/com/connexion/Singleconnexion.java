/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ZORE
 */
public class Singleconnexion {
    
    private static Connection connecter;
    static{//Sexecute au moment du chargement de la classe en memoire
       try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connecter=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##TEST","test");
       }
       catch(ClassNotFoundException | SQLException e)
       {    e.printStackTrace();
          Logger.getLogger(Singleconnexion.class.getName()).log(Level.SEVERE, null, e);
       }
    }

    public static Connection getConnecter() {
        System.out.println("conection :"+connecter);
        return connecter;
    }
    
//    
//    public Connection connecter() 
//    {
//        try{
//            Class.forName("oracle.jdbc.OracleDriver");
//            connecter=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","auto","auto");
//            
//        }catch(ClassNotFoundException e)
//        {
//            
//        }
//        catch (SQLException ex) {
//            //Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return connecter;
//    }   
}

