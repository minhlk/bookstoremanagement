/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PHIEUDHDAO;
import DTO.PHIEUDHDTO;
import DTO.TAOPHIEUDHDTO;
import DTO.THONGKECHIDTO;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author MKZ
 */
public class PHIEUDHBUS {
    private PHIEUDHDAO phieuDAO;
   
    public PHIEUDHBUS(){
    phieuDAO = new PHIEUDHDAO();
    
    }
    

    // phieuDAO
    public ArrayList<PHIEUDHDTO> getAll(){ 
         ArrayList<PHIEUDHDTO> arr= phieuDAO.getAll();
         return arr;
    }

    public void edit(int idPhieu,int state,String condition) {
        phieuDAO.edit(idPhieu,state,condition);
    }
  
    
    public void editChiTietPhieu(ArrayList<TAOPHIEUDHDTO> arr) {
        phieuDAO.editChiTietPhieu(arr);
    }
    public void changeSoLuong(ArrayList<TAOPHIEUDHDTO> arr){
        phieuDAO.editSoLuong(arr);
    }
    public ArrayList<TAOPHIEUDHDTO> find(int idPhieu){
        ArrayList<TAOPHIEUDHDTO> arr = phieuDAO.find(idPhieu);
        return arr;
    }
    
   
    
   
}
