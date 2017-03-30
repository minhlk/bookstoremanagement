/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bookstoremanagerment.BookstoreManagerment;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKZ
 */
public class Conn {

    /**
     *
     */
    public static Connection conn;
    
    public static Connection getConnect(){
    try {	
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYNHASACH1;user=sa;password=123";

             conn = DriverManager.getConnection(url);

		
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookstoreManagerment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookstoreManagerment.class.getName()).log(Level.SEVERE, null, ex);
        } 
		return conn;
    }
}
