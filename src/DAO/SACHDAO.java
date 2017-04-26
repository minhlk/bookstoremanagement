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
        rs = super.executeQuery(Sql);
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
    
    
    
}
