/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TAOPHIEUDHDAO;
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
        chiTietPhieuDAO.save(mPhieu);   
    }
    
    
}
