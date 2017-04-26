/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKZ
 */
public class GenericDAO<T> {
    private Statement st;
    private ResultSet rs ;
    private Connection conn = GetConnection.conn;
   
    public void executeUpdate(String query){
    try{
             st = conn.createStatement();
             st.executeUpdate(query);
         } catch (SQLException ex ) {
             Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    public ResultSet executeQuery(String Sql){
        try{
            st = conn.createStatement();         
            rs = st.executeQuery(Sql);

        } catch (SQLException ex ) {
        }
            return rs;
    }
}
