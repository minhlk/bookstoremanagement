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
public class TAOPHIEUDHDAO {
    private Statement st;
    private ResultSet rs;
    private Connection conn = GetConnection.conn;
    
    public void savePhieu(ArrayList<TAOPHIEUDHDTO> mPhieu){
        try{
            
//            System.out.println("test");
//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar calobj = Calendar.getInstance();
//       System.out.println(df.format(calobj.getTime()));
            st = conn.createStatement();
            // create new phieunhan
            String Sql = "insert into PhieuNhan(tinhTrang) values('0')";
            st.executeUpdate(Sql);
            // get id of that new phieunhan
            
            Sql = "SELECT TOP 1 idPhieu FROM PhieuNhan ORDER BY idPhieu DESC";
            rs = st.executeQuery(Sql);
            int idPhieu = 0;
            while (rs.next()) {
               idPhieu = Integer.parseInt(rs.getString("idPhieu"));
            }
            
            // insert list of sach to chitietphieunhan of phieunha
             Sql = "insert into ChiTietPhieuNhan(idPhieu,idSach,soLuongNhap,soLuongNhan) values";
            for(int i=0;i<mPhieu.size();i++){
//                mPhieu.get(i).getIdPhieu(idPhieu);
//                System.out.println(mPhieu.get(i).toString());
                Sql  += 
                         " ('"+idPhieu+"'"
                        + ",'"+mPhieu.get(i).getIdSach()+"'"
                        + ",'"+mPhieu.get(i).getSoLuongNhap()+"'"
                        + ",'0')";
                if(i+1 != mPhieu.size()) Sql +=",";
            }
//            System.out.println(Sql);
            st.executeUpdate(Sql);

        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
    
}
