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

/**
 *
 * @author MKZ
 */
public class PHIEUBUS {
    private PHIEUDAO phieuDAO = new PHIEUDAO();
    public void savePhieu(ArrayList<CHITIETPHIEUDTO> mPhieu){
        phieuDAO.savePhieu(mPhieu);   
    }
    public ArrayList<PHIEUDTO> loadFormNhap(){ 
         ArrayList<PHIEUDTO> arr= phieuDAO.loadFormNhap();
         return arr;
    }
    public ArrayList<CHITIETPHIEUDTO> getChiTietPhieu(int idPhieu){
        ArrayList<CHITIETPHIEUDTO> arr = phieuDAO.getChiTietPhieu(idPhieu);
        return arr;
    }
    public ArrayList<PHIEUDTO> timkiem(int idPhieu){
         ArrayList<PHIEUDTO> arr= phieuDAO.timkiem(idPhieu);    
         return arr;
        
    }
    public void deletePhieu(int idPhieu){
        phieuDAO.deletePhieu(idPhieu);
    
    }

    public void changeState(int idPhieu,int state) {
        phieuDAO.changeState(idPhieu,state);
    }

    public void editChiTietPhieu(ArrayList<CHITIETPHIEUDTO> arr) {
        phieuDAO.editChiTietPhieu(arr);
    }

    public void changetinhTrang(int idPhieu, int tinhTrang) {
        phieuDAO.changetinhTrang(idPhieu, tinhTrang);
    }

    public ArrayList<THONGKECHIDTO> loadFormThongKeChi() {
         ArrayList<THONGKECHIDTO> arr= phieuDAO.loadFormThongKeChi();    
         return arr;
    
    }

    public Map<Integer,Integer> thongKeChi(int year ) {
        return phieuDAO.thongKeChi(year);
    }

    
   
}
