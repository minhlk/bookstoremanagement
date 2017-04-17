/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PHIEUDHDTO;
import DTO.THONGKECHIDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKZ
 */
public class PHIEUDHDAO {
    private Statement st;
    private ResultSet rs;
    private Connection conn = GetConnection.conn;
    public PHIEUDHDAO(){

    }
    
    public ArrayList<PHIEUDHDTO> loadFormNhap(){
        ArrayList<PHIEUDHDTO>arr = new ArrayList<>();
         try {
              st = conn.createStatement();
             String Sql = "SELECT * FROM PhieuNhan ORDER BY idPhieu DESC";
             rs = st.executeQuery(Sql);
            while (rs.next()) {
                    arr.add(new PHIEUDHDTO(Integer.parseInt(rs.getString("idPhieu"))
                            , Integer.parseInt(rs.getString("tinhTrang"))
                            , Integer.parseInt(rs.getString("trangThai"))
                            , rs.getString("ngayLap")));
}
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDHDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    
         return arr;
    }
    
    public ArrayList<PHIEUDHDTO> timkiem(int idPhieu){
    
        
        return new ArrayList<>();
    }
    public void deletePhieu(int idPhieu){
     
          try{

            st = conn.createStatement();
            String Sql = "delete phieuNhan where idPhieu = " + idPhieu;
           
            st.executeUpdate(Sql);
            
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    public void changeState(int idPhieu,int state) {
        try{

            st = conn.createStatement();
            String Sql = "update phieuNhan set trangThai ="+state+" where idPhieu = " + idPhieu;
            System.out.println(Sql);
            st.executeUpdate(Sql);
            
            
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void changetinhTrang(int idPhieu, int tinhTrang) {
         try {
             st = conn.createStatement();
             String sql = "update phieunhan set tinhTrang = "+tinhTrang+" where idPhieu = "+idPhieu;
             System.out.println(sql);
             st.executeUpdate(sql);
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDHDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public ArrayList<THONGKECHIDTO> loadFormThongKeChi() {
        ArrayList<THONGKECHIDTO> arr = new ArrayList();
        try{
            
         st = conn.createStatement();
             String Sql = "select c.idPhieu,c.idSach,s.tenSach,p.ngayLap,c.soLuongNhap,c.soLuongNhan,c.giaMua,c.soLuongNhan * c.giaMua as tongGia,p.tinhTrang,p.trangThai " +
"from PhieuNhan p,ChiTietPhieuNhan c, SACH s where p.idPhieu = c.idPhieu and s.idSach = c.idSach";
//             System.out.println(Sql);
             rs = st.executeQuery(Sql);
//            int idPhieu = 0;
            while (rs.next()) {
//                idPhieu = Integer.parseInt(rs.getString("idPhieu"));
                    arr.add(new THONGKECHIDTO(Integer.parseInt(rs.getString("idPhieu"))
                            , Integer.parseInt(rs.getString("idSach"))
                            , Integer.parseInt(rs.getString("soLuongNhap"))
                            , Integer.parseInt(rs.getString("soLuongNhan"))
                            , Integer.parseInt(rs.getString("giaMua"))
                            ,Integer.parseInt(rs.getString("tongGia"))
                            , Integer.parseInt(rs.getString("tinhTrang"))
                            ,Integer.parseInt(rs.getString("trangThai"))
                            ,rs.getString("tenSach")
                            ,rs.getString("ngayLap")
                            
                            ));
//                    System.out.println(arr.get(0).toString());;
}
            return arr;
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDHDAO.class.getName()).log(Level.SEVERE, null, ex);
//             return null;
         }
         return arr;
    
    }
    public Map<Integer,Integer> thongKeChi(int year ) {
        Map<Integer,Integer> mMap = new HashMap<>();
         try {
             st = conn.createStatement();
             String sql = "select MONTH(ngayLap) as thang,sum(soLuongNhap * giaMua ) as tongGia " +
                     "from PhieuNhan p,ChiTietPhieuNhan c " +
                     "where p.idPhieu = c.idPhieu and YEAR(ngayLap) = " +year + 
                     " group by ngayLap";
             rs = st.executeQuery(sql);
//            int idPhieu = 0;
            while (rs.next()) {
               mMap.put(
                        Integer.parseInt(rs.getString("thang"))
                       ,Integer.parseInt(rs.getString("tongGia"))
               );
            }       
            return mMap;
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDHDAO.class.getName()).log(Level.SEVERE, null, ex);
             return mMap;
         }
    }
    
     
}