/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PHIEUDAO;
import DTO.CHITIETPHIEUDTO;
import DTO.PHIEUDTO;
import java.util.ArrayList;

/**
 *
 * @author MKZ
 */
public class PHIEUBUS {
      private PHIEUDTO phieu ;
    private PHIEUDAO phieuDAO;
//    public PHIEUDTO getPhieu(){
//        return new ;
//    }
    public void PHIEUBUS(){
        
    }
    public void savePhieu(ArrayList<CHITIETPHIEUDTO> mPhieu){
        phieuDAO = new PHIEUDAO();  
        phieuDAO.savePhieu(mPhieu);   
    }
    public ArrayList<PHIEUDTO> loadFormNhap(){
       
         phieuDAO = new PHIEUDAO();  
         ArrayList<PHIEUDTO> arr= phieuDAO.loadFormNhap();
//         for(int i=0;i< arr.size();i++){
//             System.out.println(arr.get(i).toString());
//         }
         
         return arr;
        
    }
    public void editPhieu(PHIEUDTO mPhieu){
          phieuDAO = new PHIEUDAO(); 
//          phieuDAO.editPhieu(mPhieu);
    }
    public ArrayList<CHITIETPHIEUDTO> getChiTietPhieu(int idPhieu){
        phieuDAO = new PHIEUDAO();
         ArrayList<CHITIETPHIEUDTO> arr = phieuDAO.getChiTietPhieu(idPhieu);
        return arr;
    }
    public ArrayList<PHIEUDTO> timkiem(int idPhieu){
       
         phieuDAO = new PHIEUDAO();  
         ArrayList<PHIEUDTO> arr= phieuDAO.timkiem(idPhieu);
//         for(int i=0;i< arr.size();i++){
//             System.out.println(arr.get(i).toString());
//         }
         
         return arr;
        
    }
   
}
