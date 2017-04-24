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
    public void save(SACHDTO mSach){
          
        sachDAO.save(mSach);   
    }
    public ArrayList<SACHDTO> getAll(){
         ArrayList<SACHDTO> arr= sachDAO.getAll();
         return arr;
        
    }
    public void edit(SACHDTO mSach){
          sachDAO.edit(mSach);
    }
    
    public ArrayList<SACHDTO>  find( String value, String key) {
          ArrayList<SACHDTO> arr= sachDAO.find(value, key);  
          return arr;
    }
    
    
}
