/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SACHDAO;
import DTO.TAOPHIEUDHDTO;
import DTO.SACHDTO;
import java.util.ArrayList;

/**
 *
 * @author MKZ
 */
public class SACHBUS {
    private SACHDAO sachDAO =  new SACHDAO();
    public void saveSach(SACHDTO mSach){
          
        sachDAO.saveSach(mSach);   
    }
    public ArrayList<SACHDTO> loadFormNhap(){
         ArrayList<SACHDTO> arr= sachDAO.loadFormNhap();
         return arr;
        
    }
    public void editSach(SACHDTO mSach){
          sachDAO.editSach(mSach);
    }

    public void deleteSach(SACHDTO mSach) {
          sachDAO.deleteSach(mSach.getIdSach());
    }

    public ArrayList<SACHDTO>  timKiem( String value, String key) {
          ArrayList<SACHDTO> arr= sachDAO.timKiem(value, key);  
          return arr;
    }
    public void tangSoLuong(ArrayList<TAOPHIEUDHDTO> arr){
        sachDAO.tangSoLuong(arr);
    }
    
}
