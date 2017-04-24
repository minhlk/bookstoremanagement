/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class THONGKECHIDAO extends GenericDAO<THONGKECHIDTO>{
    private Statement st;
    private ResultSet rs;
    private Connection conn = GetConnection.conn;
    
    
    public ArrayList<THONGKECHIDTO> getAll() {
         String Sql = "select c.idPhieu,c.idSach,s.tenSach,p.ngayLap,c.soLuongNhap,c.soLuongNhan,s.giaMua,c.soLuongNhan * s.giaMua as tongGia,p.tinhTrang,p.trangThai " +
"from PhieuNhan p,ChiTietPhieuNhan c, SACH s where p.idPhieu = c.idPhieu and s.idSach = c.idSach";
        rs = super.getAll(Sql);
        ArrayList<THONGKECHIDTO> arr = new ArrayList();
        try{     
            while (rs.next()) {
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
}
            return arr;
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDHDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return arr;
    
    }
    public Map<Integer,Integer> thongKeChi(int year ) {
        Map<Integer,Integer> mMap = new HashMap<>();
         try {
             st = conn.createStatement();
             String sql = "select MONTH(ngayLap) as thang,sum(soLuongNhan * s.giaMua ) as tongGia " +
                     "from PhieuNhan p,ChiTietPhieuNhan c,sach s " +
                     "where p.idPhieu = c.idPhieu and s.idSach = c.idSach and YEAR(ngayLap) = " +year + 
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
