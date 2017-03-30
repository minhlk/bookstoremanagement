/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PHIEUDTO;
import java.sql.Connection;
//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKZ
 */
public class PHIEUDAO {
     private Statement st;
    private ResultSet rs;
    private Connection conn = Conn.getConnect();
    public PHIEUDAO(){
//        try {
//            conn = Conn.getConnect();
//            System.out.println("test");
//            st = conn.createStatement();
//            String Sql = "select * from family";
//            rs = st.executeQuery(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("firstName"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PHIEUDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public void savePhieu(PHIEUDTO mPhieu){
        try{
            
//            System.out.println("test");
DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Calendar calobj = Calendar.getInstance();
//       System.out.println(df.format(calobj.getTime()));
            st = conn.createStatement();
            String Sql = "insert into PhieuNhan(ngayLap,tinhTrang) values('"+df.format(calobj.getTime())+"','0')";
//            rs = st.executeQuery(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("tenSach"));
//            }
            System.out.println(mPhieu.toString());
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch( com.microsoft.sqlserver.jdbc.SQLServerException e){}
}
}