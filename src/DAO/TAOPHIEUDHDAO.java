/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TAOPHIEUDHDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKZ
 */
public class TAOPHIEUDHDAO extends GenericDAO<TAOPHIEUDHDTO>{
    private Statement st;
    private ResultSet rs;
    private Connection conn = GetConnection.conn;
    
    
    
}
