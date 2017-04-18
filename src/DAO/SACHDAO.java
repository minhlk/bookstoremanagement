/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CHITIETPHIEUDHDTO;
import DTO.SACHDTO;
import java.awt.List;
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
public class SACHDAO {
    private Statement st;
    private ResultSet rs ;
    private Connection conn = GetConnection.conn;
    public SACHDAO(){
    }
    public void saveSach(SACHDTO mSach){
        try{
            st = conn.createStatement();

 String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan,giaMua,nhaCungCap) select "
                    +"N'"+mSach.getTenSach().toUpperCase()+"',N'"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()+"','"+mSach.getGiaMua()+"',N'"+mSach.getNhaCungCap()
                    + "'  "
                    + "  where not exists (select * from sach where tenSach = '"+mSach.getTenSach().toUpperCase()+"')";
//             
               System.out.println(Sql);
            st.executeUpdate(Sql);
            
        } catch (SQLException ex ) {
//            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<SACHDTO> loadFormNhap(){
        ArrayList<SACHDTO> mSachs = new ArrayList<>();
        try{
     st = conn.createStatement();
//            String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan) values("
//                    +"'"+mSach.getTenSach().toUpperCase()+"','"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()
//                    + "')";
            String Sql = "select * from sach";
            rs = st.executeQuery(Sql);
            while (rs.next()) {
               mSachs.add(new SACHDTO(Integer.parseInt(rs.getString("idSach"))
                        ,Integer.parseInt(rs.getString("soLuong"))
                       , Integer.parseInt(rs.getString("giaBan"))
                       , Integer.parseInt(rs.getString("giaMua"))
                       , rs.getString("tenSach")
                       , rs.getString("tacGia")
                       , rs.getString("nhaCungCap")));
            }
//            System.out.println(mSach.toString());
        } catch (SQLException ex ) {
//            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch( com.microsoft.sqlserver.jdbc.SQLServerException e){}
            return mSachs;
    }
    public void editSach(SACHDTO mSach){
        try{
            
//            System.out.println("test");
            st = conn.createStatement();
            String Sql = "update sach set "
//                    + "tenSach="+"'"+mSach.getTenSach().toUpperCase()+"',"
                    +"tacGia="+"N'"+mSach.getTacGia().toUpperCase()+"',"
                    +"soLuong="+"'"+mSach.getSoLuong()+"',"
                    +"giaBan="+"'"+mSach.getGiaBan()+"',"
                    +"giaMua="+"'"+mSach.getGiaMua()+"',"
                    +"nhaCungCap=N'"+mSach.getNhaCungCap()+"'"
//                    ,tacGia,soLuong,giaBan) values("
//                    ,'"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()
                    + " where idSach = "+mSach.getIdSach();
//            if(checkExist(mSach.getTenSach(), st)==0)
            st.executeUpdate(Sql);
//            System.out.println(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("tenSach"));
//            }
//            System.out.println(mSach.toString());
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch( com.microsoft.sqlserver.jdbc.SQLServerException e){}
    }
    public void deleteSach(int id){
        try{
            
//            System.out.println("test");
            st = conn.createStatement();
            String Sql = "delete SACH where idSach = "+ id;
//            if(checkExist(mSach.getTenSach(), st)==0)
            st.executeUpdate(Sql);
//            System.out.println(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("tenSach"));
//            }
//            System.out.println(mSach.toString());
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch( com.microsoft.sqlserver.jdbc.SQLServerException e){}
    }
    public ArrayList<SACHDTO> timKiem(String value,String key){
        ArrayList<SACHDTO> mSachs = new ArrayList<>();
        try{
     st = conn.createStatement();
//            String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan) values("
//                    +"'"+mSach.getTenSach().toUpperCase()+"','"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()
//                    + "')";
            String Sql = "select * from sach where "+key+" like '%"+value+"%'";
            rs = st.executeQuery(Sql);
//            System.out.println(Sql);
            while (rs.next()) {
               mSachs.add(new SACHDTO(Integer.parseInt(rs.getString("idSach"))
                        ,Integer.parseInt(rs.getString("soLuong"))
                       , Integer.parseInt(rs.getString("giaBan"))
                       , Integer.parseInt(rs.getString("giaMua"))
                       , rs.getString("tenSach")
                       , rs.getString("tacGia")
                       ,rs.getString("nhaCungCap")));
            }
//            System.out.println(mSach.toString());
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch( com.microsoft.sqlserver.jdbc.SQLServerException e){}
            return mSachs;
    } 
    public void tangSoLuong(ArrayList<CHITIETPHIEUDHDTO> arr){
    try{
        //tang so luong sach khi cap nhat so luong sach nhan duoc
            st = conn.createStatement();
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
