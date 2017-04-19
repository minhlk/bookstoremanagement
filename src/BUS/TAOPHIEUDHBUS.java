/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TAOPHIEUDHDAO;
import DAO.SACHDAO;
import DTO.TAOPHIEUDHDTO;
import java.util.ArrayList;

/**
 *
 * @author MKZ
 */
public class TAOPHIEUDHBUS {
     private TAOPHIEUDHDAO chiTietPhieuDAO;

    public TAOPHIEUDHBUS() {
        chiTietPhieuDAO = new TAOPHIEUDHDAO();
    }
     
    //chiTietPhieuDAO
    public void savePhieu(ArrayList<TAOPHIEUDHDTO> mPhieu){
        chiTietPhieuDAO.savePhieu(mPhieu);   
    }
    public ArrayList<TAOPHIEUDHDTO> getChiTietPhieu(int idPhieu){
        ArrayList<TAOPHIEUDHDTO> arr = chiTietPhieuDAO.getChiTietPhieu(idPhieu);
        return arr;
    }
    public void editChiTietPhieu(ArrayList<TAOPHIEUDHDTO> arr) {
        chiTietPhieuDAO.editChiTietPhieu(arr);
    }
//    public void huyChiTietPhieu(ArrayList<CHITIETPHIEUDHDTO> arr) {
//        chiTietPhieuDAO.huyChiTietPhieu(arr);
//    }
    public void tangSoLuong(ArrayList<TAOPHIEUDHDTO> arr){
        new SACHDAO().tangSoLuong(arr);
    }
}
