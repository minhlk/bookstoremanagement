/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CHITIETPHIEUDHDAO;
import DTO.CHITIETPHIEUDHDTO;
import java.util.ArrayList;

/**
 *
 * @author MKZ
 */
public class CHITIETPHIEUDHBUS {
     private CHITIETPHIEUDHDAO chiTietPhieuDAO;

    public CHITIETPHIEUDHBUS() {
        chiTietPhieuDAO = new CHITIETPHIEUDHDAO();
    }
     
    //chiTietPhieuDAO
    public void savePhieu(ArrayList<CHITIETPHIEUDHDTO> mPhieu){
        chiTietPhieuDAO.savePhieu(mPhieu);   
    }
    public ArrayList<CHITIETPHIEUDHDTO> getChiTietPhieu(int idPhieu){
        ArrayList<CHITIETPHIEUDHDTO> arr = chiTietPhieuDAO.getChiTietPhieu(idPhieu);
        return arr;
    }
    public void editChiTietPhieu(ArrayList<CHITIETPHIEUDHDTO> arr) {
        chiTietPhieuDAO.editChiTietPhieu(arr);
    }
    public void huyChiTietPhieu(ArrayList<CHITIETPHIEUDHDTO> arr) {
        chiTietPhieuDAO.huyChiTietPhieu(arr);
    }
}
