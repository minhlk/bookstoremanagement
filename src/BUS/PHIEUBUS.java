/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PHIEUDAO;
import DTO.CHITIETPHIEUDTO;
import DTO.PHIEUDTO;
import DTO.THONGKECHIDTO;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

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
    public void deletePhieu(int idPhieu){
        phieuDAO = new PHIEUDAO();
        phieuDAO.deletePhieu(idPhieu);
    
    }

    public void changeState(int idPhieu,int state) {
         phieuDAO = new PHIEUDAO();
        phieuDAO.changeState(idPhieu,state);
    }

    public void editChiTietPhieu(ArrayList<CHITIETPHIEUDTO> arr) {
        phieuDAO = new PHIEUDAO();
        phieuDAO.editChiTietPhieu(arr);
    }

    public void changetinhTrang(int idPhieu, int tinhTrang) {
       phieuDAO = new PHIEUDAO();
        phieuDAO.changetinhTrang(idPhieu, tinhTrang);
    }

    public ArrayList<THONGKECHIDTO> loadFormThongKeChi() {
        phieuDAO = new PHIEUDAO();  
         ArrayList<THONGKECHIDTO> arr= phieuDAO.loadFormThongKeChi();    
         return arr;
    
    }

    public Map<Integer,Integer> thongKeChi(int year ) {
        phieuDAO = new PHIEUDAO();
        return phieuDAO.thongKeChi(year);
    }

    
   
}
