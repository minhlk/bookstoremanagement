/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;



/**
 *
 * @author MKZ
 */
public class PHIEUDTO {
    int idPhieu,tinhTrang;
    String ngayLap;

    public PHIEUDTO(int idPhieu, int tinhTrang, String ngayLap) {
        this.idPhieu = idPhieu;
        this.tinhTrang = tinhTrang;
        this.ngayLap = ngayLap;
    }

    public PHIEUDTO() {
         this.tinhTrang = 0;
        this.ngayLap = ngayLap;
    }

    @Override
    public String toString() {
        return "PHIEUDTO{" + "idPhieu=" + idPhieu + ", tinhTrang=" + tinhTrang + ", ngayLap=" + ngayLap + '}';
    }

    public int getIdPhieu() {
        return idPhieu;
    }

    public void setIdPhieu(int idPhieu) {
        this.idPhieu = idPhieu;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
    
}
