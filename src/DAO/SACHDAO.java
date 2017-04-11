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
    private ResultSet rs ;
    private Connection conn = ConnectionSql.getConnect();
    public SACHDAO(){
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
//            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public void saveSach(SACHDTO mSach){
        try{
//            conn = ConnectionSql.getConnect();
//            conn = ConnectionSql.conn;
//            System.out.println("test");
            st = conn.createStatement();
//            String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan,nhaCungCap) values("
//                    +"'"+mSach.getTenSach().toUpperCase()+"','"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()+"','"+mSach.getNhaCungCap()
//                    + "')  "
//                    + "  where not exists (select * from sach where tenSach = '"+mSach.getTenSach().toUpperCase()+"')";
//             System.out.println(Sql);
//            if(checkExist(mSach.getTenSach(), st)==0)
 String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan,nhaCungCap) select "
                    +"'"+mSach.getTenSach().toUpperCase()+"','"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()+"','"+mSach.getNhaCungCap()
                    + "'  "
                    + "  where not exists (select * from sach where tenSach = '"+mSach.getTenSach().toUpperCase()+"')";
//             
               
            st.executeUpdate(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("tenSach"));
//            }
//            System.out.println(mSach.toString());
            
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
                       , rs.getString("tacGia")
                       ,rs.getString("nhaCungCap")));
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
                    +"tacGia="+"'"+mSach.getTacGia().toUpperCase()+"',"
                    +"soLuong="+"'"+mSach.getSoLuong()+"',"
                    +"giaBan="+"'"+mSach.getGiaBan()+"',"
                    +"nhaCungCap='"+mSach.getNhaCungCap()+"'"
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
    public int checkExist(String tenSach,Statement st){
         try{
//     st = conn.createStatement();
//            String Sql = "insert into sach(tenSach,tacGia,soLuong,giaBan) values("
//                    +"'"+mSach.getTenSach().toUpperCase()+"','"+mSach.getTacGia().toUpperCase()+"','"+mSach.getSoLuong()+"','"+mSach.getGiaBan()
//                    + "')";
            String Sql = "select * from sach where tenSach='"+tenSach+"'";
            boolean result = st.execute(Sql);
            return result == true?1:0;
          
//            System.out.println(mSach.toString());
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
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
    public ArrayList<SACHDTO> loadFormNhap(String value,String key){
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
    
}
