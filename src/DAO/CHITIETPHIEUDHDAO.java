/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CHITIETPHIEUDHDTO;
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
public class CHITIETPHIEUDHDAO {
    private Statement st;
    private ResultSet rs;
    private Connection conn = GetConnection.conn;
    
    public void savePhieu(ArrayList<CHITIETPHIEUDHDTO> mPhieu){
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
    public ArrayList<CHITIETPHIEUDHDTO> getChiTietPhieu(int idPhieu){
    ArrayList<CHITIETPHIEUDHDTO> arr = new ArrayList<>();
         try {
             st = conn.createStatement();
             String Sql = "SELECT * FROM ChiTietPhieuNhan c,PhieuNhan p,sach s where c.idPhieu = p.idPhieu and s.idSach = c.idSach and c.idPhieu="+idPhieu;
//             System.out.println(Sql);
             rs = st.executeQuery(Sql);
//            int idPhieu = 0;
            while (rs.next()) {
//                idPhieu = Integer.parseInt(rs.getString("idPhieu"));
                    arr.add(new CHITIETPHIEUDHDTO(Integer.parseInt(rs.getString("idPhieu"))
                            , Integer.parseInt(rs.getString("idSach"))
                            
                            , Integer.parseInt(rs.getString("soLuongNhap"))
                            , Integer.parseInt(rs.getString("soLuongNhan"))
                            , Integer.parseInt(rs.getString("giaMua"))
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
    public void editChiTietPhieu(ArrayList<CHITIETPHIEUDHDTO> arr){
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
    
}
