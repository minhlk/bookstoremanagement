/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SACHDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKZ
 */
public class SACHDAO extends GenericDAO<SACHDAO>{
    private ResultSet rs ;
    
    public ArrayList<SACHDTO> getAll(){
        String Sql = "select * from sach";
        rs = executeQuery(Sql);
        ArrayList<SACHDTO> mSachs = new ArrayList<>();
        try{
            while (rs.next()) {
               mSachs.add(new SACHDTO(Integer.parseInt(rs.getString("idSach"))
                        ,Integer.parseInt(rs.getString("soLuong"))
                       , Integer.parseInt(rs.getString("giaBan"))
                       , Integer.parseInt(rs.getString("giaMua"))
                       , rs.getString("tenSach")
                       , rs.getString("tacGia")
                       , rs.getString("nhaCungCap")));
            }
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return mSachs;
    }
    public void save(SACHDTO mSach){
      
 String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan,giaMua,nhaCungCap) select "
                    +"N'"+mSach.getTenSach().toUpperCase()+"',N'"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()+"','"+mSach.getGiaMua()+"',N'"+mSach.getNhaCungCap()
                    + "'  "
                    + "  where not exists (select * from sach where tenSach = '"+mSach.getTenSach().toUpperCase()+"')";
               System.out.println(Sql);
            executeUpdate(Sql);
            
       
    }
    public void edit(SACHDTO mSach){
            String Sql = "update sach set "
                    +"tacGia="+"N'"+mSach.getTacGia().toUpperCase()+"',"
                    +"soLuong="+"'"+mSach.getSoLuong()+"',"
                    +"giaBan="+"'"+mSach.getGiaBan()+"',"
                    +"giaMua="+"'"+mSach.getGiaMua()+"',"
                    +"nhaCungCap=N'"+mSach.getNhaCungCap()+"'"
                    + " where idSach = "+mSach.getIdSach();
            executeUpdate(Sql);
       
    }
    public ArrayList<SACHDTO> find(String value,String key){
        ArrayList<SACHDTO> mSachs = new ArrayList<>();
        try{
            String Sql = "select * from sach where "+key+" like '%"+value+"%'";
            rs = executeQuery(Sql);
            while (rs.next()) {
               mSachs.add(new SACHDTO(Integer.parseInt(rs.getString("idSach"))
                        ,Integer.parseInt(rs.getString("soLuong"))
                       , Integer.parseInt(rs.getString("giaBan"))
                       , Integer.parseInt(rs.getString("giaMua"))
                       , rs.getString("tenSach")
                       , rs.getString("tacGia")
                       ,rs.getString("nhaCungCap")));
            }
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return mSachs;
    } //
    
    
}
