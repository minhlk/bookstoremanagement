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
public class CHITIETPHIEUDHDTO {
   int idPhieu,idSach,soLuongNhap,soLuongNhan;
   String tenSach;

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getSoLuongNhan() {
        return soLuongNhan;
    }

    public void setSoLuongNhan(int soLuongNhan) {
        this.soLuongNhan = soLuongNhan;
    }

    public CHITIETPHIEUDHDTO(int idPhieu, int idSach, int soLuongNhap, int soLuongNhan, String tenSach) {
        this.idPhieu = idPhieu;
        this.idSach = idSach;
        this.soLuongNhap = soLuongNhap;
        this.soLuongNhan = soLuongNhan;
//        this.giaMua = giaMua;
        this.tenSach = tenSach;
    }
     public CHITIETPHIEUDHDTO( int idSach, int soLuongNhap,  String tenSach) {
//        this.idPhieu = idPhieu;
        this.idSach = idSach;
        this.soLuongNhap = soLuongNhap;
        this.soLuongNhan = 0;
//        this.giaMua = giaMua;
        this.tenSach = tenSach;
    }
    public CHITIETPHIEUDHDTO(int idPhieu, int idSach, int soLuongNhan) {
        this.idPhieu = idPhieu;
        this.idSach = idSach;
        this.soLuongNhap = 0;
        this.soLuongNhan = soLuongNhan;
//        this.giaMua = 0;
        this.tenSach = "";
    }
   
   

    public int getIdPhieu() {
        return idPhieu;
    }

    public void setIdPhieu(int idPhieu) {
        this.idPhieu = idPhieu;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }


//    public int getGiaMua() {
//        return giaMua;
//    }
//
//    public void setGiaMua(int giaMua) {
//        this.giaMua = giaMua;
//    }
   
}
