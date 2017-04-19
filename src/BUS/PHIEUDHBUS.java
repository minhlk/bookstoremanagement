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
    public ArrayList<PHIEUDHDTO> loadFormNhap(){ 
         ArrayList<PHIEUDHDTO> arr= phieuDAO.loadFormNhap();
         return arr;
    }
    
    public ArrayList<PHIEUDHDTO> timkiem(int idPhieu){
         ArrayList<PHIEUDHDTO> arr= phieuDAO.timkiem(idPhieu);    
         return arr;
        
    }
    public void changeState(int idPhieu,int state) {
        phieuDAO.changeState(idPhieu,state);
    }
    public void changetinhTrang(int idPhieu, int tinhTrang) {
        phieuDAO.changetinhTrang(idPhieu, tinhTrang);
    }
    
    public void editChiTietPhieu(ArrayList<TAOPHIEUDHDTO> arr) {
        phieuDAO.editChiTietPhieu(arr);
    }
    public void changeSoLuong(ArrayList<TAOPHIEUDHDTO> arr){
        phieuDAO.changeSoLuong(arr);
    }
    public ArrayList<TAOPHIEUDHDTO> getChiTietPhieu(int idPhieu){
        ArrayList<TAOPHIEUDHDTO> arr = phieuDAO.getChiTietPhieu(idPhieu);
        return arr;
    }
    
   
    
   
}
