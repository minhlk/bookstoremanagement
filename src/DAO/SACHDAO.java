/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
    private ResultSet rs;
    private Connection conn = Conn.getConnect();
    public SACHDAO(){
//        try {
            conn = Conn.getConnect();
//            System.out.println("test");
//            st = conn.createStatement();
//            String Sql = "select * from family";
//            rs = st.executeQuery(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("firstName"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public void saveSach(SACHDTO mSach){
        try{
            
//            System.out.println("test");
            st = conn.createStatement();
            String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan) values("
                    +"'"+mSach.getTenSach().toUpperCase()+"','"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()
                    + "')";
            rs = st.executeQuery(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("tenSach"));
//            }
            System.out.println(mSach.toString());
        } catch (SQLException ex ) {
//            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch( com.microsoft.sqlserver.jdbc.SQLServerException e){}
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
                       , rs.getString("tenSach")
                       , rs.getString("tacGia")));
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
            String Sql = "update sach set tenSach="+"'"+mSach.getTenSach().toUpperCase()+"',"
                    +"tacGia="+"'"+mSach.getTacGia().toUpperCase()+"',"
                    +"soLuong="+"'"+mSach.getSoLuong()+"',"
                    +"giaBan="+"'"+mSach.getGiaBan()+"'"
//                    ,tacGia,soLuong,giaBan) values("
//                    ,'"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()
                    + " where idSach = "+mSach.getIdSach();
            rs = st.executeQuery(Sql);
            System.out.println(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("tenSach"));
//            }
//            System.out.println(mSach.toString());
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch( com.microsoft.sqlserver.jdbc.SQLServerException e){}
    }
}
