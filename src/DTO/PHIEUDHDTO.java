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
public class PHIEUDHDTO {
    private int idPhieu,tinhTrang,trangThai;
    private String ngayLap;

    public PHIEUDHDTO(int idPhieu, int tinhTrang, int trangThai, String ngayLap) {
        this.idPhieu = idPhieu;
        this.tinhTrang = tinhTrang;
        this.trangThai = trangThai;
        this.ngayLap = ngayLap;
    }

    

    public PHIEUDHDTO() {
         this.tinhTrang = 0;
        this.ngayLap = ngayLap;
    }

    @Override
    public String toString() {
        return "PHIEUDTO{" + "idPhieu=" + idPhieu + ", tinhTrang=" + tinhTrang + ", trangThai=" + trangThai + ", ngayLap=" + ngayLap + '}';
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
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
