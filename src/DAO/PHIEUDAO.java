/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CHITIETPHIEUDTO;
import DTO.PHIEUDTO;
import java.sql.Connection;
//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public void savePhieu(ArrayList<CHITIETPHIEUDTO> mPhieu){
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
             Sql = "insert into ChiTietPhieuNhan(idPhieu,idSach,soLuongNhap,soLuongNhan,giaMua) values";
            for(int i=0;i<mPhieu.size();i++){
//                mPhieu.get(i).getIdPhieu(idPhieu);
//                System.out.println(mPhieu.get(i).toString());
                Sql  += 
                         " ('"+idPhieu+"'"
                        + ",'"+mPhieu.get(i).getIdSach()+"'"
                        + ",'"+mPhieu.get(i).getSoLuongNhap()+"'"
                        + ",'0',"
                        + "'"+mPhieu.get(i).getGiaMua()+"') ";
                if(i+1 != mPhieu.size()) Sql +=",";
            }
//            System.out.println(Sql);
            st.executeUpdate(Sql);

        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public ArrayList<PHIEUDTO> loadFormNhap(){
        ArrayList<PHIEUDTO>arr = new ArrayList<>();
         try {
              st = conn.createStatement();
             String Sql = "SELECT * FROM PhieuNhan ORDER BY idPhieu DESC";
             rs = st.executeQuery(Sql);
//            int idPhieu = 0;
            while (rs.next()) {
//                idPhieu = Integer.parseInt(rs.getString("idPhieu"));
                    arr.add(new PHIEUDTO(Integer.parseInt(rs.getString("idPhieu"))
                            , Integer.parseInt(rs.getString("tinhTrang"))
                            , Integer.parseInt(rs.getString("trangThai"))
                            , rs.getString("ngayLap")));
}
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDAO.class.getName()).log(Level.SEVERE, null, ex);
//             return null;
         }
    
         return arr;
    }
    public ArrayList<CHITIETPHIEUDTO> getChiTietPhieu(int idPhieu){
    ArrayList<CHITIETPHIEUDTO> arr = new ArrayList<>();
         try {
             st = conn.createStatement();
             String Sql = "SELECT * FROM ChiTietPhieuNhan c,PhieuNhan p,sach s where c.idPhieu = p.idPhieu and s.idSach = c.idSach and c.idPhieu="+idPhieu;
             System.out.println(Sql);
             rs = st.executeQuery(Sql);
//            int idPhieu = 0;
            while (rs.next()) {
//                idPhieu = Integer.parseInt(rs.getString("idPhieu"));
                    arr.add(new CHITIETPHIEUDTO(Integer.parseInt(rs.getString("idPhieu"))
                            , Integer.parseInt(rs.getString("idSach"))
                            
                            , Integer.parseInt(rs.getString("soLuongNhap"))
                            , Integer.parseInt(rs.getString("soLuongNhan"))
                            , Integer.parseInt(rs.getString("giaMua"))
                            , rs.getString("tenSach")
                            ));
                    System.out.println(arr.get(0).toString());;
}
            return arr;
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDAO.class.getName()).log(Level.SEVERE, null, ex);
//             return null;
         }
         return arr;
         
    
    
    }
     public ArrayList<PHIEUDTO> timkiem(int idPhieu){
    
        
        return new ArrayList<>();
    }
     public void deletePhieu(int idPhieu){
     
          try{

            st = conn.createStatement();
            String Sql = "delete phieuNhan where idPhieu = " + idPhieu;
           
            st.executeUpdate(Sql);
            
            
//            st.executeUpdate(Sql);

        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }

    public void changeState(int idPhieu,int state) {
        try{

            st = conn.createStatement();
            String Sql = "update phieuNhan set trangThai ="+state+" where idPhieu = " + idPhieu;
           
            st.executeUpdate(Sql);
            
            
//            st.executeUpdate(Sql);

        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
}