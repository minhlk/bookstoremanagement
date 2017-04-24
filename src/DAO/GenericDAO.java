/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SACHDTO;
import DTO.TAOPHIEUDHDTO;
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
public class GenericDAO<T> {
    private Statement st;
    private ResultSet rs ;
    private Connection conn = GetConnection.conn;
    public ResultSet getAll(String Sql){
        try{
            st = conn.createStatement();         
            rs = st.executeQuery(Sql);

        } catch (SQLException ex ) {
        }
            return rs;
    }
   public void save(SACHDTO mSach){
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
   public void save(ArrayList<TAOPHIEUDHDTO> mPhieu){
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
             Sql = "insert into ChiTietPhieuNhan(idPhieu,idSach,soLuongNhap,soLuongNhan) values";
            for(int i=0;i<mPhieu.size();i++){
//                mPhieu.get(i).getIdPhieu(idPhieu);
//                System.out.println(mPhieu.get(i).toString());
                Sql  += 
                         " ('"+idPhieu+"'"
                        + ",'"+mPhieu.get(i).getIdSach()+"'"
                        + ",'"+mPhieu.get(i).getSoLuongNhap()+"'"
                        + ",'0')";
                if(i+1 != mPhieu.size()) Sql +=",";
            }
//            System.out.println(Sql);
            st.executeUpdate(Sql);

        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
   public void edit(SACHDTO mSach){
        try{
            st = conn.createStatement();
            String Sql = "update sach set "
                    +"tacGia="+"N'"+mSach.getTacGia().toUpperCase()+"',"
                    +"soLuong="+"'"+mSach.getSoLuong()+"',"
                    +"giaBan="+"'"+mSach.getGiaBan()+"',"
                    +"giaMua="+"'"+mSach.getGiaMua()+"',"
                    +"nhaCungCap=N'"+mSach.getNhaCungCap()+"'"
                    + " where idSach = "+mSach.getIdSach();
            st.executeUpdate(Sql);
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void edit(String Sql){
       try{
            st = conn.createStatement();
            st.executeUpdate(Sql);
        } catch (SQLException ex ) {
            Logger.getLogger(SACHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
   
   public ArrayList<SACHDTO> find(String value,String key){
        ArrayList<SACHDTO> mSachs = new ArrayList<>();
        try{
            st = conn.createStatement();
            String Sql = "select * from sach where "+key+" like '%"+value+"%'";
            rs = st.executeQuery(Sql);
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
    } //
   public ArrayList<TAOPHIEUDHDTO> find(int idPhieu){
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
     
   
}
