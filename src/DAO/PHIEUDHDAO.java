/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PHIEUDHDTO;
import DTO.TAOPHIEUDHDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKZ
 */
public class PHIEUDHDAO extends GenericDAO<PHIEUDHDTO>{
    private ResultSet rs;
    public ArrayList<PHIEUDHDTO> getAll(){
        String Sql = "SELECT * FROM PhieuNhan ORDER BY idPhieu DESC";
        rs = executeQuery(Sql);
        ArrayList<PHIEUDHDTO> arr = new ArrayList<>();
         try {
             
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
    
    public void edit(int idPhieu,int state,String condition) {
        String Sql = "update phieuNhan set "+condition+"  ="+state+" where idPhieu = " + idPhieu;
        executeUpdate(Sql);
    }

    public void editChiTietPhieu(ArrayList<TAOPHIEUDHDTO> arr){
        //tao query khi cap nhat phieu nhan
            String Case="",condition="";
            for(int i= 0; i< arr.size(); i++){
            Case += " when idSach = "+arr.get(i).getIdSach()+" then "+arr.get(i).getSoLuongNhan();
            condition += arr.get(i).getIdSach()+",";
            }
            condition = condition.substring(0, condition.length()-1);
            
            String sql ="update ChiTietPhieuNhan set soLuongNhan = (case "+Case+" end)" +
" where idSach in ("+condition+") and idPhieu = "+arr.get(0).getIdPhieu();
            executeUpdate(sql);
}
    
    public void editSoLuong(ArrayList<TAOPHIEUDHDTO> arr){
        //tang so luong sach khi cap nhat so luong sach nhan duoc
            String Case="",condition="";
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
            executeUpdate(Sql);
       
    }
    
    public ArrayList<TAOPHIEUDHDTO> find(int idPhieu){
    ArrayList<TAOPHIEUDHDTO> arr = new ArrayList<>();
    String Sql = "SELECT * FROM ChiTietPhieuNhan c,PhieuNhan p,sach s where c.idPhieu = p.idPhieu and s.idSach = c.idSach and c.idPhieu="+idPhieu;
    rs = executeQuery(Sql);
         try {
            while (rs.next()) {
                    arr.add(new TAOPHIEUDHDTO(Integer.parseInt(rs.getString("idPhieu"))
                            , Integer.parseInt(rs.getString("idSach"))
                            , Integer.parseInt(rs.getString("soLuongNhap"))
                            , Integer.parseInt(rs.getString("soLuongNhan"))
                            , rs.getString("tenSach")
                            ));
}
            return arr;
         } catch (SQLException ex) {
             Logger.getLogger(PHIEUDHDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return arr;
         
    
    
    }
  
    
    
    
     
}