/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SACHDAO;
import DTO.SACHDTO;
import java.util.ArrayList;

/**
 *
 * @author MKZ
 */
public class SACHBUS {
    private SACHDTO sach ;
    private SACHDAO sachDAO;
//    public SACHDTO getSach(){
//        return new ;
//    }
    public void SACHBUS(){
        
    }
    public void saveSach(SACHDTO mSach){
        sachDAO = new SACHDAO();  
        sachDAO.saveSach(mSach);   
    }
    public ArrayList<SACHDTO> loadFormNhap(){
       
         sachDAO = new SACHDAO();  
         ArrayList<SACHDTO> arr= sachDAO.loadFormNhap();
//         for(int i=0;i< arr.size();i++){
//             System.out.println(arr.get(i).toString());
//         }
         
         return arr;
        
    }
    public void editSach(SACHDTO mSach){
          sachDAO = new SACHDAO(); 
          sachDAO.editSach(mSach);
    }
    
}
