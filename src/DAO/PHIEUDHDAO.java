/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PHIEUDHDTO;
import DTO.TAOPHIEUDHDTO;
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
    
    public ArrayList<TAOPHIEUDHDTO> getChiTietPhieu(int idPhieu){
    ArrayList<TAOPHIEUDHDTO> arr = new ArrayList<>();
         try {
             st = conn.createStatement();
             String Sql = "SELECT * FROM ChiTietPhieuNhan c,PhieuNhan p,sach s where c.idPhieu = p.idPhieu and s.idSach = c.idSach and c.idPhieu="+idPhieu;
//             System.out.println(Sql);
             rs = st.executeQuery(Sql);
//            int idPhieu = 0;
            while (rs.next()) {
//                idPhieu = Integer.parseInt(rs.getString("idPhieu"));
                    arr.add(new TAOPHIEUDHDTO(Integer.parseInt(rs.getString("idPhieu"))
                            , Integer.parseInt(rs.getString("idSach"))
                            
                            , Integer.parseInt(rs.getString("soLuongNhap"))
                            , Integer.parseInt(rs.getString("soLuongNhan"))
//                            , Integer.parseInt(rs.getString("giaMua"))
                            , rs.getString("tenSach")
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
     
    public void editChiTietPhieu(ArrayList<TAOPHIEUDHDTO> arr){
        try{
            String Case="",condition="";
            st = conn.createStatement();
            for(int i= 0; i< arr.size(); i++){
            Case += " when idSach = "+arr.get(i).getIdSach()+" then "+arr.get(i).getSoLuongNhan();
            condition += arr.get(i).getIdSach()+",";
            }
            condition = condition.substring(0, condition.length()-1);
            
            String sql ="update ChiTietPhieuNhan set soLuongNhan = (case "+Case+" end)" +
" where idSach in ("+condition+") and idPhieu = "+arr.get(0).getIdPhieu();
//            System.out.println(sql);
            st.executeUpdate(sql);

        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void changeSoLuong(ArrayList<TAOPHIEUDHDTO> arr){
    try{
        //tang so luong sach khi cap nhat so luong sach nhan duoc
//            st = conn.createStatement();
            String Case="",condition="";
            st = conn.createStatement();
            for(int i= 0; i< arr.size(); i++){
            Case += " when idSach = "+arr.get(i).getIdSach()+" then (select soLuong  + ( select "+arr.get(i).getSoLuongNhan()+" - soLuongNhan"
                    + " from sach s,ChiTietPhieuNhan c where s.idSach = c.idSach and s.idSach = "+arr.get(i).getIdSach()+" and c.idPhieu ="+arr.get(i).getIdPhieu()
                   + " ) as soLuong "
                   + " from sach where idSach = "+arr.get(i).getIdSach()+" )  ";
            
            
            condition += arr.get(i).getIdSach()+",";
            }
            condition = condition.substring(0, condition.length()-1);
            
            String Sql ="update sach set soLuong = (case "+Case+" end)" +
" where idSach in ("+condition+")" ;
            st.executeUpdate(Sql);
//System.out.println(Sql);
            
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
     
}