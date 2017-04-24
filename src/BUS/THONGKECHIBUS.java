/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.THONGKECHIDAO;
import DTO.TAOPHIEUDHDTO;
import DTO.THONGKECHIDTO;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author MKZ
 */
public class THONGKECHIBUS {
    private THONGKECHIDAO tkcDAO;

    public THONGKECHIBUS() {
        tkcDAO = new THONGKECHIDAO();
    }
    
     public ArrayList<THONGKECHIDTO> getAll() {
         ArrayList<THONGKECHIDTO> arr= tkcDAO.getAll();    
         return arr;
    
    }
    public Map<Integer,Integer> thongKeChi(int year ) {
        return tkcDAO.thongKeChi(year);
    }
    
}
